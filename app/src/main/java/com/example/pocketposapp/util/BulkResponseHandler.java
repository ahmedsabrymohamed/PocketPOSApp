package com.example.pocketposapp.util;

import android.util.Log;

import com.example.pocketposapp.rest.api.responses.CollectionApiResponse;

import retrofit2.Call;
import retrofit2.Response;

public class BulkResponseHandler {
    public static <T> void onResponse(Call<T> call , Response<T> response){
        if(response.isSuccessful()){
            if(response.body() instanceof CollectionApiResponse){

            }else{
                Log.i("testFunction", "updateBulkList: "+call.request().method());
                Log.i("testFunction", "updateBulkList: "+response.body());
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
