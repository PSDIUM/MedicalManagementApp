package com.sepproject.medicalmanagementapp.login;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.doctor.DoctorNavigationActivity;

import com.sepproject.medicalmanagementapp.patient.PatientNavigationActivity;
import com.sepproject.medicalmanagementapp.register.RegisterActivity;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private LoginViewModel mLoginViewModel;
    private EditText mEmailEt;
    private EditText mPasswordEt;
    private Spinner mUserTypeSpinner;

    public static final int REGISTER_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Register ViewModel
        mLoginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        // Observe LiveData
        mLoginViewModel.getRegisterResultLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                if (integer != null && integer == 1) {
                    // Register OK
                    Toast.makeText(getApplicationContext(), getString(R.string.toast_register_success),
                            Toast.LENGTH_LONG).show();
                } else if (integer != null && integer == 0) {
                    // Register failed
                    Toast.makeText(getApplicationContext(), getString(R.string.toast_register_failed),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        mLoginViewModel.getLoginResultLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                if (integer != null && integer == 1) {
                    // Login OK, check which user login
                    if (mUserTypeSpinner.getSelectedItem().toString().equals("Doctor")) {
                        startActivity(new Intent(getApplicationContext(), DoctorNavigationActivity.class));
                    } else {
                        startActivity(new Intent(getApplicationContext(), PatientNavigationActivity.class));
                    }
                        finish();
                } else if (integer != null && integer == 0) {
                    // Login failed
                    Toast.makeText(getApplicationContext(), getString(R.string.toast_login_failed),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        // Find and assign fields
        TextView registerTv = findViewById(R.id.register_tv);
        mEmailEt = findViewById(R.id.email_et);
        mPasswordEt = findViewById(R.id.password_et);
        Button loginBtn = findViewById(R.id.login_button);

        registerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(i, REGISTER_REQUEST);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        // you need to have a list of data that you want the spinner to display
        List<String> spinnerArray =  new ArrayList<>();
        spinnerArray.add("Patient");
        spinnerArray.add("Doctor");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mUserTypeSpinner = findViewById(R.id.user_spinner_login);
        mUserTypeSpinner.setAdapter(adapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (REGISTER_REQUEST) : {
                if (resultCode == Activity.RESULT_CANCELED) {
                    Toast.makeText(LoginActivity.this, "Registration Cancelled", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }

    private void login(){
        String email = mEmailEt.getText().toString();
        String password = mPasswordEt.getText().toString();

        mLoginViewModel.logIn(email, password);
    }
}
