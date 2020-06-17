package com.xl.kffta.model;

import com.xl.kffta.model.common.BusinessBean;
import com.xl.kffta.model.common.DepartmentBean;
import com.xl.kffta.model.task.CheckListBean;
import com.xl.kffta.model.task.GovermentEnforcementSchemeBean;
import com.xl.kffta.model.task.OwnerBean;

import java.io.Serializable;
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
        private DepartmentBean Department;
        private long BusinessID;
        private BusinessBean Business;
        private String ExcuteTime;
        private int ExcutionStatus;
        private String Result;
        private String StartDate;
        private String EndDate;
        private int RequiredResponseHours;
        private List<Long> OwnerIDs;
        private List<OwnerBean> Owner;
        private List<Long> PendingOwnerIDs;
        private List<OwnerBean> PendingOwner;
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

        public DepartmentBean getDepartment() {
            return Department;
        }

        public void setDepartment(DepartmentBean Department) {
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

        public List<Long> getOwnerIDs() {
            return OwnerIDs;
        }

        public void setOwnerIDs(List<Long> OwnerIDs) {
            this.OwnerIDs = OwnerIDs;
        }

        public List<OwnerBean> getOwner() {
            return Owner;
        }

        public void setOwner(List<OwnerBean> Owner) {
            this.Owner = Owner;
        }

        public List<Long> getPendingOwnerIDs() {
            return PendingOwnerIDs;
        }

        public void setPendingOwnerIDs(List<Long> PendingOwnerIDs) {
            this.PendingOwnerIDs = PendingOwnerIDs;
        }

        public List<OwnerBean> getPendingOwner() {
            return PendingOwner;
        }

        public void setPendingOwner(List<OwnerBean> PendingOwner) {
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
    }
}
