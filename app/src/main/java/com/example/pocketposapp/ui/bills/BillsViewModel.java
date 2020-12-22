package com.example.pocketposapp.ui.bills;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pocketposapp.model.Bill;
import com.example.pocketposapp.rest.api.responses.CollectionApiResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.HTTP;

public class BillsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BillsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Bills fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public static <T> void onResponse(Call<T> call , Response<T> response){
        if(response.isSuccessful()){
            if(response.body() instanceof CollectionApiResponse){

            }else{
                Log.i("testFunction", "updateBillsList: "+call.request().method());
                Log.i("testFunction", "updateBillsList: "+response.body());
            }
        }
    }

    public static <T> void onFailToRequest(Call<T> call ,Throwable t){
        Log.i("testFunction", "Fail because: "+t.getMessage());
    }


}