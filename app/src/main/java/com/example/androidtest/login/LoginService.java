package com.example.androidtest.login;

import com.example.androidtest.network.HttpResponse;
import com.example.androidtest.user.LoginModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {
    @FormUrlEncoded
    @POST("/v1/login/phoneLogin")
    Call<HttpResponse<LoginModel>> phoneLogin(@Field("phone") String phone, @Field("code") String code, @Field("area_code") String areaCode);
}
