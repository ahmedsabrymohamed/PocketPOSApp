package com.example.pocketposapp.rest.api.endpoints;

import com.example.pocketposapp.rest.api.responses.CollectionApiResponse;
import com.example.pocketposapp.model.Bill;
import com.example.pocketposapp.model.BillType;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BillApi {
    @GET
    Call<CollectionApiResponse<Bill>> getBillList(@Query("page") Integer pageNumber);

    @GET("{id}")
    Call<Bill> getBillById(@Path("id") Long id);

    @POST
    Call<Bill> addBill(@Body Bill bill);

    @PUT("{id}")
    Call<Bill> updateBill(@Body Bill bill);

    @GET("findIfExists")
    Call<CollectionApiResponse<Bill>> getBillListIfExists(@Query("deleted") boolean deleted, @Query("page") Integer pageNumber);

    @GET("findBySecondPartyId")
    Call<CollectionApiResponse<Bill>> getBillListBySecondPartyId(@Query("deleted") boolean deleted, @Query("SecondPartyId") Long SecondPartyId, @Query("page") Integer pageNumber);

    @GET("findByBillType")
    Call<CollectionApiResponse<Bill>> getBillListByBillType(@Query("deleted") boolean deleted, @Query("billType") BillType billType, @Query("page") Integer pageNumber);

    @GET("findBySecondPartyIdAndBillType")
    Call<CollectionApiResponse<Bill>> getBillListBySecondPartyIdAndBillType(@Query("deleted") boolean deleted, @Query("billType") BillType billType, @Query("SecondPartyId") Long SecondPartyId, @Query("page") Integer pageNumber);

}
