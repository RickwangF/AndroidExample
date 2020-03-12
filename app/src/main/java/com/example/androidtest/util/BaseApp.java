package com.example.androidtest.util;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

public class BaseApp extends Application {

    //以下属性应用于整个应用程序，合理利用资源，减少资源浪费
    private static Context mContext;//上下文

    @Override
    public void onCreate() {
        super.onCreate();
        //对全局属性赋值
        mContext = getApplicationContext();
    }

    /**
     * 重启当前应用
     */
    public static void restart() {
        Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mContext.startActivity(intent);
    }

    public static Context getContext() {
        return mContext;
    }

    public static void setContext(Context mContext) {
        BaseApp.mContext = mContext;
    }


}
