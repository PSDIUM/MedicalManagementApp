package com.sepproject.medicalmanagementapp.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class History {

    private String mDate;
    private String mTime;
    private String mDescription;

    History(){

    }

    public History(String description) {
        Date date = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        mTime = timeFormat.format(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        mDate = dateFormat.format(date);
        mDescription = description;
    }

    public String getTime(){
        return mTime;
    }

    public String getDate(){
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
