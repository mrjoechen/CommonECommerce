package com.jctech.commonecommerce;

import android.content.Context;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.jctech.lib_core_android.activities.ProxyActivity;
import com.jctech.lib_core_android.delegate.ECDelategate;
import com.jctech.lib_ec_android.launcher.LauncherDelegate;
import com.jctech.lib_ec_android.launcher.LauncherScrollDelegate;
import com.jctech.lib_ec_android.sign.SignInDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
    }

    @Override
    public ECDelategate setRootDelegate() {
        return new SignInDelegate();
    }

}
