package com.sepproject.medicalmanagementapp.navigation;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.model.User;

import java.util.List;

public class LookupListAdaptor extends RecyclerView.Adapter<LookupListAdaptor.LookupViewHolder> {

    public interface OnClickListener {
        void displayHistory(String title);
    }

    public class LookupViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView id;
        public ImageView image;
        public CardView navigation;

        public LookupViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.patient_item_name_tv);
            id = itemView.findViewById(R.id.patient_id_tv);
            image = itemView.findViewById(R.id.patient_item_image_iv);
            navigation = itemView.findViewById(R.id.patient_item_container);
        }
    }

    private final LayoutInflater mInflater;
    private List<User> mUserList;
    private Context mContext;
    private OnClickListener mListener;

    public LookupListAdaptor(Context context, OnClickListener listener){
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mListener = listener;
    }

    @Override
    public LookupViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = mInflater.inflate(R.layout.patient_item, viewGroup, false);
        return new LookupViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LookupViewHolder holder, int position) {
        if (mUserList != null) {
            User current = mUserList.get(position);
            holder.title.setText(current.getName());
            holder.navigation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("History", "Going to patient history");
                }
            });
        } else {
            // Covers the case of data not being ready yet.
            holder.title.setText("No Word");
        }
    }

    @Override
    public int getItemCount() {
        if(mUserList !=null){
            return mUserList.size();
        }
        else return 0;
    }

    public void setPatients(List<User> patients){
        mUserList = patients;
        notifyDataSetChanged();
    }
}

