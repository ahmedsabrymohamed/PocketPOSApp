package com.example.pocketposapp.exception;

import androidx.annotation.Nullable;

public class PageNotFoundException extends Exception {
    @Nullable
    @Override
    public String getMessage() {
        return "There is no new items inserted in this section";
    }
}
