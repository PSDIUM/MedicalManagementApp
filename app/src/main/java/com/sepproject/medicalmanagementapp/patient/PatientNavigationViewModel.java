package com.sepproject.medicalmanagementapp.patient;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.sepproject.medicalmanagementapp.db.FirebaseUtil;
import com.sepproject.medicalmanagementapp.model.History;
import com.sepproject.medicalmanagementapp.model.User;

import java.util.List;

import javax.annotation.Nullable;

public class PatientNavigationViewModel extends ViewModel implements FirebaseUtil.GetTaskResultListener {

    private FirebaseUtil mFirebaseUtil = FirebaseUtil.getInstance();
    private MutableLiveData<User> mUser = new MutableLiveData<>();
    private MutableLiveData<User> mPatient = new MutableLiveData<>();
    private MutableLiveData<List<History>> mAllAppointments = new MutableLiveData<>();

    PatientNavigationViewModel() {
        mFirebaseUtil.setGetTaskResultListener(this);
    }

    public String getUserEmail(){
        return mFirebaseUtil.getUserEmail();
    }

    public LiveData<User> setUser(){
        return mUser;
    }

    public void getUser(String userType){
        mFirebaseUtil.getUser(userType);
    }

    public void setPatient(String email){
        mFirebaseUtil.setPatient(email);
    }

    public LiveData<User> getPatient() {
        return mPatient;
    }

    public LiveData<List<History>> getAllAppointments(){
        return mAllAppointments;
    }

    public void addAppointment(User user, History appointment){
        mFirebaseUtil.addAppointment(user, appointment);
    }

    public void setPatientAppointments(String email){
        mFirebaseUtil.getAllPatientAppointments(email).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(e!=null){
                    e.printStackTrace();
                    return;
                }
                if(queryDocumentSnapshots!=null){
                    mAllAppointments.setValue(queryDocumentSnapshots.toObjects(History.class));
                }
            }
        });
    }

    @Override
    public void OnGetTaskResultReceived(User user) {
        mUser.postValue(user);
    }

    @Override
    public void OnGetPatientResultListener(User user) {
        mPatient.postValue(user);
    }
}
