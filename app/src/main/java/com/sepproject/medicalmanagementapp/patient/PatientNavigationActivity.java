package com.sepproject.medicalmanagementapp.patient;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.model.User;
import com.sepproject.medicalmanagementapp.util.ViewStatePagerAdaptor;

public class PatientNavigationActivity extends AppCompatActivity {

    private static final int HOME_POSITION = 0;
    private static final int HISTORY_POSITION = 1;

    private ViewStatePagerAdaptor mAdaptor;
    private ViewPager mViewPager;
    private PatientNavigationViewModel mPatientNavigationViewModel;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_patient_home:
                    mViewPager.setCurrentItem(HOME_POSITION);
                    return true;
                case R.id.navigation_patient_history:
                    mViewPager.setCurrentItem(HISTORY_POSITION);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_navigation);
        mViewPager = findViewById(R.id.patient_navigation_container);
        mPatientNavigationViewModel = ViewModelProviders.of(this).get(PatientNavigationViewModel.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setupViewPager();
            }
        }, 500);
    }

    private void setupViewPager(){
        Bundle args = new Bundle();
        args.putString("USER_EMAIL", mPatientNavigationViewModel.getUserEmail());
        PatientHistoryFragment patientHistoryFragment = new PatientHistoryFragment();
        patientHistoryFragment.setArguments(args);

        mAdaptor = new ViewStatePagerAdaptor(getSupportFragmentManager());
        mAdaptor.addFragement(new PatientHomeFragment(), "Home Fragment");
        mAdaptor.addFragement(patientHistoryFragment, "Patient Lookup Fragment");
        mViewPager.setAdapter(mAdaptor);

        pushFragment();
    }

    private void pushFragment(){
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
