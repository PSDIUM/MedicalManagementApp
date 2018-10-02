package com.sepproject.medicalmanagementapp.model;

public class Drug {

    private String mName;
    private String mRecommendedDosage;
    private Double mPrice;
    private String mSideEffects;

    // Empty constructor required by Firebase
    Drug() {}

    public Drug(String name, String recommendedDosage, Double price, String sideEffects) {

        this.mName = name;
        this.mRecommendedDosage = recommendedDosage;
        this.mPrice = price;
        this.mSideEffects = sideEffects;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getRecommendedDosage() {
        return mRecommendedDosage;
    }

    public void setRecommendedDosage(String recommendedDosage) {
        mRecommendedDosage = recommendedDosage;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double price) {
        mPrice = price;
    }

    public String getSideEffects() {
        return mSideEffects;
    }

    public void setSideEffects(String sideEffects) {
        mSideEffects = sideEffects;
    }
}
