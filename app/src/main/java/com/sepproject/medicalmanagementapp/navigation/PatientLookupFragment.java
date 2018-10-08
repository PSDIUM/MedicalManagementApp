/*
package com.sepproject.medicalmanagementapp.navigation;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.model.Patient;
import com.sepproject.medicalmanagementapp.util.ViewStatePagerAdaptor;

import java.util.List;

public class PatientLookupFragment extends Fragment implements LookupListAdaptor.OnClickListener {


    private NavigationViewModel mNavigationViewModel;
    private LookupListAdaptor mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_patient_lookup, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.patient_lookup_rv);
        mAdapter = new LookupListAdaptor(getActivity(), this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mNavigationViewModel = ViewModelProviders.of(getActivity()).get(NavigationViewModel.class);

        mNavigationViewModel.getAllPatients().observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(List<Patient> patients) {
                mAdapter.setPatients(patients);
            }
        });
        return view;
    }

    @Override
    public void displayHistory(String title) {

    }
}
*/