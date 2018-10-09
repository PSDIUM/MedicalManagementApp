package com.sepproject.medicalmanagementapp.navigation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.sepproject.medicalmanagementapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PatientAdapter extends FirestoreRecyclerAdapter {

    private OnPatientItemClickListener mPatientItemClickListener;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PatientAdapter(@NonNull FirestoreRecyclerOptions options) {
        super(options);
    }

    // Interface for handling OnItemClicks
    public interface OnPatientItemClickListener {

        void OnPatientItemClick(DocumentSnapshot patient, int position);
    }

    public void setOnPatientItemClickListener(OnPatientItemClickListener listener) {

        this.mPatientItemClickListener = listener;
    }

    @Override
    protected void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull Object model) {

        // TODO: Implement binds for the patient items
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.patient_item, viewGroup, false);
        return new PatientHolder(itemView);
    }

    class PatientHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.patient_item_name_tv)
        TextView mPatientTv;

        @BindView(R.id.patient_item_id_tv)
        TextView mPatientIdTv;

        public PatientHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION && mPatientItemClickListener != null) {

                        mPatientItemClickListener.OnPatientItemClick(((DocumentSnapshot) getSnapshots().getSnapshot(position)), position);
                    }
                }
            });
        }
    }
}
