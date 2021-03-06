package com.sepproject.medicalmanagementapp.doctor;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.model.User;

public class DoctorHomeFragment extends Fragment {

    DoctorNavigationViewModel mDoctorNavigationViewModel;

    private TextView mNameTv;
    private TextView mIdTv;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_doctor_home, container, false);
        mDoctorNavigationViewModel = ViewModelProviders.of(getActivity()).get(DoctorNavigationViewModel.class);

        mNameTv = view.findViewById(R.id.doctor_name_tv);
        mIdTv = view.findViewById(R.id.doctor_id_tv);
        Handler handler = new Handler();

        mDoctorNavigationViewModel.getUser("Doctor");

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setUser();
            }
        },1000);

        return view;
    }

    private void setUser(){
        mDoctorNavigationViewModel.getUserLiveData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                mNameTv.setText(user.getName());
                mIdTv.setText(String.valueOf(user.getId()));
            }
        });
    }
}
