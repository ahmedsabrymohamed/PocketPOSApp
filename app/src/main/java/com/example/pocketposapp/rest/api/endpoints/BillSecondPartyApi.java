package com.example.pocketposapp.rest.api.endpoints;

import com.example.pocketposapp.rest.api.responses.CollectionApiResponse;
import com.example.pocketposapp.model.BillSecondParty;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BillSecondPartyApi {

    @GET("billSecondParty/")
    Call<CollectionApiResponse<BillSecondParty>> getSecondPartyList(@Query("page") Integer pageNumber);
    @GET("billSecondParty/{id}")
    Call<BillSecondParty> getSecondPartyById(@Path("id") Long id);
    @POST("billSecondParty/")
    Call<BillSecondParty> addSecondParty(@Body BillSecondParty secondParty);
    @PUT("billSecondParty/{id}")
    Call<BillSecondParty> updateSecondParty(@Body BillSecondParty secondParty);
    @GET("billSecondParty/findIfExists")
    Call<CollectionApiResponse<BillSecondParty>> getSecondPartyListIfExists(@Query("deleted")boolean deleted, @Query("page") Integer pageNumber);
}
