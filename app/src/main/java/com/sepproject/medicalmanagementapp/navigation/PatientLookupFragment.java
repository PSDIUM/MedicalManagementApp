
package com.sepproject.medicalmanagementapp.navigation;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.model.User;

import java.util.List;

public class PatientLookupFragment extends Fragment implements LookupListAdaptor.OnClickListener {


    private NavigationViewModel mNavigationViewModel;
    private LookupListAdaptor mAdapter;
    private CountDownTimer mTimer;
    private EditText mSearchEt;
    private String mSearchPatient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_patient_lookup, container, false);

        mSearchEt = view.findViewById(R.id.patient_search_et);

        RecyclerView recyclerView = view.findViewById(R.id.patient_lookup_rv);
        mAdapter = new LookupListAdaptor(getActivity(), this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mNavigationViewModel = ViewModelProviders.of(getActivity()).get(NavigationViewModel.class);

        mNavigationViewModel.getAllPatients().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> patients) {
                mAdapter.setPatients(patients);
            }
        });

        setupTimer();
        setupTextListener();
        return view;
    }

    /**
     * Called when the user types within the mSearchEt
     */
    private void setupTextListener(){
        mSearchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Sets the mSearchPatient to the charSequence
                mSearchPatient = charSequence.toString();

                // Starts timer and refreshes if user continues to type before completion.
                mTimer.start();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /**
     * Starts a countdown that searches the input of the user once it
     * has completed
     */
    private void setupTimer(){
        mTimer = new CountDownTimer(1000, 1000) {

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                // Search for patient on the completion of timer
                searchForPatient();
            }
        };
    }

    /**
     * Observes both a list of groups and a list of categories. The list of groups are determine by the
     * mSearchPatient. The list of groups are then used to determine the list of categories observed.
     * RecyclerView is made visible and updated when the data within the list of categories is changed.
     */
    private void searchForPatient(){
        mNavigationViewModel.getPatients(mSearchPatient).observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> patients) {
                mAdapter.setPatients(patients);
            }
        });
    }


    @Override
    public void displayHistory(String title) {

    }
}
