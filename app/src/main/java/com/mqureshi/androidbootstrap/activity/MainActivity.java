package com.mqureshi.androidbootstrap.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;

import com.bumptech.glide.Glide;
import com.mqureshi.androidbootstrap.App;
import com.mqureshi.androidbootstrap.R;
import com.mqureshi.androidbootstrap.adapter.PhotosAdapter;
import com.mqureshi.androidbootstrap.api.Api;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    Api mApi;

    @Inject
    Resources mResources;

    @BindView(android.R.id.list)
    RecyclerView mRecyclerView;

    private CompositeSubscription mCompositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.component().inject(this);
        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mCompositeSubscription = new CompositeSubscription();

        getPhotosForAlbum("1");
    }

    private void getPhotosForAlbum(String albumId) {
        mCompositeSubscription.add(mApi.getPhotosForAlbum(albumId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map(photos -> new PhotosAdapter(photos, Glide.with(this), LayoutInflater.from(this)))
            .subscribe(mRecyclerView::setAdapter, e -> Log.e(TAG, "error fetching photos", e))
        );
    }

    @Override
    protected void onDestroy() {
        mCompositeSubscription.unsubscribe();
        super.onDestroy();
    }
}
