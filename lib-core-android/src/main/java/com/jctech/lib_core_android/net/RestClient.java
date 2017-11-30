package com.jctech.lib_core_android.net;

import android.content.Context;

import com.jctech.lib_core_android.net.callback.IError;
import com.jctech.lib_core_android.net.callback.IFailure;
import com.jctech.lib_core_android.net.callback.IRequest;
import com.jctech.lib_core_android.net.callback.ISuccess;
import com.jctech.lib_core_android.net.callback.RequestCallbacks;
import com.jctech.lib_core_android.ui.ECLoader;
import com.jctech.lib_core_android.ui.LoaderStyle;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by CHENQIAO on 2017/9/3.
 */

public class RestClient {

    private final String URL;
//    private final Map<String, Object> PARAMS;

    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest IREQUEST;
    private final ISuccess ISUCCESS;
    private final IFailure IFAILURE;
    private final IError IERROR;
    private final RequestBody BODY;
    private final File FILE;

    private final LoaderStyle loaderStyle;
    private final Context context;


    public RestClient(String mUrl,
                      Map<String, Object> mParams,
                      IRequest iRequet,
                      ISuccess iSuccess,
                      IFailure iFailure,
                      IError iError,
                      RequestBody mRequestbody,
                      Context context,
                      LoaderStyle loaderStyle,
                      File file) {
        this.URL = mUrl;
        PARAMS.putAll(mParams);
        this.IREQUEST = iRequet;
        this.ISUCCESS = iSuccess;
        this.IFAILURE = iFailure;
        this.IERROR = iError;
        this.BODY = mRequestbody;
        this.context = context;
        this.loaderStyle = loaderStyle;
        this.FILE = file;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HTTP_METHOD http_method) {

        RestService restService = RestCreator.getRestService();
        Call<String> call = null;
        if (IREQUEST != null) {
            IREQUEST.onRequestStart();
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
            case POST_RAW:
                call = restService.postRaw(URL, BODY);
                break;
            case PUT:
                call = restService.put(URL, PARAMS);
                break;
            case PUT_RAW:
                call = restService.putRaw(URL, BODY);
                break;
            case DELETE:
                call = restService.delete(URL, PARAMS);
                break;
            case UPLOAD:
                final RequestBody requestBody = RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);

                final MultipartBody.Part body = MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);

                call = RestCreator.getRestService().upload(URL, body);
                break;
            default:
                break;

        }

        if (call != null) {
            call.enqueue(getRequestCallbacks());
        }

    }

    private RequestCallbacks getRequestCallbacks() {
        return new RequestCallbacks(IREQUEST, ISUCCESS, IFAILURE, IERROR, loaderStyle);
    }

    public final void get() {
        request(HTTP_METHOD.GET);
    }

    public final void post() {
        if (BODY == null) {
            request(HTTP_METHOD.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("request params must be null");
            }
            request(HTTP_METHOD.POST_RAW);
        }
    }

    public final void put() {

        if (BODY == null) {
            request(HTTP_METHOD.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("request params must be null");
            }
            request(HTTP_METHOD.PUT_RAW);

        }
    }

    public final void delete() {
        request(HTTP_METHOD.DELETE);
    }


}
