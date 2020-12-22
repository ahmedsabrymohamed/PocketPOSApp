package com.example.pocketposapp.rest.api.clients;

import com.example.pocketposapp.exception.PageNotFoundException;
import com.example.pocketposapp.model.Product;
import com.example.pocketposapp.rest.api.endpoints.ProductApi;
import com.example.pocketposapp.rest.api.responses.CollectionApiResponse;
import com.example.pocketposapp.ui.products.ProductsViewModel;
import com.example.pocketposapp.util.ApiRequestBuilder;
import com.example.pocketposapp.util.PageController;

import java.util.Collection;
import java.util.function.BiConsumer;

import retrofit2.Call;

public class ProductClient {
    private static boolean deleted = true;

    public static boolean isDeleted() {
        return deleted;
    }

    public static void setDeleted(boolean deleted) {
        ProductClient.deleted = deleted;
    }

    public static void getAll(PageController.PagePosition pagePosition){
        Integer pageNumber = PageController.getPage("AllProducts",pagePosition);
        Call<CollectionApiResponse<Product>> call = ApiRequestBuilder.buildApiClient(ProductApi.class).getProductListIfExists(deleted,pageNumber);
        if( pageNumber == null)
            ProductsViewModel.onFailToRequest(call,new PageNotFoundException());
        else
            ApiRequestBuilder.fetchData(call,ProductsViewModel::onResponse,ProductsViewModel::onFailToRequest);
    }
    public static void getById(Long id){
        Call<Product> call = ApiRequestBuilder.buildApiClient(ProductApi.class).getProductById(id);
        ApiRequestBuilder.fetchData(call,ProductsViewModel::onResponse,ProductsViewModel::onFailToRequest);
    }

    public static void add(Product product){
        Call<Product> call = ApiRequestBuilder.buildApiClient(ProductApi.class).addProduct(product);
        ApiRequestBuilder.fetchData(call,ProductsViewModel::onResponse,ProductsViewModel::onFailToRequest);
    }

    public static void update(Product product){
        Call<Product> call = ApiRequestBuilder.buildApiClient(ProductApi.class).updateProduct(product);
        ApiRequestBuilder.fetchData(call,ProductsViewModel::onResponse,ProductsViewModel::onFailToRequest);
    }

}
