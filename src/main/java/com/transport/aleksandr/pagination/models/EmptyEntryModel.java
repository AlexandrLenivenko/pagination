package com.transport.aleksandr.pagination.models;

import com.transport.aleksandr.pagination.TypeModel;

import static com.transport.aleksandr.pagination.TypeModel.Type.EMPTY_ITEM;

public class EmptyEntryModel implements TypeModel {
    @Override
    public int getRowType() {
        return EMPTY_ITEM;
    }

    @Override
    public String getRowId() {
        return "id" + EMPTY_ITEM;
    }
}
