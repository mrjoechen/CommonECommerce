package com.jctech.lib_core_android.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.jctech.lib_core_android.app.EC;

/**
 * Created by CHENQIAO on 2017/11/23.
 */

public class DimenUtil {

    public static int getScreenWidth(){
        final Resources resources = EC.getApplication().getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight(){
        final Resources resources = EC.getApplication().getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.heightPixels;
    }
}
