package com.transport.aleksandr.pagination.imageLoader;

import android.net.Uri;
import android.widget.ImageView;

public interface ImageLoader {

    void loadImage(Uri photoUri, ImageView imageView);

    void loadImage(Uri photoUri, ImageView imageView, int placeholderResId);
}
