package com.example.pocketposapp.rest.api.responses;

import com.google.gson.annotations.SerializedName;

public class CollectionApiResponse<T> {
    @SerializedName("_embedded")
    private EntitiesList<T> embeddedList;
    @SerializedName("page")
    private Page page;

    public EntitiesList<T> getEmbeddedList() {
        return embeddedList;
    }

    public void setEmbeddedList(EntitiesList<T> embeddedList) {
        this.embeddedList = embeddedList;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
