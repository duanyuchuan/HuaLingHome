package com.hualing.hualinghome.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.activity.BaseActivity;
import com.hualing.hualinghome.fragment.find.FindFragment;
import com.hualing.hualinghome.fragment.home.HomeFragment;
import com.hualing.hualinghome.fragment.my.MyFragment;
import com.hualing.hualinghome.fragment.shard.ShardFragment;
import com.hualing.hualinghome.fragment.shop.ShopFragment;
import com.hualing.hualinghome.interfaces.IBottomItemClickListener;
import com.hualing.hualinghome.view.LayoutBottomBar;

/**
 * Home页面
 */
public class HomeActivity extends BaseActivity implements IBottomItemClickListener {
    private LayoutBottomBar mLayoutBottomBar;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setFullScrean(false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setNoTitleBar(true);
        //StatusBarCompat.compat(this, Color.TRANSPARENT);
        mFragmentManager=getSupportFragmentManager();
        //初始化视图
        initView();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        mLayoutBottomBar=(LayoutBottomBar)findViewById(R.id.bottombar);
        mLayoutBottomBar.setOnIBottomItemClickListener(this);

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_home_content,new HomeFragment());
        fragmentTransaction.commit();
    }

    /**
     * 点击底部栏
     * @param action
     */
    @Override
    public void onBottomItemClick(int action) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        switch (action){
            case R.id.rl_home:
                fragmentTransaction.replace(R.id.fl_home_content,new HomeFragment());
                break;
            case R.id.rl_shard:
                fragmentTransaction.replace(R.id.fl_home_content,new ShardFragment());
                break;
            case R.id.rl_find:
                fragmentTransaction.replace(R.id.fl_home_content,new FindFragment());
                break;
            case R.id.rl_shop:
                fragmentTransaction.replace(R.id.fl_home_content,new ShopFragment());
                break;
            case R.id.rl_my:
                fragmentTransaction.replace(R.id.fl_home_content,new MyFragment());
                break;
        }
        fragmentTransaction.commit();
    }
}
