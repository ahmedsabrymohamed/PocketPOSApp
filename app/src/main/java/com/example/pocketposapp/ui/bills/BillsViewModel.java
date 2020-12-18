package com.example.pocketposapp.ui.bills;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BillsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BillsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Bills fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}