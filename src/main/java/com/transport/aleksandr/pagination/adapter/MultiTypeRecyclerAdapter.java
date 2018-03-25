package com.transport.aleksandr.pagination.adapter;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.transport.aleksandr.pagination.TypeModel;
import com.transport.aleksandr.pagination.adapter.renders.EmptyRender;
import com.transport.aleksandr.pagination.imageLoader.ImageLoader;
import com.transport.aleksandr.pagination.models.EmptyEntryModel;

import java.util.ArrayList;
import java.util.List;

public class MultiTypeRecyclerAdapter extends RecyclerView.Adapter {
    private static final String TAG = "MultiTypeRecyclerAdapte";
    private final CustomDiffUtil customDiffUtil;

    private List<TypeModel> mainList;
    private SparseArray<ViewRenderer> rendererMap;
    private ImageLoader imageLoader;

    protected MultiTypeRecyclerAdapter() {
        mainList = new ArrayList<>(0);
        rendererMap = new SparseArray<>(0);
        this.customDiffUtil = new CustomDiffUtil();
    }

    protected MultiTypeRecyclerAdapter(boolean showEmptyItem) {
        this();
        if (showEmptyItem) {
            registerRenderer(new EmptyRender(TypeModel.Type.EMPTY_ITEM));
            mainList.add(new EmptyEntryModel());
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewRenderer viewRenderer = rendererMap.get(viewType);
        notNullRenter(viewRenderer);
        return viewRenderer.createViewHolder(parent, mainList);
    }


    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TypeModel typeModel = mainList.get(position);
        ViewRenderer viewRenderer = rendererMap.get(typeModel.getRowType());
        notNullRenter(viewRenderer);
        viewRenderer.bindView(typeModel, holder, imageLoader);
    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }

    public void addList(@NonNull List<? extends TypeModel> newList) {
        Log.d(TAG, "addList, size:" + newList.size());

        customDiffUtil.setData(mainList, newList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(customDiffUtil, false);

        clear();
        mainList.addAll(newList);

        diffResult.dispatchUpdatesTo(this);
    }

    @Override
    public int getItemViewType(int position) {
        return mainList.get(position).getRowType();
    }

    private void notNullRenter(ViewRenderer viewRenderer) {
        if (viewRenderer == null) {
            throw new RuntimeException("renderer wan't found");
        }
    }

    public List<TypeModel> getList() {
        return mainList;
    }

    protected void registerRenderer(ViewRenderer renderer) {
        int type = renderer.getType();

        if (rendererMap.get(type) == null) {
            rendererMap.put(type, renderer);
        } else {
            Log.e(TAG, "registerRenderer: renderer was added before ");
        }
    }

    private void clear() {
        mainList.clear();
    }

    public void setImageLoader(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }
}
