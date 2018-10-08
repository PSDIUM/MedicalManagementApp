package com.sepproject.medicalmanagementapp.drug;

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
import com.sepproject.medicalmanagementapp.model.Drug;

public class DrugAdapter extends FirestoreRecyclerAdapter<Drug, DrugAdapter.DrugViewHolder> {

    private OnItemClickListener mListener;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public DrugAdapter(@NonNull FirestoreRecyclerOptions<Drug> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull DrugAdapter.DrugViewHolder holder, int position, @NonNull Drug model) {

        holder.mDrugNameTv.setText(model.getName());
        holder.mDrugPriceTv.setText(String.valueOf(model.getPrice()));
    }

    @NonNull
    @Override
    public DrugAdapter.DrugViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_drug, viewGroup,
                false);
        return new DrugViewHolder(itemView);
    }

    class DrugViewHolder extends RecyclerView.ViewHolder {

        // View fields
        TextView mDrugNameTv;
        TextView mDrugPriceTv;

        public DrugViewHolder(@NonNull View itemView) {
            super(itemView);

            mDrugNameTv = itemView.findViewById(R.id.drug_name_textview);
            mDrugPriceTv = itemView.findViewById(R.id.drug_price_textview);

            // OnClickListener for each item
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO: Implement open new fragment with binded details with OnItemClickListener
                }
            });
        }
    }

    public interface OnItemClickListener {

        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {

        this.mListener = listener;
    }
}
