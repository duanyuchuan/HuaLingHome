package com.hualing.hualinghome.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hualing.hualinghome.holder.BaseHolderView;
import com.hualing.hualinghome.holder.LoadMoreHolderView;

import java.util.ArrayList;

/**ListView适配器的基类
 * Created by Administrator on 2017/7/27.
 */

public abstract class MyListViewBaseAdapter<T> extends BaseAdapter{
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
        BaseHolderView<T> holderView=null;
        if(convertView==null){
            //根据当前Item的类型，初始化不同的Holder对象
            if(getItemViewType(position)==ITEM_LOAD_MORE){
                //返回加载更多Holder对象
                // 因为所有界面加载更多的UI显示效果都是一致的,所以加载更多的业务逻辑可以做详细处理
                holderView=new LoadMoreHolderView();
            }else{
                //在初始化Holder的时候，已经对布局进行了加载，并且对象View设置了Tag
                holderView=getHolder(position);
            }
        }else{
            holderView=(BaseHolderView<T>) convertView.getTag();
        }

        //更新数据刷新界面
        if(getItemViewType(position) != ITEM_LOAD_MORE){
            //没哟加载更多是加载数据刷新界面
            holderView.setData(getItem(position));
        }
        return holderView.getRootView();
    }
    /**
     * BaseHolder的子类必须实现
     * @param position
     * @return
     */
    protected abstract BaseHolderView<T> getHolder(int position);
}
