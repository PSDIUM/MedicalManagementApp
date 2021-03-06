package com.sepproject.medicalmanagementapp.doctor;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.drug.DrugListFragment;
import com.sepproject.medicalmanagementapp.patient.PatientHistoryFragment;
import com.sepproject.medicalmanagementapp.util.ViewStatePagerAdaptor;

public class DoctorNavigationActivity extends AppCompatActivity implements PatientLookupFragment.LookupListener {

    private static final int HOME_POSITION = 0;
    private static final int LOOKUP_POSITION = 1;
    private static final int DRUG_POSITION = 2;

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
                case R.id.navigation_drugs:
                    mViewPager.setCurrentItem(DRUG_POSITION);
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

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setupViewPager(ViewPager viewPager){
        mAdaptor = new ViewStatePagerAdaptor(getSupportFragmentManager());
        mAdaptor.addFragement(new DoctorHomeFragment(), "Home Fragment");
        mAdaptor.addFragement(new PatientLookupFragment(), "Patient Lookup Fragment");
        mAdaptor.addFragement(new DrugListFragment(), "Drugs Fragment");
        viewPager.setAdapter(mAdaptor);
    }

    @Override
    public void changeFragment(int position, Bundle args) {
        PatientHistoryFragment frag = new PatientHistoryFragment();
        frag.setArguments(args);
        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.patient_lookup_container, frag,"PatientHistoryFragment")
                .addToBackStack(null)
                .commit();
    }
}
