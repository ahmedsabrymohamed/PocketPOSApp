package com.example.pocketposapp.ui.clients;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pocketposapp.rest.api.responses.CollectionApiResponse;

import retrofit2.Call;
import retrofit2.Response;

public class ClientsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ClientsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Clients fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public static <T> void onResponse(Call<T> call , Response<T> response){
        if(response.isSuccessful()){
            if(response.body() instanceof CollectionApiResponse){

            }else{
                Log.i("testFunction", "updateClientList: "+call.request().method());
                Log.i("testFunction", "updateClientList: "+response.body());
            }
        }else{
            Log.i("testFunction", "Bad Response: "+call.request().body().contentType());
            Log.i("testFunction", "Bad Response: "+response.errorBody().toString());

        }
    }

    public static <T> void onFailToRequest(Call<T> call ,Throwable t){
        Log.i("testFunction", "Fail because: "+t.getMessage());
    }
}