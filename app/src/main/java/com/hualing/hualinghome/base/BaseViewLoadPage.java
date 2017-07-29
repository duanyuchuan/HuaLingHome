package com.hualing.hualinghome.base;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.hualing.hualinghome.R;
import com.hualing.hualinghome.utils.ThreadManager;
import com.hualing.hualinghome.utils.UiUtils;

/**根据网络的状态显示页面的基类
 * Created by Administrator on 2017/7/23.
 */
public abstract class BaseViewLoadPage extends FrameLayout {
    private static final int STATE_UNLOAD = 0;// 未加载
    private static final int STATE_LOADING = 1;// 正在加载
    private static final int STATE_LOAD_EMPTY = 2;// 数据为空
    private static final int STATE_LOAD_ERROR = 3;// 加载失败
    private static final int STATE_LOAD_SUCCESS = 4;// 访问成功
    private int mCurrentState = STATE_UNLOAD;// 当前状态
    private View mLoadingView;
    private View mLoadErrorView;
    private View mLoadEmptyView;
    private View mLoadSuccessView;

    //**************************加载网络数据开始******************************
    /**
     * 加载网络数据
     */
    public void loadDataFromNetWork(){
        //System.out.println("loadDataFromNetWork:");
        //清空状态
        if( mCurrentState==STATE_LOAD_EMPTY || mCurrentState==STATE_LOAD_ERROR || mCurrentState==STATE_LOAD_SUCCESS){
            mCurrentState=STATE_UNLOAD;
        }
        if(mCurrentState==STATE_UNLOAD){
            //使用线程池异步加载数据
            ThreadManager.getThreadPool().execute(new Runnable() {
                @Override
                public void run() {
                    //加载数据返回一个结果状态
                    final ResultState stateObject = onLoadData();
                    //必须在主线程中更新UI界面
                    UiUtils.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //判断加载数据返回的结果状态
                            if(stateObject != null){
                                //更新当前的状态
                                mCurrentState=stateObject.getState();
                                //根据当前状态更新当前的UI界面
                                showRinghtPage();
                            }
                        }
                    });
                }
            });
        }
    }
    //**************************加载网络数据结束******************************
    //**************************结果状态开始******************************
    public enum ResultState{
        LOAD_SUCCES(STATE_LOAD_SUCCESS),
        LOAD_ERROR(STATE_LOAD_ERROR),
        LOAD_EMPTY(STATE_LOAD_EMPTY);

        private int mState;
        private ResultState(int state){
            this.mState=state;
        }
        //返回状态
        public int getState(){
            return mState;
        }
    }
    //**************************结果状态结束******************************
    //**************************初始化视图开始******************************
    /**
     * 根据当前状态显示正确的页面
     */
    public void showRinghtPage() {
        //显示正在加载的页面
        if (mLoadingView != null) {
            mLoadingView.setVisibility((mCurrentState == STATE_LOADING || mCurrentState == STATE_UNLOAD) ? View.VISIBLE : View.GONE);
        }
        //显示加载失败的页面
        if(mLoadErrorView != null){
            mLoadErrorView.setVisibility((mCurrentState==STATE_LOAD_ERROR) ? View.VISIBLE : View.GONE);
        }
        //显示数据为空的页面
        if(mLoadEmptyView != null){
            mLoadEmptyView.setVisibility((mCurrentState==STATE_LOAD_EMPTY) ? View.VISIBLE : View.GONE);
        }

        //显示加载成功的布局
        if(mLoadSuccessView==null && mCurrentState==STATE_LOAD_SUCCESS ){
            mLoadSuccessView=onCreateLoadSuccesView();
            if(mLoadSuccessView != null){
                addView(mLoadSuccessView);
            }
        }
        if(mLoadSuccessView != null){
            mLoadSuccessView.setVisibility((mCurrentState==STATE_LOAD_SUCCESS) ? View.VISIBLE : View.GONE);
        }
    }
    /**
     * 初始化视图
     */
    public void initView() {
        //正在加载
        if (mLoadingView == null) {
            mLoadingView = onCreateLoadingView();
            addView(mLoadingView);
        }
        //加载失败
        if (mLoadErrorView == null) {
            mLoadErrorView = onCreateLoadErrorView();
            mLoadErrorView.findViewById(R.id.tv_shop_load_error_restart).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    loadDataFromNetWork();
                }
            });
            addView(mLoadErrorView);
        }
        //数据为空的布局
        if (mLoadEmptyView == null) {
            mLoadEmptyView = onCreateLoadEmptyView();
            addView(mLoadEmptyView);
        }
        //显示成功的布局
        showRinghtPage();
        loadDataFromNetWork();
    }
    /**
     * 创建成功的视图对象必须由子类来实现
     * @return
     */
    public abstract View onCreateLoadSuccesView();

    /**
     * 加载具体网络数据必须由子类类决定
     * @return
     */
    public abstract ResultState onLoadData();
    /**
     * 数据为空的布局
     *
     * @return
     */
    public View onCreateLoadEmptyView() {
        return UiUtils.inflate(R.layout.layout_load_empty_view);
    }

    /**
     * 加载失败的布局
     *
     * @return
     */
    public View onCreateLoadErrorView() {
        return UiUtils.inflate(R.layout.layout_load_error_view);
    }

    /**
     * 正在加载的布局
     *
     * @return
     */
    public View onCreateLoadingView() {
        return UiUtils.inflate(R.layout.layout_loading);
    }
    //**************************初始化视图结束******************************
    //**************************构造方法开始******************************
    public BaseViewLoadPage(@NonNull Context context) {
        super(context);
        //初始化视图
        initView();
    }

    public BaseViewLoadPage(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //初始化视图
        initView();
    }

    public BaseViewLoadPage(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初始化视图
        initView();
    }
    //**************************构造方法结束******************************
}
