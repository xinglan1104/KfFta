package com.xl.kffta.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author created by zhanghaochen
 * @date 2020-05-20 11:34
 * 描述：事件清单实例类
 */
public class CheckListBean implements Serializable {
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
        private String Files;
        private String CreateTime;
        private int CreatorID;
        private int PageCode;
        private String Name;
        private int Frequency;
        private int FrequencyQuantity;
        private int Percentage;
        private List<Integer> DepartmentIDs;
        private List<DepartmentBean> Department;
        private List<Integer> FreeTradeZonePriviledgeIDs;
        private List<FreeTradeZonePriviledgeBean> FreeTradeZonePriviledge;
        private List<Integer> ProvincialPriviledgeIDs;
        private List<ProvincialPriviledgeBean> ProvincialPriviledge;
        private List<Integer> BusinessRegistrationIDs;
        private List<BusinessRegistrationBean> BusinessRegistration;
        private List<Integer> MarketEntryAndAppointmentIDs;
        private List<MarketEntryAndAppointmentBean> MarketEntryAndAppointment;

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

        public String getFiles() {
            return Files;
        }

        public void setFiles(String Files) {
            this.Files = Files;
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

        public List<Integer> getFreeTradeZonePriviledgeIDs() {
            return FreeTradeZonePriviledgeIDs;
        }

        public void setFreeTradeZonePriviledgeIDs(List<Integer> FreeTradeZonePriviledgeIDs) {
            this.FreeTradeZonePriviledgeIDs = FreeTradeZonePriviledgeIDs;
        }

        public List<FreeTradeZonePriviledgeBean> getFreeTradeZonePriviledge() {
            return FreeTradeZonePriviledge;
        }

        public void setFreeTradeZonePriviledge(List<FreeTradeZonePriviledgeBean> FreeTradeZonePriviledge) {
            this.FreeTradeZonePriviledge = FreeTradeZonePriviledge;
        }

        public List<Integer> getProvincialPriviledgeIDs() {
            return ProvincialPriviledgeIDs;
        }

        public void setProvincialPriviledgeIDs(List<Integer> ProvincialPriviledgeIDs) {
            this.ProvincialPriviledgeIDs = ProvincialPriviledgeIDs;
        }

        public List<ProvincialPriviledgeBean> getProvincialPriviledge() {
            return ProvincialPriviledge;
        }

        public void setProvincialPriviledge(List<ProvincialPriviledgeBean> ProvincialPriviledge) {
            this.ProvincialPriviledge = ProvincialPriviledge;
        }

        public List<Integer> getBusinessRegistrationIDs() {
            return BusinessRegistrationIDs;
        }

        public void setBusinessRegistrationIDs(List<Integer> BusinessRegistrationIDs) {
            this.BusinessRegistrationIDs = BusinessRegistrationIDs;
        }

        public List<BusinessRegistrationBean> getBusinessRegistration() {
            return BusinessRegistration;
        }

        public void setBusinessRegistration(List<BusinessRegistrationBean> BusinessRegistration) {
            this.BusinessRegistration = BusinessRegistration;
        }

        public List<Integer> getMarketEntryAndAppointmentIDs() {
            return MarketEntryAndAppointmentIDs;
        }

        public void setMarketEntryAndAppointmentIDs(List<Integer> MarketEntryAndAppointmentIDs) {
            this.MarketEntryAndAppointmentIDs = MarketEntryAndAppointmentIDs;
        }

        public List<MarketEntryAndAppointmentBean> getMarketEntryAndAppointment() {
            return MarketEntryAndAppointment;
        }

        public void setMarketEntryAndAppointment(List<MarketEntryAndAppointmentBean> MarketEntryAndAppointment) {
            this.MarketEntryAndAppointment = MarketEntryAndAppointment;
        }

        public static class DepartmentBean {
            /**
             * ID : 913
             * CompanyID : 4578
             * Name : 法制科
             * DepartmentCode : 000000008
             * ParentID : 0
             * Parent : null
             * ParentPath : [0,913]
             * Status : 1
             * OrganizationType : 0
             * LastModifyByID : 10423
             * Timestamp : /Date(1588919517136)/
             * Labels : []
             * DepartmentManagerIDs : []
             * DepartmentManager : []
             * ColorCode : null
             * PageCode : 0
             * BusinessAreaIDs : [1432]
             * BusinessArea : []
             * CreatorID : 10423
             * CreateTime : /Date(1587433081038)/
             * AdditionInfo : null
             * DF1 : 李伟
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

        public static class IndustryTypeBean {
            /**
             * ID : 1428
             * AttrID : 1428
             * CompanyID : 4578
             * Name : 房地产
             * AttrType : 12
             * Status : 1
             * R1 : null
             * R2 : null
             * Parent : null
             * ParentID : 0
             * ParentPath : [0,1428]
             * AdditionInfo : null
             * CreateTime : /Date(1587445775017)/
             * CreatorID : 10423
             * DF1 : null
             * DF10 : null
             * DF2 : null
             * DF3 : null
             * DF4 : null
             * DF5 : null
             * DF6 : null
             * DF7 : null
             * DF8 : null
             * DF9 : null
             * LastModifyByID : 10423
             * PageCode : 0
             * Timestamp : /Date(1587445775017)/
             */

            private int ID;
            private int AttrID;
            private int CompanyID;
            private String Name;
            private int AttrType;
            private int Status;
            private Object R1;
            private Object R2;
            private Object Parent;
            private int ParentID;
            private Object AdditionInfo;
            private String CreateTime;
            private int CreatorID;
            private int LastModifyByID;
            private int PageCode;
            private String Timestamp;
            private List<Integer> ParentPath;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public int getAttrID() {
                return AttrID;
            }

            public void setAttrID(int AttrID) {
                this.AttrID = AttrID;
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

            public int getAttrType() {
                return AttrType;
            }

            public void setAttrType(int AttrType) {
                this.AttrType = AttrType;
            }

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
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

            public Object getParent() {
                return Parent;
            }

            public void setParent(Object Parent) {
                this.Parent = Parent;
            }

            public int getParentID() {
                return ParentID;
            }

            public void setParentID(int ParentID) {
                this.ParentID = ParentID;
            }

            public Object getAdditionInfo() {
                return AdditionInfo;
            }

            public void setAdditionInfo(Object AdditionInfo) {
                this.AdditionInfo = AdditionInfo;
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

            public List<Integer> getParentPath() {
                return ParentPath;
            }

            public void setParentPath(List<Integer> ParentPath) {
                this.ParentPath = ParentPath;
            }
        }

        public static class FreeTradeZonePriviledgeBean {
            /**
             * ID : 9
             * Code :
             * Reference : []
             * CompanyID : 4578
             * Note : 根据园区发展定位和需求精准放权
             * LastModifyByID : 10423
             * Timestamp : /Date(1587457002106)/
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
             * CreateTime : /Date(1587437737601)/
             * CreatorID : 10423
             * PageCode : 126
             * VirtualFieldsCache : null
             * Name : 研究下放或委托重点园区管理机构行使省级管理权限事项清单
             * DepartmentIDs : [913]
             * Department : []
             * ImplementationDepartmentIDs : [908]
             * ImplementationDepartment : []
             * LegalBasis :
             * Priviledge : 园区说了算、有权能定事
             * Reason : 坚持不拘形式，要加大放权力度，充分发挥园区的作用，坚持能放则放，研究第二批放权清单，让园区说了算，就进一步提高思想认识、完善下放或委托事项清单、权限下放方式、加强工作衔接等进行研究，园区要按照谁审批谁监管的要求做好监管工作，。
             * Penalties :
             * BusinessID : 0
             * Business : null
             * SourceDepartmentID : 0
             * ReceiveDepartmentID : 0
             * SentDepartmentID : 0
             * PersonnelType :
             * IDType :
             * IDNumber :
             * LegalDescription :
             * StartDate : /Date(-62135596800000)/
             * EndDate : /Date(-62135596800000)/
             * CollectionDate : /Date(-62135596800000)/
             * CollectionOrg :
             */

            private int ID;
            private String Code;
            private int CompanyID;
            private String Note;
            private int LastModifyByID;
            private String Timestamp;
            private String AdditionInfo;
            private String Files;
            private String CreateTime;
            private int CreatorID;
            private int PageCode;
            private Object VirtualFieldsCache;
            private String Name;
            private String LegalBasis;
            private String Priviledge;
            private String Reason;
            private String Penalties;
            private int BusinessID;
            private Object Business;
            private int SourceDepartmentID;
            private int ReceiveDepartmentID;
            private int SentDepartmentID;
            private String PersonnelType;
            private String IDType;
            private String IDNumber;
            private String LegalDescription;
            private String StartDate;
            private String EndDate;
            private String CollectionDate;
            private String CollectionOrg;
            private List<?> Reference;
            private List<Integer> DepartmentIDs;
            private List<?> Department;
            private List<Integer> ImplementationDepartmentIDs;
            private List<?> ImplementationDepartment;

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

            public String getLegalBasis() {
                return LegalBasis;
            }

            public void setLegalBasis(String LegalBasis) {
                this.LegalBasis = LegalBasis;
            }

            public String getPriviledge() {
                return Priviledge;
            }

            public void setPriviledge(String Priviledge) {
                this.Priviledge = Priviledge;
            }

            public String getReason() {
                return Reason;
            }

            public void setReason(String Reason) {
                this.Reason = Reason;
            }

            public String getPenalties() {
                return Penalties;
            }

            public void setPenalties(String Penalties) {
                this.Penalties = Penalties;
            }

            public int getBusinessID() {
                return BusinessID;
            }

            public void setBusinessID(int BusinessID) {
                this.BusinessID = BusinessID;
            }

            public Object getBusiness() {
                return Business;
            }

            public void setBusiness(Object Business) {
                this.Business = Business;
            }

            public int getSourceDepartmentID() {
                return SourceDepartmentID;
            }

            public void setSourceDepartmentID(int SourceDepartmentID) {
                this.SourceDepartmentID = SourceDepartmentID;
            }

            public int getReceiveDepartmentID() {
                return ReceiveDepartmentID;
            }

            public void setReceiveDepartmentID(int ReceiveDepartmentID) {
                this.ReceiveDepartmentID = ReceiveDepartmentID;
            }

            public int getSentDepartmentID() {
                return SentDepartmentID;
            }

            public void setSentDepartmentID(int SentDepartmentID) {
                this.SentDepartmentID = SentDepartmentID;
            }

            public String getPersonnelType() {
                return PersonnelType;
            }

            public void setPersonnelType(String PersonnelType) {
                this.PersonnelType = PersonnelType;
            }

            public String getIDType() {
                return IDType;
            }

            public void setIDType(String IDType) {
                this.IDType = IDType;
            }

            public String getIDNumber() {
                return IDNumber;
            }

            public void setIDNumber(String IDNumber) {
                this.IDNumber = IDNumber;
            }

            public String getLegalDescription() {
                return LegalDescription;
            }

            public void setLegalDescription(String LegalDescription) {
                this.LegalDescription = LegalDescription;
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

            public String getCollectionDate() {
                return CollectionDate;
            }

            public void setCollectionDate(String CollectionDate) {
                this.CollectionDate = CollectionDate;
            }

            public String getCollectionOrg() {
                return CollectionOrg;
            }

            public void setCollectionOrg(String CollectionOrg) {
                this.CollectionOrg = CollectionOrg;
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

            public List<Integer> getImplementationDepartmentIDs() {
                return ImplementationDepartmentIDs;
            }

            public void setImplementationDepartmentIDs(List<Integer> ImplementationDepartmentIDs) {
                this.ImplementationDepartmentIDs = ImplementationDepartmentIDs;
            }

            public List<?> getImplementationDepartment() {
                return ImplementationDepartment;
            }

            public void setImplementationDepartment(List<?> ImplementationDepartment) {
                this.ImplementationDepartment = ImplementationDepartment;
            }
        }

        public static class ProvincialPriviledgeBean {
            /**
             * ID : 7
             * Code :
             * Reference : []
             * CompanyID : 4578
             * Note : 无
             * LastModifyByID : 10423
             * Timestamp : /Date(1587456059357)/
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
             * CreateTime : /Date(1587436820162)/
             * CreatorID : 10423
             * PageCode : 127
             * VirtualFieldsCache : null
             * Name : 下放权限到园区
             * DepartmentIDs : [912,913]
             * Department : []
             * ImplementationDepartmentIDs : [908]
             * ImplementationDepartment : []
             * LegalBasis :
             * Priviledge : 灵活下放
             * Reason : 坚持放管结合，园区要按照谁审批谁监管的要求做好监管工作
             * Penalties :
             * BusinessID : 0
             * Business : null
             * SourceDepartmentID : 0
             * ReceiveDepartmentID : 0
             * SentDepartmentID : 0
             * PersonnelType :
             * IDType :
             * IDNumber :
             * LegalDescription :
             * StartDate : /Date(-62135596800000)/
             * EndDate : /Date(-62135596800000)/
             * CollectionDate : /Date(-62135596800000)/
             * CollectionOrg :
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
            private String LegalBasis;
            private String Priviledge;
            private String Reason;
            private String Penalties;
            private int BusinessID;
            private Object Business;
            private int SourceDepartmentID;
            private int ReceiveDepartmentID;
            private int SentDepartmentID;
            private String PersonnelType;
            private String IDType;
            private String IDNumber;
            private String LegalDescription;
            private String StartDate;
            private String EndDate;
            private String CollectionDate;
            private String CollectionOrg;
            private List<?> Reference;
            private List<Integer> DepartmentIDs;
            private List<?> Department;
            private List<Integer> ImplementationDepartmentIDs;
            private List<?> ImplementationDepartment;

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

            public String getLegalBasis() {
                return LegalBasis;
            }

            public void setLegalBasis(String LegalBasis) {
                this.LegalBasis = LegalBasis;
            }

            public String getPriviledge() {
                return Priviledge;
            }

            public void setPriviledge(String Priviledge) {
                this.Priviledge = Priviledge;
            }

            public String getReason() {
                return Reason;
            }

            public void setReason(String Reason) {
                this.Reason = Reason;
            }

            public String getPenalties() {
                return Penalties;
            }

            public void setPenalties(String Penalties) {
                this.Penalties = Penalties;
            }

            public int getBusinessID() {
                return BusinessID;
            }

            public void setBusinessID(int BusinessID) {
                this.BusinessID = BusinessID;
            }

            public Object getBusiness() {
                return Business;
            }

            public void setBusiness(Object Business) {
                this.Business = Business;
            }

            public int getSourceDepartmentID() {
                return SourceDepartmentID;
            }

            public void setSourceDepartmentID(int SourceDepartmentID) {
                this.SourceDepartmentID = SourceDepartmentID;
            }

            public int getReceiveDepartmentID() {
                return ReceiveDepartmentID;
            }

            public void setReceiveDepartmentID(int ReceiveDepartmentID) {
                this.ReceiveDepartmentID = ReceiveDepartmentID;
            }

            public int getSentDepartmentID() {
                return SentDepartmentID;
            }

            public void setSentDepartmentID(int SentDepartmentID) {
                this.SentDepartmentID = SentDepartmentID;
            }

            public String getPersonnelType() {
                return PersonnelType;
            }

            public void setPersonnelType(String PersonnelType) {
                this.PersonnelType = PersonnelType;
            }

            public String getIDType() {
                return IDType;
            }

            public void setIDType(String IDType) {
                this.IDType = IDType;
            }

            public String getIDNumber() {
                return IDNumber;
            }

            public void setIDNumber(String IDNumber) {
                this.IDNumber = IDNumber;
            }

            public String getLegalDescription() {
                return LegalDescription;
            }

            public void setLegalDescription(String LegalDescription) {
                this.LegalDescription = LegalDescription;
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

            public String getCollectionDate() {
                return CollectionDate;
            }

            public void setCollectionDate(String CollectionDate) {
                this.CollectionDate = CollectionDate;
            }

            public String getCollectionOrg() {
                return CollectionOrg;
            }

            public void setCollectionOrg(String CollectionOrg) {
                this.CollectionOrg = CollectionOrg;
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

            public List<Integer> getImplementationDepartmentIDs() {
                return ImplementationDepartmentIDs;
            }

            public void setImplementationDepartmentIDs(List<Integer> ImplementationDepartmentIDs) {
                this.ImplementationDepartmentIDs = ImplementationDepartmentIDs;
            }

            public List<?> getImplementationDepartment() {
                return ImplementationDepartment;
            }

            public void setImplementationDepartment(List<?> ImplementationDepartment) {
                this.ImplementationDepartment = ImplementationDepartment;
            }
        }

        public static class BusinessRegistrationBean {
            /**
             * ID : 13
             * Code :
             * Reference : []
             * CompanyID : 4578
             * Note :
             * LastModifyByID : 10423
             * Timestamp : /Date(1587456814923)/
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
             * CreateTime : /Date(1587439516614)/
             * CreatorID : 10423
             * PageCode : 133
             * VirtualFieldsCache : null
             * Name : 公司登记
             * DepartmentIDs : []
             * Department : []
             * ImplementationDepartmentIDs : []
             * ImplementationDepartment : []
             * LegalBasis : 根据公司法第六条 公司登记 设立公司，应当依法向公司登记机关申请设立登记。符合本法规定的设立条件的，由公司登记机关分别登记为有限责任公司或者股份有限公司；不符合本法规定的设立条件的，不得登记为有限责任公司或者股份有限公司。 法律、行政法规规定设立公司必须报经批准的，应当在公司登记前依法办理批准手续。 公众可以向公司登记机关申请查询公司登记事项，公司登记机关应当提供查询服务。
             * Priviledge :
             * Reason :
             * Penalties :
             * BusinessID : 0
             * Business : null
             * SourceDepartmentID : 0
             * ReceiveDepartmentID : 0
             * SentDepartmentID : 0
             * PersonnelType :
             * IDType :
             * IDNumber :
             * LegalDescription :
             * StartDate : /Date(-62135596800000)/
             * EndDate : /Date(-62135596800000)/
             * CollectionDate : /Date(-62135596800000)/
             * CollectionOrg :
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
            private String LegalBasis;
            private String Priviledge;
            private String Reason;
            private String Penalties;
            private int BusinessID;
            private Object Business;
            private int SourceDepartmentID;
            private int ReceiveDepartmentID;
            private int SentDepartmentID;
            private String PersonnelType;
            private String IDType;
            private String IDNumber;
            private String LegalDescription;
            private String StartDate;
            private String EndDate;
            private String CollectionDate;
            private String CollectionOrg;
            private List<?> Reference;
            private List<?> DepartmentIDs;
            private List<?> Department;
            private List<?> ImplementationDepartmentIDs;
            private List<?> ImplementationDepartment;

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

            public String getLegalBasis() {
                return LegalBasis;
            }

            public void setLegalBasis(String LegalBasis) {
                this.LegalBasis = LegalBasis;
            }

            public String getPriviledge() {
                return Priviledge;
            }

            public void setPriviledge(String Priviledge) {
                this.Priviledge = Priviledge;
            }

            public String getReason() {
                return Reason;
            }

            public void setReason(String Reason) {
                this.Reason = Reason;
            }

            public String getPenalties() {
                return Penalties;
            }

            public void setPenalties(String Penalties) {
                this.Penalties = Penalties;
            }

            public int getBusinessID() {
                return BusinessID;
            }

            public void setBusinessID(int BusinessID) {
                this.BusinessID = BusinessID;
            }

            public Object getBusiness() {
                return Business;
            }

            public void setBusiness(Object Business) {
                this.Business = Business;
            }

            public int getSourceDepartmentID() {
                return SourceDepartmentID;
            }

            public void setSourceDepartmentID(int SourceDepartmentID) {
                this.SourceDepartmentID = SourceDepartmentID;
            }

            public int getReceiveDepartmentID() {
                return ReceiveDepartmentID;
            }

            public void setReceiveDepartmentID(int ReceiveDepartmentID) {
                this.ReceiveDepartmentID = ReceiveDepartmentID;
            }

            public int getSentDepartmentID() {
                return SentDepartmentID;
            }

            public void setSentDepartmentID(int SentDepartmentID) {
                this.SentDepartmentID = SentDepartmentID;
            }

            public String getPersonnelType() {
                return PersonnelType;
            }

            public void setPersonnelType(String PersonnelType) {
                this.PersonnelType = PersonnelType;
            }

            public String getIDType() {
                return IDType;
            }

            public void setIDType(String IDType) {
                this.IDType = IDType;
            }

            public String getIDNumber() {
                return IDNumber;
            }

            public void setIDNumber(String IDNumber) {
                this.IDNumber = IDNumber;
            }

            public String getLegalDescription() {
                return LegalDescription;
            }

            public void setLegalDescription(String LegalDescription) {
                this.LegalDescription = LegalDescription;
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

            public String getCollectionDate() {
                return CollectionDate;
            }

            public void setCollectionDate(String CollectionDate) {
                this.CollectionDate = CollectionDate;
            }

            public String getCollectionOrg() {
                return CollectionOrg;
            }

            public void setCollectionOrg(String CollectionOrg) {
                this.CollectionOrg = CollectionOrg;
            }

            public List<?> getReference() {
                return Reference;
            }

            public void setReference(List<?> Reference) {
                this.Reference = Reference;
            }

            public List<?> getDepartmentIDs() {
                return DepartmentIDs;
            }

            public void setDepartmentIDs(List<?> DepartmentIDs) {
                this.DepartmentIDs = DepartmentIDs;
            }

            public List<?> getDepartment() {
                return Department;
            }

            public void setDepartment(List<?> Department) {
                this.Department = Department;
            }

            public List<?> getImplementationDepartmentIDs() {
                return ImplementationDepartmentIDs;
            }

            public void setImplementationDepartmentIDs(List<?> ImplementationDepartmentIDs) {
                this.ImplementationDepartmentIDs = ImplementationDepartmentIDs;
            }

            public List<?> getImplementationDepartment() {
                return ImplementationDepartment;
            }

            public void setImplementationDepartment(List<?> ImplementationDepartment) {
                this.ImplementationDepartment = ImplementationDepartment;
            }
        }

        public static class MarketEntryAndAppointmentBean {
            /**
             * ID : 12
             * Code :
             * Reference : []
             * CompanyID : 4578
             * Note :
             * LastModifyByID : 10423
             * Timestamp : /Date(1587456898398)/
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
             * CreateTime : /Date(1587439206701)/
             * CreatorID : 10423
             * PageCode : 134
             * VirtualFieldsCache : null
             * Name : 建设工程
             * DepartmentIDs : []
             * Department : []
             * ImplementationDepartmentIDs : []
             * ImplementationDepartment : []
             * LegalBasis : 《中华人民共和国建筑法》第十二规定：从事建筑活动的建筑施工企业、勘察单位、设计 单位，应当具备下列条件：  　　一、有符合国家规定的注册资本；  　　二、有与其从事的建筑活动相适应的具有法定执业资格的专业技术人员；  　　三、有从事相关建筑活动所应有的技术装备；  　　四、法律、行政法规定的其他条件。
             * Priviledge : 建设工程，建设规章
             * Reason :
             * Penalties : 行政许可主义模式
             * BusinessID : 0
             * Business : null
             * SourceDepartmentID : 0
             * ReceiveDepartmentID : 0
             * SentDepartmentID : 0
             * PersonnelType :
             * IDType :
             * IDNumber :
             * LegalDescription :
             * StartDate : /Date(-62135596800000)/
             * EndDate : /Date(-62135596800000)/
             * CollectionDate : /Date(-62135596800000)/
             * CollectionOrg :
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
            private String LegalBasis;
            private String Priviledge;
            private String Reason;
            private String Penalties;
            private int BusinessID;
            private Object Business;
            private int SourceDepartmentID;
            private int ReceiveDepartmentID;
            private int SentDepartmentID;
            private String PersonnelType;
            private String IDType;
            private String IDNumber;
            private String LegalDescription;
            private String StartDate;
            private String EndDate;
            private String CollectionDate;
            private String CollectionOrg;
            private List<?> Reference;
            private List<?> DepartmentIDs;
            private List<?> Department;
            private List<?> ImplementationDepartmentIDs;
            private List<?> ImplementationDepartment;

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

            public String getLegalBasis() {
                return LegalBasis;
            }

            public void setLegalBasis(String LegalBasis) {
                this.LegalBasis = LegalBasis;
            }

            public String getPriviledge() {
                return Priviledge;
            }

            public void setPriviledge(String Priviledge) {
                this.Priviledge = Priviledge;
            }

            public String getReason() {
                return Reason;
            }

            public void setReason(String Reason) {
                this.Reason = Reason;
            }

            public String getPenalties() {
                return Penalties;
            }

            public void setPenalties(String Penalties) {
                this.Penalties = Penalties;
            }

            public int getBusinessID() {
                return BusinessID;
            }

            public void setBusinessID(int BusinessID) {
                this.BusinessID = BusinessID;
            }

            public Object getBusiness() {
                return Business;
            }

            public void setBusiness(Object Business) {
                this.Business = Business;
            }

            public int getSourceDepartmentID() {
                return SourceDepartmentID;
            }

            public void setSourceDepartmentID(int SourceDepartmentID) {
                this.SourceDepartmentID = SourceDepartmentID;
            }

            public int getReceiveDepartmentID() {
                return ReceiveDepartmentID;
            }

            public void setReceiveDepartmentID(int ReceiveDepartmentID) {
                this.ReceiveDepartmentID = ReceiveDepartmentID;
            }

            public int getSentDepartmentID() {
                return SentDepartmentID;
            }

            public void setSentDepartmentID(int SentDepartmentID) {
                this.SentDepartmentID = SentDepartmentID;
            }

            public String getPersonnelType() {
                return PersonnelType;
            }

            public void setPersonnelType(String PersonnelType) {
                this.PersonnelType = PersonnelType;
            }

            public String getIDType() {
                return IDType;
            }

            public void setIDType(String IDType) {
                this.IDType = IDType;
            }

            public String getIDNumber() {
                return IDNumber;
            }

            public void setIDNumber(String IDNumber) {
                this.IDNumber = IDNumber;
            }

            public String getLegalDescription() {
                return LegalDescription;
            }

            public void setLegalDescription(String LegalDescription) {
                this.LegalDescription = LegalDescription;
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

            public String getCollectionDate() {
                return CollectionDate;
            }

            public void setCollectionDate(String CollectionDate) {
                this.CollectionDate = CollectionDate;
            }

            public String getCollectionOrg() {
                return CollectionOrg;
            }

            public void setCollectionOrg(String CollectionOrg) {
                this.CollectionOrg = CollectionOrg;
            }

            public List<?> getReference() {
                return Reference;
            }

            public void setReference(List<?> Reference) {
                this.Reference = Reference;
            }

            public List<?> getDepartmentIDs() {
                return DepartmentIDs;
            }

            public void setDepartmentIDs(List<?> DepartmentIDs) {
                this.DepartmentIDs = DepartmentIDs;
            }

            public List<?> getDepartment() {
                return Department;
            }

            public void setDepartment(List<?> Department) {
                this.Department = Department;
            }

            public List<?> getImplementationDepartmentIDs() {
                return ImplementationDepartmentIDs;
            }

            public void setImplementationDepartmentIDs(List<?> ImplementationDepartmentIDs) {
                this.ImplementationDepartmentIDs = ImplementationDepartmentIDs;
            }

            public List<?> getImplementationDepartment() {
                return ImplementationDepartment;
            }

            public void setImplementationDepartment(List<?> ImplementationDepartment) {
                this.ImplementationDepartment = ImplementationDepartment;
            }
        }
    }
}
