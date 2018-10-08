package com.sepproject.medicalmanagementapp.register;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.sepproject.medicalmanagementapp.Patient.DoctorRepository;
import com.sepproject.medicalmanagementapp.Patient.PatientRepository;
import com.sepproject.medicalmanagementapp.model.Doctor;
import com.sepproject.medicalmanagementapp.model.Patient;

public class RegisterViewModel extends AndroidViewModel {


    DoctorRepository mDoctorRepository;
    PatientRepository mPatientRepository;

    public RegisterViewModel(Application application) {
        super(application);
        mDoctorRepository = new DoctorRepository(getApplication());
        mPatientRepository = new PatientRepository(getApplication());
    }

    public void insertDoctor(Doctor doctor){
        mDoctorRepository.insert(doctor);
    }

    public void insertPatient(Patient patient){
        mPatientRepository.insert(patient);
    }
}
