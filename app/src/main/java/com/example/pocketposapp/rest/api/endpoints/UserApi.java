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
    @GET
    Call<CollectionApiResponse<User>> getUserList(@Query("page") String pageNumber);
    @GET("{id}")
    Call<User> getUserById(@Path("id") Long id);
    @POST
    Call<User> addUser(@Body User user);
    @PUT("{id}")
    Call<User> updateUser(@Body User user);
    @GET("findIfExists")
    Call<CollectionApiResponse<User>> getProductListIfExists(@Query("deleted")boolean deleted, @Query("page") String pageNumber);
    @GET("findByUserNameAndPassword")
    Call<User> getByUserNameAndPassword(@Query("userName")String userName,@Query("password")String password,@Query("deleted")boolean deleted, @Query("page") String pageNumber);
}
