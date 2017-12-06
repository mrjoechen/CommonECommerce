package com.jctech.commonecommerce;

import android.content.Context;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.jctech.lib_core_android.activities.ProxyActivity;
import com.jctech.lib_core_android.delegate.ECDelategate;
import com.jctech.lib_ec_android.launcher.LauncherDelegate;
import com.jctech.lib_ec_android.launcher.LauncherScrollDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public ECDelategate setRootDelegate() {
        return new LauncherDelegate();
    }

}
