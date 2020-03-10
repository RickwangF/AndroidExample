package com.example.androidtest.network;

import android.content.Context;
import com.example.androidtest.util.BaseApp;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rick on 2018/4/9.
 */

public class CommonHttpService {
    private static Context context = BaseApp.getContext();

    private static final int DEFAULT_TIME_OUT = 3;//超时时间 3s
    private static final int DEFAULT_READ_TIME_OUT = 10;
    private Retrofit mRetrofit = null;
    private static CommonHttpService mCommonHttpService;



    private CommonHttpService() {
        // 创建 OKHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间
        builder.writeTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//写操作 超时时间
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//读操作超时时间
        // 公共的请求头拦截器
        builder.addInterceptor(new CommonHeadersInterceptor(context));
        // 添加log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);
        // 添加公共参数拦截器
        // builder.addInterceptor(new CommonParamsInterceptor(context));
        //缓存拦截器
        //builder.addNetworkInterceptor(new CacheControlInterceptor(context));
        // 创建配置过的gson对象
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE);
        gsonBuilder.serializeNulls();
        Gson gson = gsonBuilder.create();

        // 创建Retrofit
        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(NetworkConstant.BASE_URL)
                .build();
    }

    private static class SingletonHolder {
        private static final CommonHttpService INSTANCE = new CommonHttpService();
    }

    /**
     * 获取RetrofitServiceManager
     *
     * @return
     */
    public static CommonHttpService getInstance() {
        mCommonHttpService=new CommonHttpService();
        return mCommonHttpService;
    }

    /**
     * 获取对应的Service
     *
     * @param service Service 的 class
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }
}
