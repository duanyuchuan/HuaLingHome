package com.hualing.hualinghome.fragment.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hualing.hualinghome.R;
import com.hualing.hualinghome.base.BaseFragment;

/**活动
 * Created by Administrator on 2017/7/21.
 */

public class ActivityFragment extends BaseFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_activity, container, false);
        return rootView;
    }
}
