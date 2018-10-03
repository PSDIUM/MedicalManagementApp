package com.sepproject.medicalmanagementapp.activity.login;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.sepproject.medicalmanagementapp.Patient.PatientRepository;

public class LoginViewModel extends AndroidViewModel{

    private PatientRepository mRepository;

    public LoginViewModel(Application application) {
        super(application);
        mRepository = new PatientRepository(application);
    }
}
