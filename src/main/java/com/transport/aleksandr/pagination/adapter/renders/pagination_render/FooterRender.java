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
import com.transport.aleksandr.pagination.models.FooterEntryModel;

import java.util.List;

public class FooterRender extends ViewRenderer<FooterEntryModel, FooterRender.FooterHolder> {


    public FooterRender(int type) {
        super(type);
    }

    @Override
    protected void bindView(@NonNull FooterEntryModel model, @NonNull FooterHolder holder, ImageLoader imageLoader) {
        // ignored now
    }

    @NonNull
    @Override
    public FooterHolder createViewHolder(@NonNull ViewGroup parent, List<TypeModel> mainList) {
        return new FooterHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_footer, parent, false));
    }

    static class FooterHolder extends RecyclerView.ViewHolder {
        FooterHolder(View itemView) {
            super(itemView);
        }
    }
}
