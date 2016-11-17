package com.mqureshi.androidbootstrap.model;

import com.google.gson.annotations.SerializedName;

public class Photo {
    public Photo () {
        // Gson likes default constructors
    }

    @SerializedName("albumId")
    String mAlbumId;

    @SerializedName("id")
    String mId;

    @SerializedName("title")
    String mTitle;

    @SerializedName("url")
    String mUrl;

    @SerializedName("thumbnailUrl")
    String mThumbnailUrl;

    public String getAlbumId() {
        return mAlbumId;
    }

    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getThumbnailUrl() {
        return mThumbnailUrl;
    }
}
