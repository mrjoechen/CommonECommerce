package com.jctech.lib_core_android.util;

import java.util.TimerTask;

/**
 * Created by CHENQIAO on 2017/12/4.
 */

public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener timerListener) {
        this.mITimerListener = timerListener;
    }

    @Override
    public void run() {
        if (mITimerListener != null) {
            mITimerListener.onTimer();
        }
    }

    public interface ITimerListener {
        void onTimer();
    }
}
