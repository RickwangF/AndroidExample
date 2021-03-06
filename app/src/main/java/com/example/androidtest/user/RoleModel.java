package com.example.androidtest.user;

import com.google.gson.annotations.SerializedName;

public class RoleModel {

    @SerializedName("id")
    private int Id;

    @SerializedName("business_type_id")
    private int BusinessTypeId;

    @SerializedName("name")
    private String Name;

    @SerializedName("sign")
    private String Sign;

    @SerializedName("remarks")
    private String Remarks;

    @SerializedName("sortby")
    private int SortBy;

    @SerializedName("status")
    private int Status;

    @SerializedName("template")
    private String Template;

    @SerializedName("create_time")
    private String CreateTime;

    @SerializedName("end_time")
    private String EditTime;

    public RoleModel() {

    }

    public RoleModel(int id, int businessTypeId, String name, String sign, String remarks, int sortBy, int status, String template, String createTime, String editTime) {
        Id = id;
        BusinessTypeId = businessTypeId;
        Name = name;
        Sign = sign;
        Remarks = remarks;
        SortBy = sortBy;
        Status = status;
        Template = template;
        CreateTime = createTime;
        EditTime = editTime;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getBusinessTypeId() {
        return BusinessTypeId;
    }

    public void setBusinessTypeId(int businessTypeId) {
        BusinessTypeId = businessTypeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSign() {
        return Sign;
    }

    public void setSign(String sign) {
        Sign = sign;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public int getSortBy() {
        return SortBy;
    }

    public void setSortBy(int sortBy) {
        SortBy = sortBy;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getTemplate() {
        return Template;
    }

    public void setTemplate(String template) {
        Template = template;
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

    @Override
    public String toString() {
        return "RoleModel{" +
                "Id=" + Id +
                ", BusinessTypeId=" + BusinessTypeId +
                ", Name='" + Name + '\'' +
                ", Sign='" + Sign + '\'' +
                ", Remarks='" + Remarks + '\'' +
                ", SortBy=" + SortBy +
                ", Status=" + Status +
                ", Template='" + Template + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", EditTime='" + EditTime + '\'' +
                '}';
    }
}
