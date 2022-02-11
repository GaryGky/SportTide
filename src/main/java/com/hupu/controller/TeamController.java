package com.hupu.controller;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.Team;
import com.hupu.service.Impl.TeamServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/team")
public class TeamController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    @Qualifier("teamService")
    private TeamServiceImpl teamService;
    
    @RequestMapping("/getTeamByLimit")
    public List<Map<String, Object>> getTeamByLimit(HttpServletRequest request) {
        System.out.println("获取球队信息");
        if (request.getSession().getAttribute("teamInfo") != null) {
            return (List<Map<String, Object>>) request.getSession().getAttribute("teamInfo");
        }
        List<Map<String, Object>> list = teamService.getAllTeam();
        request.getSession().setAttribute("teamInfo", list);
        return list;
    }
    
    @RequestMapping(value = "/updateTeamInfo", method = RequestMethod.POST)
    public int updateTeamInfo(String teamId, String field, String new_value) {
        //根据字段进行修改
        Team team = teamService.queryById(teamId);
        switch (field) {
            case "teamId":
                team.setTeamid(new_value);
                break;
            case "teamName":
                team.setTeamname(new_value);
                break;
            case "buildTime":
                team.setBuildtime(new_value);
                break;
            case "teamArea":
                team.setArea(new_value);
                break;
            case "homeCourt":
                team.setHomecourt(new_value);
                break;
            case "chief":
                team.setChiefcoach(new_value);
                break;
        }
        logger.info(JSON.toJSONString(team));
        return teamService.update(team);
    }
}
