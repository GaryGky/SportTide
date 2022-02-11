package com.hupu.dao;

import com.hupu.pojo.FeedBack;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedBackDao {
    FeedBack queryById(int feedbackId);

    List<FeedBack> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<FeedBack> queryFeedBackByUserId(@Param("user_id") int user_id);

    int insertFeedBack(FeedBack feedBack);

    int addReply(@Param("reply") String reply,
                 @Param("reply_time") String reply_time,
                 @Param("feedbackId") int feedbackId);

    int deleteById(@Param("feedbackId") int feedbackId);

    List<FeedBack> queryAllFeedBacks();
}
