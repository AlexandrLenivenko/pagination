package com.transport.aleksandr.pagination.pagination;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.HashSet;
import java.util.Set;


public class ListScrollObserver extends RecyclerView.OnScrollListener {

    private Set<ListScrollSubscriber> subscribers;

    public ListScrollObserver() {
        this.subscribers = new HashSet<>(5);
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        for (ListScrollSubscriber subscriber : subscribers) {
            subscriber.onScrollStateChanged(recyclerView, newState);
        }
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        for (ListScrollSubscriber subscriber : subscribers) {
            subscriber.onScrolled(recyclerView, dx, dy);
        }
    }

    public void subscribe(@NonNull ListScrollSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unSubscribe(@NonNull ListScrollSubscriber subscriber) {
        subscribers.remove(subscriber);
    }
}
