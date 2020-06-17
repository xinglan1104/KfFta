package com.xl.kffta.model.task;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhanghaochen
 * Date: 2020/6/17
 * 描述：
 */
public class CheckListBean implements Serializable {
    private int ID;
    private String Code;
    private int CompanyID;
    private String Note;
    private int LastModifyByID;
    private String Timestamp;
    private String AdditionInfo;
    private String Files;
    private String CreateTime;
    private int CreatorID;
    private int PageCode;
    private String Name;
    private int Frequency;
    private int FrequencyQuantity;
    private int Percentage;
    private List<Integer> DepartmentIDs;
    private List<Integer> IndustryTypeIDs;
    private List<Integer> FreeTradeZonePriviledgeIDs;
    private List<Integer> ProvincialPriviledgeIDs;
    private List<Integer> BusinessRegistrationIDs;
    private List<Integer> MarketEntryAndAppointmentIDs;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

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

    public int getPageCode() {
        return PageCode;
    }

    public void setPageCode(int PageCode) {
        this.PageCode = PageCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getFrequency() {
        return Frequency;
    }

    public void setFrequency(int Frequency) {
        this.Frequency = Frequency;
    }

    public int getFrequencyQuantity() {
        return FrequencyQuantity;
    }

    public void setFrequencyQuantity(int FrequencyQuantity) {
        this.FrequencyQuantity = FrequencyQuantity;
    }

    public int getPercentage() {
        return Percentage;
    }

    public void setPercentage(int Percentage) {
        this.Percentage = Percentage;
    }

    public List<Integer> getDepartmentIDs() {
        return DepartmentIDs;
    }

    public void setDepartmentIDs(List<Integer> DepartmentIDs) {
        this.DepartmentIDs = DepartmentIDs;
    }

    public List<Integer> getIndustryTypeIDs() {
        return IndustryTypeIDs;
    }

    public void setIndustryTypeIDs(List<Integer> IndustryTypeIDs) {
        this.IndustryTypeIDs = IndustryTypeIDs;
    }

    public List<Integer> getFreeTradeZonePriviledgeIDs() {
        return FreeTradeZonePriviledgeIDs;
    }

    public void setFreeTradeZonePriviledgeIDs(List<Integer> FreeTradeZonePriviledgeIDs) {
        this.FreeTradeZonePriviledgeIDs = FreeTradeZonePriviledgeIDs;
    }

    public List<Integer> getProvincialPriviledgeIDs() {
        return ProvincialPriviledgeIDs;
    }

    public void setProvincialPriviledgeIDs(List<Integer> ProvincialPriviledgeIDs) {
        this.ProvincialPriviledgeIDs = ProvincialPriviledgeIDs;
    }

    public List<Integer> getMarketEntryAndAppointmentIDs() {
        return MarketEntryAndAppointmentIDs;
    }

    public void setMarketEntryAndAppointmentIDs(List<Integer> MarketEntryAndAppointmentIDs) {
        this.MarketEntryAndAppointmentIDs = MarketEntryAndAppointmentIDs;
    }
}
