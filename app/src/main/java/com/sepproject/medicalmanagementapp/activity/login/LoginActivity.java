package com.sepproject.medicalmanagementapp.activity.login;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.activity.DoctorActivity;
import com.sepproject.medicalmanagementapp.activity.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private LoginViewModel mLoginViewModel;
    private EditText mEmailEt;
    private EditText mPasswordEt;

    public static final int REGISTER_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Register ViewModel
        mLoginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        // Observe LiveData
        mLoginViewModel.getRegisterResultLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                if (integer != null && integer == 1) {
                    // Register OK
                    Log.d(TAG, "Register listener OK");
                } else if (integer != null && integer == 0) {
                    // Register failed
                    Log.d(TAG, "Register listener FAIL");
                }
            }
        });

        mLoginViewModel.getLoginResultLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                if (integer != null && integer == 1) {
                    // Login OK
                    Log.d(TAG, "Login listener OK");
                    startActivity(new Intent(getApplicationContext(), DoctorActivity.class));
                    finish();
                } else if (integer != null && integer == 0) {
                    // Login failed
                    Log.d(TAG, "Login listener FAIL");
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
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (REGISTER_REQUEST) : {
                if (resultCode == Activity.RESULT_OK) {
                    Toast.makeText(LoginActivity.this, "User Registered", Toast.LENGTH_LONG).show();
                } else {
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
