package com.jctech.lib_ec_android.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.jctech.lib_core_android.delegate.ECDelategate;

import java.util.ArrayList;

/**
 * Created by CHENQIAO on 2017/12/5.
 */

public class LauncherScrollDelegate extends ECDelategate{


    private ConvenientBanner<Integer> mConvenientBanner = null;
    private static final ArrayList<Integer> INTEGERS = new ArrayList<>();

    @Override
    public Object setLayout() {
        return null;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
