package com.sepproject.medicalmanagementapp.model;

public class Test {

    private int mId;
    private int mSenderId;
    private int mRecipientId;
    private int mPatientId;
    private String mTitle;
    private String mDescription;
    private int mUrgency;
    private boolean mComplete;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getSenderId() {
        return mSenderId;
    }

    public void setSenderId(int senderId) {
        mSenderId = senderId;
    }

    public int getRecipientId() {
        return mRecipientId;
    }

    public void setRecipientId(int recipientId) {
        mRecipientId = recipientId;
    }

    public int getPatientId() { return mPatientId; }

    public void setPatientId(int patientId) {mPatientId = patientId;}

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int getUrgency() {
        return mUrgency;
    }

    public void setUrgency(int urgency) {
        mUrgency = urgency;
    }

    public boolean getComplete() {return mComplete;}
    public void setComplete(boolean complete) {mComplete = complete;}
}
