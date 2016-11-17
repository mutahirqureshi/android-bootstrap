package com.mqureshi.androidbootstrap.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.mqureshi.androidbootstrap.R;
import com.mqureshi.androidbootstrap.model.Photo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {

    private final List<Photo> mPhotos;
    private final RequestManager mGlideRequestManager;
    private final LayoutInflater mLayoutInflater;

    public PhotosAdapter(List<Photo> photos, RequestManager glideRequestManager,
                         LayoutInflater layoutInflater) {

        mPhotos = photos;
        mGlideRequestManager = glideRequestManager;
        mLayoutInflater = layoutInflater;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView imageView;

        @BindView(R.id.text)
        TextView textView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.list_item_photo, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Photo photo = mPhotos.get(position);

        mGlideRequestManager.load(photo.getUrl())
            .centerCrop()
            .into(holder.imageView);

        holder.textView.setText(photo.getTitle());
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }
}
