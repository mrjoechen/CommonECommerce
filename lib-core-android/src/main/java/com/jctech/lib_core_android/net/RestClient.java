package com.jctech.lib_core_android.net;

import android.content.Context;

import com.jctech.lib_core_android.net.callback.IError;
import com.jctech.lib_core_android.net.callback.IFailure;
import com.jctech.lib_core_android.net.callback.IRequest;
import com.jctech.lib_core_android.net.callback.ISuccess;
import com.jctech.lib_core_android.net.callback.RequestCallbacks;
import com.jctech.lib_core_android.ui.ECLoader;
import com.jctech.lib_core_android.ui.LoaderStyle;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by CHENQIAO on 2017/9/3.
 */

public class RestClient {

    private final String URL;
//    private final Map<String, Object> PARAMS;

    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest IRequest;
    private final ISuccess ISuccess;
    private final IFailure IFailure;
    private final IError IError;
    private final RequestBody REQUESTBODY;

    private LoaderStyle loaderStyle;
    private final Context context;


    public RestClient(String mUrl,
                      Map<String, Object> mParams,
                      IRequest iRequet,
                      ISuccess iSuccess,
                      IFailure iFailure,
                      IError iError,
                      RequestBody mRequestbody,
                      Context context,
                      LoaderStyle loaderStyle) {
        this.URL = mUrl;
        PARAMS.putAll(mParams);
        this.IRequest = iRequet;
        this.ISuccess = iSuccess;
        this.IFailure = iFailure;
        this.IError = iError;
        this.REQUESTBODY = mRequestbody;
        this.context = context;
        this.loaderStyle = loaderStyle;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HTTP_METHOD http_method) {

        RestService restService = RestCreator.getRestService();
        Call<String> call = null;
        if (IRequest != null) {
            IRequest.onRequestStart();
        }
        if (loaderStyle != null) {
            ECLoader.showLoading(context, loaderStyle);
        }
        switch (http_method) {

            case GET:
                call = restService.get(URL, PARAMS);
                break;
            case POST:
                call = restService.post(URL, PARAMS);
                break;
            case PUT:
                call = restService.put(URL, PARAMS);
                break;
            case DELETE:
                call = restService.delete(URL, PARAMS);
                break;
            default:
                break;

        }

        if (call != null) {
            call.enqueue(getRequestCallbacks());
        }

    }

    private RequestCallbacks getRequestCallbacks() {
        return new RequestCallbacks(IRequest, ISuccess, IFailure, IError, loaderStyle);
    }

    public final void get() {
        request(HTTP_METHOD.GET);
    }

    public final void post() {
        request(HTTP_METHOD.POST);
    }

    public final void put() {
        request(HTTP_METHOD.PUT);
    }

    public final void delete() {
        request(HTTP_METHOD.DELETE);
    }


}
