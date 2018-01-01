package com.jctech.commonecommerce;

import android.app.Application;

import com.jctech.lib_core_android.app.EC;
import com.jctech.lib_core_android.net.interceptor.DebugInterceptor;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by CHENQIAO on 2017/8/27.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EC.init(this)
                .withIcons(new FontAwesomeModule())
                .withApiHost("http://127.0.0.1")
                .withInterceptor(new DebugInterceptor("test", R.raw.test))
                .withWeChatAppId("你的微信AppKey")
                .withWeChatAppSecret("你的微信AppSecret")
                .configure();
    }
}
