package com.sepproject.medicalmanagementapp.activity.register;

import android.arch.lifecycle.ViewModel;

import com.sepproject.medicalmanagementapp.db.FirebaseUtil;

public class RegisterViewModel extends ViewModel {

    FirebaseUtil mFirebaseUtil = FirebaseUtil.getInstance();

    public void registerUser(String email, String password) {

         mFirebaseUtil.registerUser(email, password);
    }
}
