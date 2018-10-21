package com.sepproject.medicalmanagementapp.edit;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.patient.PatientNavigationViewModel;

public class EditDetailsFragment extends Fragment {

    PatientNavigationViewModel mPatientNavigationViewModel;

    private TextView mTitle;
    private EditText mFirstNameEt;
    private EditText mLastNameEt;
    private EditText mDobEt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_edit_details, container, false);


        mPatientNavigationViewModel = ViewModelProviders.of(getActivity()).get(PatientNavigationViewModel.class);

        Button saveBtn = view.findViewById(R.id.edit_details_save_btn);
        Button cancelBtn = view.findViewById(R.id.cancel_btn);
        mFirstNameEt = view.findViewById(R.id.firstNameEt);
        mLastNameEt = view.findViewById(R.id.lastNameEt);
        mDobEt = view.findViewById(R.id.dobEt);

        setHints();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDetails();
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().setResult(getActivity().RESULT_CANCELED);
                getActivity().finish();
            }
        });

        return view;
    }

    private void setHints() {
        //Set hints to the users current details
        //mFirstNameEt.setText();
    }

    private void saveDetails(){
        String name = mFirstNameEt.getText().toString() + " " + mLastNameEt.getText().toString();
        String dob  = mDobEt.getText().toString();

        getActivity().setResult(getActivity().RESULT_OK);
        getActivity().finish();
    }
}
