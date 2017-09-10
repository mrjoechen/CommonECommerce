package com.jctech.lib_core_android.delegate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by CHENQIAO on 2017/8/29.
 */

public abstract class BaseDelegate extends SwipeBackFragment{

    public abstract Object setLayout();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = null;
        if (setLayout() instanceof Integer){
            rootView = inflater.inflate((Integer) setLayout(), container, false);
        }else if (setLayout() instanceof View){
            rootView = (View) setLayout();
        }

        if (rootView!=null){
            
        }

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
