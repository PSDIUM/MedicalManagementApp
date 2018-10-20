package com.sepproject.medicalmanagementapp.doctor;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.sepproject.medicalmanagementapp.db.FirebaseUtil;
import com.sepproject.medicalmanagementapp.model.User;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class DoctorNavigationViewModel extends ViewModel implements FirebaseUtil.GetTaskResultListener {

    FirebaseUtil mFirebaseUtil = FirebaseUtil.getInstance();
    private MutableLiveData<User> mUser = new MutableLiveData<>();
    private MutableLiveData<List<User>> mAllPatients = new MutableLiveData<>();
    private MutableLiveData<List<User>> mPatients = new MutableLiveData<>();

    DoctorNavigationViewModel() {
        mFirebaseUtil.setGetTaskResultListener(this);
        mFirebaseUtil.getAllPatients().addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(e!=null){
                    e.printStackTrace();
                    return;
                }
                if(queryDocumentSnapshots!=null){
                    mAllPatients.setValue(queryDocumentSnapshots.toObjects(User.class));
                }
            }
        });
    }

    public LiveData<User> getUserLiveData(){
        return mUser;
    }

    public LiveData<List<User>> getPatients(final String name){
        mFirebaseUtil.getAllPatients().addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(e!=null){
                    e.printStackTrace();
                    return;
                }
                if(queryDocumentSnapshots!=null){
                    List<User> patients = queryDocumentSnapshots.toObjects(User.class);
                    List<User> matchingPatients = new ArrayList<>();
                    for (User patient : patients) {
                        if(patient.getName().toLowerCase().contains(name.toLowerCase())){
                            matchingPatients.add(patient);
                        }
                    }
                    mPatients.setValue(matchingPatients);
                }
            }
        });
        return mPatients;
    }

    public void getUser(String userType) {
        mFirebaseUtil.getUser(userType);
    }

    public LiveData<List<User>> getAllPatients(){
        return mAllPatients;
    }

    @Override
    public void OnGetTaskResultReceived(User user) {
        mUser.postValue(user);
    }
}
