package com.sepproject.medicalmanagementapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.model.User;

public class DoctorActivity extends AppCompatActivity {

    private User mDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        Intent i = getIntent();
        mDoctor = (User) i.getSerializableExtra("DOCTOR");

        TextView doctorName = findViewById(R.id.doctor_name_tv);
        TextView doctorId = findViewById(R.id.doctor_id_tv);

        doctorName.setText(mDoctor.getName());
        doctorId.setText(String.valueOf(mDoctor.getId()));

        Toast.makeText(this, mDoctor.getUserType() + ": Welcome " + mDoctor.getName(), Toast.LENGTH_LONG).show();

        // Set onClickListener for Drug button
        Button drugBtn = findViewById(R.id.doctor_drugs_btn);
        drugBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open new Drug activity
                startActivity(new Intent(this, ));
            }
        });
    }
}
