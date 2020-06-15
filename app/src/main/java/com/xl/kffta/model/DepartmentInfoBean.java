package com.xl.kffta.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author created by zhanghaochen
 * @date 2020-06-15 16:31
 * 描述：部门对应列表
 */
public class DepartmentInfoBean implements Serializable {

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
             * BusinessArea : [{"ID":1432,"AttrID":1432,"Name":"计算机软件技术开发"}]
             * BusinessAreaIDs : [1432]
             * CompanyID : 4578
             * DepartmentCode : 000000008
             * DF1 : 李伟
             * ID : 913
             * Name : 法制科
             * PageCode : 0
             * Status : 1
             * Timestamp : /Date(1588919517136)/
             */

            private int CompanyID;
            private String DepartmentCode;
            private String DF1;
            private int ID;
            private String Name;
            private int PageCode;
            private int Status;
            private String Timestamp;
            private List<BusinessAreaBean> BusinessArea;
            private List<Integer> BusinessAreaIDs;

            public int getCompanyID() {
                return CompanyID;
            }

            public void setCompanyID(int CompanyID) {
                this.CompanyID = CompanyID;
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

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
            }

            public String getTimestamp() {
                return Timestamp;
            }

            public void setTimestamp(String Timestamp) {
                this.Timestamp = Timestamp;
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
}
