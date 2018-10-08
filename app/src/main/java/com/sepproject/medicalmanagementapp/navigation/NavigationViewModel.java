package com.sepproject.medicalmanagementapp.navigation;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.sepproject.medicalmanagementapp.db.FirebaseUtil;
import com.sepproject.medicalmanagementapp.model.User;

import java.util.List;

public class NavigationViewModel extends ViewModel {


    FirebaseUtil mFirebaseUtil = FirebaseUtil.getInstance();
    private MutableLiveData<User> mUser;

    public LiveData<User> getUser(String userType){
        mUser.setValue(mFirebaseUtil.getUser(userType));
        return mUser;
    }

}
