package com.transport.aleksandr.pagination.adapter;

import com.transport.aleksandr.pagination.TypeModel;
import com.transport.aleksandr.pagination.adapter.renders.pagination_render.FooterRender;
import com.transport.aleksandr.pagination.adapter.renders.pagination_render.ProgressRender;

public class PaginationAdapter extends MultiTypeRecyclerAdapter {
    protected PaginationAdapter() {
        initRenders();
    }

    protected PaginationAdapter(boolean showEmptyView) {
        super(showEmptyView);
        initRenders();
    }

    private void initRenders() {
        registerRenderer(new FooterRender(TypeModel.Type.PAGINATION_FOOTER));
        registerRenderer(new ProgressRender(TypeModel.Type.PAGINATION_PROGRESS));
    }
}
