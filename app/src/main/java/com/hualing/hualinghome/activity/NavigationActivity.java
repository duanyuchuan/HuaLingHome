package com.hualing.hualinghome.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.utils.MyConstaints;
import com.hualing.hualinghome.utils.SharedpreferencesUtil;
import com.hualing.hualinghome.utils.StartActivity;
import com.hualing.hualinghome.utils.UiUtils;

import java.util.ArrayList;


/**
 * Created by Administrator on 2017/7/17.
 */

public class NavigationActivity extends BaseActivity implements View.OnClickListener{
    private Context mContext;
    private ViewPager mViewPager;
    private Button mBtnStart;
    private LinearLayout mLLyPonit;
    private ArrayList<ImageView> mPageData;
    private ArrayList<ImageView> mPponit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        mContext=this;
        //引用布局控件
        mViewPager=findViewById(R.id.vp_navigation);
        mBtnStart = findViewById(R.id.bt_start);
        mLLyPonit = findViewById(R.id.lly_ponit);
        //初始化页面
        initData();

        //装配适配器
        MyViewPageAdapterNavigation adapter=new MyViewPageAdapterNavigation();
        mViewPager.setAdapter(adapter);
        //初始化事件
        initEnvent();
    }
    /**
     * 初始化事件
     */
    public void initEnvent(){
        mBtnStart.setOnClickListener(this);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                if(position==mPageData.size()-1){
                    mBtnStart.setVisibility(View.VISIBLE);
                }else{
                    mBtnStart.setVisibility(View.GONE);
                }
                selectImagePonit(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
    /**
     * 导航页面的指示器
     * @param position
     */
    public void selectImagePonit(int position){
        int size = mPponit.size();
        for (int i=0;i<size;i++){
            ImageView imageView = mPponit.get(i);
            if(position==i){
                imageView.setImageResource(R.drawable.selected_ponit);
            }else{
                imageView.setImageResource(R.drawable.normal_ponit);
            }
        }
    }
    /**
     * 点击开始按钮
     * @param view
     */
    @Override
    public void onClick(View view) {
        SharedpreferencesUtil.putBoolean(UiUtils.getContext(), MyConstaints.ISFIRST,false);
        StartActivity.startActivity(this,HomeActivity.class,true);
    }
    /**
     * 初始化页面
     */
    public void initData(){
        mPageData=new ArrayList<ImageView>();
        mPponit=new ArrayList<ImageView>();

        ImageView imageView1=new ImageView(mContext);
        Bitmap bitmap1 = getBitmapByResource(R.mipmap.navigation01);
        imageView1.setImageBitmap(bitmap1);
        imageView1.setScaleType(ImageView.ScaleType.FIT_XY);
        mPageData.add(imageView1);

        ImageView imageView2=new ImageView(mContext);
        Bitmap bitmap2 = getBitmapByResource(R.mipmap.navigation02);
        imageView2.setImageBitmap(bitmap2);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        mPageData.add(imageView2);

        ImageView imageView3=new ImageView(mContext);
        Bitmap bitmap3 = getBitmapByResource(R.mipmap.navigation03);
        imageView3.setImageBitmap(bitmap3);
        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
        mPageData.add(imageView3);

        int size = mPageData.size();
        for(int i=0;i<size;i++){
            ImageView ponitImageView=new ImageView(mContext);
            ponitImageView.setImageResource(R.drawable.normal_ponit);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            if(i !=0 ){
                params.setMargins(20,0,0,0);
            }
            ponitImageView.setLayoutParams(params);
            mPponit.add(ponitImageView);
            mLLyPonit.addView(ponitImageView);
        }
        //设置默认选中第一页
        selectImagePonit(0);
    }
    /**
     * 从资源文件中获取有个bitmap对象
     */
    public Bitmap getBitmapByResource(int resourceId){
        //1.获取屏幕的大小
        Display display = getWindowManager().getDefaultDisplay();
        int screanWidth = display.getWidth();
        int screanHeight = display.getHeight();
        //2.获取图片的大小
        BitmapFactory.Options options=new BitmapFactory.Options();
        BitmapFactory.decodeResource(getResources(),resourceId,options);
        options.inJustDecodeBounds=true;
        int imageWidth=options.outWidth;
        int imageHeight=options.outHeight;
        //3.获取图片的采样比例
        float scaleWidth=imageWidth/screanWidth;
        float scaleHeight=imageHeight/screanHeight;
        if((scaleWidth>scaleHeight) && scaleWidth>1){
            options.inSampleSize=(int)(scaleWidth+0.5f);
        }else if((scaleWidth<scaleHeight) && scaleHeight>1){
            options.inSampleSize=(int)(scaleHeight+0.5f);
        }
        //4.重新绘制图片
        options.inJustDecodeBounds=false;
        return BitmapFactory.decodeResource(getResources(),resourceId,options);
    }

    //自定义ViewPager适配器
    class MyViewPageAdapterNavigation extends PagerAdapter{

        @Override
        public int getCount() {
            return mPageData==null ? 0 : mPageData.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mPageData.get(position));
            return mPageData.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mPageData.get(position));
        }
    }
}
