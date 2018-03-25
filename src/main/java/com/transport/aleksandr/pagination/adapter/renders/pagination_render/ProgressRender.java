package com.transport.aleksandr.pagination.adapter.renders.pagination_render;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.transport.aleksandr.pagination.R;
import com.transport.aleksandr.pagination.TypeModel;
import com.transport.aleksandr.pagination.adapter.ViewRenderer;
import com.transport.aleksandr.pagination.imageLoader.ImageLoader;
import com.transport.aleksandr.pagination.models.ProgressEntryModel;

import java.util.List;

public class ProgressRender extends ViewRenderer<ProgressEntryModel, ProgressRender.ProgressHolder> {


    public ProgressRender(int type) {
        super(type);
    }

    @Override
    protected void bindView(@NonNull ProgressEntryModel model, @NonNull ProgressHolder holder, ImageLoader imageLoader) {
        // ignored now
    }

    @NonNull
    @Override
    public ProgressHolder createViewHolder(@NonNull ViewGroup parent, List<TypeModel> mainList) {
        return new ProgressHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progress, parent, false)
        );
    }

    static class ProgressHolder extends RecyclerView.ViewHolder {

        public ProgressHolder(View itemView) {
            super(itemView);
        }
    }
}
