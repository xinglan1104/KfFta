package com.xl.kffta.model.task;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhanghaochen
 * Date: 2020/6/17
 * 描述：
 */
public class GovermentEnforcementSchemeBean implements Serializable {
    private long ID;
    private String Code;
    private long CompanyID;
    private String Note;
    private int LastModifyByID;
    private String Timestamp;
    private String AdditionInfo;
    private String Files;
    private String DF1;
    private String DF2;
    private String DF3;
    private String DF4;
    private String DF5;
    private String DF6;
    private String DF7;
    private String DF8;
    private String DF9;
    private String DF10;
    private String CreateTime;
    private long CreatorID;
    private long PageCode;
    private String Name;
    private String Reason;
    private int Status;
    private int CheckBusinessQuantity;
    private int AndOr;
    private String StarDate;
    private String EndDate;
    private String BusinessExcelFile;
    private int ResponseTimeQuantity;
    private List<Long> CheckListIDs;
    private List<Long> CustomZoneIDs;
    private List<Long> BusinessIDs;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public long getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(long CompanyID) {
        this.CompanyID = CompanyID;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
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

    public String getAdditionInfo() {
        return AdditionInfo;
    }

    public void setAdditionInfo(String AdditionInfo) {
        this.AdditionInfo = AdditionInfo;
    }

    public String getFiles() {
        return Files;
    }

    public void setFiles(String Files) {
        this.Files = Files;
    }

    public String getDF1() {
        return DF1;
    }

    public void setDF1(String DF1) {
        this.DF1 = DF1;
    }

    public String getDF2() {
        return DF2;
    }

    public void setDF2(String DF2) {
        this.DF2 = DF2;
    }

    public String getDF3() {
        return DF3;
    }

    public void setDF3(String DF3) {
        this.DF3 = DF3;
    }

    public String getDF4() {
        return DF4;
    }

    public void setDF4(String DF4) {
        this.DF4 = DF4;
    }

    public String getDF5() {
        return DF5;
    }

    public void setDF5(String DF5) {
        this.DF5 = DF5;
    }

    public String getDF6() {
        return DF6;
    }

    public void setDF6(String DF6) {
        this.DF6 = DF6;
    }

    public String getDF7() {
        return DF7;
    }

    public void setDF7(String DF7) {
        this.DF7 = DF7;
    }

    public String getDF8() {
        return DF8;
    }

    public void setDF8(String DF8) {
        this.DF8 = DF8;
    }

    public String getDF9() {
        return DF9;
    }

    public void setDF9(String DF9) {
        this.DF9 = DF9;
    }

    public String getDF10() {
        return DF10;
    }

    public void setDF10(String DF10) {
        this.DF10 = DF10;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public long getCreatorID() {
        return CreatorID;
    }

    public void setCreatorID(long CreatorID) {
        this.CreatorID = CreatorID;
    }

    public long getPageCode() {
        return PageCode;
    }

    public void setPageCode(long PageCode) {
        this.PageCode = PageCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getCheckBusinessQuantity() {
        return CheckBusinessQuantity;
    }

    public void setCheckBusinessQuantity(int CheckBusinessQuantity) {
        this.CheckBusinessQuantity = CheckBusinessQuantity;
    }

    public int getAndOr() {
        return AndOr;
    }

    public void setAndOr(int AndOr) {
        this.AndOr = AndOr;
    }

    public String getStarDate() {
        return StarDate;
    }

    public void setStarDate(String StarDate) {
        this.StarDate = StarDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    public String getBusinessExcelFile() {
        return BusinessExcelFile;
    }

    public void setBusinessExcelFile(String BusinessExcelFile) {
        this.BusinessExcelFile = BusinessExcelFile;
    }

    public int getResponseTimeQuantity() {
        return ResponseTimeQuantity;
    }

    public void setResponseTimeQuantity(int ResponseTimeQuantity) {
        this.ResponseTimeQuantity = ResponseTimeQuantity;
    }

    public List<Long> getCheckListIDs() {
        return CheckListIDs;
    }

    public void setCheckListIDs(List<Long> CheckListIDs) {
        this.CheckListIDs = CheckListIDs;
    }

    public List<Long> getCustomZoneIDs() {
        return CustomZoneIDs;
    }

    public void setCustomZoneIDs(List<Long> CustomZoneIDs) {
        this.CustomZoneIDs = CustomZoneIDs;
    }

    public List<Long> getBusinessIDs() {
        return BusinessIDs;
    }

    public void setBusinessIDs(List<Long> BusinessIDs) {
        this.BusinessIDs = BusinessIDs;
    }
}