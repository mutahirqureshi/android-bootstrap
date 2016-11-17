package com.mqureshi.androidbootstrap.di;

import android.app.Application;

import com.mqureshi.androidbootstrap.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { MainModule.class, BuildTypeApiModule.class})
public interface MainComponent {
    final class Initializer {
        private Initializer() {}

        public static MainComponent init(Application app) {
            return DaggerMainComponent.builder()
                .mainModule(new MainModule(app))
                .build();
        }
    }


    void inject(MainActivity mainActivity);
}
