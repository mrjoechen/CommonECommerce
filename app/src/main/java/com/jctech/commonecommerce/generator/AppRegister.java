package com.jctech.commonecommerce.generator;


import com.example.annotations.AppRegisterGenerator;
import com.jctech.lib_core_android.wx.templete.WXRegisterTemplete;

/**
 * Created by chenqiao on 2017/4/22
 */
@SuppressWarnings("unused")
@AppRegisterGenerator(
        packageName = "com.jctech.commonecommerce",
        registerTemplete = WXRegisterTemplete.class
)

public interface AppRegister {
}
