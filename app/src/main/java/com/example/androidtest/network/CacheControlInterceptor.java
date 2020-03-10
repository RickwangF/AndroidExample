package com.example.androidtest.network;

import android.content.Context;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import com.example.androidtest.network.NetworkStatus;

/**
 * Created by Rick on 2018/4/9.
 * 缓存拦截器
 */

public class CacheControlInterceptor implements Interceptor {

    private Context context;

    public CacheControlInterceptor(Context context)
    {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        //（修改请求）没有网络的时候强制访问缓存
        if(!NetworkStatus.isConnected(context))
        {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .removeHeader("Pragma")
                    .build();
        }

        Response responseOrignal = chain.proceed(request);

        //（修改响应）有网络连接的时候读取每个接口上的缓存设置，未设置的不使用缓存
        if(NetworkStatus.isConnected(context))
        {
            String cacheControl = request.cacheControl().toString();

            return responseOrignal.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control",cacheControl)
                    .build();
        }
        else {//无网络时，使用一天内的缓存
            return  responseOrignal.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control","public, only-if-cached, max-stale=86400")
                    .build();
        }
    }
}