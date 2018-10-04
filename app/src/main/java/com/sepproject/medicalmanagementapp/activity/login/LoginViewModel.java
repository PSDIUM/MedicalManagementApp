package com.sepproject.medicalmanagementapp.activity.login;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.sepproject.medicalmanagementapp.db.FirebaseUtil;

public class LoginViewModel extends ViewModel {

    private FirebaseUtil mFirebaseUtil = FirebaseUtil.getInstance();

    private MutableLiveData<Integer> mLoginResultLiveData = new MutableLiveData<>();
    private MutableLiveData<Integer> mRegisterResultLiveData = new MutableLiveData<>();

    // Constructor
    public LoginViewModel() {

        mFirebaseUtil.setnTaskResultListener(new FirebaseUtil.TaskResultListener() {
            @Override
            public void OnLoginTaskResultReceived(boolean result) {
                if (result) {
                    mLoginResultLiveData.postValue(1);
                } else {
                    mLoginResultLiveData.postValue(0);
                }
            }

            @Override
            public void OnRegisterTaskResultReceived(boolean result) {
                if (result) {
                    mRegisterResultLiveData.postValue(1);
                } else {
                    mRegisterResultLiveData.postValue(0);
                }
            }
        });
    }

    public MutableLiveData<Integer> getLoginResultLiveData() {

        return mLoginResultLiveData;
    }

    public MutableLiveData<Integer> getRegisterResultLiveData() {

        return mRegisterResultLiveData;
    }

    public void logIn(String email, String password) {

        mFirebaseUtil.logIn(email, password);
    }
}
