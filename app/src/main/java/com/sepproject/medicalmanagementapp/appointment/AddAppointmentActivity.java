package com.sepproject.medicalmanagementapp.appointment;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.util.ViewStatePagerAdaptor;

public class AddAppointmentActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ViewStatePagerAdaptor mAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);

        setupViewPager();
        passUserData();
        mViewPager.setCurrentItem(0);
    }

    /**
     * Sets up the ViewPager and its Adaptor. The fragments for the class are added
     * to the adaptor.
     */
    private void setupViewPager() {
        mViewPager = findViewById(R.id.add_appointment_container);
        mAdaptor = new ViewStatePagerAdaptor(getSupportFragmentManager());
        mAdaptor.addFragement(new AddAppointmentFragment(), "Category Fragment");
        mViewPager.setAdapter(mAdaptor);
    }

    private void passUserData(){
        Intent i = getIntent();
        Bundle args = new Bundle();
        args.putString("USER_EMAIL", i.getStringExtra("USER_EMAIL"));
        mAdaptor.getItem(0).setArguments(args);
    }

}
