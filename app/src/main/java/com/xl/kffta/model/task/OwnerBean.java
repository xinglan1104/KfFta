package com.xl.kffta.model.task;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhanghaochen
 * Date: 2020/6/17
 * 描述：
 */
public class OwnerBean implements Serializable {
    private String Desc;
    private String RealName;
    private String AccountCode;
    private String Password;
    private String Email;
    private String MobilePhone;
    private int Status;
    private int UserType;
    private String AdditionInfo;
    private int UpperAccountID;
    private boolean ResetPassOnNextLogin;
    private String LastActivityTime;
    private boolean WorkflowPrivilegeMode;
    private int ThemeID;
    private boolean IgnoreLangTranslation;
    private int RoundDecimal;
    private int CurrencyRoundDecimal;
    private int CurrencySumRoundDecimal;
    private int RateRoundDecimal;
    private int CurrencyComparisonRoundDecimal;
    private int ComparisonRoundDecimal;
    private boolean IsOwner;
    private int PageCode;
    private int CreatorID;
    private String CreateTime;
    private int LastModifyByID;
    private String Timestamp;
    private String CheckReleaseNoteDate;
    private boolean IsChannelManager;
    private int ID;
    private String UserName;
    private String DisplayName;
    private int CompanyID;
    private String Lang;
    private boolean InvisibleMode;
    private List<Integer> ParentPath;
    private List<Long> RoleIDs;
    private List<Integer> DepartmentIDs;

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String RealName) {
        this.RealName = RealName;
    }

    public String getAccountCode() {
        return AccountCode;
    }

    public void setAccountCode(String AccountCode) {
        this.AccountCode = AccountCode;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMobilePhone() {
        return MobilePhone;
    }

    public void setMobilePhone(String MobilePhone) {
        this.MobilePhone = MobilePhone;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getUserType() {
        return UserType;
    }

    public void setUserType(int UserType) {
        this.UserType = UserType;
    }


    public String getAdditionInfo() {
        return AdditionInfo;
    }

    public void setAdditionInfo(String AdditionInfo) {
        this.AdditionInfo = AdditionInfo;
    }

    public int getUpperAccountID() {
        return UpperAccountID;
    }

    public void setUpperAccountID(int UpperAccountID) {
        this.UpperAccountID = UpperAccountID;
    }

    public boolean isResetPassOnNextLogin() {
        return ResetPassOnNextLogin;
    }

    public void setResetPassOnNextLogin(boolean ResetPassOnNextLogin) {
        this.ResetPassOnNextLogin = ResetPassOnNextLogin;
    }

    public String getLastActivityTime() {
        return LastActivityTime;
    }

    public void setLastActivityTime(String LastActivityTime) {
        this.LastActivityTime = LastActivityTime;
    }

    public boolean isWorkflowPrivilegeMode() {
        return WorkflowPrivilegeMode;
    }

    public void setWorkflowPrivilegeMode(boolean WorkflowPrivilegeMode) {
        this.WorkflowPrivilegeMode = WorkflowPrivilegeMode;
    }

    public int getThemeID() {
        return ThemeID;
    }

    public void setThemeID(int ThemeID) {
        this.ThemeID = ThemeID;
    }

    public boolean isIgnoreLangTranslation() {
        return IgnoreLangTranslation;
    }

    public void setIgnoreLangTranslation(boolean IgnoreLangTranslation) {
        this.IgnoreLangTranslation = IgnoreLangTranslation;
    }

    public int getRoundDecimal() {
        return RoundDecimal;
    }

    public void setRoundDecimal(int RoundDecimal) {
        this.RoundDecimal = RoundDecimal;
    }

    public int getCurrencyRoundDecimal() {
        return CurrencyRoundDecimal;
    }

    public void setCurrencyRoundDecimal(int CurrencyRoundDecimal) {
        this.CurrencyRoundDecimal = CurrencyRoundDecimal;
    }

    public int getCurrencySumRoundDecimal() {
        return CurrencySumRoundDecimal;
    }

    public void setCurrencySumRoundDecimal(int CurrencySumRoundDecimal) {
        this.CurrencySumRoundDecimal = CurrencySumRoundDecimal;
    }

    public int getRateRoundDecimal() {
        return RateRoundDecimal;
    }

    public void setRateRoundDecimal(int RateRoundDecimal) {
        this.RateRoundDecimal = RateRoundDecimal;
    }

    public int getCurrencyComparisonRoundDecimal() {
        return CurrencyComparisonRoundDecimal;
    }

    public void setCurrencyComparisonRoundDecimal(int CurrencyComparisonRoundDecimal) {
        this.CurrencyComparisonRoundDecimal = CurrencyComparisonRoundDecimal;
    }

    public int getComparisonRoundDecimal() {
        return ComparisonRoundDecimal;
    }

    public void setComparisonRoundDecimal(int ComparisonRoundDecimal) {
        this.ComparisonRoundDecimal = ComparisonRoundDecimal;
    }

    public boolean isIsOwner() {
        return IsOwner;
    }

    public void setIsOwner(boolean IsOwner) {
        this.IsOwner = IsOwner;
    }

    public int getPageCode() {
        return PageCode;
    }

    public void setPageCode(int PageCode) {
        this.PageCode = PageCode;
    }

    public int getCreatorID() {
        return CreatorID;
    }

    public void setCreatorID(int CreatorID) {
        this.CreatorID = CreatorID;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public int getLastModifyByID() {
        return LastModifyByID;
    }

    public void setLastModifyByID(int LastModifyByID) {
        this.LastModifyByID = LastModifyByID;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String Timestamp) {
        this.Timestamp = Timestamp;
    }

    public String getCheckReleaseNoteDate() {
        return CheckReleaseNoteDate;
    }

    public void setCheckReleaseNoteDate(String CheckReleaseNoteDate) {
        this.CheckReleaseNoteDate = CheckReleaseNoteDate;
    }

    public boolean isIsChannelManager() {
        return IsChannelManager;
    }

    public void setIsChannelManager(boolean IsChannelManager) {
        this.IsChannelManager = IsChannelManager;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String DisplayName) {
        this.DisplayName = DisplayName;
    }

    public int getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(int CompanyID) {
        this.CompanyID = CompanyID;
    }

    public String getLang() {
        return Lang;
    }

    public void setLang(String Lang) {
        this.Lang = Lang;
    }

    public boolean isInvisibleMode() {
        return InvisibleMode;
    }

    public void setInvisibleMode(boolean InvisibleMode) {
        this.InvisibleMode = InvisibleMode;
    }

    public List<Integer> getParentPath() {
        return ParentPath;
    }

    public void setParentPath(List<Integer> ParentPath) {
        this.ParentPath = ParentPath;
    }

    public List<Long> getRoleIDs() {
        return RoleIDs;
    }

    public void setRoleIDs(List<Long> RoleIDs) {
        this.RoleIDs = RoleIDs;
    }

    public List<Integer> getDepartmentIDs() {
        return DepartmentIDs;
    }

    public void setDepartmentIDs(List<Integer> DepartmentIDs) {
        this.DepartmentIDs = DepartmentIDs;
    }
}
