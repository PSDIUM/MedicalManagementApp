package com.sepproject.medicalmanagementapp.db;

import android.support.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class FirebaseUtil {

    private static FirebaseUtil mFirebaseUtil;
    private FirebaseAuth mAuth;
    private FirebaseFirestore mFirestore;

    private static final String DRUG_COLLECTION = "drugs";

    // Singleton instance getter
    public static FirebaseUtil getInstance() {

        if (mFirebaseUtil == null) {
            mFirebaseUtil = new FirebaseUtil();
        }
        return mFirebaseUtil;
    }

    // Private constructor to initialise auth and database
    private FirebaseUtil() {
        mAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
    }

    @Nullable
    public FirebaseUser getCurrentUser() {
        return mAuth.getCurrentUser();
    }

    public Boolean isDoctor(FirebaseUser user) {
        return true;
    }

    public Query getAllDrugQuery() {
        return mFirestore.collection(DRUG_COLLECTION);
    }
}
