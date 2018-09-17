package com.sepproject.medicalmanagementapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.db.UserDatabaseHelper;
import com.sepproject.medicalmanagementapp.model.User;

public class NewUserActivity extends AppCompatActivity {

    private EditText mFirstNameEt;
    private EditText mLastNameEt;
    private EditText mDobEt;
    private EditText mEmailEt;
    private EditText mPasswordEt;
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        mSpinner = findViewById(R.id.user_spinner);
        Button registerBtn = findViewById(R.id.register_btn);
        Button cancelBtn = findViewById(R.id.cancel_btn);
        mFirstNameEt = findViewById(R.id.firstNameEt);
        mLastNameEt = findViewById(R.id.lastNameEt);
        mDobEt = findViewById(R.id.dobEt);
        mEmailEt = findViewById(R.id.new_email_Et);
        mPasswordEt = findViewById(R.id.new_password_et);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.user_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        mSpinner.setAdapter(adapter);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    private void registerUser(){
        String name = mFirstNameEt.getText().toString() + " " + mLastNameEt.getText().toString();
        String dob = mDobEt.getText().toString();
        String email = mEmailEt.getText().toString();
        String password = mPasswordEt.getText().toString();
        String userType = mSpinner.getSelectedItem().toString();

        UserDatabaseHelper.getInstance(NewUserActivity.this).registerUser(new User(
                0,
                name,
                dob,
                password,
                email,
                userType
        ));

        //UserDatabaseHelper.getInstance(NewUserActivity.this).close();
        setResult(RESULT_OK);
        finish();
    }
}
