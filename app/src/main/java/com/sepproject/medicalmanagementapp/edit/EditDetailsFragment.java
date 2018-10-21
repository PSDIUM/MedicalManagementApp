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
import com.sepproject.medicalmanagementapp.model.User;

public class EditDetailsFragment extends Fragment implements EditDetailsViewModel.OnResultListener {

    EditDetailsViewModel mViewModel;

    private TextView mTitle;
    private EditText mFirstNameEt;
    private EditText mLastNameEt;
    private EditText mDobEt;

    private String[] mNameSplit;

    @Override
    public void OnUserReceived(User user) {
        // Set the EditTexts
        mNameSplit = user.getName().split(" ", 2);
        mFirstNameEt.setText(mNameSplit[0]);
        mLastNameEt.setText(mNameSplit[1]);
    }

    @Override
    public void OnResultListener(boolean result) {
        if (result) {
            getActivity().finish();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_edit_details, container, false);


        mViewModel = ViewModelProviders.of(getActivity()).get(EditDetailsViewModel.class);

        Button saveBtn = view.findViewById(R.id.edit_details_save_btn);
        Button cancelBtn = view.findViewById(R.id.edit_details_cancel_btn);
        mFirstNameEt = view.findViewById(R.id.edit_details_first_name_et);
        mLastNameEt = view.findViewById(R.id.edit_details_last_name_et);
        mDobEt = view.findViewById(R.id.dobEt);

        mViewModel.setOnUserReceivedListener(this);

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

    private void saveDetails() {
        mViewModel.commitEditChanges(mFirstNameEt.getText().toString(), mLastNameEt.getText().toString());

    }
}
