package com.sepproject.medicalmanagementapp.activity.drug;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sepproject.medicalmanagementapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddDrugFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddDrugFragment extends Fragment {

    public AddDrugFragment() {
        // Required empty public constructor
    }

    public static AddDrugFragment newInstance() {
        return new AddDrugFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_drug, container, false);
    }

}
