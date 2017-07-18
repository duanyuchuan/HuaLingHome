package com.hualing.hualinghome.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.myinterface.OnSkipButtonViewListener;
import com.hualing.hualinghome.utils.UiUtils;

/**
 * 自定义跳过按钮
 * Created by Administrator on 2017/7/15.
 */

public class SkipButtonView extends View {
    private int mTextWidth;
    private int mInnerWidth;
    private int mTextPadding=10;
    private int mTextPaintWidth=10;
    private int mOuterWidth;
    private Paint mInnerPaint;
    private Paint mOuterPaint;
    private RectF mRectf;
    private Paint mTextPanit;
    private int mSkipButtonColor;
    private int mOuterColor;
    private String mSkipButtonText;
    private int mSkipButtonTextSize;
    private int mSkipButtonTextColor;
    private OnSkipButtonViewListener mOnSkipButtonViewListener;

    //当前进度
    private int mProgess;

    public SkipButtonView(Context context) {
        super(context);
        initView();
    }
    public SkipButtonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SkipButtonView);
        mSkipButtonColor = array.getColor(R.styleable.SkipButtonView_SkipButtonColor, Color.GRAY);
        mOuterColor = array.getColor(R.styleable.SkipButtonView_OuterColor, Color.RED);
        mSkipButtonText = array.getString(R.styleable.SkipButtonView_SkipButtonText);
        mSkipButtonTextSize = (int) array.getDimension(R.styleable.SkipButtonView_SkipButtonTextSize, UiUtils.dpTopx(20));
        mSkipButtonTextColor = array.getColor(R.styleable.SkipButtonView_SkipButtonTextColor, Color.WHITE);

        initView();
        array.recycle();
    }
    public SkipButtonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }
    /**
     * 设置点击监听的方法
     */
    public void setOnClickSkipButtonViewListener(OnSkipButtonViewListener listener){
        this.mOnSkipButtonViewListener=listener;
    }
    /**
     * 初始化操作
     */
    private void initView() {
        //初始化文字画笔
        mTextPanit=new TextPaint();
        mTextPanit.setFlags(Paint.ANTI_ALIAS_FLAG);
        mTextPanit.setTextSize(mSkipButtonTextSize);
        mTextPanit.setColor(mSkipButtonTextColor);
        mTextWidth= (int) mTextPanit.measureText(mSkipButtonText);

        //画内圆的画笔
        mInnerPaint=new Paint();
        mInnerPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mInnerPaint.setColor(mSkipButtonColor);

        //外圆的画笔
        mOuterPaint=new Paint();
        mOuterPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mOuterPaint.setStyle(Paint.Style.STROKE);
        mOuterPaint.setStrokeWidth(mTextPaintWidth);
        mOuterPaint.setColor(mOuterColor);

        //计算内圈的宽度=文字的宽度+2倍的文字的间距
        mInnerWidth=mTextWidth+2*mTextPadding;
        //控件的宽度为=内圈的宽度+2倍画笔的宽度
        mOuterWidth=mInnerWidth+2*mTextPaintWidth;

        //计算外圈的区域
        mRectf=new RectF(
                mTextPaintWidth/2,
                mTextPaintWidth/2,
                mOuterWidth-mTextPaintWidth/2,
                mOuterWidth-mTextPaintWidth/2
                );
    }
    /**
     * 测量控件
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(mOuterWidth,mOuterWidth);
    }
    /**
     * 画控件
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画背景
        //canvas.drawColor(Color.RED);
        //画内圆背景
        canvas.drawCircle(mOuterWidth/2,mOuterWidth/2,mInnerWidth/2,mInnerPaint);

        //旋转画布
        canvas.save();
        canvas.rotate(-90,mOuterWidth/2,mOuterWidth/2);
        //画外圈
        canvas.drawArc(mRectf,0,mProgess,false,mOuterPaint);
        canvas.restore();

        //画文字
        float y=canvas.getHeight()/2;
        float descent = mTextPanit.descent();//+
        float ascent = mTextPanit.ascent();//-
        canvas.drawText(mSkipButtonText,mTextPadding+mTextPaintWidth,y-((descent+ascent)/2),mTextPanit);
    }
    /**
     * 控件的触摸事件
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                setAlpha(0.3f);
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                setAlpha(1.0f);
                if(mOnSkipButtonViewListener != null){
                    mOnSkipButtonViewListener.onClickSkipButton(this);
                }
                break;
        }
        return true;
    }
    /**
     * 提供给外部设置进度的方法
     * @param total
     * @param now
     */
    public void setProgess(int total,int now){
        int space=360/total;
        mProgess=now*space;
        //刷新重新绘制
        invalidate();
    }
    /**
     * 设置外圈角度
     */
    public void setDgree(int dgree){
        this.mProgess=dgree;
    }
}
