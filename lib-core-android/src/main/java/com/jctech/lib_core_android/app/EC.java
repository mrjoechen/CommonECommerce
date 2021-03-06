package com.jctech.lib_core_android.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by CHENQIAO on 2017/8/27.
 */

public final class EC {

    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();

    }

    public static HashMap<Object, Object> getConfigurations() {
        return Configurator.getInstance().getCONFIGS();
    }

    public static Context getApplication() {
        return getConfiguration(ConfigType.APPLICATION_CONTEXT);
    }

    public static <T> T getConfiguration(Enum<ConfigType> key) {
        return Configurator.getInstance().getConfiguration(key);
    }
}
