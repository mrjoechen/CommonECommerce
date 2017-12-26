package com.jctech.commonecommerce.generator;

import com.example.annotations.PayEntryGenerator;
import com.jctech.lib_core_android.wx.templete.WXPayEntryTemplete;

/**
 * Created by chenqiao on 2017/4/22
 */
@SuppressWarnings("unused")
@PayEntryGenerator(
        packageName = "com.jctech.commonecommerce",
        payEntryTemplete = WXPayEntryTemplete.class
)
public interface WeChatPayEntry {
}
