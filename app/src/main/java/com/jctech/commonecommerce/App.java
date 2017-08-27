package com.jctech.commonecommerce;

import android.app.Application;

import com.jctech.lib_ec_android.app.EC;

/**
 * Created by CHENQIAO on 2017/8/27.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EC.init(this).configure().withApiHost("http://127.0.0.1");
    }
}
