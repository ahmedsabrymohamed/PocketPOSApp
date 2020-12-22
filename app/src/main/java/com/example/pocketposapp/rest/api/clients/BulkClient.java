package com.example.pocketposapp.rest.api.clients;

import com.example.pocketposapp.model.Bulk;
import com.example.pocketposapp.util.PageController;

import java.util.Collection;
import java.util.function.BiConsumer;

public class BulkClient {
    private static boolean deleted = true;

    public static boolean isDeleted() {
        return deleted;
    }

    public static void setDeleted(boolean deleted) {
        BulkClient.deleted = deleted;
    }

    public static void getAll(PageController.PagePosition pagePosition, BiConsumer... responses){}
    public static void getByProductId(Long id,PageController.PagePosition pagePosition, BiConsumer... responses){}
    public static void getById(Long id, BiConsumer... responses){}

    public static void add(Bulk bulk, BiConsumer... responses){}

    public static void update(Bulk bulk, BiConsumer... responses){}
}
