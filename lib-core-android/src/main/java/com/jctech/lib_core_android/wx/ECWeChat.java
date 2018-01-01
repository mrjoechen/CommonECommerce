package com.jctech.lib_core_android.wx;

import android.app.Activity;

import com.jctech.lib_core_android.app.ConfigType;
import com.jctech.lib_core_android.app.EC;
import com.jctech.lib_core_android.wx.callbacks.IWeChatSignInCallback;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by CHENQIAO on 2018/1/1.
 */

public class ECWeChat {

    public static final String APP_ID = EC.getConfiguration(ConfigType.WE_CHAT_APP_ID);
    public static final String APP_SECRET = EC.getConfiguration(ConfigType.WE_CHAT_APP_SECRET);
    private final IWXAPI WXAPI;
    private IWeChatSignInCallback mSignInCallback = null;

    private static final class Holder {
        private static final ECWeChat INSTANCE = new ECWeChat();
    }

    public static ECWeChat getInstance() {
        return Holder.INSTANCE;
    }

    private ECWeChat() {
        final Activity activity = EC.getConfiguration(ConfigType.ACTIVITY);
        WXAPI = WXAPIFactory.createWXAPI(activity, APP_ID, true);
        WXAPI.registerApp(APP_ID);
    }

    public final IWXAPI getWXAPI() {
        return WXAPI;
    }

    public ECWeChat onSignSuccess(IWeChatSignInCallback callback) {
        this.mSignInCallback = callback;
        return this;
    }

    public IWeChatSignInCallback getSignInCallback() {
        return mSignInCallback;
    }

    public final void signIn() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        WXAPI.sendReq(req);
    }
}
