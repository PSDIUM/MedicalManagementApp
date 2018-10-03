package com.sepproject.medicalmanagementapp.activity.login;

import android.arch.lifecycle.ViewModel;

import com.sepproject.medicalmanagementapp.db.FirebaseUtil;

public class LoginViewModel extends ViewModel {

    private FirebaseUtil mFirebaseUtil = FirebaseUtil.getInstance();

    public boolean logIn(String email, String password) {
        return mFirebaseUtil.logIn(email, password);
    }
}
