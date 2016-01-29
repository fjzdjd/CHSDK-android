package com.chehui.jason.app;

import android.app.Application;

/**
 * Created by zzp on 2016/1/22.
 */
public class JasonApplication extends Application {

    public static JasonApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;

    }
}
