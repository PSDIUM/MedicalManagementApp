package com.sepproject.medicalmanagementapp.login;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.sepproject.medicalmanagementapp.database.PatientRepository;
import com.sepproject.medicalmanagementapp.model.Patient;
import com.sepproject.medicalmanagementapp.util.Shared;

public class LoginViewModel extends AndroidViewModel{

    private PatientRepository mRepository;
    private LiveData<Patient> mPatient;

    public LoginViewModel(Application application) {
        super(application);
        mRepository = new PatientRepository(application);
    }

    public LiveData<Patient> getPatient(String email, String password){
        mPatient = mRepository.getPatient(email, password);
        return mPatient;
    }
}
