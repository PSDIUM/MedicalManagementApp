package com.sepproject.medicalmanagementapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sepproject.medicalmanagementapp.model.Doctor;
import com.sepproject.medicalmanagementapp.model.Patient;
import com.sepproject.medicalmanagementapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDatabaseHelper extends SQLiteOpenHelper {

    private static UserDatabaseHelper sInstance;

    public static final String DB_FILE_NAME = "users";
    public static final int DB_VERSION = 1;

    /**
     * Singleton used to access the one instance of the class
     */

    public static synchronized UserDatabaseHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new UserDatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    /**
     * Constructor for the TrainDataBaseHelper class
     */

    public UserDatabaseHelper(Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserTable.SQL_CREATE);
    }

    /**
     * Returns all train data in the trains table
     */

    /*
    public List<User> getAllData(){
        List<User> users = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + UserTable.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();

        // Returns row based on selectQuery
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User train = new User(
                        cursor.getInt(cursor.getColumnIndex(COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_PLATFORM)),
                        cursor.getInt(cursor.getColumnIndex(COLUMN_ARRIVAL_TIME)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_STATUS)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_DESTINATION)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_DESTINATION_TIME))
                );
                trains.add(train);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return train list
        return trains;
    }
    */

    /**
     * Returns train data from a row in trains table based on the id
     */

    public User userLogin(String email, String password) {
        User user = null;

        // get readable database
        SQLiteDatabase db = this.getReadableDatabase();

        // Obtain row based on id
        Cursor cursor = db.query(UserTable.TABLE_NAME, UserTable.ALL_COLUMNS,
                null, null,
                null, null, null, null);

        if (cursor.moveToFirst()){
            do {
                // prepare train object using row data
                if(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_EMAIL)).equals(email) &&
                        cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_PASSWORD)).equals(password)) {

                    if (cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_USER_TYPE)).equals("patient")) {
                        user = new Patient(
                                cursor.getInt(cursor.getColumnIndex(UserTable.COLUMN_ID)),
                                cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME)),
                                cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_DOB)),
                                cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_EMAIL)),
                                cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_PASSWORD)),
                                cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_USER_TYPE))
                        );
                    } else {
                        user = new Doctor(
                                cursor.getInt(cursor.getColumnIndex(UserTable.COLUMN_ID)),
                                cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME)),
                                cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_DOB)),
                                cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_EMAIL)),
                                cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_PASSWORD)),
                                cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_USER_TYPE))
                        );
                    }
                }
            } while (cursor.moveToNext());
        }

        // close the db connection
        cursor.close();

        return user;
    }

    /**
     * Inserts train data into table and row id
     */

    public long registerUser(User user){
        long tempLong = registerUser(this.getWritableDatabase(), user);
        close();
        return tempLong;
    }

    private long registerUser(SQLiteDatabase db, User user){
        ContentValues values = new ContentValues();

        values.put(UserTable.COLUMN_NAME, user.getName());
        values.put(UserTable.COLUMN_DOB, user.getDOB());
        values.put(UserTable.COLUMN_EMAIL, user.getEmail());
        values.put(UserTable.COLUMN_PASSWORD, user.getPassword());
        values.put(UserTable.COLUMN_USER_TYPE, user.getUserType());

        return db.insert(UserTable.TABLE_NAME,null,values);
    }

    /**
     * delete all content from trains table
     */

    public void deleteAll(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from "+ UserTable.TABLE_NAME);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
