package com.transport.aleksandr.pagination.adapter.renders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.transport.aleksandr.pagination.R;
import com.transport.aleksandr.pagination.TypeModel;
import com.transport.aleksandr.pagination.adapter.ViewRenderer;
import com.transport.aleksandr.pagination.imageLoader.ImageLoader;
import com.transport.aleksandr.pagination.models.EmptyEntryModel;

import java.util.List;

public class EmptyRender extends ViewRenderer<EmptyEntryModel, EmptyRender.EmptyHolder> {

    public EmptyRender(int type) {
        super(type);
    }

    @Override
    protected void bindView(@NonNull EmptyEntryModel model, @NonNull EmptyHolder holder, ImageLoader imageLoader) {
        // ignored
    }

    @NonNull
    @Override
    public EmptyHolder createViewHolder(@NonNull ViewGroup parent, List<TypeModel> mainList) {
        return new EmptyHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty, parent, false)
        );
    }

    static class EmptyHolder extends RecyclerView.ViewHolder {

        EmptyHolder(View itemView) {
            super(itemView);
        }
    }
}
