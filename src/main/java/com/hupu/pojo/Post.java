package com.hupu.pojo;

public class Post {
    
    
    private Integer postId;
    
    private String postTitle;
    
    private String postContent;
    
    private String postTime;
    
    private Integer postCommentnum;
    //发表该消息的管理员id 
    private Integer adminId;
    //新闻中图片的url 
    private String imgUrl;
    
    public Post() {
    }
    
    public Post(Integer postId, String postTitle, String postContent, String postTime, Integer postCommentnum, Integer adminId, String imgUrl) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postTime = postTime;
        this.postCommentnum = postCommentnum;
        this.adminId = adminId;
        this.imgUrl = imgUrl;
    }
    
    public Integer getPostId() {
        return postId;
    }
    
    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    
    public String getPostTitle() {
        return postTitle;
    }
    
    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }
    
    public String getPostContent() {
        return postContent;
    }
    
    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
    
    public String getPostTime() {
        return postTime;
    }
    
    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }
    
    public Integer getPostCommentnum() {
        return postCommentnum;
    }
    
    public void setPostCommentnum(Integer postCommentnum) {
        this.postCommentnum = postCommentnum;
    }
    
    public Integer getAdminId() {
        return adminId;
    }
    
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
    
    public String getImgUrl() {
        return imgUrl;
    }
    
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
}