package com.jctech.lib_core_android.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.jctech.lib_core_android.delegate.ECDelategate;
import com.jctech.lib_core_android.R;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by CHENQIAO on 2017/8/29.
 */

public abstract class ProxyActivity extends SupportActivity{

    public abstract ECDelategate setRootDelegate();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState){

        final ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
        if (savedInstanceState == null){
            loadRootFragment(R.id.delegate_container, setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }
}
