package com.hualing.hualinghome.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hualing.hualinghome.base.BaseViewLoadPage;
import com.hualing.hualinghome.utils.UiUtils;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/21.
 */

public abstract class BaseFragment extends Fragment{
    private BaseViewLoadPage mBaseViewLoadPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBaseViewLoadPage = new BaseViewLoadPage(UiUtils.getContext()){
            @Override
            public View onCreateLoadSuccesView() {
                return BaseFragment.this.onCreateLoadSuccesView();
            }
            @Override
            public ResultState onLoadData() {
                return BaseFragment.this.onLoadData();
            }
        };
        return mBaseViewLoadPage;
    }
    /**
     * 加载成功的具体视图必须由子类来实现
     * @return
     */
    public abstract View onCreateLoadSuccesView();
    /**
     * 加载具体的网络数据必须由子类类实现
     * @return
     */
    public abstract BaseViewLoadPage.ResultState onLoadData();
    /**
     * 开始加载网络数据
     */
    public void loadData(){
        if(mBaseViewLoadPage != null){
            mBaseViewLoadPage.loadDataFromNetWork();
        }
    }
    /**
     *校验数据的合法性
     * @param object
     * @return
     */
    public BaseViewLoadPage.ResultState check(Object object){
        if(object != null){
            if(object instanceof ArrayList){
                ArrayList arrayList=(ArrayList) object;
                if(!arrayList.isEmpty()){
                    return BaseViewLoadPage.ResultState.LOAD_SUCCES;
                }else{
                    return BaseViewLoadPage.ResultState.LOAD_EMPTY;
                }
            }
        }
        return BaseViewLoadPage.ResultState.LOAD_ERROR;
    }
}
