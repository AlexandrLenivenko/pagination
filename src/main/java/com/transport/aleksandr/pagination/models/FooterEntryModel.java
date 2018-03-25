package com.transport.aleksandr.pagination.models;

import com.transport.aleksandr.pagination.TypeModel;

import static com.transport.aleksandr.pagination.TypeModel.Type.PAGINATION_FOOTER;

public class FooterEntryModel implements TypeModel {


    @Override
    public int getRowType() {
        return PAGINATION_FOOTER;
    }

    @Override
    public String getRowId() {
        return "" + PAGINATION_FOOTER;
    }
}