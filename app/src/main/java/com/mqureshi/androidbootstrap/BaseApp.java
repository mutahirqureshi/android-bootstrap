package com.mqureshi.androidbootstrap;

import android.app.Application;

import com.mqureshi.androidbootstrap.di.MainComponent;

abstract class BaseApp extends Application {
    private static MainComponent sMainComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sMainComponent = MainComponent.Initializer.init(this);
    }

    public static MainComponent component() {
        return sMainComponent;
    }
}
