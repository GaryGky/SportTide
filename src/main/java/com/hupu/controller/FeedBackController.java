package com.hupu.controller;

import com.hupu.pojo.FeedBack;
import com.hupu.service.Impl.FeedBackServiceImpl;
import com.hupu.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {
    @Autowired
    @Qualifier("feedbackService")
    private FeedBackServiceImpl feedBackService;

    @RequestMapping("/recvFeedBack")
    public String recvFeedBack(@RequestBody Map map){
        System.out.println(map.toString());
        int userId = (int)map.get("user_id");
        String feedBackContent = (String)map.get("content");
        String time = (String)map.get("time");
        FeedBack feedBack = new FeedBack();
        feedBack.setFeedback_content(feedBackContent);
        feedBack.setFeedback_time(time);
        feedBack.setUser_id(userId);
        int flag = feedBackService.insertFeedBack(feedBack);
        if (flag == 1) {
            return "feed back has been received";
        }
        else {
            return "there is something wrong with database operations";
        }
    }

    @RequestMapping("/repFeedBack")
    public String repFeedBack(int feedbackId, String replyContent){
        String time = DateUtils.getCurTime();
        int user_id = feedBackService.queryById(feedbackId).getUser_id();
        int flag = feedBackService.addReply(replyContent, time, feedbackId);
        if (flag != 1) {
            return "there is something wrong with database operations";
        }
        //给该用户发送通知

        return "reply has been sended";
    }

    @RequestMapping("/getFeedBacks")
    public List<Map<String, Object>> getFeedBacks(HttpServletRequest request){
        System.out.println("获取用户反馈信息");

        List<Map<String, Object>> list = feedBackService.getAllFeedBacks();
        request.getSession().setAttribute("feedbackInfo", list);
        return list;
    }

    @RequestMapping("/getFeedBacksByUser")
    public List<FeedBack> getFeedBacksByUser(int user_id){
        List<FeedBack> list = feedBackService.queryFeedBackByUserId(user_id);
        return list;
    }


}
