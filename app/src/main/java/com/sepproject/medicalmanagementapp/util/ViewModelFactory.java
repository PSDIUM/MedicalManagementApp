package com.sepproject.medicalmanagementapp.util;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider.NewInstanceFactory;
import android.support.annotation.NonNull;

import com.sepproject.medicalmanagementapp.edit.EditDetailsViewModel;

public class ViewModelFactory extends NewInstanceFactory {

    private Object[] mParams;

    /**
     * Constructor for the factory which creates ViewModels with special constructors.
     * @param params Parameters for the ViewModel.
     */
    public ViewModelFactory(Object... params) {

        super();
        this.mParams = params;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass == EditDetailsViewModel.class) {
            return (T) new EditDetailsViewModel((String) mParams[0]);
        } else {
            return super.create(modelClass);
        }
    }
}
