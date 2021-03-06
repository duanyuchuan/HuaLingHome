package com.hualing.hualinghome.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.interfaces.IBottomItemClickListener;

/**
 * Created by Administrator on 2017/7/20.
 */

public class LayoutBottomBar extends LinearLayout implements View.OnClickListener{
    private RelativeLayout mRLHome;
    private ImageView mIVHome;
    private ImageView mIVHomeSelect;
    private TextView mTVHome;

    private RelativeLayout mRLShard;
    private ImageView mIVShard;
    private ImageView mIVShardSelect;
    private TextView mTVShard;

    private RelativeLayout mRLFind;
    private ImageView mIVFind;
    private ImageView mIVFindSelect;
    private TextView mTVFind;

    private RelativeLayout mRLShop;
    private ImageView mIVShop;
    private ImageView mIVShopSelect;
    private TextView mTVShop;

    private RelativeLayout mRLMy;
    private ImageView mIVMy;
    private ImageView mIVMySelect;
    private TextView mTVMy;
    private IBottomItemClickListener mIBottomItemClickListener;
    private int mTabItemId;

    public LayoutBottomBar(Context context) {
        super(context);
    }
    public LayoutBottomBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public LayoutBottomBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnIBottomItemClickListener(IBottomItemClickListener listener){
        this.mIBottomItemClickListener=listener;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mRLHome = findViewById(R.id.rl_home);
        mIVHome = findViewById(R.id.iv_home_bottombar);
        mIVHomeSelect=findViewById(R.id.iv_home_select_bottombar);
        mTVHome=findViewById(R.id.tv_home_bottombar);
        mRLHome.setOnClickListener(this);
        mIVHome.setSelected(true);
        mTVHome.setSelected(true);
        mIVHomeSelect.setVisibility(View.VISIBLE);

        mRLShard = findViewById(R.id.rl_shard);
        mIVShard = findViewById(R.id.iv_shard_bottombar);
        mIVShardSelect=findViewById(R.id.iv_shard_select_bottombar);
        mTVShard=findViewById(R.id.tv_shard_bottombar);
        mRLShard.setOnClickListener(this);

        mRLFind = findViewById(R.id.rl_find);
        mIVFind = findViewById(R.id.iv_find_bottombar);
        mIVFindSelect=findViewById(R.id.iv_find_select_bottombar);
        mTVFind=findViewById(R.id.tv_find_bottombar);
        mRLFind.setOnClickListener(this);

        mRLShop = findViewById(R.id.rl_shop);
        mIVShop = findViewById(R.id.iv_shop_bottombar);
        mIVShopSelect=findViewById(R.id.iv_shop_select_bottombar);
        mTVShop=findViewById(R.id.tv_shop_bottombar);
        mRLShop.setOnClickListener(this);

        mRLMy = findViewById(R.id.rl_my);
        mIVMy = findViewById(R.id.iv_my_hualing_bottombar);
        mIVMySelect=findViewById(R.id.iv_my_hualing_select_bottombar);
        mTVMy=findViewById(R.id.tv_my_hualing_bottombar);
        mRLMy.setOnClickListener(this);
    }
    /**
     * 点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        if(mTabItemId==view.getId()){
            return;
        }
        mTabItemId=view.getId();
        changeTabItemStyle(view);
        if(mIBottomItemClickListener != null){
            mIBottomItemClickListener.onBottomItemClick(view);
        }
    }
    /**
     * 改变选择按钮的样式
     */
    private void changeTabItemStyle(View view) {
        mIVHome.setSelected(view.getId()==R.id.rl_home);
        mTVHome.setSelected(view.getId()==R.id.rl_home);
        mIVHomeSelect.setVisibility(view.getId()==R.id.rl_home ? View.VISIBLE : View.GONE);

        mIVShard.setSelected(view.getId()==R.id.rl_shard);
        mTVShard.setSelected(view.getId()==R.id.rl_shard);
        mIVShardSelect.setVisibility(view.getId()==R.id.rl_shard ? View.VISIBLE : View.GONE);

        mIVFind.setSelected(view.getId()==R.id.rl_find);
        mTVFind.setSelected(view.getId()==R.id.rl_find);
        mIVFindSelect.setVisibility(view.getId()==R.id.rl_find ? View.VISIBLE : View.GONE);

        mIVShop.setSelected(view.getId()==R.id.rl_shop);
        mTVShop.setSelected(view.getId()==R.id.rl_shop);
        mIVShopSelect.setVisibility(view.getId()==R.id.rl_shop ? View.VISIBLE : View.GONE);

        mIVMy.setSelected(view.getId()==R.id.rl_my);
        mTVMy.setSelected(view.getId()==R.id.rl_my);
        mIVMySelect.setVisibility(view.getId()==R.id.rl_my ? View.VISIBLE : View.GONE);
    }
}
