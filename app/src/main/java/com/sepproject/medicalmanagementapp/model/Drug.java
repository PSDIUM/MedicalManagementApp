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
}
