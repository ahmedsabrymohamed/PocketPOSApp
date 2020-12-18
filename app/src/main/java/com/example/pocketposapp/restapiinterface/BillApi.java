package com.example.pocketposapp.restapiinterface;

import com.example.pocketposapp.apiresponses.CollectionApiResponse;
import com.example.pocketposapp.model.Bill;
import com.example.pocketposapp.model.BillType;
import com.example.pocketposapp.model.Product;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BillApi {
    @GET
    Call<CollectionApiResponse<Bill>> getBillList(@Query("page") String pageNumber);

    @GET("{id}")
    Call<Bill> getBillById(@Path("id") Long id);

    @POST
    Call<Bill> addBill(@Body Bill bill);

    @PUT("{id}")
    Call<Bill> updateBill(@Body Bill bill);

    @GET("findIfExists")
    Call<CollectionApiResponse<Bill>> getBillListIfExists(@Query("deleted") boolean deleted, @Query("page") String pageNumber);

    @GET("findBySecondPartyId")
    Call<CollectionApiResponse<Bill>> getBillListBySecondPartyId(@Query("deleted") boolean deleted, @Query("SecondPartyId") Long SecondPartyId, @Query("page") String pageNumber);

    @GET("findByBillType")
    Call<CollectionApiResponse<Bill>> getBillListByBillType(@Query("deleted") boolean deleted, @Query("billType") BillType billType, @Query("page") String pageNumber);

    @GET("findBySecondPartyIdAndBillType")
    Call<CollectionApiResponse<Bill>> getBillListBySecondPartyIdAndBillType(@Query("deleted") boolean deleted, @Query("billType") BillType billType, @Query("SecondPartyId") Long SecondPartyId, @Query("page") String pageNumber);

}
