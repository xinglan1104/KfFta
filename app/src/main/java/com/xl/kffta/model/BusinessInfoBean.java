package com.xl.kffta.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhanghaochen
 * Date: 2020/6/6
 * 描述：企业信息
 */
public class BusinessInfoBean implements Serializable {

    private DataBean Data;
    private String Error;
    private int ErrorCode;
    private Object ResponseStatus;
    private Object EncryptionData;
    private Object AESEncryptionKey;

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

    public Object getEncryptionData() {
        return EncryptionData;
    }

    public void setEncryptionData(Object EncryptionData) {
        this.EncryptionData = EncryptionData;
    }

    public Object getAESEncryptionKey() {
        return AESEncryptionKey;
    }

    public void setAESEncryptionKey(Object AESEncryptionKey) {
        this.AESEncryptionKey = AESEncryptionKey;
    }

    public static class DataBean {
        /**
         * Codename : CloudEasy.ERP.BL.Model.Directory.Business
         * Blocks : null
         * FieldNames : ["BusinessName","BusinessLicenseRegistrationNumber","Representative","_BusinessTypeIDs","<BusinessTypeIDs+{0}",">BusinessType.Name","BusinessRegistrationStatus","RegisteredCapital","_BusinessLocalAssociationDepartmentID","<BusinessLocalAssociationDepartmentID+{0}",">BusinessLocalAssociationDepartment.Name","_ExtraDepartmentIDs","<ExtraDepartmentIDs+{0}",">ExtraDepartment.Name","_UnClaimDepartmentIDs","<UnClaimDepartmentIDs+{0}",">UnClainDepartment.Name","_ID","_CompanyID"]
         * Values : [{"BusinessLicenseRegistrationNumber":"141000027475392315","BusinessLocalAssociationDepartment":{"ID":912,"Name":"办公室"},"BusinessLocalAssociationDepartmentID":912,"BusinessName":"开封光诺建筑劳务有限公司","BusinessRegistrationStatus":0,"BusinessType":[],"BusinessTypeIDs":[-3],"CompanyID":4578,"ExtraDepartmentIDs":[],"ID":4227,"PageCode":0,"RegisteredCapital":200,"Representative":"尚金胜","UnClaimDepartmentIDs":[],"UnClainDepartment":[{"ID":0,"Name":"全公司"}]}]
         * AttachedValues : null
         */

        private String Codename;
        private Object Blocks;
        private Object AttachedValues;
        private List<String> FieldNames;
        private List<ValuesBean> Values;

        public String getCodename() {
            return Codename;
        }

        public void setCodename(String Codename) {
            this.Codename = Codename;
        }

        public Object getBlocks() {
            return Blocks;
        }

        public void setBlocks(Object Blocks) {
            this.Blocks = Blocks;
        }

        public Object getAttachedValues() {
            return AttachedValues;
        }

        public void setAttachedValues(Object AttachedValues) {
            this.AttachedValues = AttachedValues;
        }

        public List<String> getFieldNames() {
            return FieldNames;
        }

        public void setFieldNames(List<String> FieldNames) {
            this.FieldNames = FieldNames;
        }

        public List<ValuesBean> getValues() {
            return Values;
        }

        public void setValues(List<ValuesBean> Values) {
            this.Values = Values;
        }

        public static class ValuesBean {
            /**
             * BusinessLicenseRegistrationNumber : 141000027475392315
             * BusinessLocalAssociationDepartment : {"ID":912,"Name":"办公室"}
             * BusinessLocalAssociationDepartmentID : 912
             * BusinessName : 开封光诺建筑劳务有限公司
             * BusinessRegistrationStatus : 0
             * BusinessType : []
             * BusinessTypeIDs : [-3]
             * CompanyID : 4578
             * ExtraDepartmentIDs : []
             * ID : 4227
             * PageCode : 0
             * RegisteredCapital : 200
             * Representative : 尚金胜
             * UnClaimDepartmentIDs : []
             * UnClainDepartment : [{"ID":0,"Name":"全公司"}]
             */

            private String BusinessLicenseRegistrationNumber;
            private BusinessLocalAssociationDepartmentBean BusinessLocalAssociationDepartment;
            private int BusinessLocalAssociationDepartmentID;
            private String BusinessName;
            private int BusinessRegistrationStatus;
            private int CompanyID;
            private int ID;
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

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
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
                /**
                 * ID : 912
                 * Name : 办公室
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
}
