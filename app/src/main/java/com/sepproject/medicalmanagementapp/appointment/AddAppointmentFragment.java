package com.sepproject.medicalmanagementapp.appointment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.model.History;
import com.sepproject.medicalmanagementapp.model.User;
import com.sepproject.medicalmanagementapp.patient.PatientNavigationViewModel;

public class AddAppointmentFragment extends Fragment {

    private PatientNavigationViewModel mPatientNavigationViewModel;
    private EditText mDescription;
    private Button mAddBtn;
    private User mPatient;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_appointment_layout, container, false);
        Bundle args = getArguments();

        mPatientNavigationViewModel = ViewModelProviders.of(getActivity()).get(PatientNavigationViewModel.class);
        mPatientNavigationViewModel.setPatient(args.getString("USER_EMAIL"));

        mDescription = view.findViewById(R.id.add_appointment_et);
        mAddBtn = view.findViewById(R.id.add_appointment_btn);

        mPatientNavigationViewModel.getPatient().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                mPatient = user;
            }
        });

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                History appointment = new History(mDescription.getText().toString());
                mPatientNavigationViewModel.addAppointment(mPatient, appointment);
                getActivity().finish();
            }
        });

        return view;
    }
}