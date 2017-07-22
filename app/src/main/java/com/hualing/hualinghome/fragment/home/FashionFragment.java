package com.hualing.hualinghome.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hualing.hualinghome.R;
import com.hualing.hualinghome.base.BaseFragment;

/**时尚
 * Created by Administrator on 2017/7/22.
 */

public class FashionFragment extends BaseFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fashion,container,false);

        return rootView;
    }
}
