package com.sepproject.medicalmanagementapp.patient;

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
import com.sepproject.medicalmanagementapp.doctor.DoctorNavigationViewModel;
import com.sepproject.medicalmanagementapp.model.User;

public class PatientHomeFragment extends Fragment {

    PatientNavigationViewModel mPatientNavigationViewModel;

    private TextView mNameTv;
    private TextView mIdTv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_patient_home, container, false);
        mPatientNavigationViewModel = ViewModelProviders.of(getActivity()).get(PatientNavigationViewModel.class);

        mNameTv = view.findViewById(R.id.patient_name_tv);
        mIdTv = view.findViewById(R.id.patient_id_tv);
        Handler handler = new Handler();

        mPatientNavigationViewModel.getUser("patient");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setUser();
            }
        },500);
        return view;
    }

    private void setUser(){
        mPatientNavigationViewModel.setUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                mNameTv.setText(user.getName());
                mIdTv.setText(String.valueOf(user.getId()));
            }
        });
    }
}
