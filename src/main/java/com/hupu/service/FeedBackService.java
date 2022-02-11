package com.hupu.service;

import com.hupu.pojo.FeedBack;

import java.util.List;
import java.util.Map;

public interface FeedBackService {
    FeedBack queryById(int feedbackId);

    List<FeedBack> queryAllByLimit(int offset, int limit);

    List<FeedBack> queryFeedBackByUserId(int user_id);

    int insertFeedBack(FeedBack feedBack);

    int addReply(String reply, String reply_time, int feedbackId);

    int deleteById(int feedbackId);

    List<Map<String, Object>> getAllFeedBacks();
}
