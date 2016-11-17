package com.mqureshi.androidbootstrap.api;

import com.mqureshi.androidbootstrap.model.Photo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Single;

public interface Api {

    @GET("/photos")
    Single<List<Photo>> getPhotos();

    @GET("/albums/{id}/photos")
    Single<List<Photo>> getPhotosForAlbum(
        @Path("id") String id
    );
}
