package com.hualing.hualinghome.fragment.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hualing.hualinghome.R;
import com.hualing.hualinghome.base.BaseFragment;

/**推荐
 * Created by Administrator on 2017/7/21.
 */

public class RecommendedFragment extends BaseFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recommended, container, false);

        return rootView;
    }
}
