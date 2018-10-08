
//package com.sepproject.medicalmanagementapp.localdatabase;
//
//import android.app.Application;
//import android.arch.lifecycle.LiveData;
//import android.os.AsyncTask;
//
//import com.sepproject.medicalmanagementapp.model.Patient;
//
//import java.util.List;
//
//public class PatientRepository {
//
//    private PatientDao mPatientDao;
//    private LiveData<List<Patient>> mAllPatients;
//
//    public PatientRepository(Application application){
//        PatientDatabase categoryDatabase = PatientDatabase.getInstance(application);
//        mPatientDao = categoryDatabase.patientDao();
//        mAllPatients = mPatientDao.getAllPatients();
//    }
//
//    public void insert(Patient patient){
//        new InsertPatientAsyncTask(mPatientDao).execute(patient);
//    }
//
//    public void update(Patient patient){
//        new UpdatePatientAsyncTask(mPatientDao).execute(patient);
//    }
//
//    public void delete(Patient patient){
//        new DeletePatientAsyncTask(mPatientDao).execute(patient);
//    }
//
//    public LiveData<List<Patient>> getAllPatients(){
//        return mAllPatients;
//    }
//
//    public LiveData<Patient> getPatient(String email, String password) {
//        return mPatientDao.getPatient(email,password);
//    }
//
//    private static class InsertPatientAsyncTask extends AsyncTask<Patient, Void, Void> {
//
//        private PatientDao mPatientDao;
//
//        private InsertPatientAsyncTask(PatientDao patientDao){
//            mPatientDao = patientDao;
//        }
//        @Override
//        protected Void doInBackground(Patient... patients) {
//            mPatientDao.insert(patients[0]);
//            return null;
//        }
//    }
//
//    private static class UpdatePatientAsyncTask extends AsyncTask<Patient, Void, Void>{
//
//        private PatientDao mPatientDao;
//
//        private UpdatePatientAsyncTask(PatientDao patientDao){
//            mPatientDao = patientDao;
//        }
//        @Override
//        protected Void doInBackground(Patient... patients) {
//            mPatientDao.update(patients[0]);
//            return null;
//        }
//    }
//
//    private static class DeletePatientAsyncTask extends AsyncTask<Patient, Void, Void>{
//
//        private PatientDao mPatientDao;
//
//        private DeletePatientAsyncTask(PatientDao patientDao){
//            mPatientDao = patientDao;
//        }
//        @Override
//        protected Void doInBackground(Patient... patients) {
//            mPatientDao.delete(patients[0]);
//            return null;
//        }
//    }
//
//}