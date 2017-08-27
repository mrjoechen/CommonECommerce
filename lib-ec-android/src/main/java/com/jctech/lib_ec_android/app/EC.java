package com.jctech.lib_ec_android.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by CHENQIAO on 2017/8/27.
 */

public class EC {

    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();

    }

    private static HashMap<String, Object> getConfigurations(){
        return Configurator.getInstance().getCONFIGS();
    }
}
