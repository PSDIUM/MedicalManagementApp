package com.sepproject.medicalmanagementapp.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.util.ViewStatePagerAdaptor;

public class DoctorNavigationActivity extends AppCompatActivity {

    private static final int HOME_POSITION = 0;
    private static final int LOOKUP_POSITION = 1;

    private ViewStatePagerAdaptor mAdaptor;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(HOME_POSITION);
                    return true;
                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(LOOKUP_POSITION);
                    return true;
            }
            return false;
        }
    };
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_navigation);

        mViewPager = findViewById(R.id.doctor_navigation_container);
        setupViewPager(mViewPager);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setupViewPager(ViewPager viewPager){
        mAdaptor = new ViewStatePagerAdaptor(getSupportFragmentManager());
        mAdaptor.addFragement(new DoctorHomeFragment(), "Home Fragment");
        //mAdaptor.addFragement(new PatientLookupFragment(), "Patient Lookup Fragment");
        viewPager.setAdapter(mAdaptor);
    }

}
