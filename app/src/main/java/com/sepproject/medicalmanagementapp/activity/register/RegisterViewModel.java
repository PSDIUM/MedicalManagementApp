package com.sepproject.medicalmanagementapp.activity.register;

import android.arch.lifecycle.ViewModel;

import com.sepproject.medicalmanagementapp.db.FirebaseUtil;

public class RegisterViewModel extends ViewModel {

    FirebaseUtil mFirebaseUtil = FirebaseUtil.getInstance();

    public boolean registerUser(String email, String password) {
        return mFirebaseUtil.registerUser(email, password);
    }
}
