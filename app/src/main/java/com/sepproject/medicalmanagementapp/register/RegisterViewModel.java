package com.sepproject.medicalmanagementapp.register;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.sepproject.medicalmanagementapp.Patient.DoctorRepository;
import com.sepproject.medicalmanagementapp.Patient.PatientRepository;
import com.sepproject.medicalmanagementapp.model.Doctor;
import com.sepproject.medicalmanagementapp.model.Patient;
import com.sepproject.medicalmanagementapp.model.User;

public class RegisterViewModel extends ViewModel {


    FirebaseUtil mFirebaseUtil = FirebaseUtil.getInstance();

    public void registerUser(User user){
        mFirebaseUtil.registerUser(user);
    }

    public void registerUser(String email, String password){
        mFirebaseUtil.registerUser(email, password);
    }
}
