package com.sepproject.medicalmanagementapp.register;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.db.FirebaseUtil;
import com.sepproject.medicalmanagementapp.model.User;

public class RegisterFragment extends Fragment {

    RegisterViewModel mRegisterViewModel;

    private EditText mFirstNameEt;
    private EditText mLastNameEt;
    private EditText mDobEt;
    private EditText mEmailEt;
    private EditText mPasswordEt;
    private Spinner mSpinner;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_register, container, false);


        mRegisterViewModel = ViewModelProviders.of(getActivity()).get(RegisterViewModel.class);

        mSpinner = view.findViewById(R.id.user_spinner);
        Button registerBtn = view.findViewById(R.id.register_btn);
        Button cancelBtn = view.findViewById(R.id.cancel_btn);
        mFirstNameEt = view.findViewById(R.id.firstNameEt);
        mLastNameEt = view.findViewById(R.id.lastNameEt);
        mDobEt = view.findViewById(R.id.dobEt);
        mEmailEt = view.findViewById(R.id.new_email_Et);
        mPasswordEt = view.findViewById(R.id.new_password_et);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.user_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        mSpinner.setAdapter(adapter);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
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

    private void registerUser(){
        String name = mFirstNameEt.getText().toString() + " " + mLastNameEt.getText().toString();
        String email = mEmailEt.getText().toString();
        String password = mPasswordEt.getText().toString();
        String userType = mSpinner.getSelectedItem().toString();

        User user = new User(name, password, email, userType);
        mRegisterViewModel.registerUser(user);
        mRegisterViewModel.registerUser(email, password);
        getActivity().setResult(getActivity().RESULT_OK);
        getActivity().finish();
    }
}
