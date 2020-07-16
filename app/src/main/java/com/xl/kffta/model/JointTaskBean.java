package com.xl.kffta.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author created by zhanghaochen
 * @date 2020-05-21 11:10
 * 描述：联合监管方案大实例类
 */
public class JointTaskBean implements Serializable {

    /**
     * Fields : {"GovermentJointSupervisionSchemeID":"联合监管检查方案","DeparmentID":"部门","OwnerID":"执检查人","GovermentProjectRiskIDs":"检查阶段","AcceptStatus":"接受状态","ExcutionStatus":"执行状态","CheckDate":"检查时间","Result":"检查结果","CreateTime":"创建时间","Files":"附件"}
     * Data : [{"AcceptStatus":3,"CheckDate":"/Date(-62135596800000)/","CompanyID":4578,"CreateTime":"/Date(1589777210904)/","Deparment":{"ID":912,"Name":"办公室"},"DeparmentID":912,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":5,"Name":"检查方案A"},"GovermentJointSupervisionSchemeID":5,"GovermentProjectRisk":[{"ID":4,"Name":"图纸会审"}],"GovermentProjectRiskIDs":[4],"ID":26,"Owner":{"DisplayName":"mm","ID":10460},"OwnerID":10460,"PageCode":0},{"AcceptStatus":3,"CheckDate":"/Date(-62135596800000)/","CompanyID":4578,"CreateTime":"/Date(1589777071758)/","Deparment":{"ID":913,"Name":"法制科"},"DeparmentID":913,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":6,"Name":"检查方案B"},"GovermentJointSupervisionSchemeID":6,"GovermentProjectRisk":[{"ID":3,"Name":"现场拆迁"}],"GovermentProjectRiskIDs":[3],"ID":25,"Owner":{"DisplayName":"法制科1","ID":10461},"OwnerID":10461,"PageCode":0},{"AcceptStatus":3,"CheckDate":"/Date(-62135596800000)/","CompanyID":4578,"CreateTime":"/Date(1589777071757)/","Deparment":{"ID":912,"Name":"办公室"},"DeparmentID":912,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":6,"Name":"检查方案B"},"GovermentJointSupervisionSchemeID":6,"GovermentProjectRisk":[{"ID":3,"Name":"现场拆迁"}],"GovermentProjectRiskIDs":[3],"ID":24,"Owner":{"DisplayName":"mm","ID":10460},"OwnerID":10460,"PageCode":0},{"AcceptStatus":3,"CheckDate":"/Date(-62135596800000)/","CompanyID":4578,"CreateTime":"/Date(1589770895411)/","Deparment":{"ID":912,"Name":"办公室"},"DeparmentID":912,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":5,"Name":"检查方案A"},"GovermentJointSupervisionSchemeID":5,"GovermentProjectRisk":[{"ID":4,"Name":"图纸会审"}],"GovermentProjectRiskIDs":[4],"ID":23,"Owner":{"DisplayName":"mm","ID":10460},"OwnerID":10460,"PageCode":0},{"AcceptStatus":1,"CheckDate":"/Date(-62135596800000)/","CompanyID":4578,"CreateTime":"/Date(1589769864684)/","Deparment":{"ID":913,"Name":"法制科"},"DeparmentID":913,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":4,"Name":"自贸区联合监管检查方案第一季度"},"GovermentJointSupervisionSchemeID":4,"GovermentProjectRisk":[{"ID":3,"Name":"现场拆迁"}],"GovermentProjectRiskIDs":[3],"ID":22,"Owner":{"DisplayName":"法制科1","ID":10461},"OwnerID":10461,"PageCode":0},{"AcceptStatus":1,"CheckDate":"/Date(-62135596800000)/","CompanyID":4578,"CreateTime":"/Date(1589769864684)/","Deparment":{"ID":912,"Name":"办公室"},"DeparmentID":912,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":4,"Name":"自贸区联合监管检查方案第一季度"},"GovermentJointSupervisionSchemeID":4,"GovermentProjectRisk":[{"ID":3,"Name":"现场拆迁"}],"GovermentProjectRiskIDs":[3],"ID":21,"Owner":{"DisplayName":"mm","ID":10460},"OwnerID":10460,"PageCode":0},{"AcceptStatus":1,"CheckDate":"/Date(-62135596800000)/","CompanyID":4578,"CreateTime":"/Date(1589767749729)/","Deparment":{"ID":913,"Name":"法制科"},"DeparmentID":913,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":4,"Name":"自贸区联合监管检查方案第一季度"},"GovermentJointSupervisionSchemeID":4,"GovermentProjectRisk":[{"ID":3,"Name":"现场拆迁"}],"GovermentProjectRiskIDs":[3],"ID":20,"Owner":{"DisplayName":"法制科3","ID":10492},"OwnerID":10492,"PageCode":0},{"AcceptStatus":3,"CheckDate":"/Date(-62135596800000)/","CompanyID":4578,"CreateTime":"/Date(1589767749728)/","Deparment":{"ID":912,"Name":"办公室"},"DeparmentID":912,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":4,"Name":"自贸区联合监管检查方案第一季度"},"GovermentJointSupervisionSchemeID":4,"GovermentProjectRisk":[{"ID":3,"Name":"现场拆迁"}],"GovermentProjectRiskIDs":[3],"ID":19,"Owner":{"DisplayName":"mm","ID":10460},"OwnerID":10460,"PageCode":0},{"AcceptStatus":1,"CheckDate":"/Date(-62135596800000)/","CompanyID":4578,"CreateTime":"/Date(1589529745379)/","Deparment":{"ID":911,"Name":"商标广告监督管理科"},"DeparmentID":911,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":3,"Name":"联合监管检查方案A"},"GovermentJointSupervisionSchemeID":3,"GovermentProjectRisk":[{"ID":2,"Name":"图纸设计"}],"GovermentProjectRiskIDs":[2],"ID":18,"Owner":{"ID":0},"OwnerID":0,"PageCode":0},{"AcceptStatus":1,"CheckDate":"/Date(-62135596800000)/","CompanyID":4578,"CreateTime":"/Date(1589529745378)/","Deparment":{"ID":912,"Name":"办公室"},"DeparmentID":912,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":3,"Name":"联合监管检查方案A"},"GovermentJointSupervisionSchemeID":3,"GovermentProjectRisk":[{"ID":4,"Name":"图纸会审"}],"GovermentProjectRiskIDs":[4],"ID":17,"Owner":{"ID":0},"OwnerID":0,"PageCode":0},{"AcceptStatus":1,"CheckDate":"/Date(-62135596800000)/","CompanyID":4578,"CreateTime":"/Date(1589529646893)/","Deparment":{"ID":911,"Name":"商标广告监督管理科"},"DeparmentID":911,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":3,"Name":"联合监管检查方案A"},"GovermentJointSupervisionSchemeID":3,"GovermentProjectRisk":[{"ID":2,"Name":"图纸设计"}],"GovermentProjectRiskIDs":[2],"ID":16,"Owner":{"ID":0},"OwnerID":0,"PageCode":0},{"AcceptStatus":1,"CheckDate":"/Date(-62135596800000)/","CompanyID":4578,"CreateTime":"/Date(1589529646893)/","Deparment":{"ID":912,"Name":"办公室"},"DeparmentID":912,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":3,"Name":"联合监管检查方案A"},"GovermentJointSupervisionSchemeID":3,"GovermentProjectRisk":[{"ID":4,"Name":"图纸会审"}],"GovermentProjectRiskIDs":[4],"ID":15,"Owner":{"ID":0},"OwnerID":0,"PageCode":0},{"AcceptStatus":1,"CheckDate":"/Date(-62135596800000)/","CompanyID":4578,"CreateTime":"/Date(1589528920970)/","Deparment":{"ID":912,"Name":"办公室"},"DeparmentID":912,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":1,"Name":"自贸区联合监管检查方案"},"GovermentJointSupervisionSchemeID":1,"GovermentProjectRisk":[{"ID":1,"Name":"地质勘探"}],"GovermentProjectRiskIDs":[1],"ID":14,"Owner":{"ID":0},"OwnerID":0,"PageCode":0},{"AcceptStatus":1,"CheckDate":"/Date(-62135596800000)/","CompanyID":4578,"CreateTime":"/Date(1589528903826)/","Deparment":{"ID":911,"Name":"商标广告监督管理科"},"DeparmentID":911,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":3,"Name":"联合监管检查方案A"},"GovermentJointSupervisionSchemeID":3,"GovermentProjectRisk":[{"ID":2,"Name":"图纸设计"}],"GovermentProjectRiskIDs":[2],"ID":13,"Owner":{"ID":0},"OwnerID":0,"PageCode":0},{"AcceptStatus":1,"CheckDate":"/Date(-62135596800000)/","CompanyID":4578,"CreateTime":"/Date(1589528903826)/","Deparment":{"ID":912,"Name":"办公室"},"DeparmentID":912,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":3,"Name":"联合监管检查方案A"},"GovermentJointSupervisionSchemeID":3,"GovermentProjectRisk":[{"ID":4,"Name":"图纸会审"}],"GovermentProjectRiskIDs":[4],"ID":12,"Owner":{"ID":0},"OwnerID":0,"PageCode":0},{"AcceptStatus":3,"CheckDate":"/Date(1588089600000)/","CompanyID":4578,"CreateTime":"/Date(1587964761069)/","Deparment":{"ID":903,"Name":"Admin"},"DeparmentID":903,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":1,"Name":"自贸区联合监管检查方案"},"GovermentJointSupervisionSchemeID":1,"GovermentProjectRisk":[],"ID":4,"Owner":{"DisplayName":"南春","ID":10449},"OwnerID":10449,"PageCode":0,"Result":""},{"AcceptStatus":3,"CheckDate":"/Date(1587916800000)/","CompanyID":4578,"CreateTime":"/Date(1587964709670)/","Deparment":{"ID":903,"Name":"Admin"},"DeparmentID":903,"ExcutionStatus":0,"GovermentJointSupervisionScheme":{"ID":3,"Name":"联合监管检查方案A"},"GovermentJointSupervisionSchemeID":3,"GovermentProjectRisk":[],"ID":3,"Owner":{"DisplayName":"雅琴","ID":10451},"OwnerID":10451,"PageCode":0,"Result":"完成"}]
     * Error : null
     * ErrorCode : 0
     * ResponseStatus : null
     * EncryptionData : null
     * AESEncryptionKey : null
     */

    private FieldsBean Fields;
    private String Error;
    private int ErrorCode;
    private Object ResponseStatus;
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

    public Object getResponseStatus() {
        return ResponseStatus;
    }

    public void setResponseStatus(Object ResponseStatus) {
        this.ResponseStatus = ResponseStatus;
    }

    public ArrayList<DataBean> getData() {
        return Data;
    }

    public void setData(ArrayList<DataBean> Data) {
        this.Data = Data;
    }

    public static class FieldsBean {
        /**
         * GovermentJointSupervisionSchemeID : 联合监管检查方案
         * DeparmentID : 部门
         * OwnerID : 执检查人
         * GovermentProjectRiskIDs : 检查阶段
         * AcceptStatus : 接受状态
         * ExcutionStatus : 执行状态
         * CheckDate : 检查时间
         * Result : 检查结果
         * CreateTime : 创建时间
         * Files : 附件
         */

        private String GovermentJointSupervisionSchemeID;
        private String DeparmentID;
        private String OwnerID;
        private String GovermentProjectRiskIDs;
        private String AcceptStatus;
        private String ExcutionStatus;
        private String CheckDate;
        private String Result;
        private String CreateTime;
        private String Files;

        public String getGovermentJointSupervisionSchemeID() {
            return GovermentJointSupervisionSchemeID;
        }

        public void setGovermentJointSupervisionSchemeID(String GovermentJointSupervisionSchemeID) {
            this.GovermentJointSupervisionSchemeID = GovermentJointSupervisionSchemeID;
        }

        public String getDeparmentID() {
            return DeparmentID;
        }

        public void setDeparmentID(String DeparmentID) {
            this.DeparmentID = DeparmentID;
        }

        public String getOwnerID() {
            return OwnerID;
        }

        public void setOwnerID(String OwnerID) {
            this.OwnerID = OwnerID;
        }

        public String getGovermentProjectRiskIDs() {
            return GovermentProjectRiskIDs;
        }

        public void setGovermentProjectRiskIDs(String GovermentProjectRiskIDs) {
            this.GovermentProjectRiskIDs = GovermentProjectRiskIDs;
        }

        public String getAcceptStatus() {
            return AcceptStatus;
        }

        public void setAcceptStatus(String AcceptStatus) {
            this.AcceptStatus = AcceptStatus;
        }

        public String getExcutionStatus() {
            return ExcutionStatus;
        }

        public void setExcutionStatus(String ExcutionStatus) {
            this.ExcutionStatus = ExcutionStatus;
        }

        public String getCheckDate() {
            return CheckDate;
        }

        public void setCheckDate(String CheckDate) {
            this.CheckDate = CheckDate;
        }

        public String getResult() {
            return Result;
        }

        public void setResult(String Result) {
            this.Result = Result;
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
    }

    public static class DataBean {
        /**
         * AcceptStatus : 3
         * CheckDate : /Date(-62135596800000)/
         * CompanyID : 4578
         * CreateTime : /Date(1589777210904)/
         * Deparment : {"ID":912,"Name":"办公室"}
         * DeparmentID : 912
         * ExcutionStatus : 0
         * GovermentJointSupervisionScheme : {"ID":5,"Name":"检查方案A"}
         * GovermentJointSupervisionSchemeID : 5
         * GovermentProjectRisk : [{"ID":4,"Name":"图纸会审"}]
         * GovermentProjectRiskIDs : [4]
         * ID : 26
         * Owner : {"DisplayName":"mm","ID":10460}
         * OwnerID : 10460
         * PageCode : 0
         * Result :
         */

        private int AcceptStatus;
        private String CheckDate;
        private int CompanyID;
        private String CreateTime;
        private DeparmentBean Deparment;
        private int DeparmentID;
        private int ExcutionStatus;
        private GovermentJointSupervisionSchemeBean GovermentJointSupervisionScheme;
        private int GovermentJointSupervisionSchemeID;
        private int ID;
        private List<OwnerBean> Owner;
        private List<Long> OwnerIDs;
        private List<OwnerBean> PendingOwner;
        private List<Long> PendingOwnerIDs;
        private int PageCode;
        private String Result;
        private List<GovermentProjectRiskBean> GovermentProjectRisk;
        private List<Long> GovermentProjectRiskIDs;

        public List<Long> getOwnerIDs() {
            return OwnerIDs;
        }

        public void setOwnerIDs(List<Long> ownerIDs) {
            OwnerIDs = ownerIDs;
        }

        public List<OwnerBean> getPendingOwner() {
            return PendingOwner;
        }

        public void setPendingOwner(List<OwnerBean> pendingOwner) {
            PendingOwner = pendingOwner;
        }

        public List<Long> getPendingOwnerIDs() {
            return PendingOwnerIDs;
        }

        public void setPendingOwnerIDs(List<Long> pendingOwnerIDs) {
            PendingOwnerIDs = pendingOwnerIDs;
        }

        public int getAcceptStatus() {
            return AcceptStatus;
        }

        public void setAcceptStatus(int AcceptStatus) {
            this.AcceptStatus = AcceptStatus;
        }

        public String getCheckDate() {
            return CheckDate;
        }

        public void setCheckDate(String CheckDate) {
            this.CheckDate = CheckDate;
        }

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

        public DeparmentBean getDeparment() {
            return Deparment;
        }

        public void setDeparment(DeparmentBean Deparment) {
            this.Deparment = Deparment;
        }

        public int getDeparmentID() {
            return DeparmentID;
        }

        public void setDeparmentID(int DeparmentID) {
            this.DeparmentID = DeparmentID;
        }

        public int getExcutionStatus() {
            return ExcutionStatus;
        }

        public void setExcutionStatus(int ExcutionStatus) {
            this.ExcutionStatus = ExcutionStatus;
        }

        public GovermentJointSupervisionSchemeBean getGovermentJointSupervisionScheme() {
            return GovermentJointSupervisionScheme;
        }

        public void setGovermentJointSupervisionScheme(GovermentJointSupervisionSchemeBean GovermentJointSupervisionScheme) {
            this.GovermentJointSupervisionScheme = GovermentJointSupervisionScheme;
        }

        public int getGovermentJointSupervisionSchemeID() {
            return GovermentJointSupervisionSchemeID;
        }

        public void setGovermentJointSupervisionSchemeID(int GovermentJointSupervisionSchemeID) {
            this.GovermentJointSupervisionSchemeID = GovermentJointSupervisionSchemeID;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public List<OwnerBean> getOwner() {
            return Owner;
        }

        public void setOwner(List<OwnerBean> Owner) {
            this.Owner = Owner;
        }

        public int getPageCode() {
            return PageCode;
        }

        public void setPageCode(int PageCode) {
            this.PageCode = PageCode;
        }

        public String getResult() {
            return Result;
        }

        public void setResult(String Result) {
            this.Result = Result;
        }

        public List<GovermentProjectRiskBean> getGovermentProjectRisk() {
            return GovermentProjectRisk;
        }

        public void setGovermentProjectRisk(List<GovermentProjectRiskBean> GovermentProjectRisk) {
            this.GovermentProjectRisk = GovermentProjectRisk;
        }

        public List<Long> getGovermentProjectRiskIDs() {
            return GovermentProjectRiskIDs;
        }

        public void setGovermentProjectRiskIDs(List<Long> GovermentProjectRiskIDs) {
            this.GovermentProjectRiskIDs = GovermentProjectRiskIDs;
        }

        public static class DeparmentBean {
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

        public static class GovermentJointSupervisionSchemeBean {
            /**
             * ID : 5
             * Name : 检查方案A
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

        public static class OwnerBean {
            /**
             * DisplayName : mm
             * ID : 10460
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

        public static class GovermentProjectRiskBean {
            /**
             * ID : 4
             * Name : 图纸会审
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
