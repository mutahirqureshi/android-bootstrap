package com.mqureshi.androidbootstrap.di;

import android.app.Application;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private final Application mApp;

    MainModule(Application app) {
        mApp = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApp;
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return mApp.getResources();
    }
}
