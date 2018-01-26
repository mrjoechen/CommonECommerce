package com.jctech.lib_ec_android.main;

import com.jctech.lib_core_android.delegate.bottom.BaseBottomDelegate;
import com.jctech.lib_core_android.delegate.bottom.BottomItemDelegate;
import com.jctech.lib_core_android.delegate.bottom.BottomTabBean;
import com.jctech.lib_core_android.delegate.bottom.ItemBuilder;
import com.jctech.lib_ec_android.main.index.IndexDelegate;

import java.util.LinkedHashMap;

/**
 * Created by CHENQIAO on 2018/1/26.
 */

public class EcBottomDelegate extends BaseBottomDelegate{
    @Override
    public Object setLayout() {
        return null;
    }

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder itemBuilder) {

        final  LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();

        items.put(new BottomTabBean("", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("", "分类"), new IndexDelegate());
        items.put(new BottomTabBean("", "发现"), new IndexDelegate());
        items.put(new BottomTabBean("", "购物车"), new IndexDelegate());
        items.put(new BottomTabBean("", "我的"), new IndexDelegate());


        return items;
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return 0;
    }
}
