package com.sepproject.medicalmanagementapp.model;

import android.arch.persistence.room.Entity;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

@Entity(tableName = "patient_table")
public class Patient extends User {

    public Patient(int id, String name, String DOB, String password, String email, String userType) {
        super(id, name, DOB, password, email, userType);
    }

}
