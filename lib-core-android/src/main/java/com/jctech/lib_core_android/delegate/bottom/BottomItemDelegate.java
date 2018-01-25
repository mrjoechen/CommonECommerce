package com.jctech.lib_core_android.delegate.bottom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.jctech.lib_core_android.R;
import com.jctech.lib_core_android.delegate.ECDelategate;

/**
 * Created by CHENQIAO on 2018/1/6.
 */

public class BottomItemDelegate extends ECDelategate implements View.OnKeyListener {


    private long mExitTime = 0;
    private static final int EXIT_TIME = 1000;


    @Override
    public Object setLayout() {
        return null;
    }

    @Override
    public void onResume() {
        super.onResume();
        final View rootView = getView();
        if (rootView != null) {
            rootView.setFocusableInTouchMode(true);
            rootView.requestFocus();
            rootView.setOnKeyListener(this);
        }
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {

        if (i == KeyEvent.KEYCODE_BACK && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - mExitTime) > EXIT_TIME) {
                Toast.makeText(getContext(), "双击退出" + getString(R.string.app_name), Toast.LENGTH_LONG).show();
                mExitTime = System.currentTimeMillis();
            } else {
                _mActivity.finish();
                if (mExitTime != 0) {
                    mExitTime = 0;
                }
            }

            return true;
        }

        return false;
    }
}
