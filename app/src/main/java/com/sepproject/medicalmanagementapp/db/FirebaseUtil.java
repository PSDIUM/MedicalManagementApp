package com.sepproject.medicalmanagementapp.db;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class FirebaseUtil {

    private static final String TAG = "FirebaseUtil";

    private static FirebaseUtil mFirebaseUtil;
    private FirebaseAuth mAuth;
    private FirebaseFirestore mFirestore;

    private boolean mLoginResult = false;

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

    // Login/user methods
    @Nullable
    public FirebaseUser getCurrentUser() {
        return mAuth.getCurrentUser();
    }

    public boolean logIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithEmail:success");
                            setLoginResult(true);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            setLoginResult(false);
                        }
                    }
                });

        return mLoginResult;
    }

    private void setLoginResult(boolean success) {
        mLoginResult = success;
    }


    public Boolean isDoctor(FirebaseUser user) {
        return true;
    }

    public Query getAllDrugQuery() {
        return mFirestore.collection(DRUG_COLLECTION);
    }
}
