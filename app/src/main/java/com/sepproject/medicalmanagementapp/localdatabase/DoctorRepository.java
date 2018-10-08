//package com.sepproject.medicalmanagementapp.localdatabase;
//
//import android.app.Application;
//import android.arch.lifecycle.LiveData;
//import android.os.AsyncTask;
//
//import com.sepproject.medicalmanagementapp.model.Doctor;
//import com.sepproject.medicalmanagementapp.model.Patient;
//
//import java.util.List;
//
//public class DoctorRepository {
//
//    private DoctorDao mDoctorDao;
//    private LiveData<List<Doctor>> mAllDoctors;
//
//    public DoctorRepository(Application application){
//        PatientDatabase db = PatientDatabase.getInstance(application);
//        mDoctorDao = db.doctorDao();
//    }
//
//    public void insert(Doctor doctor){
//        new InsertDoctorAsyncTask(mDoctorDao).execute(doctor);
//    }
//
//    public void update(Doctor doctor){
//        new UpdateDoctorAsyncTask(mDoctorDao).execute(doctor);
//    }
//
//    public void delete(Doctor doctor){
//        new DeleteDoctorAsyncTask(mDoctorDao).execute(doctor);
//    }
//
//    public LiveData<Doctor> getDoctor(String email, String password) {
//        return mDoctorDao.getDoctor(email, password);
//    }
//
//    public LiveData<Doctor> getDoctorById(int id) {
//        return mDoctorDao.getDoctorById(id);
//    }
//
//    private static class InsertDoctorAsyncTask extends AsyncTask<Doctor, Void, Void> {
//
//        private DoctorDao mDoctorDao;
//
//        private InsertDoctorAsyncTask(DoctorDao doctorDao){
//            mDoctorDao = doctorDao;
//        }
//
//        @Override
//        protected Void doInBackground(Doctor... doctors) {
//            mDoctorDao.insert(doctors[0]);
//            return null;
//        }
//    }
//
//    private static class UpdateDoctorAsyncTask extends AsyncTask<Doctor, Void, Void>{
//
//
//        private DoctorDao mDoctorDao;
//
//        private UpdateDoctorAsyncTask(DoctorDao doctorDao){
//            mDoctorDao = doctorDao;
//        }
//
//        @Override
//        protected Void doInBackground(Doctor... doctors) {
//            mDoctorDao.update(doctors[0]);
//            return null;
//        }
//    }
//
//    private static class DeleteDoctorAsyncTask extends AsyncTask<Doctor, Void, Void>{
//
//
//        private DoctorDao mDoctorDao;
//
//        private DeleteDoctorAsyncTask(DoctorDao doctorDao){
//            mDoctorDao = doctorDao;
//        }
//
//        @Override
//        protected Void doInBackground(Doctor... doctors) {
//            mDoctorDao.delete(doctors[0]);
//            return null;
//        }
//    }
//
//}