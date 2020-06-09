package com.xl.kffta.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author created by zhanghaochen
 * @date 2020-06-09 13:52
 * 描述：请求附件信息的实例类
 */
public class CommonFileBean implements Serializable {

    private String Error;
    private int ErrorCode;
    private Object ResponseStatus;
    private Object EncryptionData;
    private Object AESEncryptionKey;
    private List<FilesBean> Files;

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

    public List<FilesBean> getFiles() {
        return Files;
    }

    public void setFiles(List<FilesBean> Files) {
        this.Files = Files;
    }

    public static class FilesBean {
        private int ID;
        private int CompanyID;
        private int ClientID;
        private int UserID;
        private String TargetCodeName;
        private int TargetID;
        private String Type;
        private String StorePath;
        private String PublicURL;
        private String PrivateURL;
        private String Name;
        private int Status;
        private String Desc;
        private String Guid;
        private String ModuleCode;
        private String Timestamp;
        private int Size;
        private String DownloadUrl;
        private List<?> FileAttrIDs;
        private List<?> FileAttr;

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

        public int getClientID() {
            return ClientID;
        }

        public void setClientID(int ClientID) {
            this.ClientID = ClientID;
        }

        public int getUserID() {
            return UserID;
        }

        public void setUserID(int UserID) {
            this.UserID = UserID;
        }

        public String getTargetCodeName() {
            return TargetCodeName;
        }

        public void setTargetCodeName(String TargetCodeName) {
            this.TargetCodeName = TargetCodeName;
        }

        public int getTargetID() {
            return TargetID;
        }

        public void setTargetID(int TargetID) {
            this.TargetID = TargetID;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getStorePath() {
            return StorePath;
        }

        public void setStorePath(String StorePath) {
            this.StorePath = StorePath;
        }

        public String getPublicURL() {
            return PublicURL;
        }

        public void setPublicURL(String PublicURL) {
            this.PublicURL = PublicURL;
        }

        public String getPrivateURL() {
            return PrivateURL;
        }

        public void setPrivateURL(String PrivateURL) {
            this.PrivateURL = PrivateURL;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getDesc() {
            return Desc;
        }

        public void setDesc(String Desc) {
            this.Desc = Desc;
        }

        public String getGuid() {
            return Guid;
        }

        public void setGuid(String Guid) {
            this.Guid = Guid;
        }

        public String getModuleCode() {
            return ModuleCode;
        }

        public void setModuleCode(String ModuleCode) {
            this.ModuleCode = ModuleCode;
        }

        public String getTimestamp() {
            return Timestamp;
        }

        public void setTimestamp(String Timestamp) {
            this.Timestamp = Timestamp;
        }

        public int getSize() {
            return Size;
        }

        public void setSize(int Size) {
            this.Size = Size;
        }

        public String getDownloadUrl() {
            return DownloadUrl;
        }

        public void setDownloadUrl(String DownloadUrl) {
            this.DownloadUrl = DownloadUrl;
        }

        public List<?> getFileAttrIDs() {
            return FileAttrIDs;
        }

        public void setFileAttrIDs(List<?> FileAttrIDs) {
            this.FileAttrIDs = FileAttrIDs;
        }

        public List<?> getFileAttr() {
            return FileAttr;
        }

        public void setFileAttr(List<?> FileAttr) {
            this.FileAttr = FileAttr;
        }
    }
}
