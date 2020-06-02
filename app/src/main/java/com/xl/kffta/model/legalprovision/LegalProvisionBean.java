package com.xl.kffta.model.legalprovision;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author created by zhanghaochen
 * @date 2020-06-01 16:08
 * 描述：法律条文的实例类
 */
public class LegalProvisionBean implements Serializable {

    private FieldsBean Fields;
    private String Error;
    private int ErrorCode;
    private String ResponseStatus;
    private String EncryptionData;
    private String AESEncryptionKey;
    private ArrayList<DataBean> Data = new ArrayList<>();

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

    public ArrayList<DataBean> getData() {
        return Data;
    }

    public void setData(ArrayList<DataBean> Data) {
        this.Data = Data;
    }

    public static class FieldsBean {
        /**
         * DepartmentIDs : 联合惩戒部门
         * Name : 法律法规及政策依据
         * Penalties : 惩罚措施
         * CreatorID : 创建人
         * CreateTime : 创建时间
         */

        private String DepartmentIDs;
        private String Name;
        private String Penalties;
        private String CreatorID;
        private String CreateTime;

        public String getDepartmentIDs() {
            return DepartmentIDs;
        }

        public void setDepartmentIDs(String DepartmentIDs) {
            this.DepartmentIDs = DepartmentIDs;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getPenalties() {
            return Penalties;
        }

        public void setPenalties(String Penalties) {
            this.Penalties = Penalties;
        }

        public String getCreatorID() {
            return CreatorID;
        }

        public void setCreatorID(String CreatorID) {
            this.CreatorID = CreatorID;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }
    }

    public static class DataBean implements Serializable {
        private int CompanyID;
        private String CreateTime;
        private CreatorBean Creator;
        private int CreatorID;
        private int ID;
        private String Name;
        private int PageCode;
        private String Penalties;
        private List<DepartmentBean> Department;
        private List<Integer> DepartmentIDs;

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

        public CreatorBean getCreator() {
            return Creator;
        }

        public void setCreator(CreatorBean Creator) {
            this.Creator = Creator;
        }

        public int getCreatorID() {
            return CreatorID;
        }

        public void setCreatorID(int CreatorID) {
            this.CreatorID = CreatorID;
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

        public String getPenalties() {
            return Penalties;
        }

        public void setPenalties(String Penalties) {
            this.Penalties = Penalties;
        }

        public List<DepartmentBean> getDepartment() {
            return Department;
        }

        public void setDepartment(List<DepartmentBean> Department) {
            this.Department = Department;
        }

        public List<Integer> getDepartmentIDs() {
            return DepartmentIDs;
        }

        public void setDepartmentIDs(List<Integer> DepartmentIDs) {
            this.DepartmentIDs = DepartmentIDs;
        }

        public static class CreatorBean implements Serializable {
            /**
             * DisplayName : admin
             * ID : 10423
             */

            private String DisplayName;
            private int ID;

            public String getDisplayName() {
                return DisplayName;
            }

            public void setDisplayName(String DisplayName) {
                this.DisplayName = DisplayName;
            }

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }
        }

        public static class DepartmentBean implements Serializable {
            /**
             * ID : 908
             * Name : 市场合同规范管理科
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
    }
}
