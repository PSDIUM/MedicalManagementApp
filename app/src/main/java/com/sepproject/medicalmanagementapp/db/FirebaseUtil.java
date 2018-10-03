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

    private static final String DRUG_COLLECTION = "drugs";

    private TaskResultListener mResultListener;

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

    // Interface for ResultListeners
    public interface TaskResultListener {

        void OnLoginTaskResultReceived(boolean result);
        void OnRegisterTaskResultReceived(boolean result);
    }

    // Set Result Listener
    public void setnTaskResultListener(TaskResultListener listener) {

        this.mResultListener = listener;
    }

    @Nullable
    public FirebaseUser getCurrentUser() {
        return mAuth.getCurrentUser();
    }

    public void logIn(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithEmail:success");
                            mResultListener.OnLoginTaskResultReceived(true);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            mResultListener.OnLoginTaskResultReceived(false);
                        }
                    }
                });
    }

    public void registerUser(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            mResultListener.OnRegisterTaskResultReceived(true);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            mResultListener.OnRegisterTaskResultReceived(false);
                        }
                    }
                });
    }

    public Boolean isDoctor(FirebaseUser user) {
        return true;
    }

    public Query getAllDrugQuery() {
        return mFirestore.collection(DRUG_COLLECTION);
    }
}
