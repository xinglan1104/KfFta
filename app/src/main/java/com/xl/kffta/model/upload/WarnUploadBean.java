package com.xl.kffta.model.upload;

/**
 * @author created by zhanghaochen
 * @date 2020-06-16 16:05
 * 描述：预警
 */
public class WarnUploadBean {
    private String Files;
    private String Content;
    private String Note;
    private long DepartmentID;
    private long BusinessID;
    private DepartmentBean Department;
    private BusinessBean Business;

    public long getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(long departmentID) {
        DepartmentID = departmentID;
    }

    public long getBusinessID() {
        return BusinessID;
    }

    public void setBusinessID(long businessID) {
        BusinessID = businessID;
    }

    public String getFiles() {
        return Files;
    }

    public void setFiles(String files) {
        Files = files;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public DepartmentBean getDepartment() {
        return Department;
    }

    public void setDepartment(DepartmentBean department) {
        Department = department;
    }

    public BusinessBean getBusiness() {
        return Business;
    }

    public void setBusiness(BusinessBean business) {
        Business = business;
    }

    public static final class DepartmentBean {
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

        public void setName(String name) {
            Name = name;
        }
    }

    public static final class BusinessBean {
        private int ID;
        private String BusinessName;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getBusinessName() {
            return BusinessName;
        }

        public void setBusinessName(String businessName) {
            BusinessName = businessName;
        }
    }
}
