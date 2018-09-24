package com.sepproject.medicalmanagementapp.activity;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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

import com.sepproject.medicalmanagementapp.Login.LoginViewModel;
import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.db.UserDatabaseHelper;
import com.sepproject.medicalmanagementapp.model.Patient;
import com.sepproject.medicalmanagementapp.model.User;

public class LoginActivity extends AppCompatActivity {

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

        mLoginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        TextView registerTv = findViewById(R.id.register_tv);
        mEmailEt = findViewById(R.id.email_et);
        mPasswordEt = findViewById(R.id.password_et);
        Button loginBtn = findViewById(R.id.login_button);

        registerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.print("Hello");
                Intent i = new Intent(LoginActivity.this, NewUserActivity.class);
                startActivityForResult(i, REGISTER_REQUEST);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    private void login1(){
        String email = mEmailEt.getText().toString();
        String password = mPasswordEt.getText().toString();

        LiveData<Patient> patient = mLoginViewModel.getPatient(email,password);

        if(patient!=null){
            Intent i = new Intent(LoginActivity.this, PatientActivity.class);
            i.putExtra("PATIENT", user);
            startActivity(i);
        }
    }
    private void login(){
        String email = mEmailEt.getText().toString();
        String password = mPasswordEt.getText().toString();

        User user =  UserDatabaseHelper.getInstance(LoginActivity.this).userLogin(email,password);
        if(user!=null){
            if(user.getUserType().equals("Patient")){
                Intent i = new Intent(LoginActivity.this, PatientActivity.class);
                i.putExtra("PATIENT", user);
                startActivity(i);
            } else {
                Intent i = new Intent(LoginActivity.this, DoctorActivity.class);
                i.putExtra("DOCTOR", user);
                startActivity(i);
            }
        } else {
            Toast.makeText(LoginActivity.this,"Invalid email or password", Toast.LENGTH_LONG).show();
        }
    }
}
