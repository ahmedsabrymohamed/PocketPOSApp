package com.example.pocketposapp.util;

import androidx.annotation.NonNull;

import com.example.pocketposapp.rest.api.responses.CollectionApiResponse;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private final static String BASE_URL="http://localhost:8080/dataRepo/";
    private ApiClient(){}
    private static Retrofit retrofit=null;
    public static <T> T buildApiClient(Class<T> apiClass){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(apiClass);
    }
    public  static <U> void fetchData( Call<U> call,BiConsumer<Call<U>, Response<U>> doOnResponse,
                                        BiConsumer<Call<U>,Throwable> doOnFailure){

        call.enqueue(new Callback<U>() {
            @Override
            public void onResponse(@NonNull Call<U>call, @NonNull Response<U> response) {
                doOnResponse.accept(call,response);
            }

            @Override
            public void onFailure(@NonNull Call<U>call, @NonNull Throwable t) {
               doOnFailure.accept(call,t);
            }
        });
    }
}
