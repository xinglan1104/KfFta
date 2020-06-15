package com.xl.kffta.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author created by zhanghaochen
 * @date 2020-06-15 16:31
 * 描述：部门对应列表
 */
public class DepartmentInfoBean implements Serializable {
    private FieldsBean Fields;
    private String Error;
    private int ErrorCode;
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

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class FieldsBean {
        private String DepartmentCode;
        private String Name;
        private String ParentID;
        private String DepartmentManagerIDs;
        private String BusinessAreaIDs;
        private String DF1;
        private String Status;
        private String CreateTime;

        public String getDepartmentCode() {
            return DepartmentCode;
        }

        public void setDepartmentCode(String DepartmentCode) {
            this.DepartmentCode = DepartmentCode;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getParentID() {
            return ParentID;
        }

        public void setParentID(String ParentID) {
            this.ParentID = ParentID;
        }

        public String getDepartmentManagerIDs() {
            return DepartmentManagerIDs;
        }

        public void setDepartmentManagerIDs(String DepartmentManagerIDs) {
            this.DepartmentManagerIDs = DepartmentManagerIDs;
        }

        public String getBusinessAreaIDs() {
            return BusinessAreaIDs;
        }

        public void setBusinessAreaIDs(String BusinessAreaIDs) {
            this.BusinessAreaIDs = BusinessAreaIDs;
        }

        public String getDF1() {
            return DF1;
        }

        public void setDF1(String DF1) {
            this.DF1 = DF1;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }
    }

    public static class DataBean {
        private int CompanyID;
        private String CreateTime;
        private String DepartmentCode;
        private String DF1;
        private int ID;
        private String Name;
        private int PageCode;
        private ParentBean Parent;
        private int ParentID;
        private int Status;
        private List<BusinessAreaBean> BusinessArea;
        private List<Integer> BusinessAreaIDs;
        private List<?> DepartmentManager;
        private List<?> DepartmentManagerIDs;

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

        public String getDepartmentCode() {
            return DepartmentCode;
        }

        public void setDepartmentCode(String DepartmentCode) {
            this.DepartmentCode = DepartmentCode;
        }

        public String getDF1() {
            return DF1;
        }

        public void setDF1(String DF1) {
            this.DF1 = DF1;
        }

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

        public int getPageCode() {
            return PageCode;
        }

        public void setPageCode(int PageCode) {
            this.PageCode = PageCode;
        }

        public ParentBean getParent() {
            return Parent;
        }

        public void setParent(ParentBean Parent) {
            this.Parent = Parent;
        }

        public int getParentID() {
            return ParentID;
        }

        public void setParentID(int ParentID) {
            this.ParentID = ParentID;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public List<BusinessAreaBean> getBusinessArea() {
            return BusinessArea;
        }

        public void setBusinessArea(List<BusinessAreaBean> BusinessArea) {
            this.BusinessArea = BusinessArea;
        }

        public List<Integer> getBusinessAreaIDs() {
            return BusinessAreaIDs;
        }

        public void setBusinessAreaIDs(List<Integer> BusinessAreaIDs) {
            this.BusinessAreaIDs = BusinessAreaIDs;
        }

        public List<?> getDepartmentManager() {
            return DepartmentManager;
        }

        public void setDepartmentManager(List<?> DepartmentManager) {
            this.DepartmentManager = DepartmentManager;
        }

        public List<?> getDepartmentManagerIDs() {
            return DepartmentManagerIDs;
        }

        public void setDepartmentManagerIDs(List<?> DepartmentManagerIDs) {
            this.DepartmentManagerIDs = DepartmentManagerIDs;
        }

        public static class ParentBean {
        }

        public static class BusinessAreaBean {
            /**
             * ID : 1432
             * AttrID : 1432
             * Name : 计算机软件技术开发
             */

            private int ID;
            private int AttrID;
            private String Name;

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

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }
    }
}
