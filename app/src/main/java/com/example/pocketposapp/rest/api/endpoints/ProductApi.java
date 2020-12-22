package com.example.pocketposapp.rest.api.endpoints;

import com.example.pocketposapp.rest.api.responses.CollectionApiResponse;
import com.example.pocketposapp.model.Product;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductApi {

    @GET("product/")
    Call<CollectionApiResponse<Product>> getProductList(@Query("page") Integer pageNumber);
    @GET("product/{id}")
    Call<Product> getProductById(@Path("id") Long id);
    @POST("product/")
    Call<Product> addProduct(@Body Product product);
    @PUT("product/{id}")
    Call<Product> updateProduct(@Body Product product);
    @GET("product/findIfExists")
    Call<CollectionApiResponse<Product>> getProductListIfExists(@Query("deleted")boolean deleted, @Query("page") Integer pageNumber);




}
