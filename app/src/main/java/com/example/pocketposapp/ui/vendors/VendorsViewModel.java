package com.example.pocketposapp.ui.vendors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VendorsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VendorsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Vendors fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}