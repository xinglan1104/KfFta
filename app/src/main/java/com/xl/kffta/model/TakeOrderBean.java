package com.xl.kffta.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * @author created by zhanghaochen
 * @date 2020-05-18 16:00
 * 描述：
 */
public class TakeOrderBean implements Serializable {

    /**
     * Fields : {"BusinessID":"企业","OwnerIDs":"执法人","ExcuteTime":"执法时间","ExcutionStatus":"执法状态","Result":"检查结果","Note":"备注","DepartmentID":"部门","GovermentEnforcementSchemeID":"抽取方案","PendingOwnerIDs":"待领取执法人","RequiredQuantity":"执法人数","StartDate":"执法开始时间","EndDate":"执法截至时间","CreateTime":"创建时间","CheckListIDs":"事项清单编号","CheckList.Name":"检查项目名称"}
     * Data : [{"Business":{"BusinessName":"开封谈笑之间商贸有限公司","ID":3699},"BusinessID":3699,"CheckList":[{"ID":1,"Code":"00001","Name":"各个公司是否按照规定使用公司名称改变名称是否按照规定办理变更登记"}],"CheckListIDs":[1],"CompanyID":4578,"CreateTime":"/Date(1589528735355)/","Department":{"ID":903,"Name":"Admin"},"DepartmentID":903,"EndDate":"/Date(1590019200000)/","ExcuteTime":"/Date(-62135596800000)/","ExcutionStatus":0,"GovermentEnforcementScheme":{"ID":9,"Name":"随机抽取"},"GovermentEnforcementSchemeID":9,"ID":11,"Owner":[],"OwnerIDs":[],"PageCode":0,"PendingOwner":[{"ID":10448,"DisplayName":"紫南"},{"ID":10449,"DisplayName":"南春"}],"PendingOwnerIDs":[10448,10449],"RequiredQuantity":2,"StartDate":"/Date(1588723200000)/"},{"Business":{"BusinessName":"河南威立胜建筑劳务有限公司","ID":3695},"BusinessID":3695,"CheckList":[{"ID":1,"Code":"00001","Name":"各个公司是否按照规定使用公司名称改变名称是否按照规定办理变更登记"}],"CheckListIDs":[1],"CompanyID":4578,"CreateTime":"/Date(1589528735314)/","Department":{"ID":903,"Name":"Admin"},"DepartmentID":903,"EndDate":"/Date(1590019200000)/","ExcuteTime":"/Date(-62135596800000)/","ExcutionStatus":0,"GovermentEnforcementScheme":{"ID":9,"Name":"随机抽取"},"GovermentEnforcementSchemeID":9,"ID":10,"Owner":[],"OwnerIDs":[],"PageCode":0,"PendingOwner":[{"ID":10448,"DisplayName":"紫南"},{"ID":10449,"DisplayName":"南春"}],"PendingOwnerIDs":[10449,10448],"RequiredQuantity":2,"StartDate":"/Date(1588723200000)/"},{"Business":{"BusinessName":"河南达克斯特科技有限公司","ID":3690},"BusinessID":3690,"CheckList":[{"ID":4,"Code":"00004","Name":"检查公司是否有漏税情况"}],"CheckListIDs":[4],"CompanyID":4578,"CreateTime":"/Date(1589528735265)/","Department":{"ID":913,"Name":"法制科"},"DepartmentID":913,"EndDate":"/Date(1590019200000)/","ExcuteTime":"/Date(-62135596800000)/","ExcutionStatus":0,"GovermentEnforcementScheme":{"ID":9,"Name":"随机抽取"},"GovermentEnforcementSchemeID":9,"ID":9,"Owner":[],"OwnerIDs":[],"PageCode":0,"PendingOwner":[{"ID":10492,"DisplayName":"法制科3"}],"PendingOwnerIDs":[10492],"RequiredQuantity":1,"StartDate":"/Date(1588723200000)/"},{"Business":{"BusinessName":"河南达克斯特科技有限公司","ID":3690},"BusinessID":3690,"CheckList":[{"ID":1,"Code":"00001","Name":"各个公司是否按照规定使用公司名称改变名称是否按照规定办理变更登记"}],"CheckListIDs":[1],"CompanyID":4578,"CreateTime":"/Date(1589528734684)/","Department":{"ID":903,"Name":"Admin"},"DepartmentID":903,"EndDate":"/Date(1590019200000)/","ExcuteTime":"/Date(-62135596800000)/","ExcutionStatus":0,"GovermentEnforcementScheme":{"ID":9,"Name":"随机抽取"},"GovermentEnforcementSchemeID":9,"ID":8,"Owner":[],"OwnerIDs":[],"PageCode":0,"PendingOwner":[{"ID":10450,"DisplayName":"紫安"},{"ID":10449,"DisplayName":"南春"}],"PendingOwnerIDs":[10450,10449],"RequiredQuantity":2,"StartDate":"/Date(1588723200000)/"},{"Business":{"BusinessName":"河南威特衡器有限公司开封分公司","ID":3676},"BusinessID":3676,"CheckList":[{"ID":4,"Code":"00004","Name":"检查公司是否有漏税情况"}],"CheckListIDs":[4],"CompanyID":4578,"CreateTime":"/Date(1589523340386)/","Department":{"ID":913,"Name":"法制科"},"DepartmentID":913,"EndDate":"/Date(-62135596800000)/","ExcuteTime":"/Date(-62135596800000)/","ExcutionStatus":0,"GovermentEnforcementScheme":{"ID":10,"Name":"测试方案"},"GovermentEnforcementSchemeID":10,"ID":7,"Owner":[],"OwnerIDs":[],"PageCode":0,"PendingOwner":[{"ID":10491,"DisplayName":"法制科2"},{"ID":10461,"DisplayName":"法制科1"}],"PendingOwnerIDs":[10461,10491],"RequiredQuantity":2,"StartDate":"/Date(-62135596800000)/"},{"Business":{"BusinessName":"河南省淘口令商贸有限公司","ID":3678},"BusinessID":3678,"CheckList":[{"ID":4,"Code":"00004","Name":"检查公司是否有漏税情况"}],"CheckListIDs":[4],"CompanyID":4578,"CreateTime":"/Date(1589523340333)/","Department":{"ID":913,"Name":"法制科"},"DepartmentID":913,"EndDate":"/Date(-62135596800000)/","ExcuteTime":"/Date(-62135596800000)/","ExcutionStatus":0,"GovermentEnforcementScheme":{"ID":10,"Name":"测试方案"},"GovermentEnforcementSchemeID":10,"ID":6,"Owner":[{"ID":10461,"DisplayName":"法制科1"},{"ID":10491,"DisplayName":"法制科2"}],"OwnerIDs":[10491,10461],"PageCode":0,"PendingOwner":[],"PendingOwnerIDs":[],"RequiredQuantity":2,"StartDate":"/Date(-62135596800000)/"},{"Business":{"BusinessName":"河南达克斯特科技有限公司","ID":3690},"BusinessID":3690,"CheckList":[{"ID":4,"Code":"00004","Name":"检查公司是否有漏税情况"}],"CheckListIDs":[4],"CompanyID":4578,"CreateTime":"/Date(1589523339974)/","Department":{"ID":913,"Name":"法制科"},"DepartmentID":913,"EndDate":"/Date(-62135596800000)/","ExcuteTime":"/Date(-62135596800000)/","ExcutionStatus":0,"GovermentEnforcementScheme":{"ID":10,"Name":"测试方案"},"GovermentEnforcementSchemeID":10,"ID":5,"Owner":[],"OwnerIDs":[],"PageCode":0,"PendingOwner":[{"ID":10461,"DisplayName":"法制科1"},{"ID":10491,"DisplayName":"法制科2"}],"PendingOwnerIDs":[10491,10461],"RequiredQuantity":2,"StartDate":"/Date(-62135596800000)/"},{"Business":{},"BusinessID":0,"CheckList":[],"CompanyID":4578,"CreateTime":"/Date(1587869292689)/","Department":{"ID":912,"Name":"办公室"},"DepartmentID":912,"EndDate":"/Date(1588176000000)/","ExcuteTime":"/Date(1587830400000)/","ExcutionStatus":0,"GovermentEnforcementScheme":{"ID":9,"Name":"随机抽取"},"GovermentEnforcementSchemeID":9,"ID":2,"Note":"无备注","Owner":[{"ID":10450,"DisplayName":"紫安"}],"OwnerIDs":[10450],"PageCode":0,"PendingOwner":[{"ID":10448,"DisplayName":"紫南"}],"PendingOwnerIDs":[10448],"RequiredQuantity":2,"Result":"无违法行为","StartDate":"/Date(1587830400000)/"},{"Business":{},"BusinessID":0,"CheckList":[],"CompanyID":4578,"CreateTime":"/Date(1587869231572)/","Department":{"ID":903,"Name":"Admin"},"DepartmentID":903,"EndDate":"/Date(1588176000000)/","ExcuteTime":"/Date(1587830400000)/","ExcutionStatus":0,"GovermentEnforcementScheme":{"ID":5,"Name":"是否有违法卫生行为"},"GovermentEnforcementSchemeID":5,"ID":1,"Note":"无备注","Owner":[{"ID":10423,"DisplayName":"admin"}],"OwnerIDs":[10423],"PageCode":0,"PendingOwner":[{"ID":10449,"DisplayName":"南春"}],"PendingOwnerIDs":[10449],"RequiredQuantity":2,"Result":"无违法行为","StartDate":"/Date(1587830400000)/"}]
     * Error : null
     * ErrorCode : 0
     * ResponseStatus : null
     * EncryptionData : null
     * AESEncryptionKey : null
     */

    private FieldsBean Fields;
    private String Error;
    private int ErrorCode;
    private String ResponseStatus;
    private String EncryptionData;
    private String AESEncryptionKey;
    private List<DataBean> Data;

    public FieldsBean getFields() {
        return Fields;
    }

    public void setFields(FieldsBean Fields) {
        this.Fields = Fields;
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

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class FieldsBean {
        /**
         * BusinessID : 企业
         * OwnerIDs : 执法人
         * ExcuteTime : 执法时间
         * ExcutionStatus : 执法状态
         * Result : 检查结果
         * Note : 备注
         * DepartmentID : 部门
         * GovermentEnforcementSchemeID : 抽取方案
         * PendingOwnerIDs : 待领取执法人
         * RequiredQuantity : 执法人数
         * StartDate : 执法开始时间
         * EndDate : 执法截至时间
         * CreateTime : 创建时间
         * CheckListIDs : 事项清单编号
         * CheckList.Name : 检查项目名称
         */

        private String BusinessID;
        private String OwnerIDs;
        private String ExcuteTime;
        private String ExcutionStatus;
        private String Result;
        private String Note;
        private String DepartmentID;
        private String GovermentEnforcementSchemeID;
        private String PendingOwnerIDs;
        private String RequiredQuantity;
        private String StartDate;
        private String EndDate;
        private String CreateTime;
        private String CheckListIDs;
        @SerializedName("CheckList.Name")
        private String _$CheckListName296; // FIXME check this code

        public String getBusinessID() {
            return BusinessID;
        }

        public void setBusinessID(String BusinessID) {
            this.BusinessID = BusinessID;
        }

        public String getOwnerIDs() {
            return OwnerIDs;
        }

        public void setOwnerIDs(String OwnerIDs) {
            this.OwnerIDs = OwnerIDs;
        }

        public String getExcuteTime() {
            return ExcuteTime;
        }

        public void setExcuteTime(String ExcuteTime) {
            this.ExcuteTime = ExcuteTime;
        }

        public String getExcutionStatus() {
            return ExcutionStatus;
        }

        public void setExcutionStatus(String ExcutionStatus) {
            this.ExcutionStatus = ExcutionStatus;
        }

        public String getResult() {
            return Result;
        }

        public void setResult(String Result) {
            this.Result = Result;
        }

        public String getNote() {
            return Note;
        }

        public void setNote(String Note) {
            this.Note = Note;
        }

        public String getDepartmentID() {
            return DepartmentID;
        }

        public void setDepartmentID(String DepartmentID) {
            this.DepartmentID = DepartmentID;
        }

        public String getGovermentEnforcementSchemeID() {
            return GovermentEnforcementSchemeID;
        }

        public void setGovermentEnforcementSchemeID(String GovermentEnforcementSchemeID) {
            this.GovermentEnforcementSchemeID = GovermentEnforcementSchemeID;
        }

        public String getPendingOwnerIDs() {
            return PendingOwnerIDs;
        }

        public void setPendingOwnerIDs(String PendingOwnerIDs) {
            this.PendingOwnerIDs = PendingOwnerIDs;
        }

        public String getRequiredQuantity() {
            return RequiredQuantity;
        }

        public void setRequiredQuantity(String RequiredQuantity) {
            this.RequiredQuantity = RequiredQuantity;
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

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getCheckListIDs() {
            return CheckListIDs;
        }

        public void setCheckListIDs(String CheckListIDs) {
            this.CheckListIDs = CheckListIDs;
        }

        public String get_$CheckListName296() {
            return _$CheckListName296;
        }

        public void set_$CheckListName296(String _$CheckListName296) {
            this._$CheckListName296 = _$CheckListName296;
        }
    }

    public static class DataBean {
        /**
         * Business : {"BusinessName":"开封谈笑之间商贸有限公司","ID":3699}
         * BusinessID : 3699
         * CheckList : [{"ID":1,"Code":"00001","Name":"各个公司是否按照规定使用公司名称改变名称是否按照规定办理变更登记"}]
         * CheckListIDs : [1]
         * CompanyID : 4578
         * CreateTime : /Date(1589528735355)/
         * Department : {"ID":903,"Name":"Admin"}
         * DepartmentID : 903
         * EndDate : /Date(1590019200000)/
         * ExcuteTime : /Date(-62135596800000)/
         * ExcutionStatus : 0
         * GovermentEnforcementScheme : {"ID":9,"Name":"随机抽取"}
         * GovermentEnforcementSchemeID : 9
         * ID : 11
         * Owner : []
         * OwnerIDs : []
         * PageCode : 0
         * PendingOwner : [{"ID":10448,"DisplayName":"紫南"},{"ID":10449,"DisplayName":"南春"}]
         * PendingOwnerIDs : [10448,10449]
         * RequiredQuantity : 2
         * StartDate : /Date(1588723200000)/
         * Note : 无备注
         * Result : 无违法行为
         */

        private BusinessBean Business;
        private int BusinessID;
        private int CompanyID;
        private String CreateTime;
        private DepartmentBean Department;
        private int DepartmentID;
        private String EndDate;
        private String ExcuteTime;
        private int ExcutionStatus;
        private GovermentEnforcementSchemeBean GovermentEnforcementScheme;
        private int GovermentEnforcementSchemeID;
        private long ID;
        private int PageCode;
        private int RequiredQuantity;
        private String StartDate;
        private String Note;
        private String Result;
        private List<CheckListBean> CheckList;
        private List<Long> CheckListIDs;
        private List<OwnerBean> Owner;
        private List<Long> OwnerIDs;
        private List<PendingOwnerBean> PendingOwner;
        private List<Long> PendingOwnerIDs;

        public BusinessBean getBusiness() {
            return Business;
        }

        public void setBusiness(BusinessBean Business) {
            this.Business = Business;
        }

        public int getBusinessID() {
            return BusinessID;
        }

        public void setBusinessID(int BusinessID) {
            this.BusinessID = BusinessID;
        }

        public int getCompanyID() {
            return CompanyID;
        }

        public void setCompanyID(int CompanyID) {
            this.CompanyID = CompanyID;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public DepartmentBean getDepartment() {
            return Department;
        }

        public void setDepartment(DepartmentBean Department) {
            this.Department = Department;
        }

        public int getDepartmentID() {
            return DepartmentID;
        }

        public void setDepartmentID(int DepartmentID) {
            this.DepartmentID = DepartmentID;
        }

        public String getEndDate() {
            return EndDate;
        }

        public void setEndDate(String EndDate) {
            this.EndDate = EndDate;
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

        public GovermentEnforcementSchemeBean getGovermentEnforcementScheme() {
            return GovermentEnforcementScheme;
        }

        public void setGovermentEnforcementScheme(GovermentEnforcementSchemeBean GovermentEnforcementScheme) {
            this.GovermentEnforcementScheme = GovermentEnforcementScheme;
        }

        public int getGovermentEnforcementSchemeID() {
            return GovermentEnforcementSchemeID;
        }

        public void setGovermentEnforcementSchemeID(int GovermentEnforcementSchemeID) {
            this.GovermentEnforcementSchemeID = GovermentEnforcementSchemeID;
        }

        public long getID() {
            return ID;
        }

        public void setID(long ID) {
            this.ID = ID;
        }

        public int getPageCode() {
            return PageCode;
        }

        public void setPageCode(int PageCode) {
            this.PageCode = PageCode;
        }

        public int getRequiredQuantity() {
            return RequiredQuantity;
        }

        public void setRequiredQuantity(int RequiredQuantity) {
            this.RequiredQuantity = RequiredQuantity;
        }

        public String getStartDate() {
            return StartDate;
        }

        public void setStartDate(String StartDate) {
            this.StartDate = StartDate;
        }

        public String getNote() {
            return Note;
        }

        public void setNote(String Note) {
            this.Note = Note;
        }

        public String getResult() {
            return Result;
        }

        public void setResult(String Result) {
            this.Result = Result;
        }

        public List<CheckListBean> getCheckList() {
            return CheckList;
        }

        public void setCheckList(List<CheckListBean> CheckList) {
            this.CheckList = CheckList;
        }

        public List<Long> getCheckListIDs() {
            return CheckListIDs;
        }

        public void setCheckListIDs(List<Long> CheckListIDs) {
            this.CheckListIDs = CheckListIDs;
        }

        public List<OwnerBean> getOwner() {
            return Owner;
        }

        public void setOwner(List<OwnerBean> Owner) {
            this.Owner = Owner;
        }

        public List<?> getOwnerIDs() {
            return OwnerIDs;
        }

        public void setOwnerIDs(List<Long> OwnerIDs) {
            this.OwnerIDs = OwnerIDs;
        }

        public List<PendingOwnerBean> getPendingOwner() {
            return PendingOwner;
        }

        public void setPendingOwner(List<PendingOwnerBean> PendingOwner) {
            this.PendingOwner = PendingOwner;
        }

        public List<Long> getPendingOwnerIDs() {
            return PendingOwnerIDs;
        }

        public void setPendingOwnerIDs(List<Long> PendingOwnerIDs) {
            this.PendingOwnerIDs = PendingOwnerIDs;
        }

        public static class BusinessBean {
            /**
             * BusinessName : 开封谈笑之间商贸有限公司
             * ID : 3699
             */

            private String BusinessName;
            private int ID;

            public String getBusinessName() {
                return BusinessName;
            }

            public void setBusinessName(String BusinessName) {
                this.BusinessName = BusinessName;
            }

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }
        }

        public static class DepartmentBean {
            /**
             * ID : 903
             * Name : Admin
             */

            private int ID;
            private String Name;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class GovermentEnforcementSchemeBean {
            /**
             * ID : 9
             * Name : 随机抽取
             */

            private int ID;
            private String Name;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class CheckListBean {
            /**
             * ID : 1
             * Code : 00001
             * Name : 各个公司是否按照规定使用公司名称改变名称是否按照规定办理变更登记
             */

            private int ID;
            private String Code;
            private String Name;

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

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class PendingOwnerBean {
            /**
             * ID : 10448
             * DisplayName : 紫南
             */

            private int ID;
            private String DisplayName;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public String getDisplayName() {
                return DisplayName;
            }

            public void setDisplayName(String DisplayName) {
                this.DisplayName = DisplayName;
            }
        }

        public static class OwnerBean {
            private int ID;
            private String DisplayName;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public String getDisplayName() {
                return DisplayName;
            }

            public void setDisplayName(String DisplayName) {
                this.DisplayName = DisplayName;
            }
        }
    }
}
