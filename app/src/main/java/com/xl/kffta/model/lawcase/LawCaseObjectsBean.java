package com.xl.kffta.model.lawcase;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author created by zhanghaochen
 * @date 2020-06-02 17:16
 * 描述：案件列表的类
 */
public class LawCaseObjectsBean implements Serializable {

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
         * Name : 案件名称
         * Source : 案件来源
         * BusinessID : 当事企业
         * Business.BusinessLicenseRegistrationNumber : 统一社会信用代码
         * DepartmentID : 部门
         * Content : 线索（举报）内容
         * CreatorID : 创建人
         * CreateTime : 创建时间
         * Files : 附件
         * ContactName : 提供者姓名
         * ContactPhone : 提供者联系方式
         * ContactAddress : 提供者地址
         */

        private String Name;
        private String Source;
        private String BusinessID;
        @SerializedName("Business.BusinessLicenseRegistrationNumber")
        private String _$BusinessBusinessLicenseRegistrationNumber115; // FIXME check this code
        private String DepartmentID;
        private String Content;
        private String CreatorID;
        private String CreateTime;
        private String Files;
        private String ContactName;
        private String ContactPhone;
        private String ContactAddress;

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getSource() {
            return Source;
        }

        public void setSource(String Source) {
            this.Source = Source;
        }

        public String getBusinessID() {
            return BusinessID;
        }

        public void setBusinessID(String BusinessID) {
            this.BusinessID = BusinessID;
        }

        public String get_$BusinessBusinessLicenseRegistrationNumber115() {
            return _$BusinessBusinessLicenseRegistrationNumber115;
        }

        public void set_$BusinessBusinessLicenseRegistrationNumber115(String _$BusinessBusinessLicenseRegistrationNumber115) {
            this._$BusinessBusinessLicenseRegistrationNumber115 = _$BusinessBusinessLicenseRegistrationNumber115;
        }

        public String getDepartmentID() {
            return DepartmentID;
        }

        public void setDepartmentID(String DepartmentID) {
            this.DepartmentID = DepartmentID;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
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

        public String getFiles() {
            return Files;
        }

        public void setFiles(String Files) {
            this.Files = Files;
        }

        public String getContactName() {
            return ContactName;
        }

        public void setContactName(String ContactName) {
            this.ContactName = ContactName;
        }

        public String getContactPhone() {
            return ContactPhone;
        }

        public void setContactPhone(String ContactPhone) {
            this.ContactPhone = ContactPhone;
        }

        public String getContactAddress() {
            return ContactAddress;
        }

        public void setContactAddress(String ContactAddress) {
            this.ContactAddress = ContactAddress;
        }
    }

    public static class DataBean {
        /**
         * Business : {"BusinessLicenseRegistrationNumber":"91410296MA466RNQ5J","BusinessName":"开封夏禾汽车服务有限公司","ID":3661}
         * BusinessID : 3661
         * CompanyID : 4578
         * ContactAddress : 地址
         * ContactName : 名字
         * ContactPhone : 11111111
         * Content : 测试举报
         * CreateTime : /Date(1588296945089)/
         * Creator : {"DisplayName":"admin","ID":10423}
         * CreatorID : 10423
         * Department : {"ID":903,"Name":"Admin"}
         * DepartmentID : 903
         * Files : 4578|CloudEasy.ERP.BL.Model.Government.GovermentLegalCase|CloudEasy.ERP.BL.Model.Government.GovermentLegalCase_20200501_2ec4e7ba3dbf4937af90bc4c1aabaabc|
         * Flag : 3
         * FlowFlag : 已完成
         * ID : 10
         * Name : 测试案件
         * PageCode : 0
         * Source : 来源
         */

        private BusinessBean Business;
        private int BusinessID;
        private int CompanyID;
        private String ContactAddress;
        private String ContactName;
        private String ContactPhone;
        private String Content;
        private String CreateTime;
        private CreatorBean Creator;
        private int CreatorID;
        private DepartmentBean Department;
        private int DepartmentID;
        private String Files;
        private int Flag;
        private String FlowFlag;
        private int ID;
        private String Name;
        private int PageCode;
        private String Source;

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

        public String getContactAddress() {
            return ContactAddress;
        }

        public void setContactAddress(String ContactAddress) {
            this.ContactAddress = ContactAddress;
        }

        public String getContactName() {
            return ContactName;
        }

        public void setContactName(String ContactName) {
            this.ContactName = ContactName;
        }

        public String getContactPhone() {
            return ContactPhone;
        }

        public void setContactPhone(String ContactPhone) {
            this.ContactPhone = ContactPhone;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
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

        public String getFiles() {
            return Files;
        }

        public void setFiles(String Files) {
            this.Files = Files;
        }

        public int getFlag() {
            return Flag;
        }

        public void setFlag(int Flag) {
            this.Flag = Flag;
        }

        public String getFlowFlag() {
            return FlowFlag;
        }

        public void setFlowFlag(String FlowFlag) {
            this.FlowFlag = FlowFlag;
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

        public String getSource() {
            return Source;
        }

        public void setSource(String Source) {
            this.Source = Source;
        }

        public static class BusinessBean {
            /**
             * BusinessLicenseRegistrationNumber : 91410296MA466RNQ5J
             * BusinessName : 开封夏禾汽车服务有限公司
             * ID : 3661
             */

            private String BusinessLicenseRegistrationNumber;
            private String BusinessName;
            private int ID;

            public String getBusinessLicenseRegistrationNumber() {
                return BusinessLicenseRegistrationNumber;
            }

            public void setBusinessLicenseRegistrationNumber(String BusinessLicenseRegistrationNumber) {
                this.BusinessLicenseRegistrationNumber = BusinessLicenseRegistrationNumber;
            }

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

        public static class CreatorBean {
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
    }
}
