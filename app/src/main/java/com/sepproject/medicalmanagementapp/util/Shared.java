//package com.sepproject.medicalmanagementapp.util;
//
//import android.arch.lifecycle.LiveData;
//
//import com.sepproject.medicalmanagementapp.model.Patient;
//
//public class Shared {
//
//    private LiveData<Patient> currentPatient;
//    private static Shared instance;
//
//    public static Shared getInstance(){
//        if(instance==null){
//            instance = new Shared();
//        }
//        return instance;
//    }
//
//    public LiveData<Patient> getCurrentPatient(){
//        return currentPatient;
//    }
//
//    public void setCurrentPatient(LiveData<Patient> patient){
//        currentPatient = patient;
//    }
//}
