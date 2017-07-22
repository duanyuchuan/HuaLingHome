package com.hualing.hualinghome.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hualing.hualinghome.R;
import com.hualing.hualinghome.base.BaseFragment;

/**直播微生活
 * Created by Administrator on 2017/7/22.
 */

public class LiveMicroLifeFragment extends BaseFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_live_micro_life,container,false);

        return rootView;
    }
}
