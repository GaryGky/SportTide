package com.hupu.pojo;

public class User {
    private Integer userId;
    
    private String userName;
    
    private String userEmail;
    
    private Object userPassword;
    
    private String userNikename;
    //注册时间 
    private String userTime;
    //默认0 
    private Integer userStatus;
    
    private Integer userHead;
    
    public User(Integer userId, String userName, String userEmail, Object userPassword, String userNikename, String userTime, Integer userStatus, Integer userHead) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userNikename = userNikename;
        this.userTime = userTime;
        this.userStatus = userStatus;
        this.userHead = userHead;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword=" + userPassword +
                ", userNikename='" + userNikename + '\'' +
                ", userTime='" + userTime + '\'' +
                ", userStatus=" + userStatus +
                ", userHead=" + userHead +
                '}';
    }
    
    public User() {
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getUserEmail() {
        return userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
    public Object getUserPassword() {
        return userPassword;
    }
    
    public void setUserPassword(Object userPassword) {
        this.userPassword = userPassword;
    }
    
    public String getUserNikename() {
        return userNikename;
    }
    
    public void setUserNikename(String userNikename) {
        this.userNikename = userNikename;
    }
    
    public String getUserTime() {
        return userTime;
    }
    
    public void setUserTime(String userTime) {
        this.userTime = userTime;
    }
    
    public Integer getUserStatus() {
        return userStatus;
    }
    
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }
    
    public Integer getUserHead() {
        return userHead;
    }
    
    public void setUserHead(Integer userHead) {
        this.userHead = userHead;
    }
    
}