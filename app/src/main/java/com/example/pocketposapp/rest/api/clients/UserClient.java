package com.example.pocketposapp.rest.api.clients;

import com.example.pocketposapp.exception.PageNotFoundException;
import com.example.pocketposapp.model.User;
import com.example.pocketposapp.rest.api.endpoints.UserApi;
import com.example.pocketposapp.rest.api.responses.CollectionApiResponse;
import com.example.pocketposapp.util.ApiRequestBuilder;
import com.example.pocketposapp.util.PageController;
import com.example.pocketposapp.util.UserRequestHandler;

import java.util.Collection;
import java.util.function.BiConsumer;

import retrofit2.Call;

public class UserClient {
    private static boolean deleted = true;

    public static boolean isDeleted() {
        return deleted;
    }

    public static void setDeleted(boolean deleted) {
        UserClient.deleted = deleted;
    }

    public static void getAll(PageController.PagePosition pagePosition){
        Integer pageNumber = PageController.getPage("AllUsers",pagePosition);
        Call<CollectionApiResponse<User>> call = ApiRequestBuilder.buildApiClient(UserApi.class).getProductListIfExists(deleted,pageNumber);
        if( pageNumber == null)
            UserRequestHandler.onFailToRequest(call,new PageNotFoundException());
        else
            ApiRequestBuilder.fetchData(call,UserRequestHandler::onResponse,UserRequestHandler::onFailToRequest);
    }
    public static void getById(Long id){
        Call<User> call = ApiRequestBuilder.buildApiClient(UserApi.class).getUserById(id);
        ApiRequestBuilder.fetchData(call,UserRequestHandler::onResponse,UserRequestHandler::onFailToRequest);
    }
    public static void getByNameAndPassword(String name , String password){
        Call<User> call = ApiRequestBuilder.buildApiClient(UserApi.class).getByUserNameAndPassword(name,password,deleted);
        ApiRequestBuilder.fetchData(call,UserRequestHandler::onResponse,UserRequestHandler::onFailToRequest);
    }

    public static void add(User user){
        Call<User> call = ApiRequestBuilder.buildApiClient(UserApi.class).addUser(user);
        ApiRequestBuilder.fetchData(call,UserRequestHandler::onResponse,UserRequestHandler::onFailToRequest);
    }

    public static void update(User user){
        Call<User> call = ApiRequestBuilder.buildApiClient(UserApi.class).updateUser(user);
        ApiRequestBuilder.fetchData(call,UserRequestHandler::onResponse,UserRequestHandler::onFailToRequest);
    }

}
