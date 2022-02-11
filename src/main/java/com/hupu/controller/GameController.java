package com.hupu.controller;

import com.hupu.config.HupuEnum;
import com.hupu.pojo.Game;
import com.hupu.pojo.TeamScoreStats;
import com.hupu.service.Impl.FutureGamesServiceImpl;
import com.hupu.service.Impl.GameServiceImpl;
import com.hupu.service.Impl.PlayerScoreStatsServiceImpl;
import com.hupu.service.Impl.TeamScoreStatsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/game")
public class GameController {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    @Qualifier("gameService")
    private GameServiceImpl gameService;
    
    @Autowired
    @Qualifier("futureGamesService")
    private FutureGamesServiceImpl futureGamesService;
    
    @Autowired
    @Qualifier("teamScoreStatsService")
    private TeamScoreStatsServiceImpl teamScoreStats;
    
    @Autowired
    @Qualifier("playerScoreStatsService")
    private PlayerScoreStatsServiceImpl playerScoreStatsService;
    
    @RequestMapping("/getGameByLimit") // 一次性获得比赛的全部信息
    public Map<String, Object> getGameByLimit(HttpServletRequest request) {
        log.info("======获取所有比赛=====");
        HashMap<String, Object> retMap = new HashMap<>();
        retMap.put("typeCode", HupuEnum.GameType.GAMEOVER.getGameCode()); // 0
        if (request.getSession().getAttribute("gameInfo") != null) {
            retMap.put("gameList", request.getSession().getAttribute("gameInfo"));
            return retMap;
        }
        int entity = 2000; // 一次性请求全部
        // 由比赛id索引比赛，每个比赛是一个hashmap，由string类型指向不同的信息
        ArrayList<HashMap<String, Object>> gameInfo = new ArrayList<>();
        List<Game> gameList = gameService.queryAllByLimit(0, entity);
        for (Game game : gameList) {
            int gameId = game.getGameid();
            // 只有两条信息，一条主队，一条客队
            List<TeamScoreStats> teamScoreStatsList =
                    teamScoreStats.getTeamStatsByGameId(gameId);
            HashMap<String, Object> map = new HashMap<>();
            map.put("date", game.getGametime());
            map.put("home", teamScoreStatsList.get(1).getTeamid());
            map.put("away", teamScoreStatsList.get(0).getTeamid());
            map.put("teamPoints",
                    teamScoreStatsList.get(1).getScore() + " : " + teamScoreStatsList.get(0).getScore());
            map.put("arena", game.getArena());
            map.put("audNum", game.getPeoplenum());
            map.put("gameId", gameId);
            gameInfo.add(map);
        }
        request.getSession().setAttribute("gameInfo", gameInfo);
        retMap.put("gameList", gameInfo);
        return retMap;
    }
    
    @RequestMapping("/getScoreByGame") // 获得一场比赛的双方得分数据
    public HashMap<String, Object> getScoreByGame(int gameId) {
        log.info("====获取比赛：" + gameId + " 的双方得分数据");
        return teamScoreStats.getScoreByGame(gameId);
    }
    
    
    @RequestMapping("/getPlayerByGame") // 获得一场比赛的球员数据
    public HashMap<String, Object> getPlayerStatsByGame(int gameId) {
        log.info("====获取比赛：" + gameId + " 的球员统计数据");
        return playerScoreStatsService.getPlayerStatsByGame(gameId);
    }
    
    @RequestMapping("/getTeamScoreByGame") // 获得一场比赛的球队统计数据
    public HashMap<String, Object> getTeamStatsByGame(int gameId) {
        log.info("====获取比赛：" + gameId + " 的球队统计数据");
        return playerScoreStatsService.getTeamStatsByGame(gameId);
    }
    
    @RequestMapping("/getGameIndex") // 通过日期获得一天某场比赛
    public HashMap<String, Object> getGameByDay(String date) throws ParseException {
        log.info("====获取：" + date + " 的所有比赛");
        HashMap<String, Object> retMap = new HashMap<>();
        
        ArrayList<Map> mapArrayList = teamScoreStats.getGameIndexByDay(date);
        int size = mapArrayList.size();
        log.info("size ===> " + size);
        if (size > 0) { // 判断比赛是否已经打过
            log.info("2020-02-10有什么问题");
            retMap.put("typeCode", HupuEnum.GameType.GAMEOVER.getGameCode()); // 0:已经打完的比赛
            retMap.put("gameList", mapArrayList);
        } else {
            retMap.put("gameList", futureGamesService.getFutureGameByDate(date));
            retMap.put("typeCode",
                    HupuEnum.GameType.GAMEPOSTPONE.getGameCode()); // 1：延期的比赛
        }
        return retMap;
    }
    
    @RequestMapping(value = "/updateGameScore", method = RequestMethod.POST)
    //修改比赛双方的比分
    public String updateGameScore(int gameId, String newScore,
                                  HttpServletRequest request) {
        log.info("要修改的比赛 ===>" + gameId + " 比分 ===> " + newScore);
        teamScoreStats.updateGameScore(gameId, newScore);
        request.getSession().removeAttribute("gameInfo");
        return "Success";
    }
    
    @RequestMapping("/getGameInfo")
    public Game getBaseInfoByGameId(int gameId) {
        return gameService.queryById(gameId);
    }
}
