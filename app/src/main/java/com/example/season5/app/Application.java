package com.example.season5.app;

import android.content.Context;

public class Application extends android.app.Application {


    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        setFont();
    }

    public static Context getContext() {
        return context;
    }

    private void setFont() {
        String iran_yekan = "iransansbold.ttf";
        FontOveride.setDefalutFont(iran_yekan);

    }
}
