package com.sepproject.medicalmanagementapp.Patient;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.sepproject.medicalmanagementapp.model.Patient;

public class PatientViewModel extends AndroidViewModel {

    private PatientRepository mRepository;

    public PatientViewModel(Application application) {
        super(application);
        mRepository = new PatientRepository(application);
    }

    public LiveData<Patient> getPatient(int id){
        return mRepository.getPatient(id);
    }

}
