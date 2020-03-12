package com.example.androidtest.user;
import com.google.gson.annotations.SerializedName;

public class LoginModel {

    @SerializedName("account")
    private UserModel Account;

    @SerializedName("merchant")
    private MerchantModel Merchant;

}
