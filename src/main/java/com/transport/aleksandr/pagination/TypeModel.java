package com.transport.aleksandr.pagination;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static com.transport.aleksandr.pagination.TypeModel.Type.EMPTY_ITEM;
import static com.transport.aleksandr.pagination.TypeModel.Type.PAGINATION_FOOTER;
import static com.transport.aleksandr.pagination.TypeModel.Type.PAGINATION_PROGRESS;
import static com.transport.aleksandr.pagination.TypeModel.Type.TEST_ITEM;
import static java.lang.annotation.RetentionPolicy.SOURCE;

public interface TypeModel {

    @Type
    int getRowType();

    String getRowId();


    @Retention(SOURCE)
    @IntDef({TEST_ITEM, PAGINATION_FOOTER, PAGINATION_PROGRESS,
            EMPTY_ITEM})
    @interface Type {
        int TEST_ITEM = 0X001;
        int PAGINATION_FOOTER = 0X002;
        int PAGINATION_PROGRESS = 0X003;
        int EMPTY_ITEM = 0X004;
    }
}
