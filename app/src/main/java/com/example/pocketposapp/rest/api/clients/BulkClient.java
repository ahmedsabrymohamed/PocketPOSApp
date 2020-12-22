package com.example.pocketposapp.rest.api.clients;

import com.example.pocketposapp.exception.PageNotFoundException;
import com.example.pocketposapp.model.Bulk;
import com.example.pocketposapp.rest.api.endpoints.BulkApi;
import com.example.pocketposapp.rest.api.responses.CollectionApiResponse;
import com.example.pocketposapp.util.ApiRequestBuilder;
import com.example.pocketposapp.util.BulkResponseHandler;
import com.example.pocketposapp.util.PageController;


import retrofit2.Call;

public class BulkClient {
    private static boolean deleted = true;

    public static boolean isDeleted() {
        return deleted;
    }

    public static void setDeleted(boolean deleted) {
        BulkClient.deleted = deleted;
    }

    public static void getAll(PageController.PagePosition pagePosition){
        Integer pageNumber = PageController.getPage("AllBulks",pagePosition);
        Call<CollectionApiResponse<Bulk>> call = ApiRequestBuilder.buildApiClient(BulkApi.class)
                .getBulkListIfExists(deleted,pageNumber);
        if( pageNumber == null)
            BulkResponseHandler.onFailToRequest(call,new PageNotFoundException());
        else
            ApiRequestBuilder.fetchData(call,BulkResponseHandler::onResponse,BulkResponseHandler::onFailToRequest);
    }
    public static void getByProductId(Long id,PageController.PagePosition pagePosition){
        Integer pageNumber = PageController.getPage("BulksByProduct",pagePosition);
        Call<CollectionApiResponse<Bulk>> call = ApiRequestBuilder.buildApiClient(BulkApi.class).getBulkListByProductId(id,deleted,pageNumber);
        if( pageNumber == null)
            BulkResponseHandler.onFailToRequest(call,new PageNotFoundException());
        else
        ApiRequestBuilder.fetchData(call, BulkResponseHandler::onResponse,BulkResponseHandler::onFailToRequest);
    }
    public static void getById(Long id){
        Call<Bulk> call = ApiRequestBuilder.buildApiClient(BulkApi.class).getBulkById(id);
        ApiRequestBuilder.fetchData(call, BulkResponseHandler::onResponse,BulkResponseHandler::onFailToRequest);
    }

    public static void add(Bulk bulk){
        Call<Bulk> call = ApiRequestBuilder.buildApiClient(BulkApi.class).addBulk(bulk);
        ApiRequestBuilder.fetchData(call, BulkResponseHandler::onResponse,BulkResponseHandler::onFailToRequest);
    }

    public static void update(Bulk bulk){
        Call<Bulk> call = ApiRequestBuilder.buildApiClient(BulkApi.class).updateBulk(bulk);
        ApiRequestBuilder.fetchData(call, BulkResponseHandler::onResponse,BulkResponseHandler::onFailToRequest);
    }
}
