package com.xl.kffta.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhanghaochen
 * Date: 2020/6/6
 * 描述：企业信息
 */
public class BusinessInfoBean implements Serializable {
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
        private String BusinessName;
        private String BusinessLicenseRegistrationNumber;
        private String Representative;
        private String BusinessTypeIDs;
        private String BusinessRegistrationStatus;
        private String RegisteredCapital;
        private String BusinessLocalAssociationDepartmentID;
        private String ExtraDepartmentIDs;
        private String UnClaimDepartmentIDs;

        public String getBusinessName() {
            return BusinessName;
        }

        public void setBusinessName(String BusinessName) {
            this.BusinessName = BusinessName;
        }

        public String getBusinessLicenseRegistrationNumber() {
            return BusinessLicenseRegistrationNumber;
        }

        public void setBusinessLicenseRegistrationNumber(String BusinessLicenseRegistrationNumber) {
            this.BusinessLicenseRegistrationNumber = BusinessLicenseRegistrationNumber;
        }

        public String getRepresentative() {
            return Representative;
        }

        public void setRepresentative(String Representative) {
            this.Representative = Representative;
        }

        public String getBusinessTypeIDs() {
            return BusinessTypeIDs;
        }

        public void setBusinessTypeIDs(String BusinessTypeIDs) {
            this.BusinessTypeIDs = BusinessTypeIDs;
        }

        public String getBusinessRegistrationStatus() {
            return BusinessRegistrationStatus;
        }

        public void setBusinessRegistrationStatus(String BusinessRegistrationStatus) {
            this.BusinessRegistrationStatus = BusinessRegistrationStatus;
        }

        public String getRegisteredCapital() {
            return RegisteredCapital;
        }

        public void setRegisteredCapital(String RegisteredCapital) {
            this.RegisteredCapital = RegisteredCapital;
        }

        public String getBusinessLocalAssociationDepartmentID() {
            return BusinessLocalAssociationDepartmentID;
        }

        public void setBusinessLocalAssociationDepartmentID(String BusinessLocalAssociationDepartmentID) {
            this.BusinessLocalAssociationDepartmentID = BusinessLocalAssociationDepartmentID;
        }

        public String getExtraDepartmentIDs() {
            return ExtraDepartmentIDs;
        }

        public void setExtraDepartmentIDs(String ExtraDepartmentIDs) {
            this.ExtraDepartmentIDs = ExtraDepartmentIDs;
        }

        public String getUnClaimDepartmentIDs() {
            return UnClaimDepartmentIDs;
        }

        public void setUnClaimDepartmentIDs(String UnClaimDepartmentIDs) {
            this.UnClaimDepartmentIDs = UnClaimDepartmentIDs;
        }
    }

    public static class DataBean {
        private String BusinessLicenseRegistrationNumber;
        private BusinessLocalAssociationDepartmentBean BusinessLocalAssociationDepartment;
        private int BusinessLocalAssociationDepartmentID;
        private String BusinessName;
        private int BusinessRegistrationStatus;
        private int CompanyID;
        private long ID;
        private int PageCode;
        private int RegisteredCapital;
        private String Representative;
        private List<?> BusinessType;
        private List<Integer> BusinessTypeIDs;
        private List<?> ExtraDepartmentIDs;
        private List<?> UnClaimDepartmentIDs;
        private List<UnClainDepartmentBean> UnClainDepartment;

        public String getBusinessLicenseRegistrationNumber() {
            return BusinessLicenseRegistrationNumber;
        }

        public void setBusinessLicenseRegistrationNumber(String BusinessLicenseRegistrationNumber) {
            this.BusinessLicenseRegistrationNumber = BusinessLicenseRegistrationNumber;
        }

        public BusinessLocalAssociationDepartmentBean getBusinessLocalAssociationDepartment() {
            return BusinessLocalAssociationDepartment;
        }

        public void setBusinessLocalAssociationDepartment(BusinessLocalAssociationDepartmentBean BusinessLocalAssociationDepartment) {
            this.BusinessLocalAssociationDepartment = BusinessLocalAssociationDepartment;
        }

        public int getBusinessLocalAssociationDepartmentID() {
            return BusinessLocalAssociationDepartmentID;
        }

        public void setBusinessLocalAssociationDepartmentID(int BusinessLocalAssociationDepartmentID) {
            this.BusinessLocalAssociationDepartmentID = BusinessLocalAssociationDepartmentID;
        }

        public String getBusinessName() {
            return BusinessName;
        }

        public void setBusinessName(String BusinessName) {
            this.BusinessName = BusinessName;
        }

        public int getBusinessRegistrationStatus() {
            return BusinessRegistrationStatus;
        }

        public void setBusinessRegistrationStatus(int BusinessRegistrationStatus) {
            this.BusinessRegistrationStatus = BusinessRegistrationStatus;
        }

        public int getCompanyID() {
            return CompanyID;
        }

        public void setCompanyID(int CompanyID) {
            this.CompanyID = CompanyID;
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

        public int getRegisteredCapital() {
            return RegisteredCapital;
        }

        public void setRegisteredCapital(int RegisteredCapital) {
            this.RegisteredCapital = RegisteredCapital;
        }

        public String getRepresentative() {
            return Representative;
        }

        public void setRepresentative(String Representative) {
            this.Representative = Representative;
        }

        public List<?> getBusinessType() {
            return BusinessType;
        }

        public void setBusinessType(List<?> BusinessType) {
            this.BusinessType = BusinessType;
        }

        public List<Integer> getBusinessTypeIDs() {
            return BusinessTypeIDs;
        }

        public void setBusinessTypeIDs(List<Integer> BusinessTypeIDs) {
            this.BusinessTypeIDs = BusinessTypeIDs;
        }

        public List<?> getExtraDepartmentIDs() {
            return ExtraDepartmentIDs;
        }

        public void setExtraDepartmentIDs(List<?> ExtraDepartmentIDs) {
            this.ExtraDepartmentIDs = ExtraDepartmentIDs;
        }

        public List<?> getUnClaimDepartmentIDs() {
            return UnClaimDepartmentIDs;
        }

        public void setUnClaimDepartmentIDs(List<?> UnClaimDepartmentIDs) {
            this.UnClaimDepartmentIDs = UnClaimDepartmentIDs;
        }

        public List<UnClainDepartmentBean> getUnClainDepartment() {
            return UnClainDepartment;
        }

        public void setUnClainDepartment(List<UnClainDepartmentBean> UnClainDepartment) {
            this.UnClainDepartment = UnClainDepartment;
        }

        public static class BusinessLocalAssociationDepartmentBean {
        }

        public static class UnClainDepartmentBean {
            /**
             * ID : 0
             * Name : 全公司
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
