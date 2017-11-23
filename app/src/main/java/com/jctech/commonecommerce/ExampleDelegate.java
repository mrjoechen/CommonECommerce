package com.jctech.commonecommerce;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.jctech.lib_core_android.delegate.ECDelategate;

import com.jctech.lib_core_android.net.RestClient;
import com.jctech.lib_core_android.net.callback.IError;
import com.jctech.lib_core_android.net.callback.IFailure;
import com.jctech.lib_core_android.net.callback.IRequest;
import com.jctech.lib_core_android.net.callback.ISuccess;

/**
 * Created by CHENQIAO on 2017/9/11.
 */

public class ExampleDelegate extends ECDelategate implements View.OnClickListener {

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View view) {
        testRestHttp();
    }

    public void testRestHttp(){

        RestClient.builder().request(new IRequest() {
            @Override
            public void onRequestStart() {

            }

            @Override
            public void onRequestEnd() {

            }
        }).url("http://www.baidu.com").success(new ISuccess() {
            @Override
            public void onSuccess(String response) {
                Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
            }
        }).failure(new IFailure() {
            @Override
            public void onFailure() {

            }
        }).error(new IError() {
            @Override
            public void onError(int code, String msg) {

            }
        }).loader(getContext()).build().get();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.test_btn:
                testRestHttp();
                break;
            default:
                break;

        }
    }
}
