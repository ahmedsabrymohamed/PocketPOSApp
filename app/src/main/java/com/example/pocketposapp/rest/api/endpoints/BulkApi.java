package com.example.pocketposapp.rest.api.endpoints;

import com.example.pocketposapp.rest.api.responses.CollectionApiResponse;

import com.example.pocketposapp.model.Bulk;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BulkApi {
    @GET("bulk/")
    Call<CollectionApiResponse<Bulk>> getBulkList(@Query("page") Integer pageNumber);
    @GET("bulk/{id}")
    Call<Bulk> getBulkById(@Path("id") Long id);
    @POST("bulk/")
    Call<Bulk> addBulk(@Body Bulk bulk);
    @PUT("bulk/{id}")
    Call<Bulk> updateBulk(@Body Bulk bulk);
    @GET("bulk/findIfExists")
    Call<CollectionApiResponse<Bulk>> getBulkListIfExists(@Query("deleted")boolean deleted, @Query("page") Integer pageNumber);
    @GET("bulk/findByProductId")
    Call<CollectionApiResponse<Bulk>> getBulkListByProductId(@Query("productId")Long id,@Query("deleted")boolean deleted, @Query("page") Integer pageNumber);

}
