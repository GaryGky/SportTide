package com.hupu.service.Impl;


import com.hupu.config.HupuEnum;
import com.hupu.dao.PlayerScoreStatsDao;
import com.hupu.pojo.PlayerScoreStats;
import com.hupu.pojo.TeamScoreStats;
import com.hupu.service.PlayerScoreStatsService;
import com.hupu.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (PlayerScoreStats)表服务实现类
 *
 * @author makejava
 * @since 2020-04-23 20:11:25
 */
@Service("playerScoreStatsService")
@Transactional
public class PlayerScoreStatsServiceImpl extends Play2TeamStats implements PlayerScoreStatsService {
    
    @Autowired
    @Qualifier("playerScoreStatsDao")
    private PlayerScoreStatsDao playerScoreStatsDao;
    
    @Autowired
    @Qualifier("redisUtil")
    private RedisUtil redisUtil;
    
    @Override
    public PlayerScoreStats queryById(Integer id) {
        return playerScoreStatsDao.queryById(id);
    }
    
    @Override
    public List<PlayerScoreStats> queryAllByLimit(int offset, int limit) {
        return playerScoreStatsDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<PlayerScoreStats> queryAll(PlayerScoreStats playerScoreStats) {
        return playerScoreStatsDao.queryAll(playerScoreStats);
    }
    
    @Override
    public int insert(PlayerScoreStats playerScoreStats) {
        return playerScoreStatsDao.insert(playerScoreStats);
    }
    
    @Override
    public int update(PlayerScoreStats playerScoreStats) {
        return playerScoreStatsDao.update(playerScoreStats);
    }
    
    @Override
    public int deleteById(Integer id) {
        return playerScoreStatsDao.deleteById(id);
    }
    
    @Override
    public List<PlayerScoreStats> queryByTeamStatsId(int teamStatsId) {
        return playerScoreStatsDao.queryByTeamStatsId(teamStatsId);
    }
    
    @Override
    public List<PlayerScoreStats> queryByGameId(int gameId) {
        return playerScoreStatsDao.queryByGameId(gameId);
    }
    
    
    // 获得一场比赛的球队统计数据
    @Override
    public HashMap<String, Object> getTeamStatsByGame(int gameId) {
        String key = gameId + "teamScoreStats";
        if (redisUtil.get(key) != null) {
            return (HashMap<String, Object>) redisUtil.get(key);
        }
        HashMap<String, Object> gameMap = new HashMap<>();
        List<PlayerScoreStats> listHome = new ArrayList<>();
        List<PlayerScoreStats> listAway = new ArrayList<>();
        for (PlayerScoreStats stats : playerScoreStatsDao.queryByGameId(gameId)) {
            if (stats.getTeamstatsid() % 10 == 0) {
                listAway.add(stats);
            } else {
                listHome.add(stats);
            }
        }
        gameMap.put("home", getMap(listHome));
        gameMap.put("away", getMap(listAway));
        redisUtil.set(key, gameMap, HupuEnum.RedisExpTime.SHORT_TIME.getTime());
        return gameMap;
    }
    
    @Override
    public HashMap<String, Object> getPlayerStatsByGame(int gameId) {
        String key = gameId + "player";
        if (redisUtil.get(key) != null) {
            return (HashMap<String, Object>) redisUtil.get(key);
        }
        HashMap<String, Object> gameMap = new HashMap<>();
        // 查询一次数据库
        ArrayList<PlayerScoreStats> awayList = new ArrayList<>();
        ArrayList<PlayerScoreStats> homeList = new ArrayList<>();
        for (PlayerScoreStats playerStats :
                playerScoreStatsDao.queryByGameId(gameId)) {
            if (playerStats.getTeamstatsid() % 10 == 0) {
                awayList.add(playerStats);
            } else {
                homeList.add(playerStats);
            }
        }
        gameMap.put("home", homeList);
        gameMap.put("away", awayList);
        redisUtil.set(key, gameMap, HupuEnum.RedisExpTime.SHORT_TIME.getTime());
        return gameMap;
    }
    
    
}