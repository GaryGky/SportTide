package com.hupu.pojo;

import java.io.Serializable;

public class Comment implements Serializable {
    
    
    private Integer commentId;
    
    private Integer fromUid;
    
    private Integer toUid;
    
    private Integer topicType;
    
    private Integer topicId;
    
    private String commentInfo;
    
    private String commentTime;
    
    private User fromUsr;
    
    
    public Comment(Integer commentId, Integer fromUid, Integer toUid, Integer topicType, Integer topicId, String commentInfo, String commentTime, User fromUsr) {
        this.commentId = commentId;
        this.fromUid = fromUid;
        this.toUid = toUid;
        this.topicType = topicType;
        this.topicId = topicId;
        this.commentInfo = commentInfo;
        this.commentTime = commentTime;
        this.fromUsr = fromUsr;
    }
    
    public Comment() {
    }
    
    public User getFromUsr() {
        return fromUsr;
    }
    
    public void setFromUsr(User fromUsr) {
        this.fromUsr = fromUsr;
    }
    
    public Comment(Integer commentId, Integer fromUid, Integer toUid, Integer topicType, Integer topicId, String commentInfo, String commentTime) {
        this.commentId = commentId;
        this.fromUid = fromUid;
        this.toUid = toUid;
        this.topicType = topicType;
        this.topicId = topicId;
        this.commentInfo = commentInfo;
        this.commentTime = commentTime;
    }
    
    
    public Integer getCommentId() {
        return commentId;
    }
    
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
    
    public Integer getFromUid() {
        return fromUid;
    }
    
    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }
    
    public Integer getToUid() {
        return toUid;
    }
    
    public void setToUid(Integer toUid) {
        this.toUid = toUid;
    }
    
    public Integer getTopicType() {
        return topicType;
    }
    
    public void setTopicType(Integer topicType) {
        this.topicType = topicType;
    }
    
    public Integer getTopicId() {
        return topicId;
    }
    
    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }
    
    public String getCommentInfo() {
        return commentInfo;
    }
    
    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo;
    }
    
    public String getCommentTime() {
        return commentTime;
    }
    
    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }
    
    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", fromUid=" + fromUid +
                ", toUid=" + toUid +
                ", topicType=" + topicType +
                ", topicId=" + topicId +
                ", commentInfo='" + commentInfo + '\'' +
                ", commentTime='" + commentTime + '\'' +
                ", fromUsr=" + fromUsr +
                '}';
    }
}