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

    @GET
    Call<CollectionApiResponse<Product>> getProductList(@Query("page") String pageNumber);
    @GET("{id}")
    Call<Product> getProductById(@Path("id") Long id);
    @POST
    Call<Product> addProduct(@Body Product product);
    @PUT("{id}")
    Call<Product> updateProduct(@Body Product product);
    @GET("findIfExists")
    Call<CollectionApiResponse<Product>> getProductListIfExists(@Query("deleted")boolean deleted, @Query("page") String pageNumber);




}
