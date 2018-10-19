package com.sepproject.medicalmanagementapp.patient;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sepproject.medicalmanagementapp.R;
import com.sepproject.medicalmanagementapp.model.History;
import com.sepproject.medicalmanagementapp.model.User;
import com.sepproject.medicalmanagementapp.navigation.LookupListAdaptor;

import java.util.List;

public class AppointmentListAdaptor extends RecyclerView.Adapter<AppointmentListAdaptor.AppointmentViewHolder>  {

    public interface OnClickListener {
        void displayHistory(String email);
    }

    public class AppointmentViewHolder extends RecyclerView.ViewHolder {
        public TextView time;
        public TextView date;
        public TextView description;

        public AppointmentViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.appointment_time);
            date = itemView.findViewById(R.id.appointment_date);
            description = itemView.findViewById(R.id.appointment_description);
        }
    }

    private final LayoutInflater mInflater;
    private List<History> mHistoryList;
    private Context mContext;

    public AppointmentListAdaptor(Context context){
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public AppointmentListAdaptor.AppointmentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = mInflater.inflate(R.layout.appointment_item, viewGroup, false);
        return new AppointmentListAdaptor.AppointmentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AppointmentListAdaptor.AppointmentViewHolder holder, int position) {
        if (mHistoryList != null) {
            final History current = mHistoryList.get(position);
            holder.time.setText(current.getTime());
            holder.date.setText(current.getDate());
            holder.description.setText(current.getDescription());
        }
    }

    @Override
    public int getItemCount() {
        if(mHistoryList !=null){
            return mHistoryList.size();
        }
        else return 0;
    }

    public void setHistory(List<History> appointments){
        mHistoryList = appointments;
        notifyDataSetChanged();
    }
}

