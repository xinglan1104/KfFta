package com.xl.kffta.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author created by zhanghaochen
 * @date 2020-05-18 14:59
 * 描述：
 */
public class UserInfoBean implements Serializable {

    /**
     * Token : 10423@4578@MH5xmOlP2nuAmq3hVZkyjPr/q4vGQqmQYD49DFkPNiF9fH1U363yobpqazZsbrnS
     * User : {"Desc":null,"RealName":null,"AccountCode":null,"Password":"96e79218965eb72c92a549dd5a330112","Email":"76834423@qq.com","MobilePhone":null,"Status":0,"UserType":0,"Level":null,"Files":null,"R1":null,"R2":null,"DF1":null,"DF2":null,"DF3":null,"DF4":null,"DF5":null,"DF6":null,"DF7":null,"DF8":null,"DF9":null,"DF10":"6643443","AdditionInfo":null,"UpperAccountID":0,"UpperAccount":null,"ResetPassOnNextLogin":false,"ParentPath":[0,10423],"RoleIDs":[982],"Role":[{"ID":982,"CompanyID":4578,"Name":"admin","Desc":null,"Status":1,"Operations":[],"LastModifyByID":-1,"Timestamp":"/Date(1587370700796)/","PageCode":0,"CreatorID":-1,"CreateTime":"/Date(1587370700796)/","AdditionInfo":null,"DF1":null,"DF2":null,"DF3":null,"DF4":null,"DF5":null,"DF6":null,"DF7":null,"DF8":null,"DF9":null,"DF10":null}],"Operation":null,"ModuleIDs":null,"DepartmentIDs":[903],"Department":[{"ID":903,"CompanyID":4578,"Name":"Admin","DepartmentCode":"admin","ParentID":0,"Parent":null,"ParentPath":[0,903],"Status":1,"OrganizationType":0,"LastModifyByID":10423,"Timestamp":"/Date(1588918252470)/","Labels":[],"DepartmentManagerIDs":[],"DepartmentManager":[],"ColorCode":null,"PageCode":0,"BusinessAreaIDs":[1430],"BusinessArea":[],"CreatorID":-1,"CreateTime":"/Date(1587370697568)/","AdditionInfo":null,"DF1":"刘强","DF2":null,"DF3":null,"DF4":null,"DF5":null,"DF6":null,"DF7":null,"DF8":null,"DF9":null,"DF10":null}],"GroupIDs":[],"Group":[],"LabelIDs":[],"SessionInfo":[{"Key":"cx23vtds0bsz1z5aox5cag1r","Value":"222.67.12.195","ValuePage":"","Direction":0,"ExtraInfo":null,"InnerReference":null}],"LastActivityTime":"/Date(1589797810016)/","Delegator":null,"ChannelAdmin":null,"UploadFileFolder":null,"TempUploadFileFolder":null,"WorkflowPrivilegeMode":false,"ThemeID":0,"InitPassword":null,"IgnoreLangTranslation":false,"RoundDecimal":2,"CurrencyRoundDecimal":2,"CurrencySumRoundDecimal":2,"RateRoundDecimal":5,"CurrencyComparisonRoundDecimal":2,"ComparisonRoundDecimal":2,"IsOwner":true,"PageCode":0,"CreatorID":-1,"CreateTime":"/Date(1587370703644)/","LastModifyByID":-1,"Timestamp":"/Date(1589797846852)/","CheckReleaseNoteDate":"/Date(1588089600000)/","IsChannelManager":false,"ID":10423,"UserName":"admin","DisplayName":"admin","CompanyID":4578,"Representative":null,"Lang":"zh-CN","TimezoneStr":null,"Timezone":{"Id":null,"DisplayName":"","StandardName":"","DaylightName":"","BaseUtcOffset":"PT0S","SupportsDaylightSavingTime":false},"InvisibleMode":false,"CurrentProductTemplateInfo":null}
     * BindType : null
     * BindInfo : null
     * CompanyName : kaifeng
     * Error : null
     * ErrorCode : 0
     * ResponseStatus : null
     * EncryptionData : null
     * AESEncryptionKey : null
     */

    private String Token;
    private UserBean User;
    private String BindType;
    private String BindInfo;
    private String CompanyName;
    private String Error;
    private int ErrorCode;
    private String ResponseStatus;
    private String EncryptionData;
    private String AESEncryptionKey;

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

    public String getBindType() {
        return BindType;
    }

    public void setBindType(String BindType) {
        this.BindType = BindType;
    }

    public String getBindInfo() {
        return BindInfo;
    }

    public void setBindInfo(String BindInfo) {
        this.BindInfo = BindInfo;
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

    public String getResponseStatus() {
        return ResponseStatus;
    }

    public void setResponseStatus(String ResponseStatus) {
        this.ResponseStatus = ResponseStatus;
    }

    public String getEncryptionData() {
        return EncryptionData;
    }

    public void setEncryptionData(String EncryptionData) {
        this.EncryptionData = EncryptionData;
    }

    public String getAESEncryptionKey() {
        return AESEncryptionKey;
    }

    public void setAESEncryptionKey(String AESEncryptionKey) {
        this.AESEncryptionKey = AESEncryptionKey;
    }

    public static class UserBean {
        /**
         * Desc : null
         * RealName : null
         * AccountCode : null
         * Password : 96e79218965eb72c92a549dd5a330112
         * Email : 76834423@qq.com
         * MobilePhone : null
         * Status : 0
         * UserType : 0
         * Level : null
         * Files : null
         * R1 : null
         * R2 : null
         * DF1 : null
         * DF2 : null
         * DF3 : null
         * DF4 : null
         * DF5 : null
         * DF6 : null
         * DF7 : null
         * DF8 : null
         * DF9 : null
         * DF10 : 6643443
         * AdditionInfo : null
         * UpperAccountID : 0
         * UpperAccount : null
         * ResetPassOnNextLogin : false
         * ParentPath : [0,10423]
         * RoleIDs : [982]
         * Role : [{"ID":982,"CompanyID":4578,"Name":"admin","Desc":null,"Status":1,"Operations":[],"LastModifyByID":-1,"Timestamp":"/Date(1587370700796)/","PageCode":0,"CreatorID":-1,"CreateTime":"/Date(1587370700796)/","AdditionInfo":null,"DF1":null,"DF2":null,"DF3":null,"DF4":null,"DF5":null,"DF6":null,"DF7":null,"DF8":null,"DF9":null,"DF10":null}]
         * Operation : null
         * ModuleIDs : null
         * DepartmentIDs : [903]
         * Department : [{"ID":903,"CompanyID":4578,"Name":"Admin","DepartmentCode":"admin","ParentID":0,"Parent":null,"ParentPath":[0,903],"Status":1,"OrganizationType":0,"LastModifyByID":10423,"Timestamp":"/Date(1588918252470)/","Labels":[],"DepartmentManagerIDs":[],"DepartmentManager":[],"ColorCode":null,"PageCode":0,"BusinessAreaIDs":[1430],"BusinessArea":[],"CreatorID":-1,"CreateTime":"/Date(1587370697568)/","AdditionInfo":null,"DF1":"刘强","DF2":null,"DF3":null,"DF4":null,"DF5":null,"DF6":null,"DF7":null,"DF8":null,"DF9":null,"DF10":null}]
         * GroupIDs : []
         * Group : []
         * LabelIDs : []
         * SessionInfo : [{"Key":"cx23vtds0bsz1z5aox5cag1r","Value":"222.67.12.195","ValuePage":"","Direction":0,"ExtraInfo":null,"InnerReference":null}]
         * LastActivityTime : /Date(1589797810016)/
         * Delegator : null
         * ChannelAdmin : null
         * UploadFileFolder : null
         * TempUploadFileFolder : null
         * WorkflowPrivilegeMode : false
         * ThemeID : 0
         * InitPassword : null
         * IgnoreLangTranslation : false
         * RoundDecimal : 2
         * CurrencyRoundDecimal : 2
         * CurrencySumRoundDecimal : 2
         * RateRoundDecimal : 5
         * CurrencyComparisonRoundDecimal : 2
         * ComparisonRoundDecimal : 2
         * IsOwner : true
         * PageCode : 0
         * CreatorID : -1
         * CreateTime : /Date(1587370703644)/
         * LastModifyByID : -1
         * Timestamp : /Date(1589797846852)/
         * CheckReleaseNoteDate : /Date(1588089600000)/
         * IsChannelManager : false
         * ID : 10423
         * UserName : admin
         * DisplayName : admin
         * CompanyID : 4578
         * Representative : null
         * Lang : zh-CN
         * TimezoneStr : null
         * Timezone : {"Id":null,"DisplayName":"","StandardName":"","DaylightName":"","BaseUtcOffset":"PT0S","SupportsDaylightSavingTime":false}
         * InvisibleMode : false
         * CurrentProductTemplateInfo : null
         */

        private String Desc;
        private String RealName;
        private String AccountCode;
        private String Password;
        private String Email;
        private String MobilePhone;
        private int Status;
        private int UserType;
        private String Level;
        private String Files;
        private String R1;
        private String R2;
        private String DF1;
        private String DF2;
        private String DF3;
        private String DF4;
        private String DF5;
        private String DF6;
        private String DF7;
        private String DF8;
        private String DF9;
        private String DF10;
        private String AdditionInfo;
        private int UpperAccountID;
        private String UpperAccount;
        private boolean ResetPassOnNextLogin;
        private String Operation;
        private String ModuleIDs;
        private String LastActivityTime;
        private String Delegator;
        private String ChannelAdmin;
        private String UploadFileFolder;
        private String TempUploadFileFolder;
        private boolean WorkflowPrivilegeMode;
        private int ThemeID;
        private String InitPassword;
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
        private String Representative;
        private String Lang;
        private String TimezoneStr;
        private TimezoneBean Timezone;
        private boolean InvisibleMode;
        private String CurrentProductTemplateInfo;
        private List<Integer> ParentPath;
        private List<Integer> RoleIDs;
        private List<RoleBean> Role;
        private List<Integer> DepartmentIDs;
        private List<DepartmentBean> Department;
        private List<?> GroupIDs;
        private List<?> Group;
        private List<?> LabelIDs;
        private List<SessionInfoBean> SessionInfo;

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

        public String getLevel() {
            return Level;
        }

        public void setLevel(String Level) {
            this.Level = Level;
        }

        public String getFiles() {
            return Files;
        }

        public void setFiles(String Files) {
            this.Files = Files;
        }

        public String getR1() {
            return R1;
        }

        public void setR1(String R1) {
            this.R1 = R1;
        }

        public String getR2() {
            return R2;
        }

        public void setR2(String R2) {
            this.R2 = R2;
        }

        public String getDF1() {
            return DF1;
        }

        public void setDF1(String DF1) {
            this.DF1 = DF1;
        }

        public String getDF2() {
            return DF2;
        }

        public void setDF2(String DF2) {
            this.DF2 = DF2;
        }

        public String getDF3() {
            return DF3;
        }

        public void setDF3(String DF3) {
            this.DF3 = DF3;
        }

        public String getDF4() {
            return DF4;
        }

        public void setDF4(String DF4) {
            this.DF4 = DF4;
        }

        public String getDF5() {
            return DF5;
        }

        public void setDF5(String DF5) {
            this.DF5 = DF5;
        }

        public String getDF6() {
            return DF6;
        }

        public void setDF6(String DF6) {
            this.DF6 = DF6;
        }

        public String getDF7() {
            return DF7;
        }

        public void setDF7(String DF7) {
            this.DF7 = DF7;
        }

        public String getDF8() {
            return DF8;
        }

        public void setDF8(String DF8) {
            this.DF8 = DF8;
        }

        public String getDF9() {
            return DF9;
        }

        public void setDF9(String DF9) {
            this.DF9 = DF9;
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

        public String getUpperAccount() {
            return UpperAccount;
        }

        public void setUpperAccount(String UpperAccount) {
            this.UpperAccount = UpperAccount;
        }

        public boolean isResetPassOnNextLogin() {
            return ResetPassOnNextLogin;
        }

        public void setResetPassOnNextLogin(boolean ResetPassOnNextLogin) {
            this.ResetPassOnNextLogin = ResetPassOnNextLogin;
        }

        public String getOperation() {
            return Operation;
        }

        public void setOperation(String Operation) {
            this.Operation = Operation;
        }

        public String getModuleIDs() {
            return ModuleIDs;
        }

        public void setModuleIDs(String ModuleIDs) {
            this.ModuleIDs = ModuleIDs;
        }

        public String getLastActivityTime() {
            return LastActivityTime;
        }

        public void setLastActivityTime(String LastActivityTime) {
            this.LastActivityTime = LastActivityTime;
        }

        public String getDelegator() {
            return Delegator;
        }

        public void setDelegator(String Delegator) {
            this.Delegator = Delegator;
        }

        public String getChannelAdmin() {
            return ChannelAdmin;
        }

        public void setChannelAdmin(String ChannelAdmin) {
            this.ChannelAdmin = ChannelAdmin;
        }

        public String getUploadFileFolder() {
            return UploadFileFolder;
        }

        public void setUploadFileFolder(String UploadFileFolder) {
            this.UploadFileFolder = UploadFileFolder;
        }

        public String getTempUploadFileFolder() {
            return TempUploadFileFolder;
        }

        public void setTempUploadFileFolder(String TempUploadFileFolder) {
            this.TempUploadFileFolder = TempUploadFileFolder;
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

        public String getInitPassword() {
            return InitPassword;
        }

        public void setInitPassword(String InitPassword) {
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

        public String getRepresentative() {
            return Representative;
        }

        public void setRepresentative(String Representative) {
            this.Representative = Representative;
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

        public TimezoneBean getTimezone() {
            return Timezone;
        }

        public void setTimezone(TimezoneBean Timezone) {
            this.Timezone = Timezone;
        }

        public boolean isInvisibleMode() {
            return InvisibleMode;
        }

        public void setInvisibleMode(boolean InvisibleMode) {
            this.InvisibleMode = InvisibleMode;
        }

        public String getCurrentProductTemplateInfo() {
            return CurrentProductTemplateInfo;
        }

        public void setCurrentProductTemplateInfo(String CurrentProductTemplateInfo) {
            this.CurrentProductTemplateInfo = CurrentProductTemplateInfo;
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

        public List<?> getGroupIDs() {
            return GroupIDs;
        }

        public void setGroupIDs(List<?> GroupIDs) {
            this.GroupIDs = GroupIDs;
        }

        public List<?> getGroup() {
            return Group;
        }

        public void setGroup(List<?> Group) {
            this.Group = Group;
        }

        public List<?> getLabelIDs() {
            return LabelIDs;
        }

        public void setLabelIDs(List<?> LabelIDs) {
            this.LabelIDs = LabelIDs;
        }

        public List<SessionInfoBean> getSessionInfo() {
            return SessionInfo;
        }

        public void setSessionInfo(List<SessionInfoBean> SessionInfo) {
            this.SessionInfo = SessionInfo;
        }

        public static class TimezoneBean {
            /**
             * Id : null
             * DisplayName :
             * StandardName :
             * DaylightName :
             * BaseUtcOffset : PT0S
             * SupportsDaylightSavingTime : false
             */

            private String Id;
            private String DisplayName;
            private String StandardName;
            private String DaylightName;
            private String BaseUtcOffset;
            private boolean SupportsDaylightSavingTime;

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getDisplayName() {
                return DisplayName;
            }

            public void setDisplayName(String DisplayName) {
                this.DisplayName = DisplayName;
            }

            public String getStandardName() {
                return StandardName;
            }

            public void setStandardName(String StandardName) {
                this.StandardName = StandardName;
            }

            public String getDaylightName() {
                return DaylightName;
            }

            public void setDaylightName(String DaylightName) {
                this.DaylightName = DaylightName;
            }

            public String getBaseUtcOffset() {
                return BaseUtcOffset;
            }

            public void setBaseUtcOffset(String BaseUtcOffset) {
                this.BaseUtcOffset = BaseUtcOffset;
            }

            public boolean isSupportsDaylightSavingTime() {
                return SupportsDaylightSavingTime;
            }

            public void setSupportsDaylightSavingTime(boolean SupportsDaylightSavingTime) {
                this.SupportsDaylightSavingTime = SupportsDaylightSavingTime;
            }
        }

        public static class RoleBean {
            /**
             * ID : 982
             * CompanyID : 4578
             * Name : admin
             * Desc : null
             * Status : 1
             * Operations : []
             * LastModifyByID : -1
             * Timestamp : /Date(1587370700796)/
             * PageCode : 0
             * CreatorID : -1
             * CreateTime : /Date(1587370700796)/
             * AdditionInfo : null
             * DF1 : null
             * DF2 : null
             * DF3 : null
             * DF4 : null
             * DF5 : null
             * DF6 : null
             * DF7 : null
             * DF8 : null
             * DF9 : null
             * DF10 : null
             */

            private int ID;
            private int CompanyID;
            private String Name;
            private String Desc;
            private int Status;
            private int LastModifyByID;
            private String Timestamp;
            private int PageCode;
            private int CreatorID;
            private String CreateTime;
            private String AdditionInfo;
            private String DF1;
            private String DF2;
            private String DF3;
            private String DF4;
            private String DF5;
            private String DF6;
            private String DF7;
            private String DF8;
            private String DF9;
            private String DF10;
            private List<?> Operations;

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

            public String getDesc() {
                return Desc;
            }

            public void setDesc(String Desc) {
                this.Desc = Desc;
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

            public String getAdditionInfo() {
                return AdditionInfo;
            }

            public void setAdditionInfo(String AdditionInfo) {
                this.AdditionInfo = AdditionInfo;
            }

            public String getDF1() {
                return DF1;
            }

            public void setDF1(String DF1) {
                this.DF1 = DF1;
            }

            public String getDF2() {
                return DF2;
            }

            public void setDF2(String DF2) {
                this.DF2 = DF2;
            }

            public String getDF3() {
                return DF3;
            }

            public void setDF3(String DF3) {
                this.DF3 = DF3;
            }

            public String getDF4() {
                return DF4;
            }

            public void setDF4(String DF4) {
                this.DF4 = DF4;
            }

            public String getDF5() {
                return DF5;
            }

            public void setDF5(String DF5) {
                this.DF5 = DF5;
            }

            public String getDF6() {
                return DF6;
            }

            public void setDF6(String DF6) {
                this.DF6 = DF6;
            }

            public String getDF7() {
                return DF7;
            }

            public void setDF7(String DF7) {
                this.DF7 = DF7;
            }

            public String getDF8() {
                return DF8;
            }

            public void setDF8(String DF8) {
                this.DF8 = DF8;
            }

            public String getDF9() {
                return DF9;
            }

            public void setDF9(String DF9) {
                this.DF9 = DF9;
            }

            public String getDF10() {
                return DF10;
            }

            public void setDF10(String DF10) {
                this.DF10 = DF10;
            }

            public List<?> getOperations() {
                return Operations;
            }

            public void setOperations(List<?> Operations) {
                this.Operations = Operations;
            }
        }

        public static class DepartmentBean {
            /**
             * ID : 903
             * CompanyID : 4578
             * Name : Admin
             * DepartmentCode : admin
             * ParentID : 0
             * Parent : null
             * ParentPath : [0,903]
             * Status : 1
             * OrganizationType : 0
             * LastModifyByID : 10423
             * Timestamp : /Date(1588918252470)/
             * Labels : []
             * DepartmentManagerIDs : []
             * DepartmentManager : []
             * ColorCode : null
             * PageCode : 0
             * BusinessAreaIDs : [1430]
             * BusinessArea : []
             * CreatorID : -1
             * CreateTime : /Date(1587370697568)/
             * AdditionInfo : null
             * DF1 : 刘强
             * DF2 : null
             * DF3 : null
             * DF4 : null
             * DF5 : null
             * DF6 : null
             * DF7 : null
             * DF8 : null
             * DF9 : null
             * DF10 : null
             */

            private int ID;
            private int CompanyID;
            private String Name;
            private String DepartmentCode;
            private int ParentID;
            private String Parent;
            private int Status;
            private int OrganizationType;
            private int LastModifyByID;
            private String Timestamp;
            private String ColorCode;
            private int PageCode;
            private int CreatorID;
            private String CreateTime;
            private String AdditionInfo;
            private String DF1;
            private String DF2;
            private String DF3;
            private String DF4;
            private String DF5;
            private String DF6;
            private String DF7;
            private String DF8;
            private String DF9;
            private String DF10;
            private List<Integer> ParentPath;
            private List<?> Labels;
            private List<?> DepartmentManagerIDs;
            private List<?> DepartmentManager;
            private List<Integer> BusinessAreaIDs;
            private List<?> BusinessArea;

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

            public String getDepartmentCode() {
                return DepartmentCode;
            }

            public void setDepartmentCode(String DepartmentCode) {
                this.DepartmentCode = DepartmentCode;
            }

            public int getParentID() {
                return ParentID;
            }

            public void setParentID(int ParentID) {
                this.ParentID = ParentID;
            }

            public String getParent() {
                return Parent;
            }

            public void setParent(String Parent) {
                this.Parent = Parent;
            }

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
            }

            public int getOrganizationType() {
                return OrganizationType;
            }

            public void setOrganizationType(int OrganizationType) {
                this.OrganizationType = OrganizationType;
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

            public String getColorCode() {
                return ColorCode;
            }

            public void setColorCode(String ColorCode) {
                this.ColorCode = ColorCode;
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

            public String getAdditionInfo() {
                return AdditionInfo;
            }

            public void setAdditionInfo(String AdditionInfo) {
                this.AdditionInfo = AdditionInfo;
            }

            public String getDF1() {
                return DF1;
            }

            public void setDF1(String DF1) {
                this.DF1 = DF1;
            }

            public String getDF2() {
                return DF2;
            }

            public void setDF2(String DF2) {
                this.DF2 = DF2;
            }

            public String getDF3() {
                return DF3;
            }

            public void setDF3(String DF3) {
                this.DF3 = DF3;
            }

            public String getDF4() {
                return DF4;
            }

            public void setDF4(String DF4) {
                this.DF4 = DF4;
            }

            public String getDF5() {
                return DF5;
            }

            public void setDF5(String DF5) {
                this.DF5 = DF5;
            }

            public String getDF6() {
                return DF6;
            }

            public void setDF6(String DF6) {
                this.DF6 = DF6;
            }

            public String getDF7() {
                return DF7;
            }

            public void setDF7(String DF7) {
                this.DF7 = DF7;
            }

            public String getDF8() {
                return DF8;
            }

            public void setDF8(String DF8) {
                this.DF8 = DF8;
            }

            public String getDF9() {
                return DF9;
            }

            public void setDF9(String DF9) {
                this.DF9 = DF9;
            }

            public String getDF10() {
                return DF10;
            }

            public void setDF10(String DF10) {
                this.DF10 = DF10;
            }

            public List<Integer> getParentPath() {
                return ParentPath;
            }

            public void setParentPath(List<Integer> ParentPath) {
                this.ParentPath = ParentPath;
            }

            public List<?> getLabels() {
                return Labels;
            }

            public void setLabels(List<?> Labels) {
                this.Labels = Labels;
            }

            public List<?> getDepartmentManagerIDs() {
                return DepartmentManagerIDs;
            }

            public void setDepartmentManagerIDs(List<?> DepartmentManagerIDs) {
                this.DepartmentManagerIDs = DepartmentManagerIDs;
            }

            public List<?> getDepartmentManager() {
                return DepartmentManager;
            }

            public void setDepartmentManager(List<?> DepartmentManager) {
                this.DepartmentManager = DepartmentManager;
            }

            public List<Integer> getBusinessAreaIDs() {
                return BusinessAreaIDs;
            }

            public void setBusinessAreaIDs(List<Integer> BusinessAreaIDs) {
                this.BusinessAreaIDs = BusinessAreaIDs;
            }

            public List<?> getBusinessArea() {
                return BusinessArea;
            }

            public void setBusinessArea(List<?> BusinessArea) {
                this.BusinessArea = BusinessArea;
            }
        }

        public static class SessionInfoBean {
            /**
             * Key : cx23vtds0bsz1z5aox5cag1r
             * Value : 222.67.12.195
             * ValuePage :
             * Direction : 0
             * ExtraInfo : null
             * InnerReference : null
             */

            private String Key;
            private String Value;
            private String ValuePage;
            private int Direction;
            private String ExtraInfo;
            private String InnerReference;

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

            public String getExtraInfo() {
                return ExtraInfo;
            }

            public void setExtraInfo(String ExtraInfo) {
                this.ExtraInfo = ExtraInfo;
            }

            public String getInnerReference() {
                return InnerReference;
            }

            public void setInnerReference(String InnerReference) {
                this.InnerReference = InnerReference;
            }
        }
    }
}
