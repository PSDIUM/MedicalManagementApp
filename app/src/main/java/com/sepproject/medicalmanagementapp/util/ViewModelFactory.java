package com.sepproject.medicalmanagementapp.util;

import android.arch.lifecycle.ViewModelProvider.NewInstanceFactory;

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

        if (modelClass == PortalViewViewModel.class) {
            return (T) new PortalViewViewModel((Application) mParams[0], (String) mParams[1]);
        } else if (modelClass == InventoryViewViewModel.class) {
            return (T) new InventoryViewViewModel((String) mParams[0], (String) mParams[1]);
        } else if (modelClass == ManageInventoryViewModel.class) {
            return (T) new ManageInventoryViewModel((String) mParams[0]);
        } else {
            return super.create(modelClass);
        }
    }
}
