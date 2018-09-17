package com.sepproject.medicalmanagementapp.model;

import java.io.Serializable;

public class User implements Serializable {

    private int mId;
    private String mName;
    private String mDOB;
    private String mPassword;
    private String mEmail;
    private String mUserType;

    public User(int id, String name, String DOB, String password, String email, String userType) {
        mId = id;
        mName = name;
        mDOB = DOB;
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

    public String getDOB() {
        return mDOB;
    }

    public void setDOB(String DOB) {
        mDOB = DOB;
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
