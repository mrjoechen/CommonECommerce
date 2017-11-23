package com.jctech.lib_core_android.net.callback;

import android.os.Handler;

import com.jctech.lib_core_android.ui.ECLoader;
import com.jctech.lib_core_android.ui.LoaderStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by CHENQIAO on 2017/9/11.
 */

public class RequestCallbacks implements Callback<String> {

    private final IRequest IREQUET;
    private final ISuccess iSuccess;
    private final IFailure iFailure;
    private final IError iError;
    private final LoaderStyle loaderStyle;
    private final Handler handler = new Handler();


    public RequestCallbacks(IRequest IREQUET, ISuccess iSuccess, IFailure iFailure, IError iError, LoaderStyle loaderStyle) {
        this.IREQUET = IREQUET;
        this.iSuccess = iSuccess;
        this.iFailure = iFailure;
        this.iError = iError;
        this.loaderStyle = loaderStyle;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {

        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (iSuccess != null) {
                    iSuccess.onSuccess(response.body());
                }
            }
        } else {
            if (iError != null) {
                iError.onError(response.code(), response.message());
            }
        }

        if (loaderStyle != null) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ECLoader.stopLoading();
                }
            }, 3000);
        }

    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {

        if (iFailure != null) {
            iFailure.onFailure();
        }

        if (IREQUET != null) {
            IREQUET.onRequestEnd();
        }

    }
}
