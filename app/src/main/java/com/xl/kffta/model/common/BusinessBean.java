package com.xl.kffta.model.common;

import java.io.Serializable;
import java.util.List;

/**
 * @author created by zhanghaochen
 * @date 2020-06-15 17:04
 * 描述：
 */
public class BusinessBean implements Serializable {
    private int ID;
    private int CompanyID;
    private String BusinessCode;
    private String BusinessName;
    private int BusinessCompanyID;
    private Object BusinessCompany;
    private int SupplierStatus;
    private int SupplierRelationshipTypeAttrID;
    private Object SupplierRelationshipTypeAttr;
    private int CustomerRelationshipTypeAttrID;
    private Object CustomerRelationshipTypeAttr;
    private int SalesChannelTypeAttrID;
    private Object SalesChannelTypeAttr;
    private int PurchaseChannelTypeAttrID;
    private Object PurchaseChannelTypeAttr;
    private int CustomerStatus;
    private int BusinessRegistrationStatus;
    private String RevkDate;
    private String DOM;
    private String OPFrom;
    private String RegistrationOrgnization;
    private String ApprDate;
    private double BizAddrLatitude;
    private double BizAddrLongitude;
    private String RegOrg;
    private int Grade;
    private int Score;
    private int BusinessLocalAssociationDepartmentID;
    private int CustomZoneID;
    private String NameAbbr;
    private int DefaultContactID;
    private int DefaultShippingAddressID;
    private Object DefaultShippingAddress;
    private int OwnerID;
    private Object Owner;
    private int OwnerDepartmentID;
    private Object OwnerDepartment;
    private int SupplierRank;
    private int CustomerRank;
    private int SupplierRankAttrID;
    private Object SupplierRankAttr;
    private int CustomerRankAttrID;
    private Object CustomerRankAttr;
    private int CustomerClassificationAttrID;
    private Object CustomerClassificationAttr;
    private int SupplierClassificationAttrID;
    private Object SupplierClassificationAttr;
    private String Representative;
    private String CreateTime;
    private String LastSupplierAuditTime;
    private String LastCustomerAuditTime;
    private String SupplierAuditExpire;
    private String CustomerAuditExpire;
    private String BrandRepresent;
    private String URL;
    private String BusinessLicenseRegistrationNumber;
    private String TaxRegistrationCertificateNumber;
    private int TaxRate;
    private String BusinessRegistrationTime;
    private String OrganizationCode;
    private int RegisteredCapital;
    private int RegisteredCurrencyID;
    private Object RegisteredCurrency;
    private String BusinessLicenseExpire;
    private int RegistrationLevelID;
    private Object RegistrationLevel;
    private int ParentCompanyID;
    private Object ParentCompany;
    private String Files;
    private String Desc;
    private String AdditionInfo;
    private int CreatorID;
    private String DF1;
    private String DF10;
    private String DF2;
    private String DF3;
    private String DF4;
    private String DF5;
    private String DF6;
    private String DF7;
    private String DF8;
    private String DF9;
    private int LastModifyByID;
    private int PageCode;
    private String Timestamp;
    private List<?> UnClaimDepartmentIDs;
    private List<Integer> BusinessAreaIDs;
    private List<BusinessAreaBeanX> BusinessArea;
    private List<?> ExtraUserIDs;
    private List<?> ExtraUser;
    private List<?> ExtraDepartmentIDs;
    private List<?> ExtraDepartment;
    private List<Integer> BusinessTypeIDs;
    private List<BusinessTypeBean> BusinessType;
    private List<?> WarehouseIDs;
    private List<?> Warehouse;
    private List<?> WarehouseBinIDs;
    private List<?> WarehouseBin;
    private List<?> WarehouseDeliveryRouteIDs;
    private List<?> WarehouseDeliveryRoute;
    private List<?> MainBusinessIDs;
    private List<?> MainBusiness;
    private List<?> AdditionBusinessIDs;
    private List<?> AdditionBusiness;
    private List<?> OperationModeIDs;
    private List<?> OperationMode;
    private List<Integer> IndustryTypeIDs;
    private List<IndustryTypeBean> IndustryType;
    private List<?> SourceIDs;
    private List<?> Source;
    private List<?> LabelIDs;
    private List<?> TriggeredNotification;

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

    public String getBusinessCode() {
        return BusinessCode;
    }

    public void setBusinessCode(String BusinessCode) {
        this.BusinessCode = BusinessCode;
    }

    public String getBusinessName() {
        return BusinessName;
    }

    public void setBusinessName(String BusinessName) {
        this.BusinessName = BusinessName;
    }

    public int getBusinessCompanyID() {
        return BusinessCompanyID;
    }

    public void setBusinessCompanyID(int BusinessCompanyID) {
        this.BusinessCompanyID = BusinessCompanyID;
    }

    public Object getBusinessCompany() {
        return BusinessCompany;
    }

    public void setBusinessCompany(Object BusinessCompany) {
        this.BusinessCompany = BusinessCompany;
    }

    public int getSupplierStatus() {
        return SupplierStatus;
    }

    public void setSupplierStatus(int SupplierStatus) {
        this.SupplierStatus = SupplierStatus;
    }

    public int getSupplierRelationshipTypeAttrID() {
        return SupplierRelationshipTypeAttrID;
    }

    public void setSupplierRelationshipTypeAttrID(int SupplierRelationshipTypeAttrID) {
        this.SupplierRelationshipTypeAttrID = SupplierRelationshipTypeAttrID;
    }

    public Object getSupplierRelationshipTypeAttr() {
        return SupplierRelationshipTypeAttr;
    }

    public void setSupplierRelationshipTypeAttr(Object SupplierRelationshipTypeAttr) {
        this.SupplierRelationshipTypeAttr = SupplierRelationshipTypeAttr;
    }

    public int getCustomerRelationshipTypeAttrID() {
        return CustomerRelationshipTypeAttrID;
    }

    public void setCustomerRelationshipTypeAttrID(int CustomerRelationshipTypeAttrID) {
        this.CustomerRelationshipTypeAttrID = CustomerRelationshipTypeAttrID;
    }

    public Object getCustomerRelationshipTypeAttr() {
        return CustomerRelationshipTypeAttr;
    }

    public void setCustomerRelationshipTypeAttr(Object CustomerRelationshipTypeAttr) {
        this.CustomerRelationshipTypeAttr = CustomerRelationshipTypeAttr;
    }

    public int getSalesChannelTypeAttrID() {
        return SalesChannelTypeAttrID;
    }

    public void setSalesChannelTypeAttrID(int SalesChannelTypeAttrID) {
        this.SalesChannelTypeAttrID = SalesChannelTypeAttrID;
    }

    public Object getSalesChannelTypeAttr() {
        return SalesChannelTypeAttr;
    }

    public void setSalesChannelTypeAttr(Object SalesChannelTypeAttr) {
        this.SalesChannelTypeAttr = SalesChannelTypeAttr;
    }

    public int getPurchaseChannelTypeAttrID() {
        return PurchaseChannelTypeAttrID;
    }

    public void setPurchaseChannelTypeAttrID(int PurchaseChannelTypeAttrID) {
        this.PurchaseChannelTypeAttrID = PurchaseChannelTypeAttrID;
    }

    public Object getPurchaseChannelTypeAttr() {
        return PurchaseChannelTypeAttr;
    }

    public void setPurchaseChannelTypeAttr(Object PurchaseChannelTypeAttr) {
        this.PurchaseChannelTypeAttr = PurchaseChannelTypeAttr;
    }

    public int getCustomerStatus() {
        return CustomerStatus;
    }

    public void setCustomerStatus(int CustomerStatus) {
        this.CustomerStatus = CustomerStatus;
    }

    public int getBusinessRegistrationStatus() {
        return BusinessRegistrationStatus;
    }

    public void setBusinessRegistrationStatus(int BusinessRegistrationStatus) {
        this.BusinessRegistrationStatus = BusinessRegistrationStatus;
    }

    public String getRevkDate() {
        return RevkDate;
    }

    public void setRevkDate(String RevkDate) {
        this.RevkDate = RevkDate;
    }

    public String getDOM() {
        return DOM;
    }

    public void setDOM(String DOM) {
        this.DOM = DOM;
    }

    public String getOPFrom() {
        return OPFrom;
    }

    public void setOPFrom(String OPFrom) {
        this.OPFrom = OPFrom;
    }

    public String getRegistrationOrgnization() {
        return RegistrationOrgnization;
    }

    public void setRegistrationOrgnization(String RegistrationOrgnization) {
        this.RegistrationOrgnization = RegistrationOrgnization;
    }

    public String getApprDate() {
        return ApprDate;
    }

    public void setApprDate(String ApprDate) {
        this.ApprDate = ApprDate;
    }

    public double getBizAddrLatitude() {
        return BizAddrLatitude;
    }

    public void setBizAddrLatitude(double BizAddrLatitude) {
        this.BizAddrLatitude = BizAddrLatitude;
    }

    public double getBizAddrLongitude() {
        return BizAddrLongitude;
    }

    public void setBizAddrLongitude(double BizAddrLongitude) {
        this.BizAddrLongitude = BizAddrLongitude;
    }

    public String getRegOrg() {
        return RegOrg;
    }

    public void setRegOrg(String RegOrg) {
        this.RegOrg = RegOrg;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int Grade) {
        this.Grade = Grade;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public int getBusinessLocalAssociationDepartmentID() {
        return BusinessLocalAssociationDepartmentID;
    }

    public void setBusinessLocalAssociationDepartmentID(int BusinessLocalAssociationDepartmentID) {
        this.BusinessLocalAssociationDepartmentID = BusinessLocalAssociationDepartmentID;
    }

    public int getCustomZoneID() {
        return CustomZoneID;
    }

    public void setCustomZoneID(int CustomZoneID) {
        this.CustomZoneID = CustomZoneID;
    }

    public String getNameAbbr() {
        return NameAbbr;
    }

    public void setNameAbbr(String NameAbbr) {
        this.NameAbbr = NameAbbr;
    }

    public int getDefaultContactID() {
        return DefaultContactID;
    }

    public void setDefaultContactID(int DefaultContactID) {
        this.DefaultContactID = DefaultContactID;
    }

    public int getDefaultShippingAddressID() {
        return DefaultShippingAddressID;
    }

    public void setDefaultShippingAddressID(int DefaultShippingAddressID) {
        this.DefaultShippingAddressID = DefaultShippingAddressID;
    }

    public Object getDefaultShippingAddress() {
        return DefaultShippingAddress;
    }

    public void setDefaultShippingAddress(Object DefaultShippingAddress) {
        this.DefaultShippingAddress = DefaultShippingAddress;
    }

    public int getOwnerID() {
        return OwnerID;
    }

    public void setOwnerID(int OwnerID) {
        this.OwnerID = OwnerID;
    }

    public Object getOwner() {
        return Owner;
    }

    public void setOwner(Object Owner) {
        this.Owner = Owner;
    }

    public int getOwnerDepartmentID() {
        return OwnerDepartmentID;
    }

    public void setOwnerDepartmentID(int OwnerDepartmentID) {
        this.OwnerDepartmentID = OwnerDepartmentID;
    }

    public Object getOwnerDepartment() {
        return OwnerDepartment;
    }

    public void setOwnerDepartment(Object OwnerDepartment) {
        this.OwnerDepartment = OwnerDepartment;
    }

    public int getSupplierRank() {
        return SupplierRank;
    }

    public void setSupplierRank(int SupplierRank) {
        this.SupplierRank = SupplierRank;
    }

    public int getCustomerRank() {
        return CustomerRank;
    }

    public void setCustomerRank(int CustomerRank) {
        this.CustomerRank = CustomerRank;
    }

    public int getSupplierRankAttrID() {
        return SupplierRankAttrID;
    }

    public void setSupplierRankAttrID(int SupplierRankAttrID) {
        this.SupplierRankAttrID = SupplierRankAttrID;
    }

    public Object getSupplierRankAttr() {
        return SupplierRankAttr;
    }

    public void setSupplierRankAttr(Object SupplierRankAttr) {
        this.SupplierRankAttr = SupplierRankAttr;
    }

    public int getCustomerRankAttrID() {
        return CustomerRankAttrID;
    }

    public void setCustomerRankAttrID(int CustomerRankAttrID) {
        this.CustomerRankAttrID = CustomerRankAttrID;
    }

    public Object getCustomerRankAttr() {
        return CustomerRankAttr;
    }

    public void setCustomerRankAttr(Object CustomerRankAttr) {
        this.CustomerRankAttr = CustomerRankAttr;
    }

    public int getCustomerClassificationAttrID() {
        return CustomerClassificationAttrID;
    }

    public void setCustomerClassificationAttrID(int CustomerClassificationAttrID) {
        this.CustomerClassificationAttrID = CustomerClassificationAttrID;
    }

    public Object getCustomerClassificationAttr() {
        return CustomerClassificationAttr;
    }

    public void setCustomerClassificationAttr(Object CustomerClassificationAttr) {
        this.CustomerClassificationAttr = CustomerClassificationAttr;
    }

    public int getSupplierClassificationAttrID() {
        return SupplierClassificationAttrID;
    }

    public void setSupplierClassificationAttrID(int SupplierClassificationAttrID) {
        this.SupplierClassificationAttrID = SupplierClassificationAttrID;
    }

    public Object getSupplierClassificationAttr() {
        return SupplierClassificationAttr;
    }

    public void setSupplierClassificationAttr(Object SupplierClassificationAttr) {
        this.SupplierClassificationAttr = SupplierClassificationAttr;
    }

    public String getRepresentative() {
        return Representative;
    }

    public void setRepresentative(String Representative) {
        this.Representative = Representative;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public String getLastSupplierAuditTime() {
        return LastSupplierAuditTime;
    }

    public void setLastSupplierAuditTime(String LastSupplierAuditTime) {
        this.LastSupplierAuditTime = LastSupplierAuditTime;
    }

    public String getLastCustomerAuditTime() {
        return LastCustomerAuditTime;
    }

    public void setLastCustomerAuditTime(String LastCustomerAuditTime) {
        this.LastCustomerAuditTime = LastCustomerAuditTime;
    }

    public String getSupplierAuditExpire() {
        return SupplierAuditExpire;
    }

    public void setSupplierAuditExpire(String SupplierAuditExpire) {
        this.SupplierAuditExpire = SupplierAuditExpire;
    }

    public String getCustomerAuditExpire() {
        return CustomerAuditExpire;
    }

    public void setCustomerAuditExpire(String CustomerAuditExpire) {
        this.CustomerAuditExpire = CustomerAuditExpire;
    }

    public String getBrandRepresent() {
        return BrandRepresent;
    }

    public void setBrandRepresent(String BrandRepresent) {
        this.BrandRepresent = BrandRepresent;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getBusinessLicenseRegistrationNumber() {
        return BusinessLicenseRegistrationNumber;
    }

    public void setBusinessLicenseRegistrationNumber(String BusinessLicenseRegistrationNumber) {
        this.BusinessLicenseRegistrationNumber = BusinessLicenseRegistrationNumber;
    }

    public String getTaxRegistrationCertificateNumber() {
        return TaxRegistrationCertificateNumber;
    }

    public void setTaxRegistrationCertificateNumber(String TaxRegistrationCertificateNumber) {
        this.TaxRegistrationCertificateNumber = TaxRegistrationCertificateNumber;
    }

    public int getTaxRate() {
        return TaxRate;
    }

    public void setTaxRate(int TaxRate) {
        this.TaxRate = TaxRate;
    }

    public String getBusinessRegistrationTime() {
        return BusinessRegistrationTime;
    }

    public void setBusinessRegistrationTime(String BusinessRegistrationTime) {
        this.BusinessRegistrationTime = BusinessRegistrationTime;
    }

    public String getOrganizationCode() {
        return OrganizationCode;
    }

    public void setOrganizationCode(String OrganizationCode) {
        this.OrganizationCode = OrganizationCode;
    }

    public int getRegisteredCapital() {
        return RegisteredCapital;
    }

    public void setRegisteredCapital(int RegisteredCapital) {
        this.RegisteredCapital = RegisteredCapital;
    }

    public int getRegisteredCurrencyID() {
        return RegisteredCurrencyID;
    }

    public void setRegisteredCurrencyID(int RegisteredCurrencyID) {
        this.RegisteredCurrencyID = RegisteredCurrencyID;
    }

    public Object getRegisteredCurrency() {
        return RegisteredCurrency;
    }

    public void setRegisteredCurrency(Object RegisteredCurrency) {
        this.RegisteredCurrency = RegisteredCurrency;
    }

    public String getBusinessLicenseExpire() {
        return BusinessLicenseExpire;
    }

    public void setBusinessLicenseExpire(String BusinessLicenseExpire) {
        this.BusinessLicenseExpire = BusinessLicenseExpire;
    }

    public int getRegistrationLevelID() {
        return RegistrationLevelID;
    }

    public void setRegistrationLevelID(int RegistrationLevelID) {
        this.RegistrationLevelID = RegistrationLevelID;
    }

    public Object getRegistrationLevel() {
        return RegistrationLevel;
    }

    public void setRegistrationLevel(Object RegistrationLevel) {
        this.RegistrationLevel = RegistrationLevel;
    }

    public int getParentCompanyID() {
        return ParentCompanyID;
    }

    public void setParentCompanyID(int ParentCompanyID) {
        this.ParentCompanyID = ParentCompanyID;
    }

    public Object getParentCompany() {
        return ParentCompany;
    }

    public void setParentCompany(Object ParentCompany) {
        this.ParentCompany = ParentCompany;
    }

    public String getFiles() {
        return Files;
    }

    public void setFiles(String Files) {
        this.Files = Files;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public String getAdditionInfo() {
        return AdditionInfo;
    }

    public void setAdditionInfo(String AdditionInfo) {
        this.AdditionInfo = AdditionInfo;
    }

    public int getCreatorID() {
        return CreatorID;
    }

    public void setCreatorID(int CreatorID) {
        this.CreatorID = CreatorID;
    }

    public String getDF1() {
        return DF1;
    }

    public void setDF1(String DF1) {
        this.DF1 = DF1;
    }

    public String getDF10() {
        return DF10;
    }

    public void setDF10(String DF10) {
        this.DF10 = DF10;
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

    public List<?> getUnClaimDepartmentIDs() {
        return UnClaimDepartmentIDs;
    }

    public void setUnClaimDepartmentIDs(List<?> UnClaimDepartmentIDs) {
        this.UnClaimDepartmentIDs = UnClaimDepartmentIDs;
    }

    public List<Integer> getBusinessAreaIDs() {
        return BusinessAreaIDs;
    }

    public void setBusinessAreaIDs(List<Integer> BusinessAreaIDs) {
        this.BusinessAreaIDs = BusinessAreaIDs;
    }

    public List<BusinessAreaBeanX> getBusinessArea() {
        return BusinessArea;
    }

    public void setBusinessArea(List<BusinessAreaBeanX> BusinessArea) {
        this.BusinessArea = BusinessArea;
    }

    public List<?> getExtraUserIDs() {
        return ExtraUserIDs;
    }

    public void setExtraUserIDs(List<?> ExtraUserIDs) {
        this.ExtraUserIDs = ExtraUserIDs;
    }

    public List<?> getExtraUser() {
        return ExtraUser;
    }

    public void setExtraUser(List<?> ExtraUser) {
        this.ExtraUser = ExtraUser;
    }

    public List<?> getExtraDepartmentIDs() {
        return ExtraDepartmentIDs;
    }

    public void setExtraDepartmentIDs(List<?> ExtraDepartmentIDs) {
        this.ExtraDepartmentIDs = ExtraDepartmentIDs;
    }

    public List<?> getExtraDepartment() {
        return ExtraDepartment;
    }

    public void setExtraDepartment(List<?> ExtraDepartment) {
        this.ExtraDepartment = ExtraDepartment;
    }

    public List<Integer> getBusinessTypeIDs() {
        return BusinessTypeIDs;
    }

    public void setBusinessTypeIDs(List<Integer> BusinessTypeIDs) {
        this.BusinessTypeIDs = BusinessTypeIDs;
    }

    public List<BusinessTypeBean> getBusinessType() {
        return BusinessType;
    }

    public void setBusinessType(List<BusinessTypeBean> BusinessType) {
        this.BusinessType = BusinessType;
    }

    public List<?> getWarehouseIDs() {
        return WarehouseIDs;
    }

    public void setWarehouseIDs(List<?> WarehouseIDs) {
        this.WarehouseIDs = WarehouseIDs;
    }

    public List<?> getWarehouse() {
        return Warehouse;
    }

    public void setWarehouse(List<?> Warehouse) {
        this.Warehouse = Warehouse;
    }

    public List<?> getWarehouseBinIDs() {
        return WarehouseBinIDs;
    }

    public void setWarehouseBinIDs(List<?> WarehouseBinIDs) {
        this.WarehouseBinIDs = WarehouseBinIDs;
    }

    public List<?> getWarehouseBin() {
        return WarehouseBin;
    }

    public void setWarehouseBin(List<?> WarehouseBin) {
        this.WarehouseBin = WarehouseBin;
    }

    public List<?> getWarehouseDeliveryRouteIDs() {
        return WarehouseDeliveryRouteIDs;
    }

    public void setWarehouseDeliveryRouteIDs(List<?> WarehouseDeliveryRouteIDs) {
        this.WarehouseDeliveryRouteIDs = WarehouseDeliveryRouteIDs;
    }

    public List<?> getWarehouseDeliveryRoute() {
        return WarehouseDeliveryRoute;
    }

    public void setWarehouseDeliveryRoute(List<?> WarehouseDeliveryRoute) {
        this.WarehouseDeliveryRoute = WarehouseDeliveryRoute;
    }

    public List<?> getMainBusinessIDs() {
        return MainBusinessIDs;
    }

    public void setMainBusinessIDs(List<?> MainBusinessIDs) {
        this.MainBusinessIDs = MainBusinessIDs;
    }

    public List<?> getMainBusiness() {
        return MainBusiness;
    }

    public void setMainBusiness(List<?> MainBusiness) {
        this.MainBusiness = MainBusiness;
    }

    public List<?> getAdditionBusinessIDs() {
        return AdditionBusinessIDs;
    }

    public void setAdditionBusinessIDs(List<?> AdditionBusinessIDs) {
        this.AdditionBusinessIDs = AdditionBusinessIDs;
    }

    public List<?> getAdditionBusiness() {
        return AdditionBusiness;
    }

    public void setAdditionBusiness(List<?> AdditionBusiness) {
        this.AdditionBusiness = AdditionBusiness;
    }

    public List<?> getOperationModeIDs() {
        return OperationModeIDs;
    }

    public void setOperationModeIDs(List<?> OperationModeIDs) {
        this.OperationModeIDs = OperationModeIDs;
    }

    public List<?> getOperationMode() {
        return OperationMode;
    }

    public void setOperationMode(List<?> OperationMode) {
        this.OperationMode = OperationMode;
    }

    public List<Integer> getIndustryTypeIDs() {
        return IndustryTypeIDs;
    }

    public void setIndustryTypeIDs(List<Integer> IndustryTypeIDs) {
        this.IndustryTypeIDs = IndustryTypeIDs;
    }

    public List<IndustryTypeBean> getIndustryType() {
        return IndustryType;
    }

    public void setIndustryType(List<IndustryTypeBean> IndustryType) {
        this.IndustryType = IndustryType;
    }

    public List<?> getSourceIDs() {
        return SourceIDs;
    }

    public void setSourceIDs(List<?> SourceIDs) {
        this.SourceIDs = SourceIDs;
    }

    public List<?> getSource() {
        return Source;
    }

    public void setSource(List<?> Source) {
        this.Source = Source;
    }

    public List<?> getLabelIDs() {
        return LabelIDs;
    }

    public void setLabelIDs(List<?> LabelIDs) {
        this.LabelIDs = LabelIDs;
    }

    public List<?> getTriggeredNotification() {
        return TriggeredNotification;
    }

    public void setTriggeredNotification(List<?> TriggeredNotification) {
        this.TriggeredNotification = TriggeredNotification;
    }

    public static class BusinessAreaBeanX {
        /**
         * ID : 1432
         * AttrID : 1432
         * CompanyID : 4578
         * Name : 计算机软件技术开发
         * AttrType : 6
         * Status : 1
         * R1 : null
         * R2 : null
         * Parent : null
         * ParentID : 0
         * ParentPath : [0,1432]
         * AdditionInfo : null
         * CreateTime : /Date(1587447219608)/
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
         * Timestamp : /Date(1587447219608)/
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

    public static class BusinessTypeBean {
        /**
         * ID : -3
         * AttrID : -3
         * CompanyID : 0
         * Name : 个人
         * AttrType : 5
         * Status : 1
         * R1 : null
         * R2 : null
         * Parent : null
         * ParentID : 0
         * ParentPath : [0,-3]
         * AdditionInfo : null
         * CreateTime : /Date(-62135596800000)/
         * CreatorID : 0
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
         * LastModifyByID : 0
         * PageCode : 0
         * Timestamp : /Date(-62135596800000)/
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

    public static class IndustryTypeBean {
        /**
         * ID : 1427
         * AttrID : 1427
         * CompanyID : 4578
         * Name : 软件
         * AttrType : 12
         * Status : 1
         * R1 : null
         * R2 : null
         * Parent : null
         * ParentID : 0
         * ParentPath : [0,1427]
         * AdditionInfo : null
         * CreateTime : /Date(1587445766841)/
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
         * Timestamp : /Date(1587445766841)/
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
