package com.sepproject.medicalmanagementapp.patient;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.appointment.AddAppointmentActivity;
import com.sepproject.medicalmanagementapp.appointment.AddAppointmentFragment;
import com.sepproject.medicalmanagementapp.model.History;
import com.sepproject.medicalmanagementapp.model.User;

import java.util.List;

public class PatientHistoryFragement extends Fragment {

    private PatientNavigationViewModel mPatientNavigationViewModel;
    private TextView mTitle;
    private TextView mFirstName;
    private TextView mLastName;
    private TextView mId;
    private TextView mAppointmentTitle;
    private User mCurrentUser;
    private RecyclerView mRecyclerView;
    private AppointmentListAdaptor mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_layout, container, false);
        Bundle args = getArguments();

        mPatientNavigationViewModel = ViewModelProviders.of(getActivity()).get(PatientNavigationViewModel.class);
        mPatientNavigationViewModel.setPatient(args.getString("USER_EMAIL"));
        mPatientNavigationViewModel.setPatientAppointments(args.getString("USER_EMAIL"));

        mTitle = view.findViewById(R.id.patient_history_title);
        mFirstName = view.findViewById(R.id.patient_history_first_name);
        mLastName = view.findViewById(R.id.patient_history_last_name);
        mId = view.findViewById(R.id.patient_history_id);
        mAppointmentTitle = view.findViewById(R.id.patient_history_appointment_title);
        FloatingActionButton fab = view.findViewById(R.id.patient_history_fb);

        RecyclerView recyclerView = view.findViewById(R.id.patient_history_rv);
        mAdapter = new AppointmentListAdaptor(getActivity());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mPatientNavigationViewModel.getAllAppointments().observe(this, new Observer<List<History>>() {
            @Override
            public void onChanged(@Nullable List<History> histories) {
                if(histories.size()!=0) {
                    mAdapter.setHistory(histories);
                }
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setPatient();
            }
        },500);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAddAppointment();
            }
        });

        return view;
    }

    private void setPatient(){
        mPatientNavigationViewModel.getPatient().observe(getActivity(), new Observer<User>() {
            @Override
            public void onChanged(User patient) {
                mCurrentUser = patient;
                setPatientDetails(patient);
            }
        });
    }

    private void setAppointments(){
    }

    private void setPatientDetails(User patient){
        mTitle.setText(patient.getName());
        String[] patientName = patient.getName().split(" ");
        mFirstName.setText(patientName[0]);
        mLastName.setText(patientName[1]);
        mId.setText(String.valueOf(patient.getId()));
        mAppointmentTitle.setText(patient.getName() + "'s \n Previous Appointments");
    }

    private void startAddAppointment(){
        Intent i = new Intent(getActivity(), AddAppointmentActivity.class);
        i.putExtra("USER_EMAIL", mCurrentUser.getEmail());
        startActivity(i);
    }
}
