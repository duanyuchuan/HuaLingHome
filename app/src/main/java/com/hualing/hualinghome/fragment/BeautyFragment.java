package com.hualing.hualinghome.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.base.BaseFragment;

/**美妆护理
 * Created by Administrator on 2017/7/21.
 */

public class BeautyFragment extends BaseFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_beauty, container, false);
        return rootView;
    }
}
