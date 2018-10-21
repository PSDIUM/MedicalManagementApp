package com.sepproject.medicalmanagementapp.edit;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.model.User;
import com.sepproject.medicalmanagementapp.util.ViewModelFactory;
import com.sepproject.medicalmanagementapp.util.ViewStatePagerAdaptor;

public class EditDetailsActivity extends AppCompatActivity  {

    private static final int EDIT_DETAILS_POSITION = 0;
    private ViewPager mViewPager;
    private ViewStatePagerAdaptor mAdaptor;
    private EditDetailsViewModel mViewModel;

    private EditText mFirstNameEt;
    private EditText mLastNameEt;
    private EditText mDobEt;

    private String[] mNameSplit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);
        // Register ViewModel
        mViewModel = ViewModelProviders.of(this, new ViewModelFactory(
                getIntent().getStringExtra(Intent.EXTRA_EMAIL)
        )).get(EditDetailsViewModel.class);

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
