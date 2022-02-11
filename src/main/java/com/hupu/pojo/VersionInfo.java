package com.hupu.pojo;

public class VersionInfo {
    
    
    //版本号
    
    private Integer versionCode;
    
    private String versionName;
    //是否强制更新 
    private boolean forceUpdate;
    //版本的url连接 
    private String updateUrl;
    //更新信息
    
    private String updateInfo;
    
    public VersionInfo(Integer versionCode, String versionName, boolean forceUpdate, String updateUrl, String updateInfo) {
        this.versionCode = versionCode;
        this.versionName = versionName;
        this.forceUpdate = forceUpdate;
        this.updateUrl = updateUrl;
        this.updateInfo = updateInfo;
    }
    
    public Integer getVersionCode() {
        return versionCode;
    }
    
    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }
    
    public String getVersionName() {
        return versionName;
    }
    
    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }
    
    public boolean isForceUpdate() {
        return forceUpdate;
    }
    
    public void setForceUpdate(boolean forceUpdate) {
        this.forceUpdate = forceUpdate;
    }
    
    public String getUpdateUrl() {
        return updateUrl;
    }
    
    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }
    
    public String getUpdateInfo() {
        return updateInfo;
    }
    
    public void setUpdateInfo(String updateInfo) {
        this.updateInfo = updateInfo;
    }
    
    @Override
    public String toString() {
        return "VersionInfo{" +
                "versionCode=" + versionCode +
                ", versionName='" + versionName + '\'' +
                ", forceUpdate=" + forceUpdate +
                ", updateUrl='" + updateUrl + '\'' +
                ", updateInfo='" + updateInfo + '\'' +
                '}';
    }
    
    
}