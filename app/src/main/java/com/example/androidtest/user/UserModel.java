package com.example.androidtest.user;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserModel {

    @SerializedName("id")
    private int Id;

    @SerializedName("mid")
    private int Mid;

    @SerializedName("is_main")
    private int IsMain;

    @SerializedName("phone")
    private String Phone;

    @SerializedName("wechat")
    private String Wechat;

    @SerializedName("nick_name")
    private String NickName;

    @SerializedName("name")
    private String Name;

    @SerializedName("avatar")
    private String Avatar;

    @SerializedName("status")
    private int Status;

    @SerializedName("ext_data")
    private String ExtData;

    @SerializedName("create_time")
    private String CreateTime;

    @SerializedName("edit_time")
    private String EditTime;

    @SerializedName("uid")
    private int Uid;

    @SerializedName("roles")
    private List<RoleModel> Roles;

    @SerializedName("easeAcountUser")
    private String EaseAcountUser;

    @SerializedName("easeAcountPass")
    private String EaseAcountPass;

    @SerializedName("push_alias")
    private String PushAlias;

    @SerializedName("accessToken")
    private String AccessToken;

    public UserModel() {
    }

    public UserModel(int id, int mid, int isMain, String phone, String wechat, String nickName, String name, String avatar, int status, String extData, String createTime, String editTime, int uid, List<RoleModel> roles, String easeAcountUser, String easeAcountPass, String pushAlias, String accessToken) {
        Id = id;
        Mid = mid;
        IsMain = isMain;
        Phone = phone;
        Wechat = wechat;
        NickName = nickName;
        Name = name;
        Avatar = avatar;
        Status = status;
        ExtData = extData;
        CreateTime = createTime;
        EditTime = editTime;
        Uid = uid;
        Roles = roles;
        EaseAcountUser = easeAcountUser;
        EaseAcountPass = easeAcountPass;
        PushAlias = pushAlias;
        AccessToken = accessToken;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getMid() {
        return Mid;
    }

    public void setMid(int mid) {
        Mid = mid;
    }

    public int getIsMain() {
        return IsMain;
    }

    public void setIsMain(int isMain) {
        IsMain = isMain;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getWechat() {
        return Wechat;
    }

    public void setWechat(String wechat) {
        Wechat = wechat;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getExtData() {
        return ExtData;
    }

    public void setExtData(String extData) {
        ExtData = extData;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getEditTime() {
        return EditTime;
    }

    public void setEditTime(String editTime) {
        EditTime = editTime;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public List<RoleModel> getRoles() {
        return Roles;
    }

    public void setRoles(List<RoleModel> roles) {
        Roles = roles;
    }

    public String getEaseAcountUser() {
        return EaseAcountUser;
    }

    public void setEaseAcountUser(String easeAcountUser) {
        EaseAcountUser = easeAcountUser;
    }

    public String getEaseAcountPass() {
        return EaseAcountPass;
    }

    public void setEaseAcountPass(String easeAcountPass) {
        EaseAcountPass = easeAcountPass;
    }

    public String getPushAlias() {
        return PushAlias;
    }

    public void setPushAlias(String pushAlias) {
        PushAlias = pushAlias;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "Id=" + Id +
                ", Mid=" + Mid +
                ", IsMain=" + IsMain +
                ", Phone='" + Phone + '\'' +
                ", Wechat='" + Wechat + '\'' +
                ", NickName='" + NickName + '\'' +
                ", Name='" + Name + '\'' +
                ", Avatar='" + Avatar + '\'' +
                ", Status=" + Status +
                ", ExtData='" + ExtData + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", EditTime='" + EditTime + '\'' +
                ", Uid=" + Uid +
                ", Roles=" + Roles +
                ", EaseAcountUser='" + EaseAcountUser + '\'' +
                ", EaseAcountPass='" + EaseAcountPass + '\'' +
                ", PushAlias='" + PushAlias + '\'' +
                ", AccessToken='" + AccessToken + '\'' +
                '}';
    }
}
