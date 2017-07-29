package com.hualing.hualinghome.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hualing.hualinghome.R;
import com.hualing.hualinghome.utils.UiUtils;

/**
 * Created by Administrator on 2017/7/27.
 */

public class LoadMoreHolderView extends BaseHolderView<Integer>{
    public static final int TYPE_HAS_MORE=0;//可以加载更多
    public static final int TYPE_NO_MORE=1;//可以加载更多
    public static final int TYPE_LOAD_MORE_ERROR=2;//可以加载更多
    private LinearLayout mLlyLoadingMore;
    private TextView mTvLoadError;
    private TextView mTvNoMore;

    public LoadMoreHolderView(boolean hasMore){
        //将加载的类型以数据的方式设置进去
        setData(hasMore ? TYPE_HAS_MORE : TYPE_NO_MORE);
    }

    @Override
    protected View initView() {
        View rootView = UiUtils.inflate(R.layout.layout_load_more);
        mLlyLoadingMore = rootView.findViewById(R.id.lly_loading_more);
        mTvLoadError = rootView.findViewById(R.id.tv_load_error);
        mTvNoMore = rootView.findViewById(R.id.tv_no_more);
        return rootView;
    }

    @Override
    protected void refreshView(Integer data) {
        //根据状态，来更新界面展示
        switch (data){
            case TYPE_HAS_MORE:
                //有更多数据
                mLlyLoadingMore.setVisibility(View.VISIBLE);
                mTvLoadError.setVisibility(View.GONE);
                mTvNoMore.setVisibility(View.GONE);
                break;
            case TYPE_NO_MORE:
                //没有更多数据
                mLlyLoadingMore.setVisibility(View.GONE);
                mTvLoadError.setVisibility(View.GONE);
                mTvNoMore.setVisibility(View.VISIBLE);
                break;
            case TYPE_LOAD_MORE_ERROR:
                //加载错误
                mTvNoMore.setVisibility(View.GONE);
                mLlyLoadingMore.setVisibility(View.GONE);
                mTvLoadError.setVisibility(View.VISIBLE);
                break;
        }
    }

}
