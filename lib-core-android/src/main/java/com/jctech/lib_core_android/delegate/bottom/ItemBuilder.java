package com.jctech.lib_core_android.delegate.bottom;

import java.util.LinkedHashMap;

/**
 * @author Created by CHENQIAO on 2018/1/6.
 */

public final class ItemBuilder {

    private final LinkedHashMap<BottomTabBean, BottomItemDelegate> ITEMS = new LinkedHashMap<>();

    static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public final ItemBuilder addItem(BottomTabBean bottomTabBean, BottomItemDelegate bottomItemDelegate) {

        ITEMS.put(bottomTabBean, bottomItemDelegate);
        return this;
    }

    public final ItemBuilder addItem(LinkedHashMap<BottomTabBean, BottomItemDelegate> bottomTabBean) {

        ITEMS.putAll(bottomTabBean);
        return this;
    }

    public final LinkedHashMap<BottomTabBean, BottomItemDelegate> build() {

        return ITEMS;
    }
}
