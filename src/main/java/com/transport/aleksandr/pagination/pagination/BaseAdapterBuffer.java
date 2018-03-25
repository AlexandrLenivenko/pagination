package com.transport.aleksandr.pagination.pagination;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.transport.aleksandr.pagination.TypeModel;

import java.util.List;

import static android.widget.AbsListView.OnScrollListener.SCROLL_STATE_IDLE;

public abstract class BaseAdapterBuffer extends ListScrollSubscriber {
    private final UpdateStateListener updateStateListener;
    private List<TypeModel> buffer;
    private boolean hasNewData, isIdleNow = true;

    BaseAdapterBuffer(@NonNull UpdateStateListener updateStateListener) {
        this.updateStateListener = updateStateListener;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        isIdleNow = newState == SCROLL_STATE_IDLE;

        update();
    }

    final void setBuffer(List<TypeModel> list) {
        hasNewData = true;
        this.buffer = list;
        update();
    }

    private void update() {
        if (isIdleNow && hasNewData) {
            updateStateListener.onUpdateList(buffer);
            hasNewData = false;
        }
    }

    public interface UpdateStateListener {
        void onUpdateList(List<TypeModel> list);
    }
}
