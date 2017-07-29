package com.hualing.hualinghome.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hualing.hualinghome.holder.BaseHolderView;
import com.hualing.hualinghome.holder.LoadMoreHolderView;
import com.hualing.hualinghome.utils.ThreadManager;
import com.hualing.hualinghome.utils.UiUtils;

import java.util.ArrayList;

/**ListView适配器的基类
 * Created by Administrator on 2017/7/27.
 */

public abstract class MyListViewBaseAdapter<T> extends BaseAdapter{
    private boolean isLoadMore=false;
    private ArrayList<T> mData;
    private static final int ITEM_LOAD_MORE=0;//加载更多
    private static final int ITEM_LIST_VIEW=1;//普通加载ListView

    public MyListViewBaseAdapter(ArrayList<T> data){
        this.mData=data;
    }

    @Override
    public int getCount() {
        //加载更多布局也站一个位置，所以加1
        return mData==null ? 0 : mData.size()+1;
    }

    @Override
    public int getViewTypeCount() {
        //两种布局类型，一种普通布局，一种加载更多
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==getCount()-1){
            //最后一条则为加载跟多
            return ITEM_LOAD_MORE;
        }else{
            //否则普通加载
            return getInnerType(position);
        }
    }
    /**
     * 普通布局也有可能返回多种数据，重写该方法可以返回更多不同类型的数据
     * @param position
     * @return
     */
    public int getInnerType(int position){
        return ITEM_LIST_VIEW;
    }

    @Override
    public T getItem(int position) {
        return mData==null ? null : mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseHolderView holderView=null;
        if(convertView==null){
            //根据当前Item的类型，初始化不同的Holder对象
            if(getItemViewType(position)==ITEM_LOAD_MORE){
                //返回加载更多Holder对象
                // 因为所有界面加载更多的UI显示效果都是一致的,所以加载更多的业务逻辑可以做详细处理
                holderView= new LoadMoreHolderView(hasMore());
            }else{
                //在初始化Holder的时候，已经对布局进行了加载，并且对象View设置了Tag
                holderView=getHolder(position);
            }
        }else{
            holderView=(BaseHolderView) convertView.getTag();
        }

        //更新数据刷新界面
        if(getItemViewType(position) != ITEM_LOAD_MORE){
            //没哟加载更多是加载数据刷新界面
            holderView.setData(getItem(position));
        }else{
            //如果当前展示的是加载更多的界面，需要加载下一页数据
            LoadMoreHolderView loadMoreHolderView=(LoadMoreHolderView)holderView;
            //加载之前要判断是否有更多数据
            if(loadMoreHolderView.getData()==LoadMoreHolderView.TYPE_HAS_MORE){
                loadMore(loadMoreHolderView);
            }
        }
        return holderView.getRootView();
    }

    /**
     * 加载更多数据
     * @param loadMoreHolderView
     */
    private void loadMore(final LoadMoreHolderView loadMoreHolderView) {
        if(!isLoadMore){
            isLoadMore=true;
            //开启子线程加载更多数据
            ThreadManager.getThreadPool().execute(new Runnable() {
                @Override
                public void run() {
                    //获取更多数据
                    final ArrayList<T> loadMoreData=onLoadMore();
                    //更新ui必须在主线程
                    UiUtils.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(loadMoreData==null){
                                //如果没有拿到数据，说明加载失败
                                loadMoreHolderView.setData(LoadMoreHolderView.TYPE_LOAD_MORE_ERROR);
                            }else{
                                //每一页返回15条数据，如果小于15条数据则说明没有跟多数据了
                                if(loadMoreData.size()<15){
                                    loadMoreHolderView.setData(LoadMoreHolderView.TYPE_NO_MORE);
                                }else{
                                    loadMoreHolderView.setData(LoadMoreHolderView.TYPE_HAS_MORE);
                                }
                                //将下一页数据追加到当前集合中
                                mData.addAll(loadMoreData);
                                //刷新界面
                                notifyDataSetChanged();
                            }
                            //数据加载完毕，已经没有更多数据了
                            isLoadMore=false;
                        }
                    });
                }
            });
        }
    }

    /**
     * 加载更多数据必须由子类去实现
     * @return
     */
    public abstract ArrayList<T> onLoadMore();

    /**
     * BaseHolder的子类必须实现
     * @param position
     * @return
     */
    protected abstract BaseHolderView getHolder(int position);

    /**
     * 子类可以重写该方法来决定是否要加载跟多数据
     * @return
     */
    public boolean hasMore(){
        return true;
    }
}
