package com.jctech.lib_core_android.net;

import android.content.Context;

import com.jctech.lib_core_android.net.callback.IError;
import com.jctech.lib_core_android.net.callback.IFailure;
import com.jctech.lib_core_android.net.callback.IRequest;
import com.jctech.lib_core_android.net.callback.ISuccess;
import com.jctech.lib_core_android.ui.LoaderStyle;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by CHENQIAO on 2017/9/10.
 */

public class RestClientBuilder {

    private String mUrl;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private IRequest mRequet;
    private ISuccess mSuccess;
    private IFailure mFailure;
    private IError mError;
    private RequestBody mRequestbody;
    private Context mContext;
    private LoaderStyle mLoadStyle;

    RestClientBuilder() {
    }

    public final RestClientBuilder url(String mUrl) {
        this.mUrl = mUrl;
        return this;
    }

    public final RestClientBuilder params(Map<String, Object> mParams) {
        PARAMS.putAll(mParams);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder request(IRequest mRequet) {
        this.mRequet = mRequet;
        return this;
    }

    public final RestClientBuilder success(ISuccess mSuccess) {
        this.mSuccess = mSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure mFailure) {
        this.mFailure = mFailure;
        return this;
    }

    public final RestClientBuilder error(IError mError) {
        this.mError = mError;
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mRequestbody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final Map<String, Object> checkParams() {
        if (PARAMS == null) {
            return new WeakHashMap<>();
        }
        return PARAMS;
    }

    public final RestClientBuilder loader(Context context, LoaderStyle loaderStyle){
        this.mContext = context;
        this.mLoadStyle = loaderStyle;
        return this;
    }

    public final RestClientBuilder loader(Context context){
        this.mContext = context;
        this.mLoadStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }


    public RestClient build() {
        return new RestClient(mUrl, PARAMS, mRequet, mSuccess, mFailure, mError, mRequestbody, mContext, mLoadStyle);
    }


}
