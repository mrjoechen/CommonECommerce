package com.jctech.commonecommerce;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.widget.Toast;

import com.jctech.lib_core_android.activities.ProxyActivity;
import com.jctech.lib_core_android.delegate.ECDelategate;
import com.jctech.lib_ec_android.main.EcBottomDelegate;
import com.jctech.lib_ec_android.sign.ISignListener;
import com.jctech.lib_ec_android.sign.SignInDelegate;
import com.jctech.lib_ui.launcher.ILauncherListener;
import com.jctech.lib_ui.launcher.OnLauncherFinishTag;

public class ExampleActivity extends ProxyActivity implements
        ISignListener,
        ILauncherListener {

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

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSignUpSuccess() {

        Toast.makeText(this, "注册成功", Toast.LENGTH_LONG).show();
        //可以进行收集信息，统计信息等操作
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                Toast.makeText(this, "启动结束，用户登录了", Toast.LENGTH_LONG).show();
                startWithPop(new EcBottomDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this, "启动结束，用户没登录", Toast.LENGTH_LONG).show();
                startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }

}
