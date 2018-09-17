package com.sepproject.medicalmanagementapp.db;

public class PatientsTable {

    public static final String TABLE_NAME = "patients";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DOB = "dob";
    public static final String COLUMN_EMAIL= "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_USER_TYPE = "userType";

    public static final String[] ALL_COLUMNS = {COLUMN_ID, COLUMN_NAME, COLUMN_DOB,
            COLUMN_EMAIL, COLUMN_PASSWORD, COLUMN_USER_TYPE};

    public static final String SQL_CREATE = "CREATE TABLE " + TABLE_NAME + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY" + " AUTOINCREMENT," +
            COLUMN_NAME + " TEXT," +
            COLUMN_DOB + " INTEGER," +
            COLUMN_EMAIL + " TEXT," +
            COLUMN_PASSWORD + " TEXT," +
            COLUMN_USER_TYPE + " TEXT" + ");";

    public static final String SQL_DELETE = "DROP TABLE " + TABLE_NAME;

}
