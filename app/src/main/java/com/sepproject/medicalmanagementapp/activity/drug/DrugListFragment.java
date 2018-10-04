package com.sepproject.medicalmanagementapp.activity.drug;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;
import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.db.FirebaseUtil;
import com.sepproject.medicalmanagementapp.model.Drug;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class DrugListFragment extends Fragment {

    private DrugAdapter mAdapter;

    @BindView(R.id.drug_recycler)
    RecyclerView mRecyclerView;

    public DrugListFragment() {
    }

    public static DrugListFragment newInstance() {
        return new DrugListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_drug, container, false);
        // Bind views with ButterKnife
        ButterKnife.bind(this, view);

        // TODO: Move this into ViewModel
        FirebaseUtil firebaseUtil = FirebaseUtil.getInstance();
        Query query = firebaseUtil.getAllDrugQuery();

        // Create FirebaseUI RecyclerView adapter
        FirestoreRecyclerOptions<Drug> options = new FirestoreRecyclerOptions.Builder<Drug>()
                .setQuery(query, Drug.class)
                .setLifecycleOwner(this)
                .build();

        // Find and assign views
        mAdapter = new DrugAdapter(options);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
