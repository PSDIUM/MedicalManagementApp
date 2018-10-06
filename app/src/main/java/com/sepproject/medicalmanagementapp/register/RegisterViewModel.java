package com.sepproject.medicalmanagementapp.register;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.sepproject.medicalmanagementapp.database.PatientRepository;
import com.sepproject.medicalmanagementapp.model.Patient;

public class RegisterViewModel extends AndroidViewModel {

    private PatientRepository mRepository;

    public RegisterViewModel(Application application) {
        super(application);
        mRepository = new PatientRepository(application);
    }

    public void insert(Patient patient){
        mRepository.insert(patient);
    }
}
