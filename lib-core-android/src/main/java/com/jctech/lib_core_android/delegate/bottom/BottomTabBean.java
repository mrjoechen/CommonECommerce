package com.jctech.lib_core_android.delegate.bottom;

/**
 * Created by CHENQIAO on 2018/1/6.
 */

public class BottomTabBean {

    private final CharSequence ICON;
    private final CharSequence NAME;

    public BottomTabBean(CharSequence ICON, CharSequence NAME) {
        this.ICON = ICON;
        this.NAME = NAME;
    }

    public CharSequence getNAME() {
        return NAME;
    }

    public CharSequence getICON() {
        return ICON;
    }
}
