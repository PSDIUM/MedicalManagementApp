package com.sepproject.medicalmanagementapp.drug;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sepproject.medicalmanagementapp.R;

public class DrugActivity extends AppCompatActivity {

    // Fields for fragments
    DrugListFragment mActivityFragment;
    AddDrugFragment mDrugFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mActivityFragment = DrugListFragment.newInstance();
        mDrugFragment = AddDrugFragment.newInstance();

        changeFragmentTo(mActivityFragment);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch add drug fragment
                changeFragmentTo(mDrugFragment);
            }
        });
    }

    private void changeFragmentTo(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.drug_framelayout, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
