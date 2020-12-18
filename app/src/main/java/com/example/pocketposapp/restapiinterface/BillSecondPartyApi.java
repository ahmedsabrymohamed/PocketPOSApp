package com.example.pocketposapp.restapiinterface;

import com.example.pocketposapp.apiresponses.CollectionApiResponse;
import com.example.pocketposapp.model.Bill;
import com.example.pocketposapp.model.BillSecondParty;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BillSecondPartyApi {

    @GET
    Call<CollectionApiResponse<BillSecondParty>> getSecondPartyList(@Query("page") String pageNumber);
    @GET("{id}")
    Call<BillSecondParty> getSecondPartyById(@Path("id") Long id);
    @POST
    Call<BillSecondParty> addSecondParty(@Body BillSecondParty secondParty);
    @PUT("{id}")
    Call<BillSecondParty> updateSecondParty(@Body BillSecondParty secondParty);
    @GET("findIfExists")
    Call<CollectionApiResponse<BillSecondParty>> getSecondPartyListIfExists(@Query("deleted")boolean deleted, @Query("page") String pageNumber);
}
