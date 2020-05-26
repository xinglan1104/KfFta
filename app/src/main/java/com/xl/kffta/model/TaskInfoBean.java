package com.xl.kffta.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @author created by zhanghaochen
 * @date 2020-05-19 16:43
 * 描述：任务信息实例类
 */
public class TaskInfoBean implements Serializable {
    private DataBean Data;
    private String Error;
    private int ErrorCode;
    private Object ResponseStatus;
    private String EncryptionData;
    private String AESEncryptionKey;

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
        private long GovermentEnforcementSchemeID;
        private GovermentEnforcementSchemeBean GovermentEnforcementScheme;
        private int RequiredQuantity;
        private long DepartmentID;
        private DepartmentBeanX Department;
        private long BusinessID;
        private BusinessBean Business;
        private String ExcuteTime;
        private int ExcutionStatus;
        private String Result;
        private String StartDate;
        private String EndDate;
        private int RequiredResponseHours;
        private List<HashMap<String, Integer>> Reference;
        private List<Long> OwnerIDs;
        private List<PendingOwnerBean> Owner;
        private List<Long> PendingOwnerIDs;
        private List<PendingOwnerBean> PendingOwner;
        private List<Long> CheckListIDs;
        private List<CheckListBean> CheckList;

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

        public long getGovermentEnforcementSchemeID() {
            return GovermentEnforcementSchemeID;
        }

        public void setGovermentEnforcementSchemeID(long GovermentEnforcementSchemeID) {
            this.GovermentEnforcementSchemeID = GovermentEnforcementSchemeID;
        }

        public GovermentEnforcementSchemeBean getGovermentEnforcementScheme() {
            return GovermentEnforcementScheme;
        }

        public void setGovermentEnforcementScheme(GovermentEnforcementSchemeBean GovermentEnforcementScheme) {
            this.GovermentEnforcementScheme = GovermentEnforcementScheme;
        }

        public int getRequiredQuantity() {
            return RequiredQuantity;
        }

        public void setRequiredQuantity(int RequiredQuantity) {
            this.RequiredQuantity = RequiredQuantity;
        }

        public long getDepartmentID() {
            return DepartmentID;
        }

        public void setDepartmentID(long DepartmentID) {
            this.DepartmentID = DepartmentID;
        }

        public DepartmentBeanX getDepartment() {
            return Department;
        }

        public void setDepartment(DepartmentBeanX Department) {
            this.Department = Department;
        }

        public long getBusinessID() {
            return BusinessID;
        }

        public void setBusinessID(long BusinessID) {
            this.BusinessID = BusinessID;
        }

        public BusinessBean getBusiness() {
            return Business;
        }

        public void setBusiness(BusinessBean Business) {
            this.Business = Business;
        }

        public String getExcuteTime() {
            return ExcuteTime;
        }

        public void setExcuteTime(String ExcuteTime) {
            this.ExcuteTime = ExcuteTime;
        }

        public int getExcutionStatus() {
            return ExcutionStatus;
        }

        public void setExcutionStatus(int ExcutionStatus) {
            this.ExcutionStatus = ExcutionStatus;
        }

        public String getResult() {
            return Result;
        }

        public void setResult(String Result) {
            this.Result = Result;
        }

        public String getStartDate() {
            return StartDate;
        }

        public void setStartDate(String StartDate) {
            this.StartDate = StartDate;
        }

        public String getEndDate() {
            return EndDate;
        }

        public void setEndDate(String EndDate) {
            this.EndDate = EndDate;
        }

        public int getRequiredResponseHours() {
            return RequiredResponseHours;
        }

        public void setRequiredResponseHours(int RequiredResponseHours) {
            this.RequiredResponseHours = RequiredResponseHours;
        }

        public List<HashMap<String, Integer>> getReference() {
            return Reference;
        }

        public void setReference(List<HashMap<String, Integer>> Reference) {
            this.Reference = Reference;
        }

        public List<Long> getOwnerIDs() {
            return OwnerIDs;
        }

        public void setOwnerIDs(List<Long> OwnerIDs) {
            this.OwnerIDs = OwnerIDs;
        }

        public List<PendingOwnerBean> getOwner() {
            return Owner;
        }

        public void setOwner(List<PendingOwnerBean> Owner) {
            this.Owner = Owner;
        }

        public List<Long> getPendingOwnerIDs() {
            return PendingOwnerIDs;
        }

        public void setPendingOwnerIDs(List<Long> PendingOwnerIDs) {
            this.PendingOwnerIDs = PendingOwnerIDs;
        }

        public List<PendingOwnerBean> getPendingOwner() {
            return PendingOwner;
        }

        public void setPendingOwner(List<PendingOwnerBean> PendingOwner) {
            this.PendingOwner = PendingOwner;
        }

        public List<Long> getCheckListIDs() {
            return CheckListIDs;
        }

        public void setCheckListIDs(List<Long> CheckListIDs) {
            this.CheckListIDs = CheckListIDs;
        }

        public List<CheckListBean> getCheckList() {
            return CheckList;
        }

        public void setCheckList(List<CheckListBean> CheckList) {
            this.CheckList = CheckList;
        }

        public static class GovermentEnforcementSchemeBean {
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
            private String Reason;
            private int Status;
            private int CheckBusinessQuantity;
            private int AndOr;
            private String StarDate;
            private String EndDate;
            private String BusinessExcelFile;
            private int ResponseTimeQuantity;
            private List<HashMap<String, Integer>> Reference;
            private List<Long> CheckListIDs;
            private List<Long> CustomZoneIDs;
            private List<DeparmentPeopleIncludedBean> DeparmentPeopleIncluded;
            private List<Long> BusinessIDs;

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

            public String getReason() {
                return Reason;
            }

            public void setReason(String Reason) {
                this.Reason = Reason;
            }

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
            }

            public int getCheckBusinessQuantity() {
                return CheckBusinessQuantity;
            }

            public void setCheckBusinessQuantity(int CheckBusinessQuantity) {
                this.CheckBusinessQuantity = CheckBusinessQuantity;
            }

            public int getAndOr() {
                return AndOr;
            }

            public void setAndOr(int AndOr) {
                this.AndOr = AndOr;
            }

            public String getStarDate() {
                return StarDate;
            }

            public void setStarDate(String StarDate) {
                this.StarDate = StarDate;
            }

            public String getEndDate() {
                return EndDate;
            }

            public void setEndDate(String EndDate) {
                this.EndDate = EndDate;
            }

            public String getBusinessExcelFile() {
                return BusinessExcelFile;
            }

            public void setBusinessExcelFile(String BusinessExcelFile) {
                this.BusinessExcelFile = BusinessExcelFile;
            }

            public int getResponseTimeQuantity() {
                return ResponseTimeQuantity;
            }

            public void setResponseTimeQuantity(int ResponseTimeQuantity) {
                this.ResponseTimeQuantity = ResponseTimeQuantity;
            }

            public List<HashMap<String, Integer>> getReference() {
                return Reference;
            }

            public void setReference(List<HashMap<String, Integer>> Reference) {
                this.Reference = Reference;
            }

            public List<Long> getCheckListIDs() {
                return CheckListIDs;
            }

            public void setCheckListIDs(List<Long> CheckListIDs) {
                this.CheckListIDs = CheckListIDs;
            }

            public List<Long> getCustomZoneIDs() {
                return CustomZoneIDs;
            }

            public void setCustomZoneIDs(List<Long> CustomZoneIDs) {
                this.CustomZoneIDs = CustomZoneIDs;
            }

            public List<DeparmentPeopleIncludedBean> getDeparmentPeopleIncluded() {
                return DeparmentPeopleIncluded;
            }

            public void setDeparmentPeopleIncluded(List<DeparmentPeopleIncludedBean> DeparmentPeopleIncluded) {
                this.DeparmentPeopleIncluded = DeparmentPeopleIncluded;
            }

            public List<Long> getBusinessIDs() {
                return BusinessIDs;
            }

            public void setBusinessIDs(List<Long> BusinessIDs) {
                this.BusinessIDs = BusinessIDs;
            }

            public static class DeparmentPeopleIncludedBean {
                private long DepartmentID;
                private DepartmentBean Department;
                private int PeopleQuantity;

                public long getDepartmentID() {
                    return DepartmentID;
                }

                public void setDepartmentID(long DepartmentID) {
                    this.DepartmentID = DepartmentID;
                }

                public DepartmentBean getDepartment() {
                    return Department;
                }

                public void setDepartment(DepartmentBean Department) {
                    this.Department = Department;
                }

                public int getPeopleQuantity() {
                    return PeopleQuantity;
                }

                public void setPeopleQuantity(int PeopleQuantity) {
                    this.PeopleQuantity = PeopleQuantity;
                }

                public static class DepartmentBean {
                    private long ID;
                    private long CompanyID;
                    private String Name;
                    private String DepartmentCode;
                    private int ParentID;
                    private Object Parent;
                    private int Status;
                    private int OrganizationType;
                    private long LastModifyByID;
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
                    private List<Long> ParentPath;
                    private List<Long> Labels;
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

                    public long getLastModifyByID() {
                        return LastModifyByID;
                    }

                    public void setLastModifyByID(long LastModifyByID) {
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

                    public List<Long> getParentPath() {
                        return ParentPath;
                    }

                    public void setParentPath(List<Long> ParentPath) {
                        this.ParentPath = ParentPath;
                    }

                    public List<Long> getLabels() {
                        return Labels;
                    }

                    public void setLabels(List<Long> Labels) {
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
            }
        }

        public static class DepartmentBeanX {
            private long ID;
            private long CompanyID;
            private String Name;
            private String DepartmentCode;
            private int ParentID;
            private Object Parent;
            private int Status;
            private int OrganizationType;
            private long LastModifyByID;
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
            private List<Long> ParentPath;
            private List<Long> Labels;
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

            public long getLastModifyByID() {
                return LastModifyByID;
            }

            public void setLastModifyByID(long LastModifyByID) {
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

            public List<Long> getParentPath() {
                return ParentPath;
            }

            public void setParentPath(List<Long> ParentPath) {
                this.ParentPath = ParentPath;
            }

            public List<Long> getLabels() {
                return Labels;
            }

            public void setLabels(List<Long> Labels) {
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

        public static class BusinessBean {
            private int ID;
            private int CompanyID;
            private Object BusinessCode;
            private String BusinessName;
            private int BusinessCompanyID;
            private Object BusinessCompany;
            private int SupplierStatus;
            private int SupplierRelationshipTypeAttrID;
            private Object SupplierRelationshipTypeAttr;
            private int CustomerRelationshipTypeAttrID;
            private Object CustomerRelationshipTypeAttr;
            private int SalesChannelTypeAttrID;
            private Object SalesChannelTypeAttr;
            private int PurchaseChannelTypeAttrID;
            private Object PurchaseChannelTypeAttr;
            private int CustomerStatus;
            private int BusinessRegistrationStatus;
            private String RevkDate;
            private String DOM;
            private String OPFrom;
            private Object RegistrationOrgnization;
            private String ApprDate;
            private int BizAddrLatitude;
            private int BizAddrLongitude;
            private String RegOrg;
            private int Grade;
            private int Score;
            private int BusinessLocalAssociationDepartmentID;
            private int CustomZoneID;
            private Object NameAbbr;
            private int DefaultContactID;
            private int DefaultShippingAddressID;
            private Object DefaultShippingAddress;
            private int OwnerID;
            private Object Owner;
            private int OwnerDepartmentID;
            private Object OwnerDepartment;
            private int SupplierRank;
            private int CustomerRank;
            private int SupplierRankAttrID;
            private Object SupplierRankAttr;
            private int CustomerRankAttrID;
            private Object CustomerRankAttr;
            private int CustomerClassificationAttrID;
            private Object CustomerClassificationAttr;
            private int SupplierClassificationAttrID;
            private Object SupplierClassificationAttr;
            private String Representative;
            private String CreateTime;
            private String LastSupplierAuditTime;
            private String LastCustomerAuditTime;
            private String SupplierAuditExpire;
            private String CustomerAuditExpire;
            private Object BrandRepresent;
            private Object URL;
            private String BusinessLicenseRegistrationNumber;
            private Object TaxRegistrationCertificateNumber;
            private int TaxRate;
            private String BusinessRegistrationTime;
            private Object OrganizationCode;
            private int RegisteredCapital;
            private int RegisteredCurrencyID;
            private Object RegisteredCurrency;
            private String BusinessLicenseExpire;
            private int RegistrationLevelID;
            private Object RegistrationLevel;
            private int ParentCompanyID;
            private Object ParentCompany;
            private String Files;
            private Object Desc;
            private Object AdditionInfo;
            private int CreatorID;
            private Object DF1;
            private Object DF10;
            private Object DF2;
            private Object DF3;
            private Object DF4;
            private Object DF5;
            private Object DF6;
            private Object DF7;
            private Object DF8;
            private Object DF9;
            private int LastModifyByID;
            private int PageCode;
            private String Timestamp;
            private List<?> UnClaimDepartmentIDs;
            private List<Integer> BusinessAreaIDs;
            private List<?> BusinessArea;
            private List<?> ExtraUserIDs;
            private List<?> ExtraUser;
            private List<Integer> ExtraDepartmentIDs;
            private List<?> ExtraDepartment;
            private List<Integer> BusinessTypeIDs;
            private List<?> BusinessType;
            private List<?> WarehouseIDs;
            private List<?> Warehouse;
            private List<?> WarehouseBinIDs;
            private List<?> WarehouseBin;
            private List<?> WarehouseDeliveryRouteIDs;
            private List<?> WarehouseDeliveryRoute;
            private List<?> MainBusinessIDs;
            private List<?> MainBusiness;
            private List<?> AdditionBusinessIDs;
            private List<?> AdditionBusiness;
            private List<?> OperationModeIDs;
            private List<?> OperationMode;
            private List<Integer> IndustryTypeIDs;
            private List<?> IndustryType;
            private List<?> SourceIDs;
            private List<?> Source;
            private List<?> LabelIDs;

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

            public Object getBusinessCode() {
                return BusinessCode;
            }

            public void setBusinessCode(Object BusinessCode) {
                this.BusinessCode = BusinessCode;
            }

            public String getBusinessName() {
                return BusinessName;
            }

            public void setBusinessName(String BusinessName) {
                this.BusinessName = BusinessName;
            }

            public int getBusinessCompanyID() {
                return BusinessCompanyID;
            }

            public void setBusinessCompanyID(int BusinessCompanyID) {
                this.BusinessCompanyID = BusinessCompanyID;
            }

            public Object getBusinessCompany() {
                return BusinessCompany;
            }

            public void setBusinessCompany(Object BusinessCompany) {
                this.BusinessCompany = BusinessCompany;
            }

            public int getSupplierStatus() {
                return SupplierStatus;
            }

            public void setSupplierStatus(int SupplierStatus) {
                this.SupplierStatus = SupplierStatus;
            }

            public int getSupplierRelationshipTypeAttrID() {
                return SupplierRelationshipTypeAttrID;
            }

            public void setSupplierRelationshipTypeAttrID(int SupplierRelationshipTypeAttrID) {
                this.SupplierRelationshipTypeAttrID = SupplierRelationshipTypeAttrID;
            }

            public Object getSupplierRelationshipTypeAttr() {
                return SupplierRelationshipTypeAttr;
            }

            public void setSupplierRelationshipTypeAttr(Object SupplierRelationshipTypeAttr) {
                this.SupplierRelationshipTypeAttr = SupplierRelationshipTypeAttr;
            }

            public int getCustomerRelationshipTypeAttrID() {
                return CustomerRelationshipTypeAttrID;
            }

            public void setCustomerRelationshipTypeAttrID(int CustomerRelationshipTypeAttrID) {
                this.CustomerRelationshipTypeAttrID = CustomerRelationshipTypeAttrID;
            }

            public Object getCustomerRelationshipTypeAttr() {
                return CustomerRelationshipTypeAttr;
            }

            public void setCustomerRelationshipTypeAttr(Object CustomerRelationshipTypeAttr) {
                this.CustomerRelationshipTypeAttr = CustomerRelationshipTypeAttr;
            }

            public int getSalesChannelTypeAttrID() {
                return SalesChannelTypeAttrID;
            }

            public void setSalesChannelTypeAttrID(int SalesChannelTypeAttrID) {
                this.SalesChannelTypeAttrID = SalesChannelTypeAttrID;
            }

            public Object getSalesChannelTypeAttr() {
                return SalesChannelTypeAttr;
            }

            public void setSalesChannelTypeAttr(Object SalesChannelTypeAttr) {
                this.SalesChannelTypeAttr = SalesChannelTypeAttr;
            }

            public int getPurchaseChannelTypeAttrID() {
                return PurchaseChannelTypeAttrID;
            }

            public void setPurchaseChannelTypeAttrID(int PurchaseChannelTypeAttrID) {
                this.PurchaseChannelTypeAttrID = PurchaseChannelTypeAttrID;
            }

            public Object getPurchaseChannelTypeAttr() {
                return PurchaseChannelTypeAttr;
            }

            public void setPurchaseChannelTypeAttr(Object PurchaseChannelTypeAttr) {
                this.PurchaseChannelTypeAttr = PurchaseChannelTypeAttr;
            }

            public int getCustomerStatus() {
                return CustomerStatus;
            }

            public void setCustomerStatus(int CustomerStatus) {
                this.CustomerStatus = CustomerStatus;
            }

            public int getBusinessRegistrationStatus() {
                return BusinessRegistrationStatus;
            }

            public void setBusinessRegistrationStatus(int BusinessRegistrationStatus) {
                this.BusinessRegistrationStatus = BusinessRegistrationStatus;
            }

            public String getRevkDate() {
                return RevkDate;
            }

            public void setRevkDate(String RevkDate) {
                this.RevkDate = RevkDate;
            }

            public String getDOM() {
                return DOM;
            }

            public void setDOM(String DOM) {
                this.DOM = DOM;
            }

            public String getOPFrom() {
                return OPFrom;
            }

            public void setOPFrom(String OPFrom) {
                this.OPFrom = OPFrom;
            }

            public Object getRegistrationOrgnization() {
                return RegistrationOrgnization;
            }

            public void setRegistrationOrgnization(Object RegistrationOrgnization) {
                this.RegistrationOrgnization = RegistrationOrgnization;
            }

            public String getApprDate() {
                return ApprDate;
            }

            public void setApprDate(String ApprDate) {
                this.ApprDate = ApprDate;
            }

            public int getBizAddrLatitude() {
                return BizAddrLatitude;
            }

            public void setBizAddrLatitude(int BizAddrLatitude) {
                this.BizAddrLatitude = BizAddrLatitude;
            }

            public int getBizAddrLongitude() {
                return BizAddrLongitude;
            }

            public void setBizAddrLongitude(int BizAddrLongitude) {
                this.BizAddrLongitude = BizAddrLongitude;
            }

            public String getRegOrg() {
                return RegOrg;
            }

            public void setRegOrg(String RegOrg) {
                this.RegOrg = RegOrg;
            }

            public int getGrade() {
                return Grade;
            }

            public void setGrade(int Grade) {
                this.Grade = Grade;
            }

            public int getScore() {
                return Score;
            }

            public void setScore(int Score) {
                this.Score = Score;
            }

            public int getBusinessLocalAssociationDepartmentID() {
                return BusinessLocalAssociationDepartmentID;
            }

            public void setBusinessLocalAssociationDepartmentID(int BusinessLocalAssociationDepartmentID) {
                this.BusinessLocalAssociationDepartmentID = BusinessLocalAssociationDepartmentID;
            }

            public int getCustomZoneID() {
                return CustomZoneID;
            }

            public void setCustomZoneID(int CustomZoneID) {
                this.CustomZoneID = CustomZoneID;
            }

            public Object getNameAbbr() {
                return NameAbbr;
            }

            public void setNameAbbr(Object NameAbbr) {
                this.NameAbbr = NameAbbr;
            }

            public int getDefaultContactID() {
                return DefaultContactID;
            }

            public void setDefaultContactID(int DefaultContactID) {
                this.DefaultContactID = DefaultContactID;
            }

            public int getDefaultShippingAddressID() {
                return DefaultShippingAddressID;
            }

            public void setDefaultShippingAddressID(int DefaultShippingAddressID) {
                this.DefaultShippingAddressID = DefaultShippingAddressID;
            }

            public Object getDefaultShippingAddress() {
                return DefaultShippingAddress;
            }

            public void setDefaultShippingAddress(Object DefaultShippingAddress) {
                this.DefaultShippingAddress = DefaultShippingAddress;
            }

            public int getOwnerID() {
                return OwnerID;
            }

            public void setOwnerID(int OwnerID) {
                this.OwnerID = OwnerID;
            }

            public Object getOwner() {
                return Owner;
            }

            public void setOwner(Object Owner) {
                this.Owner = Owner;
            }

            public int getOwnerDepartmentID() {
                return OwnerDepartmentID;
            }

            public void setOwnerDepartmentID(int OwnerDepartmentID) {
                this.OwnerDepartmentID = OwnerDepartmentID;
            }

            public Object getOwnerDepartment() {
                return OwnerDepartment;
            }

            public void setOwnerDepartment(Object OwnerDepartment) {
                this.OwnerDepartment = OwnerDepartment;
            }

            public int getSupplierRank() {
                return SupplierRank;
            }

            public void setSupplierRank(int SupplierRank) {
                this.SupplierRank = SupplierRank;
            }

            public int getCustomerRank() {
                return CustomerRank;
            }

            public void setCustomerRank(int CustomerRank) {
                this.CustomerRank = CustomerRank;
            }

            public int getSupplierRankAttrID() {
                return SupplierRankAttrID;
            }

            public void setSupplierRankAttrID(int SupplierRankAttrID) {
                this.SupplierRankAttrID = SupplierRankAttrID;
            }

            public Object getSupplierRankAttr() {
                return SupplierRankAttr;
            }

            public void setSupplierRankAttr(Object SupplierRankAttr) {
                this.SupplierRankAttr = SupplierRankAttr;
            }

            public int getCustomerRankAttrID() {
                return CustomerRankAttrID;
            }

            public void setCustomerRankAttrID(int CustomerRankAttrID) {
                this.CustomerRankAttrID = CustomerRankAttrID;
            }

            public Object getCustomerRankAttr() {
                return CustomerRankAttr;
            }

            public void setCustomerRankAttr(Object CustomerRankAttr) {
                this.CustomerRankAttr = CustomerRankAttr;
            }

            public int getCustomerClassificationAttrID() {
                return CustomerClassificationAttrID;
            }

            public void setCustomerClassificationAttrID(int CustomerClassificationAttrID) {
                this.CustomerClassificationAttrID = CustomerClassificationAttrID;
            }

            public Object getCustomerClassificationAttr() {
                return CustomerClassificationAttr;
            }

            public void setCustomerClassificationAttr(Object CustomerClassificationAttr) {
                this.CustomerClassificationAttr = CustomerClassificationAttr;
            }

            public int getSupplierClassificationAttrID() {
                return SupplierClassificationAttrID;
            }

            public void setSupplierClassificationAttrID(int SupplierClassificationAttrID) {
                this.SupplierClassificationAttrID = SupplierClassificationAttrID;
            }

            public Object getSupplierClassificationAttr() {
                return SupplierClassificationAttr;
            }

            public void setSupplierClassificationAttr(Object SupplierClassificationAttr) {
                this.SupplierClassificationAttr = SupplierClassificationAttr;
            }

            public String getRepresentative() {
                return Representative;
            }

            public void setRepresentative(String Representative) {
                this.Representative = Representative;
            }

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public String getLastSupplierAuditTime() {
                return LastSupplierAuditTime;
            }

            public void setLastSupplierAuditTime(String LastSupplierAuditTime) {
                this.LastSupplierAuditTime = LastSupplierAuditTime;
            }

            public String getLastCustomerAuditTime() {
                return LastCustomerAuditTime;
            }

            public void setLastCustomerAuditTime(String LastCustomerAuditTime) {
                this.LastCustomerAuditTime = LastCustomerAuditTime;
            }

            public String getSupplierAuditExpire() {
                return SupplierAuditExpire;
            }

            public void setSupplierAuditExpire(String SupplierAuditExpire) {
                this.SupplierAuditExpire = SupplierAuditExpire;
            }

            public String getCustomerAuditExpire() {
                return CustomerAuditExpire;
            }

            public void setCustomerAuditExpire(String CustomerAuditExpire) {
                this.CustomerAuditExpire = CustomerAuditExpire;
            }

            public Object getBrandRepresent() {
                return BrandRepresent;
            }

            public void setBrandRepresent(Object BrandRepresent) {
                this.BrandRepresent = BrandRepresent;
            }

            public Object getURL() {
                return URL;
            }

            public void setURL(Object URL) {
                this.URL = URL;
            }

            public String getBusinessLicenseRegistrationNumber() {
                return BusinessLicenseRegistrationNumber;
            }

            public void setBusinessLicenseRegistrationNumber(String BusinessLicenseRegistrationNumber) {
                this.BusinessLicenseRegistrationNumber = BusinessLicenseRegistrationNumber;
            }

            public Object getTaxRegistrationCertificateNumber() {
                return TaxRegistrationCertificateNumber;
            }

            public void setTaxRegistrationCertificateNumber(Object TaxRegistrationCertificateNumber) {
                this.TaxRegistrationCertificateNumber = TaxRegistrationCertificateNumber;
            }

            public int getTaxRate() {
                return TaxRate;
            }

            public void setTaxRate(int TaxRate) {
                this.TaxRate = TaxRate;
            }

            public String getBusinessRegistrationTime() {
                return BusinessRegistrationTime;
            }

            public void setBusinessRegistrationTime(String BusinessRegistrationTime) {
                this.BusinessRegistrationTime = BusinessRegistrationTime;
            }

            public Object getOrganizationCode() {
                return OrganizationCode;
            }

            public void setOrganizationCode(Object OrganizationCode) {
                this.OrganizationCode = OrganizationCode;
            }

            public int getRegisteredCapital() {
                return RegisteredCapital;
            }

            public void setRegisteredCapital(int RegisteredCapital) {
                this.RegisteredCapital = RegisteredCapital;
            }

            public int getRegisteredCurrencyID() {
                return RegisteredCurrencyID;
            }

            public void setRegisteredCurrencyID(int RegisteredCurrencyID) {
                this.RegisteredCurrencyID = RegisteredCurrencyID;
            }

            public Object getRegisteredCurrency() {
                return RegisteredCurrency;
            }

            public void setRegisteredCurrency(Object RegisteredCurrency) {
                this.RegisteredCurrency = RegisteredCurrency;
            }

            public String getBusinessLicenseExpire() {
                return BusinessLicenseExpire;
            }

            public void setBusinessLicenseExpire(String BusinessLicenseExpire) {
                this.BusinessLicenseExpire = BusinessLicenseExpire;
            }

            public int getRegistrationLevelID() {
                return RegistrationLevelID;
            }

            public void setRegistrationLevelID(int RegistrationLevelID) {
                this.RegistrationLevelID = RegistrationLevelID;
            }

            public Object getRegistrationLevel() {
                return RegistrationLevel;
            }

            public void setRegistrationLevel(Object RegistrationLevel) {
                this.RegistrationLevel = RegistrationLevel;
            }

            public int getParentCompanyID() {
                return ParentCompanyID;
            }

            public void setParentCompanyID(int ParentCompanyID) {
                this.ParentCompanyID = ParentCompanyID;
            }

            public Object getParentCompany() {
                return ParentCompany;
            }

            public void setParentCompany(Object ParentCompany) {
                this.ParentCompany = ParentCompany;
            }

            public String getFiles() {
                return Files;
            }

            public void setFiles(String Files) {
                this.Files = Files;
            }

            public Object getDesc() {
                return Desc;
            }

            public void setDesc(Object Desc) {
                this.Desc = Desc;
            }

            public Object getAdditionInfo() {
                return AdditionInfo;
            }

            public void setAdditionInfo(Object AdditionInfo) {
                this.AdditionInfo = AdditionInfo;
            }

            public int getCreatorID() {
                return CreatorID;
            }

            public void setCreatorID(int CreatorID) {
                this.CreatorID = CreatorID;
            }

            public Object getDF1() {
                return DF1;
            }

            public void setDF1(Object DF1) {
                this.DF1 = DF1;
            }

            public Object getDF10() {
                return DF10;
            }

            public void setDF10(Object DF10) {
                this.DF10 = DF10;
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

            public int getLastModifyByID() {
                return LastModifyByID;
            }

            public void setLastModifyByID(int LastModifyByID) {
                this.LastModifyByID = LastModifyByID;
            }

            public int getPageCode() {
                return PageCode;
            }

            public void setPageCode(int PageCode) {
                this.PageCode = PageCode;
            }

            public String getTimestamp() {
                return Timestamp;
            }

            public void setTimestamp(String Timestamp) {
                this.Timestamp = Timestamp;
            }

            public List<?> getUnClaimDepartmentIDs() {
                return UnClaimDepartmentIDs;
            }

            public void setUnClaimDepartmentIDs(List<?> UnClaimDepartmentIDs) {
                this.UnClaimDepartmentIDs = UnClaimDepartmentIDs;
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

            public List<?> getExtraUserIDs() {
                return ExtraUserIDs;
            }

            public void setExtraUserIDs(List<?> ExtraUserIDs) {
                this.ExtraUserIDs = ExtraUserIDs;
            }

            public List<?> getExtraUser() {
                return ExtraUser;
            }

            public void setExtraUser(List<?> ExtraUser) {
                this.ExtraUser = ExtraUser;
            }

            public List<Integer> getExtraDepartmentIDs() {
                return ExtraDepartmentIDs;
            }

            public void setExtraDepartmentIDs(List<Integer> ExtraDepartmentIDs) {
                this.ExtraDepartmentIDs = ExtraDepartmentIDs;
            }

            public List<?> getExtraDepartment() {
                return ExtraDepartment;
            }

            public void setExtraDepartment(List<?> ExtraDepartment) {
                this.ExtraDepartment = ExtraDepartment;
            }

            public List<Integer> getBusinessTypeIDs() {
                return BusinessTypeIDs;
            }

            public void setBusinessTypeIDs(List<Integer> BusinessTypeIDs) {
                this.BusinessTypeIDs = BusinessTypeIDs;
            }

            public List<?> getBusinessType() {
                return BusinessType;
            }

            public void setBusinessType(List<?> BusinessType) {
                this.BusinessType = BusinessType;
            }

            public List<?> getWarehouseIDs() {
                return WarehouseIDs;
            }

            public void setWarehouseIDs(List<?> WarehouseIDs) {
                this.WarehouseIDs = WarehouseIDs;
            }

            public List<?> getWarehouse() {
                return Warehouse;
            }

            public void setWarehouse(List<?> Warehouse) {
                this.Warehouse = Warehouse;
            }

            public List<?> getWarehouseBinIDs() {
                return WarehouseBinIDs;
            }

            public void setWarehouseBinIDs(List<?> WarehouseBinIDs) {
                this.WarehouseBinIDs = WarehouseBinIDs;
            }

            public List<?> getWarehouseBin() {
                return WarehouseBin;
            }

            public void setWarehouseBin(List<?> WarehouseBin) {
                this.WarehouseBin = WarehouseBin;
            }

            public List<?> getWarehouseDeliveryRouteIDs() {
                return WarehouseDeliveryRouteIDs;
            }

            public void setWarehouseDeliveryRouteIDs(List<?> WarehouseDeliveryRouteIDs) {
                this.WarehouseDeliveryRouteIDs = WarehouseDeliveryRouteIDs;
            }

            public List<?> getWarehouseDeliveryRoute() {
                return WarehouseDeliveryRoute;
            }

            public void setWarehouseDeliveryRoute(List<?> WarehouseDeliveryRoute) {
                this.WarehouseDeliveryRoute = WarehouseDeliveryRoute;
            }

            public List<?> getMainBusinessIDs() {
                return MainBusinessIDs;
            }

            public void setMainBusinessIDs(List<?> MainBusinessIDs) {
                this.MainBusinessIDs = MainBusinessIDs;
            }

            public List<?> getMainBusiness() {
                return MainBusiness;
            }

            public void setMainBusiness(List<?> MainBusiness) {
                this.MainBusiness = MainBusiness;
            }

            public List<?> getAdditionBusinessIDs() {
                return AdditionBusinessIDs;
            }

            public void setAdditionBusinessIDs(List<?> AdditionBusinessIDs) {
                this.AdditionBusinessIDs = AdditionBusinessIDs;
            }

            public List<?> getAdditionBusiness() {
                return AdditionBusiness;
            }

            public void setAdditionBusiness(List<?> AdditionBusiness) {
                this.AdditionBusiness = AdditionBusiness;
            }

            public List<?> getOperationModeIDs() {
                return OperationModeIDs;
            }

            public void setOperationModeIDs(List<?> OperationModeIDs) {
                this.OperationModeIDs = OperationModeIDs;
            }

            public List<?> getOperationMode() {
                return OperationMode;
            }

            public void setOperationMode(List<?> OperationMode) {
                this.OperationMode = OperationMode;
            }

            public List<Integer> getIndustryTypeIDs() {
                return IndustryTypeIDs;
            }

            public void setIndustryTypeIDs(List<Integer> IndustryTypeIDs) {
                this.IndustryTypeIDs = IndustryTypeIDs;
            }

            public List<?> getIndustryType() {
                return IndustryType;
            }

            public void setIndustryType(List<?> IndustryType) {
                this.IndustryType = IndustryType;
            }

            public List<?> getSourceIDs() {
                return SourceIDs;
            }

            public void setSourceIDs(List<?> SourceIDs) {
                this.SourceIDs = SourceIDs;
            }

            public List<?> getSource() {
                return Source;
            }

            public void setSource(List<?> Source) {
                this.Source = Source;
            }

            public List<?> getLabelIDs() {
                return LabelIDs;
            }

            public void setLabelIDs(List<?> LabelIDs) {
                this.LabelIDs = LabelIDs;
            }
        }

        public static class PendingOwnerBean {

            private String Desc;
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
            private List<Long> RoleIDs;
            private List<?> Role;
            private List<Integer> DepartmentIDs;
            private List<?> Department;
            private List<?> GroupIDs;
            private List<?> Group;
            private List<?> LabelIDs;
            private List<?> SessionInfo;

            public String getDesc() {
                return Desc;
            }

            public void setDesc(String Desc) {
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

            public List<Long> getRoleIDs() {
                return RoleIDs;
            }

            public void setRoleIDs(List<Long> RoleIDs) {
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

        public static class CheckListBean {
            /**
             * ID : 4
             * Code : 00004
             * Reference : []
             * CompanyID : 4578
             * Note :
             * LastModifyByID : 10423
             * Timestamp : /Date(1587693429992)/
             * AdditionInfo :
             * Files : 4578|CloudEasy.ERP.BL.Model.Government.CheckList|CloudEasy.ERP.BL.Model.Government.CheckList_20200424_8af17f682c654b618b76f1d96f5bc849|
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
             * CreateTime : /Date(1587693051575)/
             * CreatorID : 10423
             * PageCode : 0
             * VirtualFieldsCache : null
             * Name : 检查公司是否有漏税情况
             * DepartmentIDs : [913]
             * Department : []
             * IndustryTypeIDs : [1428]
             * IndustryType : []
             * Frequency : 1
             * FrequencyQuantity : 2
             * Percentage : 12
             * FreeTradeZonePriviledgeIDs : [9]
             * FreeTradeZonePriviledge : []
             * ProvincialPriviledgeIDs : [7]
             * ProvincialPriviledge : []
             * JointDisciplinaryInfoIDs : []
             * JointDisciplinaryInfo : []
             * LicensePenaltyInformationIDs : []
             * LicensePenaltyInformation : []
             * CoRegulateMeasuresIDs : []
             * CoRegulateMeasures : []
             * BusinessRegistrationIDs : [13]
             * BusinessRegistration : []
             * MarketEntryAndAppointmentIDs : [12]
             * MarketEntryAndAppointment : []
             */

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
            private int PageCode;
            private Object VirtualFieldsCache;
            private String Name;
            private int Frequency;
            private int FrequencyQuantity;
            private int Percentage;
            private List<?> Reference;
            private List<Integer> DepartmentIDs;
            private List<?> Department;
            private List<Integer> IndustryTypeIDs;
            private List<?> IndustryType;
            private List<Integer> FreeTradeZonePriviledgeIDs;
            private List<?> FreeTradeZonePriviledge;
            private List<Integer> ProvincialPriviledgeIDs;
            private List<?> ProvincialPriviledge;
            private List<?> JointDisciplinaryInfoIDs;
            private List<?> JointDisciplinaryInfo;
            private List<?> LicensePenaltyInformationIDs;
            private List<?> LicensePenaltyInformation;
            private List<?> CoRegulateMeasuresIDs;
            private List<?> CoRegulateMeasures;
            private List<Integer> BusinessRegistrationIDs;
            private List<?> BusinessRegistration;
            private List<Integer> MarketEntryAndAppointmentIDs;
            private List<?> MarketEntryAndAppointment;

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

            public int getPageCode() {
                return PageCode;
            }

            public void setPageCode(int PageCode) {
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

            public int getFrequency() {
                return Frequency;
            }

            public void setFrequency(int Frequency) {
                this.Frequency = Frequency;
            }

            public int getFrequencyQuantity() {
                return FrequencyQuantity;
            }

            public void setFrequencyQuantity(int FrequencyQuantity) {
                this.FrequencyQuantity = FrequencyQuantity;
            }

            public int getPercentage() {
                return Percentage;
            }

            public void setPercentage(int Percentage) {
                this.Percentage = Percentage;
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

            public List<?> getDepartment() {
                return Department;
            }

            public void setDepartment(List<?> Department) {
                this.Department = Department;
            }

            public List<Integer> getIndustryTypeIDs() {
                return IndustryTypeIDs;
            }

            public void setIndustryTypeIDs(List<Integer> IndustryTypeIDs) {
                this.IndustryTypeIDs = IndustryTypeIDs;
            }

            public List<?> getIndustryType() {
                return IndustryType;
            }

            public void setIndustryType(List<?> IndustryType) {
                this.IndustryType = IndustryType;
            }

            public List<Integer> getFreeTradeZonePriviledgeIDs() {
                return FreeTradeZonePriviledgeIDs;
            }

            public void setFreeTradeZonePriviledgeIDs(List<Integer> FreeTradeZonePriviledgeIDs) {
                this.FreeTradeZonePriviledgeIDs = FreeTradeZonePriviledgeIDs;
            }

            public List<?> getFreeTradeZonePriviledge() {
                return FreeTradeZonePriviledge;
            }

            public void setFreeTradeZonePriviledge(List<?> FreeTradeZonePriviledge) {
                this.FreeTradeZonePriviledge = FreeTradeZonePriviledge;
            }

            public List<Integer> getProvincialPriviledgeIDs() {
                return ProvincialPriviledgeIDs;
            }

            public void setProvincialPriviledgeIDs(List<Integer> ProvincialPriviledgeIDs) {
                this.ProvincialPriviledgeIDs = ProvincialPriviledgeIDs;
            }

            public List<?> getProvincialPriviledge() {
                return ProvincialPriviledge;
            }

            public void setProvincialPriviledge(List<?> ProvincialPriviledge) {
                this.ProvincialPriviledge = ProvincialPriviledge;
            }

            public List<?> getJointDisciplinaryInfoIDs() {
                return JointDisciplinaryInfoIDs;
            }

            public void setJointDisciplinaryInfoIDs(List<?> JointDisciplinaryInfoIDs) {
                this.JointDisciplinaryInfoIDs = JointDisciplinaryInfoIDs;
            }

            public List<?> getJointDisciplinaryInfo() {
                return JointDisciplinaryInfo;
            }

            public void setJointDisciplinaryInfo(List<?> JointDisciplinaryInfo) {
                this.JointDisciplinaryInfo = JointDisciplinaryInfo;
            }

            public List<?> getLicensePenaltyInformationIDs() {
                return LicensePenaltyInformationIDs;
            }

            public void setLicensePenaltyInformationIDs(List<?> LicensePenaltyInformationIDs) {
                this.LicensePenaltyInformationIDs = LicensePenaltyInformationIDs;
            }

            public List<?> getLicensePenaltyInformation() {
                return LicensePenaltyInformation;
            }

            public void setLicensePenaltyInformation(List<?> LicensePenaltyInformation) {
                this.LicensePenaltyInformation = LicensePenaltyInformation;
            }

            public List<?> getCoRegulateMeasuresIDs() {
                return CoRegulateMeasuresIDs;
            }

            public void setCoRegulateMeasuresIDs(List<?> CoRegulateMeasuresIDs) {
                this.CoRegulateMeasuresIDs = CoRegulateMeasuresIDs;
            }

            public List<?> getCoRegulateMeasures() {
                return CoRegulateMeasures;
            }

            public void setCoRegulateMeasures(List<?> CoRegulateMeasures) {
                this.CoRegulateMeasures = CoRegulateMeasures;
            }

            public List<Integer> getBusinessRegistrationIDs() {
                return BusinessRegistrationIDs;
            }

            public void setBusinessRegistrationIDs(List<Integer> BusinessRegistrationIDs) {
                this.BusinessRegistrationIDs = BusinessRegistrationIDs;
            }

            public List<?> getBusinessRegistration() {
                return BusinessRegistration;
            }

            public void setBusinessRegistration(List<?> BusinessRegistration) {
                this.BusinessRegistration = BusinessRegistration;
            }

            public List<Integer> getMarketEntryAndAppointmentIDs() {
                return MarketEntryAndAppointmentIDs;
            }

            public void setMarketEntryAndAppointmentIDs(List<Integer> MarketEntryAndAppointmentIDs) {
                this.MarketEntryAndAppointmentIDs = MarketEntryAndAppointmentIDs;
            }

            public List<?> getMarketEntryAndAppointment() {
                return MarketEntryAndAppointment;
            }

            public void setMarketEntryAndAppointment(List<?> MarketEntryAndAppointment) {
                this.MarketEntryAndAppointment = MarketEntryAndAppointment;
            }
        }
    }
}
