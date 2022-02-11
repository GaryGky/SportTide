package com.hupu.pojo;

import java.io.Serializable;

public class FeedBack implements Serializable {
    private Integer feedbackId;

    private String feedback_content;

    private String feedback_time;

    private String reply;

    private String reply_time;

    private Integer user_id;

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public void setFeedback_content(String feedback_content) {
        this.feedback_content = feedback_content;
    }

    public void setFeedback_time(String feedback_time) {
        this.feedback_time = feedback_time;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public void setReply_time(String reply_time) {
        this.reply_time = reply_time;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public String getFeedback_content() {
        return feedback_content;
    }

    public String getFeedback_time() {
        return feedback_time;
    }

    public String getReply() {
        return reply;
    }

    public String getReply_time() {
        return reply_time;
    }

    public Integer getUser_id() {
        return user_id;
    }
}
