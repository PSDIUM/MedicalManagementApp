package com.sepproject.medicalmanagementapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Patient extends User {

    public Patient(int id, String name, String DOB, String password, String email, String userType) {
        super(id, name, DOB, password, email, userType);
    }

}
