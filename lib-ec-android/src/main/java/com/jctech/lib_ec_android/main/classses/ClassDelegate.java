package com.jctech.lib_ec_android.main.classses;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.jctech.lib_core_android.delegate.bottom.BottomItemDelegate;
import com.jctech.lib_ec_android.R;

/**
 * Created by CHENQIAO on 2018/1/27.
 */

public class ClassDelegate extends BottomItemDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_class;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        super.onBindView(savedInstanceState, rootView);
    }
}