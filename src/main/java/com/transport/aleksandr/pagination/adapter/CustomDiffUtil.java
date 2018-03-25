package com.transport.aleksandr.pagination.adapter;

import android.support.v7.util.DiffUtil;

import com.transport.aleksandr.pagination.TypeModel;

import java.util.List;

public class CustomDiffUtil extends DiffUtil.Callback {

    private List<? extends TypeModel> oldList;
    private List<? extends TypeModel> newList;

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getRowId().equals(newList.get(newItemPosition).getRowId());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }

    void setData(List<? extends TypeModel> oldList, List<? extends TypeModel> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }
}
