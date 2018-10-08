//package com.sepproject.medicalmanagementapp.localdatabase;
//
//import android.arch.persistence.db.SupportSQLiteDatabase;
//import android.arch.persistence.room.Database;
//import android.arch.persistence.room.Room;
//import android.arch.persistence.room.RoomDatabase;
//import android.content.Context;
//import android.os.AsyncTask;
//import android.support.annotation.NonNull;
//import android.util.Log;
//
//import com.sepproject.medicalmanagementapp.model.Doctor;
//import com.sepproject.medicalmanagementapp.model.Patient;
//
//@Database(entities = {Patient.class, Doctor.class}, version = 1)
//public abstract class PatientDatabase extends RoomDatabase {
//
//    private static volatile PatientDatabase INSTANCE;
//
//    public abstract PatientDao patientDao();
//    public abstract DoctorDao doctorDao();
//
//
//    private static PatientDatabase.Callback sCategoryDatabaseCallback = new PatientDatabase.Callback() {
//        @Override
//        public void onOpen(@NonNull SupportSQLiteDatabase db) {
//            super.onOpen(db);
//            Log.d("Database", "Opened");
//            new PopulateDbAsync(INSTANCE).execute();
//        }
//    };
//
//    public static synchronized PatientDatabase getInstance(Context context){
//        if(INSTANCE == null){
//            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
//                    PatientDatabase.class, "medical_database")
//                    .addCallback(sCategoryDatabaseCallback)
//                    .build();
//        }
//        return INSTANCE;
//    }
//
//    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
//
//        private final PatientDao mPatientDao;
//        private final DoctorDao mDoctorDao;
//
//        PopulateDbAsync(PatientDatabase db) {
//            mPatientDao = db.patientDao();
//            mDoctorDao = db.doctorDao();
//        }
//
//        @Override
//        protected Void doInBackground(final Void... params) {
//            mDoctorDao.deleteAll();
//            Doctor doctor = new Doctor("Jimmy jims", "jim69@gmail.com", "69", "Doctor");
//            mDoctorDao.insert(doctor);
//            return null;
//        }
//
//    }
//}
