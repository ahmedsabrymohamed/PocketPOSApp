package com.example.pocketposapp.rest.api.clients;

import com.example.pocketposapp.model.User;
import com.example.pocketposapp.util.PageController;

import java.util.Collection;
import java.util.function.BiConsumer;

public class UserClient {
    private static boolean deleted = true;

    public static boolean isDeleted() {
        return deleted;
    }

    public static void setDeleted(boolean deleted) {
        UserClient.deleted = deleted;
    }

    public static void getAll(PageController.PagePosition pagePosition, BiConsumer... responses){}
    public static void getById(Long id, BiConsumer... responses){}
    public static void getByNameAndPassword(String name , String Password, BiConsumer... responses){}

    public static void add(User user, BiConsumer... responses){}

    public static void update(User user, BiConsumer... responses){}

}
