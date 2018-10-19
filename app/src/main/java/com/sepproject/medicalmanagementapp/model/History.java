package com.sepproject.medicalmanagementapp.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class History {

    private Date mDate;
    private String mDescription;

    public History(String description) {
        mDate = new Date();
        mDescription = description;
    }

    public String getTime(){
        return String.valueOf(mDate.getTime());
    }

    public String getDate(){
        SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
        return date.format(mDate.getTime());
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
