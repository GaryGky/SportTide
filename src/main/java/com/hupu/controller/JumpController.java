package com.hupu.controller;

import com.hupu.service.Impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/jump")
public class JumpController {
    @Autowired
    private PostServiceImpl postService;
    
    // 用于页面跳转
    @RequestMapping("/toGameTable")
    public String gotoGameTab() {
        return "Hupu_GameTable";
    }
    
    @RequestMapping("/toGameAdd")
    public String gotoGameAdd() {
        return "Hupu_GameAdd";
    }
    
    @RequestMapping("/toUserTable")
    public String gotoUserTab() {
        return "Hupu_UserTable";
    }
    
    @RequestMapping("/toAdminAdd")
    public String gotoAdminAdd() {
        return "Hupu_AdminAdd";
    }
    
    @RequestMapping("/toPostTable")
    public String gotoPostTable() {
        return "Hupu_PostingTable";
    }
    
    @RequestMapping("/toComTable")
    public String gotoComTab() {
        return "Hupu_CommentTable";
    }
    
    @RequestMapping("/toHome")
    public String gotoLogin(HttpServletRequest request) {
        // TODO:查询一次数据库全取出来
        List<Integer> list = postService.getTotalInfo();
        request.getSession().setAttribute("totalUser", list.get(0));
        request.getSession().setAttribute("totalGame", list.get(1));
        request.getSession().setAttribute("totalPost", list.get(2));
        request.getSession().setAttribute("totalComments", list.get(3));
        request.getSession().setAttribute("totalCollections", list.get(4));
        //TODO: 构造一个map
        request.getSession().setAttribute("postList", postService.getHomePost());
        return "Hupu_Home";
    }
    
    @RequestMapping("/toTeamTable")
    public String gotoTeamTable() {
        return "Hupu_TeamTable";
    }
    
    @RequestMapping("/toAdminUserTable")
    public String gotoAdminUserTable() {
        return "Hupu_AdminUserTable";
    }
    
    @RequestMapping("/toGameFuture")
    public String gotoGameFutureTable() {
        return "Hupu_Future_Game";
    }
    
    @RequestMapping("/toPyGame")
    public String gotoPyGameTable() {
        return "Hupu_PyControl";
    }
    
    @RequestMapping("/toVersion")
    public String gotoVersionTable() {
        return "Hupu_Version";
    }
    
    @RequestMapping("/toVersionList")
    public String gotoVersionList() {
        return "Hupu_VersionInfo";
    }
    
    @RequestMapping("/toFeedBackTable")
    public String toFeedBackTab(){return "Hupu_FeedBackTable";}
}
