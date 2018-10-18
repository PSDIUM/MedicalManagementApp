package com.sepproject.medicalmanagementapp.patient;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.sepproject.medicalmanagementapp.db.FirebaseUtil;
import com.sepproject.medicalmanagementapp.model.User;

public class PatientNavigationViewModel extends ViewModel implements FirebaseUtil.GetTaskResultListener {

    private FirebaseUtil mFirebaseUtil = FirebaseUtil.getInstance();
    private MutableLiveData<User> mPatient = new MutableLiveData<>();

    public void setPatient(String email){
        mFirebaseUtil.setPatient(email);
    }

    public LiveData<User> getPatient(){
        return mPatient;
    }

    @Override
    public void OnGetTaskResultReceived(User user) {
        mPatient.postValue(user);
    }
}
