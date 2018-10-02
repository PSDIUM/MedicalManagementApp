package com.sepproject.medicalmanagementapp.activity.drug;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;
import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.db.FirebaseUtil;
import com.sepproject.medicalmanagementapp.model.Drug;

/**
 * A placeholder fragment containing a simple view.
 */
public class DrugActivityFragment extends Fragment {

    public DrugActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // TODO: Move this into ViewModel
        FirebaseUtil firebaseUtil = FirebaseUtil.getInstance();

        Query query = firebaseUtil.getAllDrugQuery();

        // Create FirebaseUI RecyclerView adapter
        FirestoreRecyclerOptions<Drug> options = new FirestoreRecyclerOptions.Builder<Drug>()
                .setQuery(query, Drug.class)
                .build();

        // Create the adapter
        FirestoreRecyclerAdapter adapter = new FirestoreRecyclerAdapter<Drug, DrugViewHolder>(options) {
            @Override
            public void onBindViewHolder(DrugViewHolder holder, int position, Drug model) {
                // Bind the Chat object to the ChatHolder
                // ...
            }

            @Override
            public DrugViewHolder onCreateViewHolder(ViewGroup group, int i) {
                // Create a new instance of the ViewHolder, in this case we are using a custom
                // layout called R.layout.message for each item
                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.item_drug, group, false);

                return new DrugViewHolder(view);
            }
            private static class DrugViewHolder extends RecyclerView.ViewHolder {
                // each data item is just a string in this case
                public TextView mTextView;
                public MyViewHolder(TextView v) {
                    super(v);
                    mTextView = v;
                }
            }

        };

        return inflater.inflate(R.layout.fragment_drug, container, false);
    }
}
