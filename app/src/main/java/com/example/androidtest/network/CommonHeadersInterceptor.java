package com.example.androidtest.network;

/**
 * Created by Rick on 2018/4/9.
 */

import android.content.Context;

import com.example.androidtest.store.SharedPreferenceUtil;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Rick on 2017/8/28.
 * 公共的请求头拦截器
 */

public class CommonHeadersInterceptor implements Interceptor {
    Context context;
    public CommonHeadersInterceptor(Context context) {
        this.context=context;

    }
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("User-Agent", "android/5.1");
        builder.addHeader("Cache-Control", "max-age=0");
        builder.addHeader("Upgrade-Insecure-Requests", "1");
        builder.addHeader("X-Requested-With", "XMLHttpRequest");
        builder.addHeader("userToken", (String)SharedPreferenceUtil.get(context, NetworkConstant.SP_TOKEN,""));
        builder.addHeader("udid", (String) SharedPreferenceUtil.get(context,NetworkConstant.SP_UDID,""));
        builder.addHeader("Content-Type", "application/json;charset=utf-8");
        builder.addHeader("Accept", "application/json");
        return chain.proceed(builder.build());
    }
}
