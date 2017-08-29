package com.jctech.commonecommerce;

import android.app.Application;

import com.jctech.lib_core_android.app.app.EC;
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
                .configure();
    }
}
