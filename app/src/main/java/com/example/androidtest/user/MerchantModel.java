package com.example.androidtest.user;

public class MerchantModel {

    private int Id;

    private int Uid;

    private int AccountUid;

    private String Source;

    private int type;

    private int AccountStatus;

    private String Accid;

    private int Assistant;

    private int Bond;

    private double BondBalance;

    private int Category;

    private String RealName;

    private String CompanyName;

    private String Idcard;

    private String Mobile;

    private String Wechat;

    private String Name;

    private String Cover;

    private String Avatar;

    private String Introduction;

    private String Remarks;

    private int Template;

    private int Status;

    private String CreateTime;

    private String EditTime;

    private String ExtData;

    private int OldMerid;

    private int UserUpgrade;

    private int LiveGoods;

    private int LiveDiscern;

    private int Video;

    private int Auction;

    private int Ordinary;

    private int Fixed;

    private int NewMerchant;

    public MerchantModel() {
    }

    public MerchantModel(int id, int uid, int accountUid, String source, int type, int accountStatus, String accid, int assistant, int bond, double bondBalance, int category, String realName, String companyName, String idcard, String mobile, String wechat, String name, String cover, String avatar, String introduction, String remarks, int template, int status, String createTime, String editTime, String extData, int oldMerid, int userUpgrade, int liveGoods, int liveDiscern, int video, int auction, int ordinary, int fixed, int newMerchant) {
        Id = id;
        Uid = uid;
        AccountUid = accountUid;
        Source = source;
        this.type = type;
        AccountStatus = accountStatus;
        Accid = accid;
        Assistant = assistant;
        Bond = bond;
        BondBalance = bondBalance;
        Category = category;
        RealName = realName;
        CompanyName = companyName;
        Idcard = idcard;
        Mobile = mobile;
        Wechat = wechat;
        Name = name;
        Cover = cover;
        Avatar = avatar;
        Introduction = introduction;
        Remarks = remarks;
        Template = template;
        Status = status;
        CreateTime = createTime;
        EditTime = editTime;
        ExtData = extData;
        OldMerid = oldMerid;
        UserUpgrade = userUpgrade;
        LiveGoods = liveGoods;
        LiveDiscern = liveDiscern;
        Video = video;
        Auction = auction;
        Ordinary = ordinary;
        Fixed = fixed;
        NewMerchant = newMerchant;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public int getAccountUid() {
        return AccountUid;
    }

    public void setAccountUid(int accountUid) {
        AccountUid = accountUid;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        AccountStatus = accountStatus;
    }

    public String getAccid() {
        return Accid;
    }

    public void setAccid(String accid) {
        Accid = accid;
    }

    public int getAssistant() {
        return Assistant;
    }

    public void setAssistant(int assistant) {
        Assistant = assistant;
    }

    public int getBond() {
        return Bond;
    }

    public void setBond(int bond) {
        Bond = bond;
    }

    public double getBondBalance() {
        return BondBalance;
    }

    public void setBondBalance(double bondBalance) {
        BondBalance = bondBalance;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int category) {
        Category = category;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String realName) {
        RealName = realName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getIdcard() {
        return Idcard;
    }

    public void setIdcard(String idcard) {
        Idcard = idcard;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getWechat() {
        return Wechat;
    }

    public void setWechat(String wechat) {
        Wechat = wechat;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCover() {
        return Cover;
    }

    public void setCover(String cover) {
        Cover = cover;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public int getTemplate() {
        return Template;
    }

    public void setTemplate(int template) {
        Template = template;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
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

    public String getExtData() {
        return ExtData;
    }

    public void setExtData(String extData) {
        ExtData = extData;
    }

    public int getOldMerid() {
        return OldMerid;
    }

    public void setOldMerid(int oldMerid) {
        OldMerid = oldMerid;
    }

    public int getUserUpgrade() {
        return UserUpgrade;
    }

    public void setUserUpgrade(int userUpgrade) {
        UserUpgrade = userUpgrade;
    }

    public int getLiveGoods() {
        return LiveGoods;
    }

    public void setLiveGoods(int liveGoods) {
        LiveGoods = liveGoods;
    }

    public int getLiveDiscern() {
        return LiveDiscern;
    }

    public void setLiveDiscern(int liveDiscern) {
        LiveDiscern = liveDiscern;
    }

    public int getVideo() {
        return Video;
    }

    public void setVideo(int video) {
        Video = video;
    }

    public int getAuction() {
        return Auction;
    }

    public void setAuction(int auction) {
        Auction = auction;
    }

    public int getOrdinary() {
        return Ordinary;
    }

    public void setOrdinary(int ordinary) {
        Ordinary = ordinary;
    }

    public int getFixed() {
        return Fixed;
    }

    public void setFixed(int fixed) {
        Fixed = fixed;
    }

    public int getNewMerchant() {
        return NewMerchant;
    }

    public void setNewMerchant(int newMerchant) {
        NewMerchant = newMerchant;
    }

    @Override
    public String toString() {
        return "MerchantModel{" +
                "Id=" + Id +
                ", Uid=" + Uid +
                ", AccountUid=" + AccountUid +
                ", Source='" + Source + '\'' +
                ", type=" + type +
                ", AccountStatus=" + AccountStatus +
                ", Accid='" + Accid + '\'' +
                ", Assistant=" + Assistant +
                ", Bond=" + Bond +
                ", BondBalance=" + BondBalance +
                ", Category=" + Category +
                ", RealName='" + RealName + '\'' +
                ", CompanyName='" + CompanyName + '\'' +
                ", Idcard='" + Idcard + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", Wechat='" + Wechat + '\'' +
                ", Name='" + Name + '\'' +
                ", Cover='" + Cover + '\'' +
                ", Avatar='" + Avatar + '\'' +
                ", Introduction='" + Introduction + '\'' +
                ", Remarks='" + Remarks + '\'' +
                ", Template=" + Template +
                ", Status=" + Status +
                ", CreateTime='" + CreateTime + '\'' +
                ", EditTime='" + EditTime + '\'' +
                ", ExtData='" + ExtData + '\'' +
                ", OldMerid=" + OldMerid +
                ", UserUpgrade=" + UserUpgrade +
                ", LiveGoods=" + LiveGoods +
                ", LiveDiscern=" + LiveDiscern +
                ", Video=" + Video +
                ", Auction=" + Auction +
                ", Ordinary=" + Ordinary +
                ", Fixed=" + Fixed +
                ", NewMerchant=" + NewMerchant +
                '}';
    }
}
