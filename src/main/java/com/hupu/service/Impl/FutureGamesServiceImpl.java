package com.hupu.service.Impl;


import com.hupu.config.HupuEnum;
import com.hupu.dao.FutureGamesDao;
import com.hupu.dao.PlayerScoreStatsDao;
import com.hupu.dao.TeamScoreStatsDao;
import com.hupu.pojo.FutureGames;
import com.hupu.service.FutureGamesService;
import com.hupu.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (FutureGames)表服务实现类
 *
 * @author makejava
 * @since 2020-05-11 11:19:08
 */
@Service("futureGamesService")
@Transactional
public class FutureGamesServiceImpl extends Play2TeamStats implements FutureGamesService {
    
    @Autowired
    @Qualifier("futureGamesDao")
    private FutureGamesDao futureGamesDao;
    
    @Autowired
    @Qualifier("teamScoreStatsDao")
    private TeamScoreStatsDao statsDao;
    
    @Autowired
    @Qualifier("playerScoreStatsDao")
    private PlayerScoreStatsDao playerDao;
    
    @Autowired
    @Qualifier("redisUtil")
    private RedisUtil redisUtil;
    
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
    @Override
    public FutureGames queryById(String gameid) {
        return futureGamesDao.queryById(gameid);
    }
    
    @Override
    public List<FutureGames> queryAllByLimit(int offset, int limit) {
        return futureGamesDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<FutureGames> queryAll(FutureGames futureGames) {
        return futureGamesDao.queryAll(futureGames);
    }
    
    @Override
    public int insert(FutureGames futureGames) {
        return futureGamesDao.insert(futureGames);
    }
    
    @Override
    public int update(FutureGames futureGames) {
        logger.info("更新未来赛事信息");
        return futureGamesDao.update(futureGames);
    }
    
    @Override
    public int deleteById(String gameid) {
        return futureGamesDao.deleteById(gameid);
    }
    
    @Override
    public List<FutureGames> getFutureGameByDate(String date) throws ParseException {
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format = new SimpleDateFormat("yyyy_M_d %");
        String queryDay = format.format(myFmt.parse(date));
        logger.info("AI预测查询日期 ====> " + queryDay);
        String key = queryDay + "future";
        if (redisUtil.hasKey(key)) {
            return (List) redisUtil.get(key);
        }
        List<FutureGames> list = futureGamesDao.getFutureGameByDate(queryDay);
        if (list.size() > 0) {
            redisUtil.set(key, list, HupuEnum.RedisExpTime.SHORT_TIME.getTime());
        }
        return list;
    }
    
    
    /*
    获得一支球队的赛季表现数据
    @param: 球队名称
     */
    @Override
    public HashMap<String, Object> getTeamPreview(String teamId) {
        logger.info("获取球队历史数据  => " + teamId);
        String key = teamId + "preview";
        if (redisUtil.hasKey(key)) {
            return (HashMap<String, Object>) redisUtil.get(key);
        }
        Map<String, Long> minMaxMap = futureGamesDao.getMinMax();
        HashMap<String, Object> previewMap = new HashMap<>();
        Map<String, BigDecimal> avgMap =
                futureGamesDao.getFutureAVGShot(teamId,
                        minMaxMap.get("min"),
                        minMaxMap.get("max"));
        Map<String, BigDecimal> sumMap =
                futureGamesDao.getFutureSUMScore(teamId, minMaxMap.get("min"),
                        minMaxMap.get("max"));
        int listSize = getAllGames(teamId);
        
        logger.info("listSize ===> " + listSize);
        
        previewMap.clear();
        previewMap.put("score", sumMap.get("score").doubleValue() / listSize);
        previewMap.put("court",
                (sumMap.get("backcourt").doubleValue() + sumMap.get(
                        "frontcourt").doubleValue()) / listSize);
        previewMap.put("assist", sumMap.get("assist").doubleValue() / listSize);
        previewMap.put("steal", sumMap.get("steal").doubleValue() / listSize);
        previewMap.put("block", sumMap.get("block").doubleValue() / listSize);
        previewMap.put("shot", avgMap.get("shot").doubleValue() / listSize);
        previewMap.put("shot3", avgMap.get("shot3").doubleValue() / listSize);
        previewMap.put("goal", avgMap.get("goal").doubleValue() / listSize);
        previewMap.put("goal3", avgMap.get("goal3").doubleValue() / listSize);
        
        previewMap.put("allGames", listSize);
        previewMap.put("winGames", getWinGames(teamId));
        previewMap.put("teamId", teamId);
        redisUtil.set(key, previewMap, HupuEnum.RedisExpTime.SS_LONG.getTime());
        return previewMap;
    }
    
    @Override
    public int getAllGames(String teamId) {
        String key = teamId + "AllGames";
        if (redisUtil.hasKey(key)) {
            return (int) redisUtil.get(key);
        }
        int allGames = futureGamesDao.getAllGames(teamId);
        redisUtil.set(key, allGames, HupuEnum.RedisExpTime.S_LONG.getTime());
        return allGames;
    }
    
    @Override
    public int getWinGames(String teamId) {
        String key = teamId + "WinGames";
        if (redisUtil.hasKey(key)) {
            return (int) redisUtil.get(key);
        }
        int winGames = futureGamesDao.getWinGames(teamId);
        redisUtil.set(key, winGames, HupuEnum.RedisExpTime.S_LONG.getTime());
        return winGames;
    }
    
    @Override
    public HashMap<String, Object> getGamePreview(int gameId) {
        FutureGames futureGames = futureGamesDao.queryById(String.valueOf(gameId));
        HashMap<String, Object> map = new HashMap<>();
        map.put("awayTeam", getTeamPreview(futureGames.getAway()));
        map.put("homeTeam", getTeamPreview(futureGames.getHome()));
        return map;
    }
}