package com.example.androidtest.network;
import android.content.Context;
import android.os.NetworkOnMainThreadException;
import com.example.androidtest.store.SharedPreferenceUtil;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rick on 2018/4/9.
 */

public abstract class HttpCallBack<T> implements Callback<HttpResponse<T>> {
    protected static final int TASK_NONETWORK = -2;//无网络
    private final int RESPONSE_FATAL_EOR = -1; //返回其他错误

    private int errorCode = -1;
    private String errorMsg = "未知的错误！";

    private Context context;
    private int retryTimes = 0;
    private int maxRetryTimes = 1;
    private boolean retryFlag = false;

    public HttpCallBack(Context context, boolean retryFlag)
    {
        this.context = context;
        this.retryFlag = retryFlag;
    }
    //正确回调
    public abstract void onSuccess(T t);
    @Override
    public void onResponse(Call<HttpResponse<T>> call, final Response<HttpResponse<T>> response) {
        if (response.isSuccessful()){
            if (response.body() == null) {
                onFailMessage("获取数据失败",RESPONSE_FATAL_EOR);
                return;
            }
            int code = response.body().getCode();
            if (code != 0) {
                if(code > 0)
                {
                    System.out.println("网络请求失败");
                    return;
                }
                onFailMessage(response.body().getMessage(),RESPONSE_FATAL_EOR);
                return;
            }
            onSuccess(response.body().getData());
        }
        else {
            if(retryTimes < maxRetryTimes && retryFlag)
            {
                retryTimes++;
                retry(call);
            }
            else
                onFailMessage("网络连接超时",RESPONSE_FATAL_EOR);
        }
    }

    //错误回调
    public abstract void onFailMessage(String msg,int code);
    @Override
    public void onFailure(Call<HttpResponse<T>> call, Throwable t) {
        if(retryTimes < maxRetryTimes && retryFlag)
        {
            retryTimes++;
            retry(call);
        }
        else{
            if (t instanceof SocketTimeoutException) {  //VPN open
                errorCode = RESPONSE_FATAL_EOR;
                errorMsg = "服务器响应超时";
            } else if (t instanceof ConnectException) {
                errorCode = TASK_NONETWORK;
                errorMsg = "网络连接异常，请检查网络";
            }else if (t instanceof UnknownHostException) {
                errorCode = RESPONSE_FATAL_EOR;
                errorMsg = "无法解析主机，请检查网络连接";
            } else if (t instanceof UnknownServiceException) {
                errorCode = RESPONSE_FATAL_EOR;
                errorMsg = "未知的服务器错误";
            } else if (t instanceof IOException) {   //飞行模式等
                errorCode = TASK_NONETWORK;
                errorMsg = "没有网络，请检查网络连接";
            } else if (t instanceof NetworkOnMainThreadException) {//主线程不能网络请求，这个很容易发现
                errorCode = RESPONSE_FATAL_EOR;
                errorMsg = "主线程不能网络请求";
                // ... ...
            } else if (t instanceof RuntimeException) { //很多的错误都是extends RuntimeException
                errorCode = RESPONSE_FATAL_EOR;
                errorMsg = "运行时错误";
            }
            onFailMessage(errorMsg,errorCode);
        }
    }



    public void retry(Call<HttpResponse<T>> call)
    {
        call.clone().enqueue(this);
    }
}
