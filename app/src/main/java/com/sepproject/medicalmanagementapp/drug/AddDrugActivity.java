package com.sepproject.medicalmanagementapp.drug;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.db.FirebaseUtil;

public class AddDrugActivity extends AppCompatActivity {

    private EditText mDrugNameEt;
    private EditText mDrugPriceEt;
    private EditText mRecommendedDosageEt;
    private EditText mSideEffects;

    private FirebaseUtil mFirebaseUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drug);

        mDrugNameEt = findViewById(R.id.drug_name_edittext);
        mDrugPriceEt = findViewById(R.id.drug_price_edittext);
        mRecommendedDosageEt = findViewById(R.id.drug_dosage_edittext);
        mSideEffects = findViewById(R.id.drug_sideeffects_edittext);

        mFirebaseUtil = FirebaseUtil.getInstance();

        FloatingActionButton fab = findViewById(R.id.add_drug_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text
                String name = mDrugNameEt.getText().toString();
                Double price = Double.parseDouble(mDrugPriceEt.getText().toString());
                String dosage = mRecommendedDosageEt.getText().toString();
                String sideEffects = mSideEffects.getText().toString();

                mFirebaseUtil.addDrug(name, price, dosage, sideEffects);
            }
        });
    }
}
