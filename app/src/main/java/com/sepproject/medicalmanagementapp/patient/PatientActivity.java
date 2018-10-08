package com.sepproject.medicalmanagementapp.patient;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.model.User;

public class PatientActivity extends AppCompatActivity {

    private User mPatient;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        Intent i = getIntent();
        mPatient = (User) i.getSerializableExtra("PATIENT");

        initPatDetails();

        Toast.makeText(this, mPatient.getUserType() + ": Welcome " + mPatient.getName(), Toast.LENGTH_LONG).show();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void initPatDetails() {
        TextView patTitle = findViewById(R.id.patTitle);
        TextView patientName = findViewById(R.id.patient_name_tv);
        TextView patientId = findViewById(R.id.patient_id_tv);
        TextView patDOB = findViewById(R.id.patient_DOB);

        patientName.setText("Name: " + mPatient.getName());
        patientId.setText("ID: " + String.valueOf(mPatient.getId()));
        patTitle.setText("Welcome " + mPatient.getName());
        //patDOB.setText("DOB: " + mPatient.getDOB());
    }

}