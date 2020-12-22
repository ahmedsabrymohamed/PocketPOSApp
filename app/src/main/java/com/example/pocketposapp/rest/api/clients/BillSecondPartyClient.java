package com.example.pocketposapp.rest.api.clients;

import com.example.pocketposapp.util.PageController;

import java.util.function.BiConsumer;

public class BillSecondPartyClient {
    private static boolean deleted = true;

    public static boolean isDeleted() {
        return deleted;
    }

    public static void setDeleted(boolean deleted) {
        BillSecondPartyClient.deleted = deleted;
    }

    public static void getAll(PageController.PagePosition pagePosition, BiConsumer... responses) {
    }

    public static void getById(Long id, BiConsumer... responses) {
    }

    public static void add(String secondParty, BiConsumer... responses) {
    }

    public static void update(String secondParty, BiConsumer... responses) {
    }

}
