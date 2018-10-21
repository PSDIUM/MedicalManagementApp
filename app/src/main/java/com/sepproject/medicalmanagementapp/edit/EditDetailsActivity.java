package com.sepproject.medicalmanagementapp.edit;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.register.RegisterFragment;
import com.sepproject.medicalmanagementapp.util.ViewStatePagerAdaptor;

public class EditDetailsActivity extends AppCompatActivity {

    private static final int EDIT_DETAILS_POSITION = 0;
    private ViewPager mViewPager;
    private ViewStatePagerAdaptor mAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);
        setupViewPager();
        mViewPager.setCurrentItem(EDIT_DETAILS_POSITION);
    }


    private void setupViewPager() {
        mViewPager = findViewById(R.id.edit_details_vp);
        mAdaptor = new ViewStatePagerAdaptor(getSupportFragmentManager());
        mAdaptor.addFragement(new EditDetailsFragment(), "Edit Details Fragment");
        mViewPager.setAdapter(mAdaptor);
    }
}
