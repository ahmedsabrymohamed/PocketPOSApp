package com.example.pocketposapp.apiresponses;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public class EntitiesList<T> {
    @SerializedName(value = "product",alternate = {"bill","user","billSecondParty"})
    private Collection<T> entities;

    public Collection<T> getEntities() {
        return entities;
    }

    public void setEntities(Collection<T> entities) {
        this.entities = entities;
    }
}
