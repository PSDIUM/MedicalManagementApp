package com.sepproject.medicalmanagementapp.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "patient_table")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int mId;
    private String mName;
    private String mPassword;
    private String mEmail;
    private String mUserType;

    public User(String name, String password, String email, String userType) {
        mName = name;
        mPassword = password;
        mEmail = email;
        mUserType = userType;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getUserType() {
        return mUserType;
    }

    public void setUserType(String userType) {
        mUserType = userType;
    }
}
