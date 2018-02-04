package com.jctech.lib_ec_android.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jctech.lib_core_android.app.AccountManager;
import com.jctech.lib_ec_android.database.DatabasesManager;
import com.jctech.lib_ec_android.database.UserProfile;

/**
 * Created by CHENQIAO on 2017/12/18.
 */

public class SignHandler {

    public static void onSignIn(String response, ISignListener signListener) {

        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");

        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabasesManager.getInstance().getDao().insert(profile);
        //已经注册并登录成功了
        AccountManager.setSignState(true);
        signListener.onSignInSuccess();
    }


    public static void onSignUp(String response, ISignListener signListener) {

        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");

        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabasesManager.getInstance().getDao().insert(profile);

        //已经注册并登录成功了
        AccountManager.setSignState(true);
        signListener.onSignUpSuccess();
    }
}
