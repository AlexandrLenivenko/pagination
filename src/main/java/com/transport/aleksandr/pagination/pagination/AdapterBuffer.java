package com.transport.aleksandr.pagination.pagination;

import android.support.annotation.NonNull;

import com.transport.aleksandr.pagination.TypeModel;
import com.transport.aleksandr.pagination.models.FooterEntryModel;
import com.transport.aleksandr.pagination.models.ProgressEntryModel;

import java.util.ArrayList;
import java.util.List;

public class AdapterBuffer extends BaseAdapterBuffer {

    private final FooterEntryModel footerEntryModel;
    private final ProgressEntryModel progressEntryModel;

    public AdapterBuffer(@NonNull UpdateStateListener updateStateListener) {
        super(updateStateListener);
        footerEntryModel = new FooterEntryModel();
        progressEntryModel = new ProgressEntryModel();
    }

    public void setList(List<TypeModel> list, boolean isLoadedAll) {
        super.setBuffer(getModifiedList(list, isLoadedAll));
    }

    private List<TypeModel> getModifiedList(List<TypeModel> list, boolean isLoadedAll) {
        List<TypeModel> all = new ArrayList<>(list);
        if (isLoadedAll) {
            all.add(footerEntryModel);
        } else {
            all.add(progressEntryModel);
        }

        return all;
    }
}
