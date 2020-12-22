package com.example.pocketposapp.rest.api.clients;

import com.example.pocketposapp.exception.PageNotFoundException;
import com.example.pocketposapp.model.Bill;
import com.example.pocketposapp.model.BillType;
import com.example.pocketposapp.rest.api.endpoints.BillApi;
import com.example.pocketposapp.rest.api.responses.CollectionApiResponse;
import com.example.pocketposapp.ui.bills.BillsViewModel;
import com.example.pocketposapp.util.ApiRequestBuilder;
import com.example.pocketposapp.util.PageController;

import java.util.function.BiConsumer;

import retrofit2.Call;



public class BillClient {
    private static boolean deleted = true;


    public static boolean isDeleted() {
        return deleted;
    }

    public static void setDeleted(boolean deleted) {
        BillClient.deleted = deleted;
    }

    public static void getAll(PageController.PagePosition pagePosition) {
        Integer pageNumber = PageController.getPage("AllBills",pagePosition);
        Call<CollectionApiResponse<Bill>> call = ApiRequestBuilder.buildApiClient(BillApi.class).getBillListIfExists(deleted,pageNumber);
        if( pageNumber == null)
            BillsViewModel.onFailToRequest(call,new PageNotFoundException());
        else
            ApiRequestBuilder.fetchData(call,BillsViewModel::onResponse,BillsViewModel::onFailToRequest);
    }
    public static void getBySecondParty(Long secondPartyId, PageController.PagePosition pagePosition) {
        Integer pageNumber = PageController.getPage("BillsBySecondParty",pagePosition);
        Call<CollectionApiResponse<Bill>> call = ApiRequestBuilder.buildApiClient(BillApi.class).getBillListBySecondPartyId(deleted,secondPartyId,pageNumber);
        if( pageNumber == null)
            BillsViewModel.onFailToRequest(call,new PageNotFoundException());
        else
            ApiRequestBuilder.fetchData(call,BillsViewModel::onResponse,BillsViewModel::onFailToRequest);
    }
    public static void getByType(BillType type, PageController.PagePosition pagePosition) {
        Integer pageNumber = PageController.getPage("BillsByType",pagePosition);
        Call<CollectionApiResponse<Bill>> call = ApiRequestBuilder.buildApiClient(BillApi.class).getBillListByBillType(deleted,type,pageNumber);
        if( pageNumber == null)
            BillsViewModel.onFailToRequest(call,new PageNotFoundException());
        else
            ApiRequestBuilder.fetchData(call,BillsViewModel::onResponse,BillsViewModel::onFailToRequest);
    }
    public static  void getByTypeAndSecondParty(BillType type, Long secondPartyId,PageController.PagePosition pagePosition) {
        Integer pageNumber = PageController.getPage("BillsByTypeAndSecondParty",pagePosition);
        Call<CollectionApiResponse<Bill>> call = ApiRequestBuilder.buildApiClient(BillApi.class)
                .getBillListBySecondPartyIdAndBillType(deleted,type,secondPartyId,pageNumber);
        if( pageNumber == null)
            BillsViewModel.onFailToRequest(call,new PageNotFoundException());
        else
            ApiRequestBuilder.fetchData(call,BillsViewModel::onResponse,BillsViewModel::onFailToRequest);
    }
    public static void getById(Long id) {
        Call<Bill> call = ApiRequestBuilder.buildApiClient(BillApi.class).getBillById(id);
        ApiRequestBuilder.fetchData(call,BillsViewModel::onResponse,BillsViewModel::onFailToRequest);
    }

    public static void add(Bill bill) {
        Call<Bill> call = ApiRequestBuilder.buildApiClient(BillApi.class).addBill(bill);
        ApiRequestBuilder.fetchData(call,BillsViewModel::onResponse,BillsViewModel::onFailToRequest);
    }

    public static void update(Bill bill) {
        Call<Bill> call = ApiRequestBuilder.buildApiClient(BillApi.class).updateBill(bill);
        ApiRequestBuilder.fetchData(call,BillsViewModel::onResponse,BillsViewModel::onFailToRequest);
    }





}
