package com.jctech.lib_ec_android.app;

import java.util.HashMap;

/**
 * Created by CHENQIAO on 2017/8/27.
 */

public class Configurator {

    private static final HashMap<String, Object> CONFIGS = new HashMap<>();

    /**
     * 静态内部类，实现线程安全懒加载单例模式
     */
    private static class Holder{
        private static final Configurator Instance = new Configurator();
    }

    public static Configurator getInstance(){
        return Holder.Instance;
    }


    private Configurator() {
        CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public final Configurator configure(){
        CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
        return this;
    }

    final HashMap<String, Object> getCONFIGS() {
        return CONFIGS;
    }

    public final Configurator withApiHost(String host){
        CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private void checkConfiguation(){
        final boolean isReady = (boolean) CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("Configuation is not ready, please call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(String key){
        checkConfiguation();
        return (T) CONFIGS.get(key);

    }

}
