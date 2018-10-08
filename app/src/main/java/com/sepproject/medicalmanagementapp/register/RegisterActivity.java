package com.sepproject.medicalmanagementapp.register;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.util.ViewStatePagerAdaptor;

public class RegisterActivity extends AppCompatActivity {

    private static final int CATEGORY_POSITION = 0;
    private static final String CATEGORY_KEY= "CATEGORY_TITLE";
    private ViewPager mViewPager;
    private ViewStatePagerAdaptor mAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupViewPager();
        mViewPager.setCurrentItem(CATEGORY_POSITION);
    }

    private void setupViewPager() {
        mViewPager = findViewById(R.id.register_container);
        mAdaptor = new ViewStatePagerAdaptor(getSupportFragmentManager());
        mAdaptor.addFragement(new RegisterFragment(), "Category Fragment");
        mViewPager.setAdapter(mAdaptor);
    }

}
