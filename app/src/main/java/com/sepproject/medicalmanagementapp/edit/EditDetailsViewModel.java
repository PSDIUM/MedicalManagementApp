package com.sepproject.medicalmanagementapp.edit;
import android.arch.lifecycle.ViewModel;
import com.sepproject.medicalmanagementapp.db.FirebaseUtil;
import com.sepproject.medicalmanagementapp.model.User;

import java.util.HashMap;
import java.util.Map;


public class EditDetailsViewModel extends ViewModel implements FirebaseUtil.GetTaskResultListener {

    private FirebaseUtil mFirebaseUtil = FirebaseUtil.getInstance();
    private String[] mNameSplit;
    private User mUser;

    private OnResultListener mListener;

    public interface OnResultListener {
        void OnUserReceived(User user);
        void OnResultListener(boolean result);
    }

    public void setOnUserReceivedListener(OnResultListener listener) {
        mListener = listener;
    }

    public EditDetailsViewModel(String email) {

        mFirebaseUtil.setGetTaskResultListener(this);
        // Get user based off email
        mFirebaseUtil.setPatient(email);
    }

    public String getFirstName() {
        return mNameSplit[0];
    }

    public String getLastName() {
        return mNameSplit[1];
    }

    public void commitEditChanges(String firstName, String lastName) {
        String nameConcat = "";
        // Verify the changes
        if (!firstName.trim().equals(mNameSplit[0])) {
            nameConcat += firstName.trim();
        } else {
            nameConcat += mNameSplit[0];
        }

        nameConcat += " ";

        if (!lastName.trim().equals(mNameSplit[1])) {
            nameConcat += lastName.trim();
        } else {
            nameConcat += mNameSplit[1];
        }

        // Create map of details
        Map<String, Object> name = new HashMap<>();
        name.put("name", nameConcat);

        mFirebaseUtil.updateUsersName(mUser.getEmail(), name);
        mListener.OnResultListener(true);
    }

    @Override
    public void OnGetTaskResultReceived(User user) {
        // Not required
    }

    @Override
    public void OnGetPatientResultListener(User user) {
        // Set the current EditTexts with the names
        // Save name
        mUser = user;
        mNameSplit = user.getName().split(" ", 2);
        mListener.OnUserReceived(user);
    }
}
