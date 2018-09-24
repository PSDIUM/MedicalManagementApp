package com.sepproject.medicalmanagementapp.Patient;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.sepproject.medicalmanagementapp.model.Patient;

@Database(entities = {Patient.class}, version = 1)
public abstract class PatientDatabase extends RoomDatabase {

    private static volatile PatientDatabase INSTANCE;

    public abstract PatientDao patientDao();

    public static synchronized PatientDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    PatientDatabase.class, "category_database")
                    .build();
        }
        return INSTANCE;
    }


}