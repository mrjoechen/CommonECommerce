package com.jctech.lib_core_android.delegate.bottom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;

import com.jctech.lib_core_android.delegate.ECDelategate;

/**
 * Created by CHENQIAO on 2018/1/6.
 */

public class BaseBottomDelegate extends ECDelategate implements View.OnKeyListener {




    @Override
    public Object setLayout() {
        return null;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }
}
