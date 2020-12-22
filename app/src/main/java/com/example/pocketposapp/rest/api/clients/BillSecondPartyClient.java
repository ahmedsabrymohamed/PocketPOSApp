package com.example.pocketposapp.rest.api.clients;

import com.example.pocketposapp.exception.PageNotFoundException;
import com.example.pocketposapp.model.BillSecondParty;
import com.example.pocketposapp.rest.api.endpoints.BillSecondPartyApi;
import com.example.pocketposapp.rest.api.responses.CollectionApiResponse;
import com.example.pocketposapp.ui.bills.BillsViewModel;
import com.example.pocketposapp.ui.clients.ClientsViewModel;
import com.example.pocketposapp.util.ApiRequestBuilder;
import com.example.pocketposapp.util.PageController;

import java.util.function.BiConsumer;

import retrofit2.Call;

public class BillSecondPartyClient {
    private static boolean deleted = true;

    public static boolean isDeleted() {
        return deleted;
    }

    public static void setDeleted(boolean deleted) {
        BillSecondPartyClient.deleted = deleted;
    }

    public static void getAll(PageController.PagePosition pagePosition, BiConsumer... responses) {
        Integer pageNumber = PageController.getPage("AllSecondParties",pagePosition);
        Call<CollectionApiResponse<BillSecondParty>> call = ApiRequestBuilder.buildApiClient(BillSecondPartyApi.class)
                .getSecondPartyListIfExists(deleted,pageNumber);
        if( pageNumber == null)
            ClientsViewModel.onFailToRequest(call,new PageNotFoundException());
        else
            ApiRequestBuilder.fetchData(call,ClientsViewModel::onResponse,ClientsViewModel::onFailToRequest);
    }

    public static void getById(Long id) {

        Call<BillSecondParty> call = ApiRequestBuilder.buildApiClient(BillSecondPartyApi.class)
                .getSecondPartyById(id);
            ApiRequestBuilder.fetchData(call,ClientsViewModel::onResponse,ClientsViewModel::onFailToRequest);
    }

    public static void add(BillSecondParty secondParty) {
        Call<BillSecondParty> call = ApiRequestBuilder.buildApiClient(BillSecondPartyApi.class)
                .addSecondParty(secondParty);
            ApiRequestBuilder.fetchData(call,ClientsViewModel::onResponse,ClientsViewModel::onFailToRequest);
    }

    public static void update(BillSecondParty secondParty) {
        Call<BillSecondParty> call = ApiRequestBuilder.buildApiClient(BillSecondPartyApi.class)
                .updateSecondParty(secondParty);
        ApiRequestBuilder.fetchData(call,ClientsViewModel::onResponse,ClientsViewModel::onFailToRequest);
    }

}
