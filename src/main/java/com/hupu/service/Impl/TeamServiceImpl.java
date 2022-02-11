package com.hupu.service.Impl;


import com.hupu.config.HupuEnum;
import com.hupu.dao.TeamDao;
import com.hupu.pojo.Team;
import com.hupu.service.TeamService;
import com.hupu.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Team)表服务实现类
 *
 * @author makejava
 * @since 2020-04-23 19:30:38
 */
@Service("teamService")
@Transactional
public class TeamServiceImpl implements TeamService {
    @Autowired
    private FutureGamesServiceImpl futureGamesService;
    
    @Autowired
    @Qualifier("teamDao")
    private TeamDao teamDao;
    
    @Autowired
    @Qualifier("redisUtil")
    private RedisUtil redisUtil;
    
    @Override
    public Team queryById(String teamid) {
        return teamDao.queryById(teamid);
    }
    
    @Override
    public List<Team> queryAllByLimit(int offset, int limit) {
        return teamDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<Team> queryAll(Team team) {
        return teamDao.queryAll(team);
    }
    
    @Override
    public int insert(Team team) {
        return teamDao.insert(team);
    }
    
    @Override
    public int update(Team team) {
        redisUtil.del("AllTeams"); // 更新了球队信息之后要删除缓存
        return teamDao.update(team);
    }
    
    @Override
    public int deleteById(String teamid) {
        return teamDao.deleteById(teamid);
    }
    
    @Override
    public List<Map<String, Object>> getAllTeam() {
        String key = "AllTeams";
        if (redisUtil.hasKey(key)) {
            return (List<Map<String, Object>>) redisUtil.get(key);
        }
        ArrayList<Map<String, Object>> teamInfo = new ArrayList<>();
        List<Team> teamList = teamDao.queryAllByLimit(0, 50); // 得到所有球队
        for (Team team : teamList) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", team.getTeamid());
            map.put("name", team.getTeamname());
            map.put("buildtime", team.getBuildtime());
            map.put("area", team.getArea());
            map.put("homecourt", team.getHomecourt());
            map.put("chiefcoach", team.getChiefcoach());
            map.put("website", team.getWebsite());
            map.put("teamName", team.getTeamname());
            map.put("winGame", futureGamesService.getWinGames(team.getTeamid()));
            map.put("allGame", futureGamesService.getAllGames(team.getTeamid()));
            teamInfo.add(map);
        }
        redisUtil.set(key, teamInfo, HupuEnum.RedisExpTime.SS_LONG.getTime());
        return teamInfo;
    }
}