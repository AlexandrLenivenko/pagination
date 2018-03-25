package com.transport.aleksandr.pagination.pagination;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class PaginationSubscriber extends ListScrollSubscriber {

    private final PaginationListener paginationListener;
    int firstVisibleItem, visibleItemCount, totalItemCount;
    private int previousTotal = 0; // The total number of items in the dataset after the last load
    private boolean loading = true; // True if we are still waiting for the last set of data to load.
    private int visibleThreshold = 5; // The minimum amount of items to have below your current scroll position before loading more.
    private LinearLayoutManager linearLayoutManager;

    public PaginationSubscriber(PaginationListener paginationListener) {
        this.paginationListener = paginationListener;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        createLayoutManagerIfNeeded(recyclerView);

        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = linearLayoutManager.getItemCount();
        firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();

        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
            }
        }
        if (!loading && (totalItemCount - visibleItemCount)
                <= (firstVisibleItem + visibleThreshold)) {
            if (paginationListener == null) {
                return;
            }
            paginationListener.onLoadMore(totalItemCount);
            loading = true;
        }
    }

    private void createLayoutManagerIfNeeded(RecyclerView recyclerView) {
        if (linearLayoutManager != null) {
            return;
        }

        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            throw new IllegalArgumentException("Current realisation works only with LinearLayoutManager");
        }
    }

    public interface PaginationListener {
        void onLoadMore(int totalItemCount);
    }
}

