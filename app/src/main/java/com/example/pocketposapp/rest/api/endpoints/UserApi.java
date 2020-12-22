package com.example.pocketposapp.rest.api.endpoints;

import com.example.pocketposapp.rest.api.responses.CollectionApiResponse;
import com.example.pocketposapp.model.User;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserApi {
    @GET("user/")
    Call<CollectionApiResponse<User>> getUserList(@Query("page") Integer pageNumber);
    @GET("user/{id}")
    Call<User> getUserById(@Path("id") Long id);
    @POST("user/")
    Call<User> addUser(@Body User user);
    @PUT("user/{id}")
    Call<User> updateUser(@Body User user);
    @GET("user/findIfExists")
    Call<CollectionApiResponse<User>> getProductListIfExists(@Query("deleted")boolean deleted, @Query("page") Integer pageNumber);
    @GET("user/findByUserNameAndPassword")
    Call<User> getByUserNameAndPassword(@Query("userName")String userName,@Query("password")String password,@Query("deleted")boolean deleted);
}
