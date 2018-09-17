package com.sepproject.medicalmanagementapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Doctor extends User {

    public Doctor(int id, String name, String DOB, String password, String email, String userType) {
        super(id, name, DOB, password, email, userType);
    }
}