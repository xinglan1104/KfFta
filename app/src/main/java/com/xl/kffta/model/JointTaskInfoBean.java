package com.xl.kffta.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author created by zhanghaochen
 * @date 2020-05-21 16:14
 * 描述：具体id的检查任务的请求实例类
 */
public class JointTaskInfoBean implements Serializable {
    private Object Blocks;
    private DataBean Data;
    private String Error;
    private int ErrorCode;
    private Object ResponseStatus;
    private String EncryptionData;
    private String AESEncryptionKey;

    public Object getBlocks() {
        return Blocks;
    }

    public void setBlocks(Object Blocks) {
        this.Blocks = Blocks;
    }

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

    public Object getResponseStatus() {
        return ResponseStatus;
    }

    public void setResponseStatus(Object ResponseStatus) {
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

    public static class DataBean implements Serializable {
        private String __type;
        private long ID;
        private long CompanyID;
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
        private long CreatorID;
        private long PageCode;
        private long GovermentJointSupervisionSchemeID;
        private GovermentJointSupervisionSchemeBean GovermentJointSupervisionScheme;
        private long DeparmentID;
        private DeparmentBean Deparment;
        private List<Long> OwnerIDs;
        private List<OwnerBean> Owner;
        private List<OwnerBean> PendingOwner;
        private List<Long> PendingOwnerIDs;
        private int AcceptStatus;
        private String CheckDate;
        private String Result;
        private int ExcutionStatus;
        //        private List<?> Reference;
        private List<Long> GovermentProjectRiskIDs;
        private List<GovermentProjectRiskBean> GovermentProjectRisk;

        public String get__type() {
            return __type;
        }

        public void set__type(String __type) {
            this.__type = __type;
        }

        public long getID() {
            return ID;
        }

        public void setID(long ID) {
            this.ID = ID;
        }

        public List<Long> getOwnerIDs() {
            return OwnerIDs;
        }

        public void setOwnerIDs(List<Long> ownerIDs) {
            OwnerIDs = ownerIDs;
        }

        public List<OwnerBean> getPendingOwner() {
            return PendingOwner;
        }

        public void setPendingOwner(List<OwnerBean> pendingOwner) {
            PendingOwner = pendingOwner;
        }

        public List<Long> getPendingOwnerIDs() {
            return PendingOwnerIDs;
        }

        public void setPendingOwnerIDs(List<Long> pendingOwnerIDs) {
            PendingOwnerIDs = pendingOwnerIDs;
        }

        public long getCompanyID() {
            return CompanyID;
        }

        public void setCompanyID(long CompanyID) {
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

        public long getCreatorID() {
            return CreatorID;
        }

        public void setCreatorID(long CreatorID) {
            this.CreatorID = CreatorID;
        }

        public long getPageCode() {
            return PageCode;
        }

        public void setPageCode(long PageCode) {
            this.PageCode = PageCode;
        }

        public long getGovermentJointSupervisionSchemeID() {
            return GovermentJointSupervisionSchemeID;
        }

        public void setGovermentJointSupervisionSchemeID(long GovermentJointSupervisionSchemeID) {
            this.GovermentJointSupervisionSchemeID = GovermentJointSupervisionSchemeID;
        }

        public GovermentJointSupervisionSchemeBean getGovermentJointSupervisionScheme() {
            return GovermentJointSupervisionScheme;
        }

        public void setGovermentJointSupervisionScheme(GovermentJointSupervisionSchemeBean GovermentJointSupervisionScheme) {
            this.GovermentJointSupervisionScheme = GovermentJointSupervisionScheme;
        }

        public long getDeparmentID() {
            return DeparmentID;
        }

        public void setDeparmentID(long DeparmentID) {
            this.DeparmentID = DeparmentID;
        }

        public DeparmentBean getDeparment() {
            return Deparment;
        }

        public void setDeparment(DeparmentBean Deparment) {
            this.Deparment = Deparment;
        }

//        public long getOwnerID() {
//            return OwnerID;
//        }
//
//        public void setOwnerID(long OwnerID) {
//            this.OwnerID = OwnerID;
//        }

        public List<OwnerBean> getOwner() {
            return Owner;
        }

        public void setOwner(List<OwnerBean> Owner) {
            this.Owner = Owner;
        }

        public int getAcceptStatus() {
            return AcceptStatus;
        }

        public void setAcceptStatus(int AcceptStatus) {
            this.AcceptStatus = AcceptStatus;
        }

        public String getCheckDate() {
            return CheckDate;
        }

        public void setCheckDate(String CheckDate) {
            this.CheckDate = CheckDate;
        }

        public String getResult() {
            return Result;
        }

        public void setResult(String Result) {
            this.Result = Result;
        }

        public int getExcutionStatus() {
            return ExcutionStatus;
        }

        public void setExcutionStatus(int ExcutionStatus) {
            this.ExcutionStatus = ExcutionStatus;
        }

//        public List<?> getReference() {
//            return Reference;
//        }
//
//        public void setReference(List<?> Reference) {
//            this.Reference = Reference;
//        }

        public List<Long> getGovermentProjectRiskIDs() {
            return GovermentProjectRiskIDs;
        }

        public void setGovermentProjectRiskIDs(List<Long> GovermentProjectRiskIDs) {
            this.GovermentProjectRiskIDs = GovermentProjectRiskIDs;
        }

        public List<GovermentProjectRiskBean> getGovermentProjectRisk() {
            return GovermentProjectRisk;
        }

        public void setGovermentProjectRisk(List<GovermentProjectRiskBean> GovermentProjectRisk) {
            this.GovermentProjectRisk = GovermentProjectRisk;
        }

        public static class GovermentJointSupervisionSchemeBean {
            private long ID;
            private String Code;
            private long CompanyID;
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
            private long CreatorID;
            private long PageCode;
            private Object VirtualFieldsCache;
            private String Name;
            private long GovermentProjectID;
            private int Status;
            private String CheckDate;
            private String Responsible;
            private String Contact;
            private List<?> Reference;
            private List<Long> GovermentProjectRiskIDs;
            private List<Long> DepartmentIDs;

            public long getID() {
                return ID;
            }

            public void setID(long ID) {
                this.ID = ID;
            }

            public String getCode() {
                return Code;
            }

            public void setCode(String Code) {
                this.Code = Code;
            }

            public long getCompanyID() {
                return CompanyID;
            }

            public void setCompanyID(long CompanyID) {
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

            public long getCreatorID() {
                return CreatorID;
            }

            public void setCreatorID(long CreatorID) {
                this.CreatorID = CreatorID;
            }

            public long getPageCode() {
                return PageCode;
            }

            public void setPageCode(long PageCode) {
                this.PageCode = PageCode;
            }

            public Object getVirtualFieldsCache() {
                return VirtualFieldsCache;
            }

            public void setVirtualFieldsCache(Object VirtualFieldsCache) {
                this.VirtualFieldsCache = VirtualFieldsCache;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public long getGovermentProjectID() {
                return GovermentProjectID;
            }

            public void setGovermentProjectID(long GovermentProjectID) {
                this.GovermentProjectID = GovermentProjectID;
            }

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
            }

            public String getCheckDate() {
                return CheckDate;
            }

            public void setCheckDate(String CheckDate) {
                this.CheckDate = CheckDate;
            }

            public String getResponsible() {
                return Responsible;
            }

            public void setResponsible(String Responsible) {
                this.Responsible = Responsible;
            }

            public String getContact() {
                return Contact;
            }

            public void setContact(String Contact) {
                this.Contact = Contact;
            }

            public List<?> getReference() {
                return Reference;
            }

            public void setReference(List<?> Reference) {
                this.Reference = Reference;
            }

            public List<Long> getGovermentProjectRiskIDs() {
                return GovermentProjectRiskIDs;
            }

            public void setGovermentProjectRiskIDs(List<Long> GovermentProjectRiskIDs) {
                this.GovermentProjectRiskIDs = GovermentProjectRiskIDs;
            }

            public List<Long> getDepartmentIDs() {
                return DepartmentIDs;
            }

            public void setDepartmentIDs(List<Long> DepartmentIDs) {
                this.DepartmentIDs = DepartmentIDs;
            }
        }

        public static class DeparmentBean {
            private long ID;
            private long CompanyID;
            private String Name;
            private String DepartmentCode;
            private long ParentID;
            private Object Parent;
            private int Status;
            private int OrganizationType;
            private int LastModifyByID;
            private String Timestamp;
            private String ColorCode;
            private long PageCode;
            private long CreatorID;
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
            private List<Long> DepartmentManagerIDs;
            private List<?> DepartmentManager;
            private List<Long> BusinessAreaIDs;
            private List<?> BusinessArea;

            public long getID() {
                return ID;
            }

            public void setID(long ID) {
                this.ID = ID;
            }

            public long getCompanyID() {
                return CompanyID;
            }

            public void setCompanyID(long CompanyID) {
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

            public long getParentID() {
                return ParentID;
            }

            public void setParentID(long ParentID) {
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

            public String getColorCode() {
                return ColorCode;
            }

            public void setColorCode(String ColorCode) {
                this.ColorCode = ColorCode;
            }

            public long getPageCode() {
                return PageCode;
            }

            public void setPageCode(long PageCode) {
                this.PageCode = PageCode;
            }

            public long getCreatorID() {
                return CreatorID;
            }

            public void setCreatorID(long CreatorID) {
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

            public List<Long> getDepartmentManagerIDs() {
                return DepartmentManagerIDs;
            }

            public void setDepartmentManagerIDs(List<Long> DepartmentManagerIDs) {
                this.DepartmentManagerIDs = DepartmentManagerIDs;
            }

            public List<?> getDepartmentManager() {
                return DepartmentManager;
            }

            public void setDepartmentManager(List<?> DepartmentManager) {
                this.DepartmentManager = DepartmentManager;
            }

            public List<Long> getBusinessAreaIDs() {
                return BusinessAreaIDs;
            }

            public void setBusinessAreaIDs(List<Long> BusinessAreaIDs) {
                this.BusinessAreaIDs = BusinessAreaIDs;
            }

            public List<?> getBusinessArea() {
                return BusinessArea;
            }

            public void setBusinessArea(List<?> BusinessArea) {
                this.BusinessArea = BusinessArea;
            }
        }

        public static class OwnerBean {
            /**
             * Desc : null
             * RealName : null
             * AccountCode : null
             * Password : 96e79218965eb72c92a549dd5a330112
             * Email : null
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
             * DF10 : null
             * AdditionInfo : null
             * UpperAccountID : 0
             * UpperAccount : null
             * ResetPassOnNextLogin : false
             * ParentPath : [0,10460]
             * RoleIDs : [982]
             * Role : []
             * Operation : null
             * ModuleIDs : null
             * DepartmentIDs : [912]
             * Department : []
             * GroupIDs : []
             * Group : []
             * LabelIDs : []
             * SessionInfo : []
             * LastActivityTime : /Date(1590121270653)/
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
             * IsOwner : false
             * PageCode : 0
             * CreatorID : 10423
             * CreateTime : /Date(1588918988477)/
             * LastModifyByID : 10423
             * Timestamp : /Date(1590121311018)/
             * CheckReleaseNoteDate : /Date(1588089600000)/
             * IsChannelManager : false
             * ID : 10460
             * UserName : mm
             * DisplayName : mm
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
            private Object Email;
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
            private Object DF10;
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
            private List<?> Role;
            private List<Integer> DepartmentIDs;
            private List<?> Department;
            private List<?> GroupIDs;
            private List<?> Group;
            private List<?> LabelIDs;
            private List<?> SessionInfo;

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

            public Object getEmail() {
                return Email;
            }

            public void setEmail(Object Email) {
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

            public Object getDF10() {
                return DF10;
            }

            public void setDF10(Object DF10) {
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

            public List<?> getRole() {
                return Role;
            }

            public void setRole(List<?> Role) {
                this.Role = Role;
            }

            public List<Integer> getDepartmentIDs() {
                return DepartmentIDs;
            }

            public void setDepartmentIDs(List<Integer> DepartmentIDs) {
                this.DepartmentIDs = DepartmentIDs;
            }

            public List<?> getDepartment() {
                return Department;
            }

            public void setDepartment(List<?> Department) {
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

            public List<?> getSessionInfo() {
                return SessionInfo;
            }

            public void setSessionInfo(List<?> SessionInfo) {
                this.SessionInfo = SessionInfo;
            }
        }

        public static class GovermentProjectRiskBean {
            /**
             * ID : 4
             * Reference : []
             * CompanyID : 4578
             * Note :
             * LastModifyByID : 10423
             * Timestamp : /Date(1587627866716)/
             * AdditionInfo :
             * Files :
             * DF1 :
             * DF2 :
             * DF3 :
             * DF4 :
             * DF5 :
             * DF6 :
             * DF7 :
             * DF8 :
             * DF9 :
             * DF10 :
             * CreateTime : /Date(1587627473245)/
             * CreatorID : 10423
             * PageCode : 0
             * Name : 图纸会审
             * Risk : 设计阶段以及图纸会审时应注意的问题 设计图纸质量的好与差,直接关系到工程进度的快慢和工程造价的高低,一方面要通过推行限额设计来降低造价
             * DepartmentIDs : [912]
             * Department : []
             */

            private int ID;
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
            private int PageCode;
            private String Name;
            private String Risk;
            private List<?> Reference;
            private List<Integer> DepartmentIDs;
            private List<CheckListBean.DataBean.DepartmentBean> Department;

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

            public int getPageCode() {
                return PageCode;
            }

            public void setPageCode(int PageCode) {
                this.PageCode = PageCode;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getRisk() {
                return Risk;
            }

            public void setRisk(String Risk) {
                this.Risk = Risk;
            }

            public List<?> getReference() {
                return Reference;
            }

            public void setReference(List<?> Reference) {
                this.Reference = Reference;
            }

            public List<Integer> getDepartmentIDs() {
                return DepartmentIDs;
            }

            public void setDepartmentIDs(List<Integer> DepartmentIDs) {
                this.DepartmentIDs = DepartmentIDs;
            }

            public List<CheckListBean.DataBean.DepartmentBean> getDepartment() {
                return Department;
            }

            public void setDepartment(List<CheckListBean.DataBean.DepartmentBean> Department) {
                this.Department = Department;
            }
        }

    }
}
