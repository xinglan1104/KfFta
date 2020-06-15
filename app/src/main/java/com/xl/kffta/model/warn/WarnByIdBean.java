package com.xl.kffta.model.warn;

import com.xl.kffta.model.common.BusinessBean;
import com.xl.kffta.model.common.DepartmentBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author created by zhanghaochen
 * @date 2020-06-15 17:01
 * 描述：预警详情
 */
public class WarnByIdBean implements Serializable {

    /**
     * Blocks : null
     * Data : {"__type":"CloudEasy.ERP.BL.Model.Government.GovermentWarning, CloudEasy.ERP.BL.Model","ID":1,"Code":"0001","CompanyID":4578,"Note":"","LastModifyByID":10423,"Timestamp":"/Date(1591948067052)/","AdditionInfo":null,"Files":"4578|CloudEasy.ERP.BL.Model.Government.GovermentWarning|CloudEasy.ERP.BL.Model.Government.GovermentWarning_20200612_d1e80bf818c24ac894de4903edbaeea2|2912","DF1":null,"DF2":null,"DF3":null,"DF4":null,"DF5":null,"DF6":null,"DF7":null,"DF8":null,"DF9":null,"DF10":null,"CreateTime":"/Date(1591948067052)/","CreatorID":10423,"Creator":{"Desc":null,"RealName":null,"AccountCode":null,"Password":"96e79218965eb72c92a549dd5a330112","Email":"76834423@qq.com","MobilePhone":null,"Status":0,"UserType":0,"Level":null,"Files":null,"R1":null,"R2":null,"DF1":null,"DF2":null,"DF3":null,"DF4":null,"DF5":null,"DF6":null,"DF7":null,"DF8":null,"DF9":null,"DF10":"6643443","AdditionInfo":null,"UpperAccountID":0,"UpperAccount":null,"ResetPassOnNextLogin":false,"ParentPath":[0,10423],"RoleIDs":[982],"Role":[{"ID":982,"CompanyID":4578,"Name":"admin","Desc":null,"Status":1,"Operations":[],"LastModifyByID":-1,"Timestamp":"/Date(1587370700796)/","PageCode":0,"CreatorID":-1,"CreateTime":"/Date(1587370700796)/","AdditionInfo":null,"DF1":null,"DF2":null,"DF3":null,"DF4":null,"DF5":null,"DF6":null,"DF7":null,"DF8":null,"DF9":null,"DF10":null}],"Operation":null,"ModuleIDs":null,"DepartmentIDs":[903],"Department":[{"ID":903,"CompanyID":4578,"Name":"Admin","DepartmentCode":"admin","ParentID":0,"Parent":null,"ParentPath":[0,903],"Status":1,"OrganizationType":0,"LastModifyByID":10423,"Timestamp":"/Date(1591768922112)/","Labels":[],"DepartmentManagerIDs":[],"DepartmentManager":[],"ColorCode":null,"PageCode":0,"BusinessAreaIDs":[1430],"BusinessArea":[],"CreatorID":-1,"CreateTime":"/Date(1587370697568)/","AdditionInfo":null,"DF1":"刘强","DF2":null,"DF3":null,"DF4":null,"DF5":null,"DF6":null,"DF7":null,"DF8":null,"DF9":null,"DF10":null}],"GroupIDs":[],"Group":[],"LabelIDs":[],"SessionInfo":[{"Key":"lmafx5nrcmtwxg5amim4uvzf","Value":"222.67.12.195","ValuePage":"","Direction":0,"ExtraInfo":null,"InnerReference":null}],"LastActivityTime":"/Date(1592206212932)/","Delegator":null,"ChannelAdmin":null,"UploadFileFolder":null,"TempUploadFileFolder":null,"WorkflowPrivilegeMode":false,"ThemeID":0,"InitPassword":null,"IgnoreLangTranslation":false,"RoundDecimal":2,"CurrencyRoundDecimal":2,"CurrencySumRoundDecimal":2,"RateRoundDecimal":5,"CurrencyComparisonRoundDecimal":2,"ComparisonRoundDecimal":2,"IsOwner":true,"PageCode":0,"CreatorID":-1,"CreateTime":"/Date(1587370703644)/","LastModifyByID":-1,"Timestamp":"/Date(1592206276135)/","CheckReleaseNoteDate":"/Date(1591113600000)/","IsChannelManager":false,"ID":10423,"UserName":"admin","DisplayName":"admin","CompanyID":4578,"Representative":null,"Lang":"zh-CN","TimezoneStr":null,"Timezone":null,"InvisibleMode":false,"CurrentProductTemplateInfo":null},"PageCode":0,"Content":"wewr","DepartmentID":912,"Department":{"ID":912,"CompanyID":4578,"Name":"办公室","DepartmentCode":"000000007","ParentID":0,"Parent":null,"ParentPath":[0,912],"Status":1,"OrganizationType":0,"LastModifyByID":10423,"Timestamp":"/Date(1588926629613)/","Labels":[],"DepartmentManagerIDs":[],"DepartmentManager":[],"ColorCode":null,"PageCode":0,"BusinessAreaIDs":[1431],"BusinessArea":[{"ID":1431,"AttrID":1431,"CompanyID":4578,"Name":"初级食用农产品、蔬菜、水果、预包装食品","AttrType":6,"Status":1,"R1":null,"R2":null,"Parent":null,"ParentID":0,"ParentPath":[0,1431],"AdditionInfo":null,"CreateTime":"/Date(1587447215399)/","CreatorID":10423,"DF1":null,"DF10":null,"DF2":null,"DF3":null,"DF4":null,"DF5":null,"DF6":null,"DF7":null,"DF8":null,"DF9":null,"LastModifyByID":10423,"PageCode":0,"Timestamp":"/Date(1587447215399)/"}],"CreatorID":10423,"CreateTime":"/Date(1587433071679)/","AdditionInfo":null,"DF1":"乐菱","DF2":null,"DF3":null,"DF4":null,"DF5":null,"DF6":null,"DF7":null,"DF8":null,"DF9":null,"DF10":null},"BusinessID":0,"Business":null}
     * Error : null
     * ErrorCode : 0
     * ResponseStatus : null
     * EncryptionData : null
     * AESEncryptionKey : null
     */

    private DataBean Data;
    private String Error;
    private int ErrorCode;

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
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

    public static class DataBean {

        private String __type;
        private int ID;
        private String Code;
        private int CompanyID;
        private String Note;
        private int LastModifyByID;
        private String Timestamp;
        private String AdditionInfo;
        private String Files;
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
        private String CreateTime;
        private int CreatorID;
        private CreatorBean Creator;
        private int PageCode;
        private String Content;
        private int DepartmentID;
        private DepartmentBean Department;
        private int BusinessID;
        private BusinessBean Business;

        public String get__type() {
            return __type;
        }

        public void set__type(String __type) {
            this.__type = __type;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getCode() {
            return Code;
        }

        public void setCode(String Code) {
            this.Code = Code;
        }

        public int getCompanyID() {
            return CompanyID;
        }

        public void setCompanyID(int CompanyID) {
            this.CompanyID = CompanyID;
        }

        public String getNote() {
            return Note;
        }

        public void setNote(String Note) {
            this.Note = Note;
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

        public String getAdditionInfo() {
            return AdditionInfo;
        }

        public void setAdditionInfo(String AdditionInfo) {
            this.AdditionInfo = AdditionInfo;
        }

        public String getFiles() {
            return Files;
        }

        public void setFiles(String Files) {
            this.Files = Files;
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

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getCreatorID() {
            return CreatorID;
        }

        public void setCreatorID(int CreatorID) {
            this.CreatorID = CreatorID;
        }

        public CreatorBean getCreator() {
            return Creator;
        }

        public void setCreator(CreatorBean Creator) {
            this.Creator = Creator;
        }

        public int getPageCode() {
            return PageCode;
        }

        public void setPageCode(int PageCode) {
            this.PageCode = PageCode;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }

        public int getDepartmentID() {
            return DepartmentID;
        }

        public void setDepartmentID(int DepartmentID) {
            this.DepartmentID = DepartmentID;
        }

        public DepartmentBean getDepartment() {
            return Department;
        }

        public void setDepartment(DepartmentBean Department) {
            this.Department = Department;
        }

        public int getBusinessID() {
            return BusinessID;
        }

        public void setBusinessID(int BusinessID) {
            this.BusinessID = BusinessID;
        }

        public BusinessBean getBusiness() {
            return Business;
        }

        public void setBusiness(BusinessBean Business) {
            this.Business = Business;
        }

        public static class CreatorBean {
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
             * Department : [{"ID":903,"CompanyID":4578,"Name":"Admin","DepartmentCode":"admin","ParentID":0,"Parent":null,"ParentPath":[0,903],"Status":1,"OrganizationType":0,"LastModifyByID":10423,"Timestamp":"/Date(1591768922112)/","Labels":[],"DepartmentManagerIDs":[],"DepartmentManager":[],"ColorCode":null,"PageCode":0,"BusinessAreaIDs":[1430],"BusinessArea":[],"CreatorID":-1,"CreateTime":"/Date(1587370697568)/","AdditionInfo":null,"DF1":"刘强","DF2":null,"DF3":null,"DF4":null,"DF5":null,"DF6":null,"DF7":null,"DF8":null,"DF9":null,"DF10":null}]
             * GroupIDs : []
             * Group : []
             * LabelIDs : []
             * SessionInfo : [{"Key":"lmafx5nrcmtwxg5amim4uvzf","Value":"222.67.12.195","ValuePage":"","Direction":0,"ExtraInfo":null,"InnerReference":null}]
             * LastActivityTime : /Date(1592206212932)/
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
             * Timestamp : /Date(1592206276135)/
             * CheckReleaseNoteDate : /Date(1591113600000)/
             * IsChannelManager : false
             * ID : 10423
             * UserName : admin
             * DisplayName : admin
             * CompanyID : 4578
             * Representative : null
             * Lang : zh-CN
             * TimezoneStr : null
             * Timezone : null
             * InvisibleMode : false
             * CurrentProductTemplateInfo : null
             */

            private Object Desc;
            private Object RealName;
            private Object AccountCode;
            private String Password;
            private String Email;
            private Object MobilePhone;
            private int Status;
            private int UserType;
            private Object Level;
            private Object Files;
            private Object R1;
            private Object R2;
            private Object DF1;
            private Object DF2;
            private Object DF3;
            private Object DF4;
            private Object DF5;
            private Object DF6;
            private Object DF7;
            private Object DF8;
            private Object DF9;
            private String DF10;
            private Object AdditionInfo;
            private int UpperAccountID;
            private Object UpperAccount;
            private boolean ResetPassOnNextLogin;
            private Object Operation;
            private Object ModuleIDs;
            private String LastActivityTime;
            private Object Delegator;
            private Object ChannelAdmin;
            private Object UploadFileFolder;
            private Object TempUploadFileFolder;
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
            private int ID;
            private String UserName;
            private String DisplayName;
            private int CompanyID;
            private Object Representative;
            private String Lang;
            private Object TimezoneStr;
            private Object Timezone;
            private boolean InvisibleMode;
            private Object CurrentProductTemplateInfo;
            private List<Integer> ParentPath;
            private List<Integer> RoleIDs;
            private List<RoleBean> Role;
            private List<Integer> DepartmentIDs;
            private List<DepartmentBean> Department;
            private List<?> GroupIDs;
            private List<?> Group;
            private List<?> LabelIDs;
            private List<SessionInfoBean> SessionInfo;

            public Object getDesc() {
                return Desc;
            }

            public void setDesc(Object Desc) {
                this.Desc = Desc;
            }

            public Object getRealName() {
                return RealName;
            }

            public void setRealName(Object RealName) {
                this.RealName = RealName;
            }

            public Object getAccountCode() {
                return AccountCode;
            }

            public void setAccountCode(Object AccountCode) {
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

            public Object getMobilePhone() {
                return MobilePhone;
            }

            public void setMobilePhone(Object MobilePhone) {
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

            public Object getR1() {
                return R1;
            }

            public void setR1(Object R1) {
                this.R1 = R1;
            }

            public Object getR2() {
                return R2;
            }

            public void setR2(Object R2) {
                this.R2 = R2;
            }

            public Object getDF1() {
                return DF1;
            }

            public void setDF1(Object DF1) {
                this.DF1 = DF1;
            }

            public Object getDF2() {
                return DF2;
            }

            public void setDF2(Object DF2) {
                this.DF2 = DF2;
            }

            public Object getDF3() {
                return DF3;
            }

            public void setDF3(Object DF3) {
                this.DF3 = DF3;
            }

            public Object getDF4() {
                return DF4;
            }

            public void setDF4(Object DF4) {
                this.DF4 = DF4;
            }

            public Object getDF5() {
                return DF5;
            }

            public void setDF5(Object DF5) {
                this.DF5 = DF5;
            }

            public Object getDF6() {
                return DF6;
            }

            public void setDF6(Object DF6) {
                this.DF6 = DF6;
            }

            public Object getDF7() {
                return DF7;
            }

            public void setDF7(Object DF7) {
                this.DF7 = DF7;
            }

            public Object getDF8() {
                return DF8;
            }

            public void setDF8(Object DF8) {
                this.DF8 = DF8;
            }

            public Object getDF9() {
                return DF9;
            }

            public void setDF9(Object DF9) {
                this.DF9 = DF9;
            }

            public String getDF10() {
                return DF10;
            }

            public void setDF10(String DF10) {
                this.DF10 = DF10;
            }

            public Object getAdditionInfo() {
                return AdditionInfo;
            }

            public void setAdditionInfo(Object AdditionInfo) {
                this.AdditionInfo = AdditionInfo;
            }

            public int getUpperAccountID() {
                return UpperAccountID;
            }

            public void setUpperAccountID(int UpperAccountID) {
                this.UpperAccountID = UpperAccountID;
            }

            public Object getUpperAccount() {
                return UpperAccount;
            }

            public void setUpperAccount(Object UpperAccount) {
                this.UpperAccount = UpperAccount;
            }

            public boolean isResetPassOnNextLogin() {
                return ResetPassOnNextLogin;
            }

            public void setResetPassOnNextLogin(boolean ResetPassOnNextLogin) {
                this.ResetPassOnNextLogin = ResetPassOnNextLogin;
            }

            public Object getOperation() {
                return Operation;
            }

            public void setOperation(Object Operation) {
                this.Operation = Operation;
            }

            public Object getModuleIDs() {
                return ModuleIDs;
            }

            public void setModuleIDs(Object ModuleIDs) {
                this.ModuleIDs = ModuleIDs;
            }

            public String getLastActivityTime() {
                return LastActivityTime;
            }

            public void setLastActivityTime(String LastActivityTime) {
                this.LastActivityTime = LastActivityTime;
            }

            public Object getDelegator() {
                return Delegator;
            }

            public void setDelegator(Object Delegator) {
                this.Delegator = Delegator;
            }

            public Object getChannelAdmin() {
                return ChannelAdmin;
            }

            public void setChannelAdmin(Object ChannelAdmin) {
                this.ChannelAdmin = ChannelAdmin;
            }

            public Object getUploadFileFolder() {
                return UploadFileFolder;
            }

            public void setUploadFileFolder(Object UploadFileFolder) {
                this.UploadFileFolder = UploadFileFolder;
            }

            public Object getTempUploadFileFolder() {
                return TempUploadFileFolder;
            }

            public void setTempUploadFileFolder(Object TempUploadFileFolder) {
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

            public Object getRepresentative() {
                return Representative;
            }

            public void setRepresentative(Object Representative) {
                this.Representative = Representative;
            }

            public String getLang() {
                return Lang;
            }

            public void setLang(String Lang) {
                this.Lang = Lang;
            }

            public Object getTimezoneStr() {
                return TimezoneStr;
            }

            public void setTimezoneStr(Object TimezoneStr) {
                this.TimezoneStr = TimezoneStr;
            }

            public Object getTimezone() {
                return Timezone;
            }

            public void setTimezone(Object Timezone) {
                this.Timezone = Timezone;
            }

            public boolean isInvisibleMode() {
                return InvisibleMode;
            }

            public void setInvisibleMode(boolean InvisibleMode) {
                this.InvisibleMode = InvisibleMode;
            }

            public Object getCurrentProductTemplateInfo() {
                return CurrentProductTemplateInfo;
            }

            public void setCurrentProductTemplateInfo(Object CurrentProductTemplateInfo) {
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
                private Object Desc;
                private int Status;
                private int LastModifyByID;
                private String Timestamp;
                private int PageCode;
                private int CreatorID;
                private String CreateTime;
                private Object AdditionInfo;
                private Object DF1;
                private Object DF2;
                private Object DF3;
                private Object DF4;
                private Object DF5;
                private Object DF6;
                private Object DF7;
                private Object DF8;
                private Object DF9;
                private Object DF10;
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

                public Object getDesc() {
                    return Desc;
                }

                public void setDesc(Object Desc) {
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

                public Object getAdditionInfo() {
                    return AdditionInfo;
                }

                public void setAdditionInfo(Object AdditionInfo) {
                    this.AdditionInfo = AdditionInfo;
                }

                public Object getDF1() {
                    return DF1;
                }

                public void setDF1(Object DF1) {
                    this.DF1 = DF1;
                }

                public Object getDF2() {
                    return DF2;
                }

                public void setDF2(Object DF2) {
                    this.DF2 = DF2;
                }

                public Object getDF3() {
                    return DF3;
                }

                public void setDF3(Object DF3) {
                    this.DF3 = DF3;
                }

                public Object getDF4() {
                    return DF4;
                }

                public void setDF4(Object DF4) {
                    this.DF4 = DF4;
                }

                public Object getDF5() {
                    return DF5;
                }

                public void setDF5(Object DF5) {
                    this.DF5 = DF5;
                }

                public Object getDF6() {
                    return DF6;
                }

                public void setDF6(Object DF6) {
                    this.DF6 = DF6;
                }

                public Object getDF7() {
                    return DF7;
                }

                public void setDF7(Object DF7) {
                    this.DF7 = DF7;
                }

                public Object getDF8() {
                    return DF8;
                }

                public void setDF8(Object DF8) {
                    this.DF8 = DF8;
                }

                public Object getDF9() {
                    return DF9;
                }

                public void setDF9(Object DF9) {
                    this.DF9 = DF9;
                }

                public Object getDF10() {
                    return DF10;
                }

                public void setDF10(Object DF10) {
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
                 * Timestamp : /Date(1591768922112)/
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
                private Object Parent;
                private int Status;
                private int OrganizationType;
                private int LastModifyByID;
                private String Timestamp;
                private Object ColorCode;
                private int PageCode;
                private int CreatorID;
                private String CreateTime;
                private Object AdditionInfo;
                private String DF1;
                private Object DF2;
                private Object DF3;
                private Object DF4;
                private Object DF5;
                private Object DF6;
                private Object DF7;
                private Object DF8;
                private Object DF9;
                private Object DF10;
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

                public Object getParent() {
                    return Parent;
                }

                public void setParent(Object Parent) {
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

                public Object getColorCode() {
                    return ColorCode;
                }

                public void setColorCode(Object ColorCode) {
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

                public Object getAdditionInfo() {
                    return AdditionInfo;
                }

                public void setAdditionInfo(Object AdditionInfo) {
                    this.AdditionInfo = AdditionInfo;
                }

                public String getDF1() {
                    return DF1;
                }

                public void setDF1(String DF1) {
                    this.DF1 = DF1;
                }

                public Object getDF2() {
                    return DF2;
                }

                public void setDF2(Object DF2) {
                    this.DF2 = DF2;
                }

                public Object getDF3() {
                    return DF3;
                }

                public void setDF3(Object DF3) {
                    this.DF3 = DF3;
                }

                public Object getDF4() {
                    return DF4;
                }

                public void setDF4(Object DF4) {
                    this.DF4 = DF4;
                }

                public Object getDF5() {
                    return DF5;
                }

                public void setDF5(Object DF5) {
                    this.DF5 = DF5;
                }

                public Object getDF6() {
                    return DF6;
                }

                public void setDF6(Object DF6) {
                    this.DF6 = DF6;
                }

                public Object getDF7() {
                    return DF7;
                }

                public void setDF7(Object DF7) {
                    this.DF7 = DF7;
                }

                public Object getDF8() {
                    return DF8;
                }

                public void setDF8(Object DF8) {
                    this.DF8 = DF8;
                }

                public Object getDF9() {
                    return DF9;
                }

                public void setDF9(Object DF9) {
                    this.DF9 = DF9;
                }

                public Object getDF10() {
                    return DF10;
                }

                public void setDF10(Object DF10) {
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
                 * Key : lmafx5nrcmtwxg5amim4uvzf
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
}
