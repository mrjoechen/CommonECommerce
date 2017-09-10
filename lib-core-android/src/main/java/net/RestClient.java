package net;

import net.callback.IError;
import net.callback.IFailure;
import net.callback.IRequest;
import net.callback.ISuccess;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.RequestBody;

/**
 * Created by CHENQIAO on 2017/9/3.
 */

public class RestClient {

    private final String URL;
//    private final Map<String, Object> PARAMS;

    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest IREQUET;
    private final ISuccess iSuccess;
    private final IFailure iFailure;
    private final IError iError;
    private final RequestBody REQUESTBODY;


    public RestClient(String mUrl,
                      Map<String, Object> mParams,
                      IRequest iRequet,
                      ISuccess iSuccess,
                      IFailure iFailure,
                      IError iError,
                      RequestBody mRequestbody) {
        this.URL = mUrl;
        PARAMS.putAll(mParams);
        this.IREQUET = iRequet;
        this.iSuccess = iSuccess;
        this.iFailure = iFailure;
        this.iError = iError;
        this.REQUESTBODY = mRequestbody;
    }

    public static RestClientBuilder builder(){
        return new RestClientBuilder();
    }
}
