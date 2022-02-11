package com.hupu.service.Impl;


import com.alibaba.fastjson.JSON;
import com.hupu.config.HupuEnum;
import com.hupu.dao.GameDao;
import com.hupu.dao.TeamScoreStatsDao;
import com.hupu.pojo.TeamScoreStats;
import com.hupu.service.TeamScoreStatsService;
import com.hupu.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (TeamScoreStats)表服务实现类
 *
 * @author makejava
 * @since 2020-04-20 13:40:39
 */
@Service("teamScoreStatsService")
@Transactional
public class TeamScoreStatsServiceImpl implements TeamScoreStatsService {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    @Qualifier("gameDao")
    private GameDao gameDao;
    
    @Autowired
    @Qualifier("teamScoreStatsDao")
    private TeamScoreStatsDao teamScoreStatsDao;
    
    @Autowired
    @Qualifier("redisUtil")
    private RedisUtil redisUtil;
    
    @Override
    public TeamScoreStats queryById(Integer id) {
        return teamScoreStatsDao.queryById(id);
    }
    
    @Override
    public List<TeamScoreStats> queryAllByLimit(int offset, int limit) {
        return teamScoreStatsDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<TeamScoreStats> queryAll(TeamScoreStats teamScoreStats) {
        return teamScoreStatsDao.queryAll(teamScoreStats);
    }
    
    @Override
    public int insert(TeamScoreStats teamScoreStats) {
        return teamScoreStatsDao.insert(teamScoreStats);
    }
    
    @Override
    public int update(TeamScoreStats teamScoreStats) {
        return teamScoreStatsDao.update(teamScoreStats);
    }
    
    @Override
    public int deleteById(Integer id) {
        return teamScoreStatsDao.deleteById(id);
    }
    
    // TODO:这里定义为切入点
    // TODO: 加一个切面，设置访问数据库之前先访问redis缓存
    @Override
    public List<TeamScoreStats> getTeamStatsByGameId(int gameId) {
        String key = gameId + "teamStats";
        if (redisUtil.hasKey(key)) { // 如果缓存存在则从缓存中取得
            return (List<TeamScoreStats>) redisUtil.get(key);
        } else { // 否则从数据库中get并且刷新缓存
            List<TeamScoreStats> list =
                    teamScoreStatsDao.getTeamStatsByGameId(gameId);
            redisUtil.set(key, list, HupuEnum.RedisExpTime.LongTime.getTime());
            return list;
        }
    }
    
    
    @Override
    public ArrayList<Map> getGameIndexByDay(String date) throws ParseException {
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd%");
        String queryDay = format.format(myFmt.parse(date));
        List<TeamScoreStats> gameIndexByDay = null;
        String key = queryDay + "day";
        if (redisUtil.get(key) != null) {
            // TODO: 有没有办法可以保证转换合法?
            gameIndexByDay = (List<TeamScoreStats>) redisUtil.get(key);
        }else {
            gameIndexByDay =
                    teamScoreStatsDao.getGameIndex(queryDay);
        }
        if (gameIndexByDay.size() > 0) {
            redisUtil.set(key, gameIndexByDay,
                    HupuEnum.RedisExpTime.LongTime.getTime());
        }
        ArrayList<Map> maps = new ArrayList<>();
        for (int i = 0; i < gameIndexByDay.size(); i++) {
            HashMap<String, Object> gameMap = new HashMap<>();
            gameMap.put("gameId", gameIndexByDay.get(i).getGameid());
            gameMap.put("awayTeam", gameIndexByDay.get(i).getTeamid());
            gameMap.put("awayScore", gameIndexByDay.get(i).getScore());
            gameMap.put("homeTeam", gameIndexByDay.get(i + 1).getTeamid());
            gameMap.put("homeScore", gameIndexByDay.get(i + 1).getScore());
            log.info("gameID ---> " + gameIndexByDay.get(i).getGameid());
            gameMap.put("gameArena",
                    gameDao.queryById(gameIndexByDay.get(i).getGameid()).getArena());
            i++;
            maps.add(gameMap);
        }
        return maps;
    }
    
    
    @Override
    public HashMap<String, Object> getScoreByGame(int gameId) { // 获得比赛的得分数据
        String key = gameId + "gameScore";
        HashMap<String, Object> map = new HashMap<>();
        if (redisUtil.get(key) != null) {
            return (HashMap<String, Object>) redisUtil.get(key);
        }
        for (TeamScoreStats teamScore :
                teamScoreStatsDao.getTeamStatsByGameId(gameId)) {
            if (teamScore.getIshome() == 0) {
                map.put("away", teamScore);
            } else {
                map.put("home", teamScore);
            }
        }
        redisUtil.set(key, map, HupuEnum.RedisExpTime.SHORT_TIME.getTime()); // 15分钟过期
        return map;
    }
    
    @Override
    public void updateGameScore(int gameId, String newScore) {
        List<TeamScoreStats> statsList = getTeamStatsByGameId(gameId);
        log.info(JSON.toJSONString(statsList));
        Pattern pattern = Pattern.compile("\\s*(\\d+)\\s*:\\s*(\\d+)\\s*");
        Matcher matcher = pattern.matcher(newScore);
        if (matcher.matches()) {
            log.info("matcher g1 ===> " + matcher.group(1));
            log.info("matcher g2 ===> " + matcher.group(2));
            statsList.get(0).setScore(Integer.valueOf(matcher.group(1)));
            statsList.get(1).setScore(Integer.valueOf(matcher.group(2)));
        }
        log.info("新的主队得分数据： " + JSON.toJSONString(statsList.get(0)));
        log.info("新的客队得分数据： " + JSON.toJSONString(statsList.get(1)));
        String key = gameId + "teamStats";
        if (redisUtil.hasKey(key)) {
            redisUtil.set(key, statsList); //更新redis缓存
        }
        teamScoreStatsDao.update(statsList.get(0)); //更新mysql数据库
        teamScoreStatsDao.update(statsList.get(1));
    }
}