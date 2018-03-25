package com.transport.aleksandr.pagination.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.transport.aleksandr.pagination.TypeModel;
import com.transport.aleksandr.pagination.imageLoader.ImageLoader;

import java.util.List;


public abstract class ViewRenderer<Model extends TypeModel, ViewHolder extends RecyclerView.ViewHolder> {
    private final int type;

    public ViewRenderer(@TypeModel.Type int type) {
        this.type = type;
    }

    protected abstract void bindView(@NonNull Model model, @NonNull ViewHolder holder, ImageLoader imageLoader);

    @NonNull
    public abstract ViewHolder createViewHolder(@NonNull ViewGroup parent, List<TypeModel> mainList);

    public int getType() {
        return type;
    }
}
