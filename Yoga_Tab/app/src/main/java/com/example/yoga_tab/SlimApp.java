package com.example.yoga_tab;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

public class SlimApp extends Application {
    @SuppressLint("StaticFieldLeak")
    static Context context, contextList;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        contextList = getApplicationContext();
    }
}