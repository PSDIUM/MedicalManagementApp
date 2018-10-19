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
    private MutableLiveData<User> mPatient = new MutableLiveData<>();
    private MutableLiveData<History> mAllAppointments = new MutableLiveData<>();

    PatientNavigationViewModel() {
        mFirebaseUtil.setGetTaskResultListener(this);
        mFirebaseUtil.getAllAppointments().addSnapshotListener(new EventListener<QuerySnapshot>() {
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

    public void setPatient(String email){
        mFirebaseUtil.setPatient(email);
    }

    public LiveData<User> getPatient(){
        return mPatient;
    }

    public LiveData<List<History>> getAllAppointments(){

    }

    @Override
    public void OnGetTaskResultReceived(User user) {
        mPatient.postValue(user);
    }
}
