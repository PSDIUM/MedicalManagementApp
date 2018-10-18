package com.sepproject.medicalmanagementapp.patient;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.model.User;

public class PatientHistoryFragement extends Fragment {

    private PatientNavigationViewModel mPatientNavigationViewModel;
    private TextView mTitle;
    private TextView mFirstName;
    private TextView mLastName;
    private TextView mId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_layout, container, false);
        Bundle args = getArguments();

        mPatientNavigationViewModel = ViewModelProviders.of(getActivity()).get(PatientNavigationViewModel.class);
        Log.d("History", "SHould work" + args.getString("USER_EMAIL"));
        mPatientNavigationViewModel.setPatient(args.getString("USER_EMAIL"));

        mTitle = view.findViewById(R.id.patient_history_title);
        mFirstName = view.findViewById(R.id.patient_history_first_name);
        mLastName = view.findViewById(R.id.patient_history_last_name);
        mId = view.findViewById(R.id.patient_history_id);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setPatient();
            }
        },1000);

        return view;
    }

    private void setPatient(){
        mPatientNavigationViewModel.getPatient().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User patient) {
                setPatientDetails(patient);
            }
        });
    }
    private void setPatientDetails(User patient){
        mTitle.setText(patient.getName());
        String[] patientName = patient.getName().split(" ");
        mFirstName.setText(patientName[0]);
        mLastName.setText(patientName[1]);
        mId.setText(patient.getId());
    }
}
