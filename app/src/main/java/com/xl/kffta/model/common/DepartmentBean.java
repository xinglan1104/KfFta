package com.xl.kffta.model.common;

import java.io.Serializable;
import java.util.List;

/**
 * @author created by zhanghaochen
 * @date 2020-06-15 17:06
 * 描述：
 */
public class DepartmentBean implements Serializable {
    /**
     * ID : 912
     * CompanyID : 4578
     * Name : 办公室
     * DepartmentCode : 000000007
     * ParentID : 0
     * Parent : null
     * ParentPath : [0,912]
     * Status : 1
     * OrganizationType : 0
     * LastModifyByID : 10423
     * Timestamp : /Date(1588926629613)/
     * Labels : []
     * DepartmentManagerIDs : []
     * DepartmentManager : []
     * ColorCode : null
     * PageCode : 0
     * BusinessAreaIDs : [1431]
     * BusinessArea : [{"ID":1431,"AttrID":1431,"CompanyID":4578,"Name":"初级食用农产品、蔬菜、水果、预包装食品","AttrType":6,"Status":1,"R1":null,"R2":null,"Parent":null,"ParentID":0,"ParentPath":[0,1431],"AdditionInfo":null,"CreateTime":"/Date(1587447215399)/","CreatorID":10423,"DF1":null,"DF10":null,"DF2":null,"DF3":null,"DF4":null,"DF5":null,"DF6":null,"DF7":null,"DF8":null,"DF9":null,"LastModifyByID":10423,"PageCode":0,"Timestamp":"/Date(1587447215399)/"}]
     * CreatorID : 10423
     * CreateTime : /Date(1587433071679)/
     * AdditionInfo : null
     * DF1 : 乐菱
     * DF2 : null
     * DF3 : null
     * DF4 : null
     * DF5 : null
     * DF6 : null
     * DF7 : null
     * DF8 : null
     * DF9 : null
     * DF10 : null
     */

    private int ID;
    private int CompanyID;
    private String Name;
    private String DepartmentCode;
    private int ParentID;
    private Object Parent;
    private int Status;
    private int OrganizationType;
    private int LastModifyByID;
    private String Timestamp;
    private Object ColorCode;
    private int PageCode;
    private int CreatorID;
    private String CreateTime;
    private Object AdditionInfo;
    private String DF1;
    private Object DF2;
    private Object DF3;
    private Object DF4;
    private Object DF5;
    private Object DF6;
    private Object DF7;
    private Object DF8;
    private Object DF9;
    private Object DF10;
    private List<Integer> ParentPath;
    private List<?> Labels;
    private List<?> DepartmentManagerIDs;
    private List<?> DepartmentManager;
    private List<Integer> BusinessAreaIDs;
    private List<BusinessAreaBean> BusinessArea;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(int CompanyID) {
        this.CompanyID = CompanyID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDepartmentCode() {
        return DepartmentCode;
    }

    public void setDepartmentCode(String DepartmentCode) {
        this.DepartmentCode = DepartmentCode;
    }

    public int getParentID() {
        return ParentID;
    }

    public void setParentID(int ParentID) {
        this.ParentID = ParentID;
    }

    public Object getParent() {
        return Parent;
    }

    public void setParent(Object Parent) {
        this.Parent = Parent;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getOrganizationType() {
        return OrganizationType;
    }

    public void setOrganizationType(int OrganizationType) {
        this.OrganizationType = OrganizationType;
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

    public Object getColorCode() {
        return ColorCode;
    }

    public void setColorCode(Object ColorCode) {
        this.ColorCode = ColorCode;
    }

    public int getPageCode() {
        return PageCode;
    }

    public void setPageCode(int PageCode) {
        this.PageCode = PageCode;
    }

    public int getCreatorID() {
        return CreatorID;
    }

    public void setCreatorID(int CreatorID) {
        this.CreatorID = CreatorID;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public Object getAdditionInfo() {
        return AdditionInfo;
    }

    public void setAdditionInfo(Object AdditionInfo) {
        this.AdditionInfo = AdditionInfo;
    }

    public String getDF1() {
        return DF1;
    }

    public void setDF1(String DF1) {
        this.DF1 = DF1;
    }

    public Object getDF2() {
        return DF2;
    }

    public void setDF2(Object DF2) {
        this.DF2 = DF2;
    }

    public Object getDF3() {
        return DF3;
    }

    public void setDF3(Object DF3) {
        this.DF3 = DF3;
    }

    public Object getDF4() {
        return DF4;
    }

    public void setDF4(Object DF4) {
        this.DF4 = DF4;
    }

    public Object getDF5() {
        return DF5;
    }

    public void setDF5(Object DF5) {
        this.DF5 = DF5;
    }

    public Object getDF6() {
        return DF6;
    }

    public void setDF6(Object DF6) {
        this.DF6 = DF6;
    }

    public Object getDF7() {
        return DF7;
    }

    public void setDF7(Object DF7) {
        this.DF7 = DF7;
    }

    public Object getDF8() {
        return DF8;
    }

    public void setDF8(Object DF8) {
        this.DF8 = DF8;
    }

    public Object getDF9() {
        return DF9;
    }

    public void setDF9(Object DF9) {
        this.DF9 = DF9;
    }

    public Object getDF10() {
        return DF10;
    }

    public void setDF10(Object DF10) {
        this.DF10 = DF10;
    }

    public List<Integer> getParentPath() {
        return ParentPath;
    }

    public void setParentPath(List<Integer> ParentPath) {
        this.ParentPath = ParentPath;
    }

    public List<?> getLabels() {
        return Labels;
    }

    public void setLabels(List<?> Labels) {
        this.Labels = Labels;
    }

    public List<?> getDepartmentManagerIDs() {
        return DepartmentManagerIDs;
    }

    public void setDepartmentManagerIDs(List<?> DepartmentManagerIDs) {
        this.DepartmentManagerIDs = DepartmentManagerIDs;
    }

    public List<?> getDepartmentManager() {
        return DepartmentManager;
    }

    public void setDepartmentManager(List<?> DepartmentManager) {
        this.DepartmentManager = DepartmentManager;
    }

    public List<Integer> getBusinessAreaIDs() {
        return BusinessAreaIDs;
    }

    public void setBusinessAreaIDs(List<Integer> BusinessAreaIDs) {
        this.BusinessAreaIDs = BusinessAreaIDs;
    }

    public List<BusinessAreaBean> getBusinessArea() {
        return BusinessArea;
    }

    public void setBusinessArea(List<BusinessAreaBean> BusinessArea) {
        this.BusinessArea = BusinessArea;
    }

    public static class BusinessAreaBean {
        /**
         * ID : 1431
         * AttrID : 1431
         * CompanyID : 4578
         * Name : 初级食用农产品、蔬菜、水果、预包装食品
         * AttrType : 6
         * Status : 1
         * R1 : null
         * R2 : null
         * Parent : null
         * ParentID : 0
         * ParentPath : [0,1431]
         * AdditionInfo : null
         * CreateTime : /Date(1587447215399)/
         * CreatorID : 10423
         * DF1 : null
         * DF10 : null
         * DF2 : null
         * DF3 : null
         * DF4 : null
         * DF5 : null
         * DF6 : null
         * DF7 : null
         * DF8 : null
         * DF9 : null
         * LastModifyByID : 10423
         * PageCode : 0
         * Timestamp : /Date(1587447215399)/
         */

        private int ID;
        private int AttrID;
        private int CompanyID;
        private String Name;
        private int AttrType;
        private int Status;
        private Object R1;
        private Object R2;
        private Object Parent;
        private int ParentID;
        private Object AdditionInfo;
        private String CreateTime;
        private int CreatorID;
        private Object DF1;
        private Object DF10;
        private Object DF2;
        private Object DF3;
        private Object DF4;
        private Object DF5;
        private Object DF6;
        private Object DF7;
        private Object DF8;
        private Object DF9;
        private int LastModifyByID;
        private int PageCode;
        private String Timestamp;
        private List<Integer> ParentPath;

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

        public int getCompanyID() {
            return CompanyID;
        }

        public void setCompanyID(int CompanyID) {
            this.CompanyID = CompanyID;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getAttrType() {
            return AttrType;
        }

        public void setAttrType(int AttrType) {
            this.AttrType = AttrType;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public Object getR1() {
            return R1;
        }

        public void setR1(Object R1) {
            this.R1 = R1;
        }

        public Object getR2() {
            return R2;
        }

        public void setR2(Object R2) {
            this.R2 = R2;
        }

        public Object getParent() {
            return Parent;
        }

        public void setParent(Object Parent) {
            this.Parent = Parent;
        }

        public int getParentID() {
            return ParentID;
        }

        public void setParentID(int ParentID) {
            this.ParentID = ParentID;
        }

        public Object getAdditionInfo() {
            return AdditionInfo;
        }

        public void setAdditionInfo(Object AdditionInfo) {
            this.AdditionInfo = AdditionInfo;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getCreatorID() {
            return CreatorID;
        }

        public void setCreatorID(int CreatorID) {
            this.CreatorID = CreatorID;
        }

        public Object getDF1() {
            return DF1;
        }

        public void setDF1(Object DF1) {
            this.DF1 = DF1;
        }

        public Object getDF10() {
            return DF10;
        }

        public void setDF10(Object DF10) {
            this.DF10 = DF10;
        }

        public Object getDF2() {
            return DF2;
        }

        public void setDF2(Object DF2) {
            this.DF2 = DF2;
        }

        public Object getDF3() {
            return DF3;
        }

        public void setDF3(Object DF3) {
            this.DF3 = DF3;
        }

        public Object getDF4() {
            return DF4;
        }

        public void setDF4(Object DF4) {
            this.DF4 = DF4;
        }

        public Object getDF5() {
            return DF5;
        }

        public void setDF5(Object DF5) {
            this.DF5 = DF5;
        }

        public Object getDF6() {
            return DF6;
        }

        public void setDF6(Object DF6) {
            this.DF6 = DF6;
        }

        public Object getDF7() {
            return DF7;
        }

        public void setDF7(Object DF7) {
            this.DF7 = DF7;
        }

        public Object getDF8() {
            return DF8;
        }

        public void setDF8(Object DF8) {
            this.DF8 = DF8;
        }

        public Object getDF9() {
            return DF9;
        }

        public void setDF9(Object DF9) {
            this.DF9 = DF9;
        }

        public int getLastModifyByID() {
            return LastModifyByID;
        }

        public void setLastModifyByID(int LastModifyByID) {
            this.LastModifyByID = LastModifyByID;
        }

        public int getPageCode() {
            return PageCode;
        }

        public void setPageCode(int PageCode) {
            this.PageCode = PageCode;
        }

        public String getTimestamp() {
            return Timestamp;
        }

        public void setTimestamp(String Timestamp) {
            this.Timestamp = Timestamp;
        }

        public List<Integer> getParentPath() {
            return ParentPath;
        }

        public void setParentPath(List<Integer> ParentPath) {
            this.ParentPath = ParentPath;
        }
    }
}
