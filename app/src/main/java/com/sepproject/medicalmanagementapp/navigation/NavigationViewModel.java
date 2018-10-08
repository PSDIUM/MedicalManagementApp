package com.sepproject.medicalmanagementapp.navigation;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.sepproject.medicalmanagementapp.db.FirebaseUtil;
import com.sepproject.medicalmanagementapp.model.User;

import java.util.List;

public class NavigationViewModel extends ViewModel implements FirebaseUtil.GetTaskResultListener {

    FirebaseUtil mFirebaseUtil = FirebaseUtil.getInstance();
    private MutableLiveData<User> mUser = new MutableLiveData<>();

    public LiveData<User> getUserLiveData(){
        return mUser;
    }

    NavigationViewModel() {
        mFirebaseUtil.setGetTaskResultListener(this);
    }

    public void getUser(String userType) {

        mFirebaseUtil.getUser(userType);
    }

    @Override
    public void OnGetTaskResultReceived(User user) {

        mUser.postValue(user);
    }
}
