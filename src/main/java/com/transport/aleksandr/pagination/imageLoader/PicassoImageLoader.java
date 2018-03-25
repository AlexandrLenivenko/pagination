package com.transport.aleksandr.pagination.imageLoader;

import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoImageLoader implements ImageLoader {

    @Override
    public void loadImage(Uri photoUri, ImageView imageView) {
        Picasso.with(imageView.getContext().getApplicationContext())
                .load(photoUri)
                .error(android.R.drawable.stat_notify_error)
                .into(imageView);
    }

    @Override
    public void loadImage(Uri photoUri, ImageView imageView, int placeholderResId) {
        if (placeholderResId == 0) {
            loadImage(photoUri, imageView);
            return;
        }
        Picasso.with(imageView.getContext().getApplicationContext())
                .load(photoUri)
                .placeholder(placeholderResId)
                .error(android.R.drawable.stat_notify_error)
                .into(imageView);
    }
}

