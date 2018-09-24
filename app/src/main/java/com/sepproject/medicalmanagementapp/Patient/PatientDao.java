package com.sepproject.medicalmanagementapp.Patient;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.sepproject.medicalmanagementapp.model.Patient;

import java.util.List;

@Dao
public interface PatientDao {

    @Insert
    void insert(Patient patient);

    @Update
    void update(Patient patient);

    @Delete
    void delete(Patient patient);

    @Query("DELETE FROM patient_table")
    void deleteAll();

    @Query("SELECT * FROM patient_table WHERE mEmail=:email AND mPassword=:password")
    LiveData<Patient> getPatient(String email, String password);

    @Query("SELECT * FROM patient_table")
    LiveData<List<Patient>> getAllPatients();
}
