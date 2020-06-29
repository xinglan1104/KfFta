package com.xl.kffta.model;

import com.xl.kffta.model.common.DepartmentBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author created by zhanghaochen
 * @date 2020-05-18 14:59
 * 描述：
 */
public class UserInfoBean implements Serializable {

    private String Token;
    private UserBean User;
    private int BaseUtcOffsetTotalSeconds;
    private String CompanyName;
    private String Error;
    private int ErrorCode;

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public UserBean getUser() {
        return User;
    }

    public void setUser(UserBean User) {
        this.User = User;
    }

    public int getBaseUtcOffsetTotalSeconds() {
        return BaseUtcOffsetTotalSeconds;
    }

    public void setBaseUtcOffsetTotalSeconds(int BaseUtcOffsetTotalSeconds) {
        this.BaseUtcOffsetTotalSeconds = BaseUtcOffsetTotalSeconds;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public static class UserBean {

        private String Password;
        private String Email;
        private String MobilePhone;
        private int Status;
        private int UserType;
        private Object Level;
        private Object Files;
        private String DF10;
        private String AdditionInfo;
        private int UpperAccountID;
        private boolean ResetPassOnNextLogin;
        private boolean WorkflowPrivilegeMode;
        private int ThemeID;
        private Object InitPassword;
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
        private long ID;
        private String UserName;
        private String DisplayName;
        private int CompanyID;
        private String Lang;
        private String TimezoneStr;
        private String Timezone;
        private boolean InvisibleMode;
        private List<Integer> ParentPath;
        private List<Integer> RoleIDs;
        private List<RoleBean> Role;
        private List<Integer> DepartmentIDs;
        private List<DepartmentBean> Department;
        private List<SessionInfoBean> SessionInfo;

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

        public Object getLevel() {
            return Level;
        }

        public void setLevel(Object Level) {
            this.Level = Level;
        }

        public Object getFiles() {
            return Files;
        }

        public void setFiles(Object Files) {
            this.Files = Files;
        }

        public String getDF10() {
            return DF10;
        }

        public void setDF10(String DF10) {
            this.DF10 = DF10;
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

        public Object getInitPassword() {
            return InitPassword;
        }

        public void setInitPassword(Object InitPassword) {
            this.InitPassword = InitPassword;
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

        public long getID() {
            return ID;
        }

        public void setID(long ID) {
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

        public String getTimezoneStr() {
            return TimezoneStr;
        }

        public void setTimezoneStr(String TimezoneStr) {
            this.TimezoneStr = TimezoneStr;
        }

        public String getTimezone() {
            return Timezone;
        }

        public void setTimezone(String Timezone) {
            this.Timezone = Timezone;
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

        public List<Integer> getRoleIDs() {
            return RoleIDs;
        }

        public void setRoleIDs(List<Integer> RoleIDs) {
            this.RoleIDs = RoleIDs;
        }

        public List<RoleBean> getRole() {
            return Role;
        }

        public void setRole(List<RoleBean> Role) {
            this.Role = Role;
        }

        public List<Integer> getDepartmentIDs() {
            return DepartmentIDs;
        }

        public void setDepartmentIDs(List<Integer> DepartmentIDs) {
            this.DepartmentIDs = DepartmentIDs;
        }

        public List<DepartmentBean> getDepartment() {
            return Department;
        }

        public void setDepartment(List<DepartmentBean> Department) {
            this.Department = Department;
        }

        public List<SessionInfoBean> getSessionInfo() {
            return SessionInfo;
        }

        public void setSessionInfo(List<SessionInfoBean> SessionInfo) {
            this.SessionInfo = SessionInfo;
        }

        public static class RoleBean {
            private int ID;
            private int CompanyID;
            private String Name;
            private int Status;
            private int LastModifyByID;
            private String Timestamp;
            private int PageCode;
            private int CreatorID;
            private String CreateTime;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public int getCompanyID() {
                return CompanyID;
            }

            public void setCompanyID(int CompanyID) {
                this.CompanyID = CompanyID;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
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
        }

        public static class SessionInfoBean {
            /**
             * Key : 52wlshvpn0yq52ihmwmtbkgd
             * Value : 61.177.128.130
             * ValuePage :
             * Direction : 0
             * ExtraInfo : null
             * InnerReference : null
             */

            private String Key;
            private String Value;
            private String ValuePage;
            private int Direction;
            private Object ExtraInfo;
            private Object InnerReference;

            public String getKey() {
                return Key;
            }

            public void setKey(String Key) {
                this.Key = Key;
            }

            public String getValue() {
                return Value;
            }

            public void setValue(String Value) {
                this.Value = Value;
            }

            public String getValuePage() {
                return ValuePage;
            }

            public void setValuePage(String ValuePage) {
                this.ValuePage = ValuePage;
            }

            public int getDirection() {
                return Direction;
            }

            public void setDirection(int Direction) {
                this.Direction = Direction;
            }

            public Object getExtraInfo() {
                return ExtraInfo;
            }

            public void setExtraInfo(Object ExtraInfo) {
                this.ExtraInfo = ExtraInfo;
            }

            public Object getInnerReference() {
                return InnerReference;
            }

            public void setInnerReference(Object InnerReference) {
                this.InnerReference = InnerReference;
            }
        }
    }
}
