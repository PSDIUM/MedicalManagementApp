package com.sepproject.medicalmanagementapp.patient;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.model.User;
import com.sepproject.medicalmanagementapp.navigation.LookupListAdaptor;

public class PatientHistoryFragement extends Fragment {

    private PatientNavigationViewModel mPatientNavigationViewModel;
    private TextView mTitle;
    private TextView mFirstName;
    private TextView mLastName;
    private TextView mId;
    private TextView mAppointmentTitle;
    private RecyclerView mRecyclerView;
    private AppointmentListAdaptor mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_layout, container, false);
        Bundle args = getArguments();

        mPatientNavigationViewModel = ViewModelProviders.of(getActivity()).get(PatientNavigationViewModel.class);
        mPatientNavigationViewModel.setPatient(args.getString("USER_EMAIL"));

        mTitle = view.findViewById(R.id.patient_history_title);
        mFirstName = view.findViewById(R.id.patient_history_first_name);
        mLastName = view.findViewById(R.id.patient_history_last_name);
        mId = view.findViewById(R.id.patient_history_id);
        mAppointmentTitle = view.findViewById(R.id.patient_history_appointment_title);

        RecyclerView recyclerView = view.findViewById(R.id.patient_history_rv);
        mAdapter = new AppointmentListAdaptor(getActivity());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setPatient();
            }
        },500);

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
        mId.setText(String.valueOf(patient.getId()));
        mAppointmentTitle.setText(patient.getName() + "'s \n Previous Appointments");
    }
}
