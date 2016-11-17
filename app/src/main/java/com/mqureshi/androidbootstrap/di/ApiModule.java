package com.mqureshi.androidbootstrap.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mqureshi.androidbootstrap.BuildConfig;
import com.mqureshi.androidbootstrap.api.Api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    @Provides
    @Singleton
    Gson provideGson(){
        return new GsonBuilder()
//            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();
    }

    @Provides
    @Singleton
    Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }
}
