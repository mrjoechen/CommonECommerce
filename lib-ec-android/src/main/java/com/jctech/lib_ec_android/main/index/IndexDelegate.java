package com.jctech.lib_ec_android.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.jctech.lib_core_android.delegate.bottom.BottomItemDelegate;
import com.jctech.lib_ec_android.R;

/**
 * Created by CHENQIAO on 2018/1/27.
 */

public class IndexDelegate extends BottomItemDelegate{

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        super.onBindView(savedInstanceState, rootView);
    }
}
