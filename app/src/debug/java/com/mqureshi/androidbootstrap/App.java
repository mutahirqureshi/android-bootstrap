package com.mqureshi.androidbootstrap;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

public class App extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        LeakCanary.install(this);
    }
}
