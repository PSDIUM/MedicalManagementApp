//package com.sepproject.medicalmanagementapp.localdatabase;
//
//import android.arch.lifecycle.LiveData;
//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Delete;
//import android.arch.persistence.room.Insert;
//import android.arch.persistence.room.Query;
//import android.arch.persistence.room.Update;
//
//import com.sepproject.medicalmanagementapp.model.Doctor;
//import com.sepproject.medicalmanagementapp.model.Patient;
//
//import java.util.List;
//
//@Dao
//public interface DoctorDao {
//
//    @Insert
//    void insert(Doctor doctor);
//
//    @Update
//    void update(Doctor doctor);
//
//    @Delete
//    void delete(Doctor doctor);
//
//    @Query("DELETE FROM doctor_table")
//    void deleteAll();
//
//    @Query("SELECT * FROM doctor_table WHERE mEmail=:email AND mPassword=:password")
//    LiveData<Doctor> getDoctor(String email, String password);
//
//    @Query("SELECT * FROM doctor_table WHERE mId=:id")
//    LiveData<Doctor> getDoctorById(int id);
//
//    @Query("SELECT * FROM doctor_table")
//    LiveData<List<Doctor>> getAllDoctors();
//}