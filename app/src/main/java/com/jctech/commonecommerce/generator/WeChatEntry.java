package com.jctech.commonecommerce.generator;


import com.example.annotations.EntryGenerator;
import com.jctech.lib_core_android.wx.templete.WXEntryTemplete;

/**
 * Created by chenqiao on 2017/4/22
 */

@SuppressWarnings("unused")
@EntryGenerator(
        packageName = "com.jctech.commonecommerce",
        entryTemplete = WXEntryTemplete.class
)
public interface WeChatEntry {
}
