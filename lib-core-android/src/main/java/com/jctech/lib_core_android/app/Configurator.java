package com.jctech.lib_core_android.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

import okhttp3.Interceptor;

/**
 * Created by CHENQIAO on 2017/8/27.
 */


/**
 * 配置文件获取和存储
 */
public final class Configurator {

//    private static final WeakHashMap<String, Object> CONFIG = new WeakHashMap<>();//不使用是可以及时被回收
    private static final HashMap<Object, Object> CONFIGS = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList();
    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();


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
        initializIcons();
        CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
        return this;
    }

    final HashMap<Object, Object> getCONFIGS() {
        return CONFIGS;
    }

    public final Configurator withApiHost(String host){
        CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private void initializIcons(){
        if (ICONS.size() > 0){
            Iconify.IconifyInitializer iconifyInitializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i<ICONS.size();i++){
                iconifyInitializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcons(IconFontDescriptor icon){
        ICONS.add(icon);
        return this;
    }

    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        CONFIGS.put(ConfigType.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        CONFIGS.put(ConfigType.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    public final Configurator withLoaderDelayed(long delayed) {
        CONFIGS.put(ConfigType.LOADER_DELAYED, delayed);
        return this;
    }

    public final Configurator withWeChatAppId(String appId) {
        CONFIGS.put(ConfigType.WE_CHAT_APP_ID, appId);
        return this;
    }

    public final Configurator withWeChatAppSecret(String appSecret) {
        CONFIGS.put(ConfigType.WE_CHAT_APP_SECRET, appSecret);
        return this;
    }

    private void checkConfiguation(){
        final boolean isReady = (boolean) CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("Configuation is not ready, please call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfiguation();
        return (T) CONFIGS.get(key.name());
    }

}
