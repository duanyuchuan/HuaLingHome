package com.hualing.hualinghome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.hualing.hualinghome.base.BaseActivity;
import com.hualing.hualinghome.fragment.FindFragment;
import com.hualing.hualinghome.fragment.HomeFragment;
import com.hualing.hualinghome.fragment.MyFragment;
import com.hualing.hualinghome.fragment.ShardFragment;
import com.hualing.hualinghome.fragment.ShopFragment;
import com.hualing.hualinghome.interfaces.IBottomItemClickListener;
import com.hualing.hualinghome.view.LayoutBottomBar;

/**
 * Home页面
 */
public class HomeActivity extends BaseActivity implements IBottomItemClickListener {
    private LayoutBottomBar mLayoutBottomBar;
    private HomeFragment mHomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setFullScrean(false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setNoTitleBar(true);
        //StatusBarCompat.compat(this, Color.TRANSPARENT);
        //初始化视图
        initView();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        mLayoutBottomBar=(LayoutBottomBar)findViewById(R.id.bottombar);
        mLayoutBottomBar.setOnIBottomItemClickListener(this);
        mHomeFragment=new HomeFragment();
        replaceContentByFragment(mHomeFragment);
    }

    /**
     * 点击底部栏
     * @param view
     */
    @Override
    public void onBottomItemClick(View view) {
        switch (view.getId()){
            case R.id.rl_home:
                if(mHomeFragment != null){
                    replaceContentByFragment(mHomeFragment);
                }else{
                    mHomeFragment=new HomeFragment();
                    replaceContentByFragment(mHomeFragment);
                }
                break;
            case R.id.rl_shard:
                replaceContentByFragment(new ShardFragment());
                break;
            case R.id.rl_find:
                replaceContentByFragment(new FindFragment());
                break;
            case R.id.rl_shop:
                replaceContentByFragment(new ShopFragment());
                break;
            case R.id.rl_my:
                replaceContentByFragment(new MyFragment());
                break;
        }
    }
    /**
     * 切换Fragment
     * @param fragment
     */
    private void replaceContentByFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        fragmentTransaction.replace(R.id.fl_home_content,fragment);
        fragmentTransaction.commit();
    }
}
