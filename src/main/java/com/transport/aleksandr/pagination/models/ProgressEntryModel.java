package com.transport.aleksandr.pagination.models;

import com.transport.aleksandr.pagination.TypeModel;

import static com.transport.aleksandr.pagination.TypeModel.Type.PAGINATION_PROGRESS;

public class ProgressEntryModel implements TypeModel {
    @Override
    public int getRowType() {
        return PAGINATION_PROGRESS;
    }

    @Override
    public String getRowId() {
        return "" + PAGINATION_PROGRESS;
    }
}
