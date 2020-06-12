package com.xl.kffta.model.warn;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author created by zhanghaochen
 * @date 2020-06-12 16:37
 * 描述：预警信息
 */
public class WarnObjectsBean implements Serializable {

    private FieldsBean Fields;
    private String Error;
    private int ErrorCode;
    private ArrayList<DataBean> Data;

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

    public ArrayList<DataBean> getData() {
        return Data;
    }

    public void setData(ArrayList<DataBean> Data) {
        this.Data = Data;
    }

    public static class FieldsBean {
        private String Code;
        private String DepartmentID;
        private String Content;
        private String Note;
        private String Files;
        private String CreatorID;
        private String CreateTime;

        public String getCode() {
            return Code;
        }

        public void setCode(String Code) {
            this.Code = Code;
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

        public String getNote() {
            return Note;
        }

        public void setNote(String Note) {
            this.Note = Note;
        }

        public String getFiles() {
            return Files;
        }

        public void setFiles(String Files) {
            this.Files = Files;
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

    public static class DataBean {

        private String Code;
        private int CompanyID;
        private String Content;
        private String CreateTime;
        private CreatorBean Creator;
        private int CreatorID;
        private DepartmentBean Department;
        private int DepartmentID;
        private String Files;
        private int ID;
        private String Note;
        private int PageCode;

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

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getNote() {
            return Note;
        }

        public void setNote(String Note) {
            this.Note = Note;
        }

        public int getPageCode() {
            return PageCode;
        }

        public void setPageCode(int PageCode) {
            this.PageCode = PageCode;
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
    }
}
