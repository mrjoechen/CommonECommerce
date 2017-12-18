package com.jctech.lib_core_android.ui.loader;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.jctech.lib_core_android.R;
import com.jctech.lib_core_android.util.DimenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * Created by CHENQIAO on 2017/11/23.
 */

public class ECLoader {


    private static final int LOADER_SICE_SCALE = 8;
    private static final int LOADER_OFFSET_SCALE = 10;

    private static final ArrayList<AppCompatDialog> loaders = new ArrayList<>();

    private static final String DEFAULT_LOADER = LoaderStyle.BallClipRotatePulseIndicator.name();

    public static void showLoading(Context context, Enum<LoaderStyle> type) {

        showLoading(context, type.name());
    }

    public static void showLoading(Context context, String type) {

        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);

        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type, context);
        dialog.setContentView(avLoadingIndicatorView);

        int screenWidth = DimenUtil.getScreenWidth();
        int screenHeight = DimenUtil.getScreenHeight();

        final Window window = dialog.getWindow();

        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();

            attributes.width = screenWidth / LOADER_SICE_SCALE;
            attributes.height = screenHeight / LOADER_SICE_SCALE;
            attributes.height = attributes.height + screenHeight / LOADER_OFFSET_SCALE;
            attributes.gravity = Gravity.CENTER;
        }
        loaders.add(dialog);
        dialog.show();
    }

    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADER);
    }

    public static void stopLoading() {
        for (AppCompatDialog dialog : loaders) {
            if (dialog != null) {
                if (dialog.isShowing()) {
                    dialog.cancel();
                }
            }
        }
    }

}
