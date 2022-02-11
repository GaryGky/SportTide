package com.hupu.service;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.Game;
import com.hupu.pojo.PlayerScoreStats;
import com.hupu.pojo.TeamScoreStats;
import com.hupu.service.Impl.GameServiceImpl;
import com.hupu.service.Impl.PlayerScoreStatsServiceImpl;
import com.hupu.service.Impl.TeamScoreStatsServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayStatsTest {
    private PlayerScoreStatsServiceImpl playerScoreStats;
    private TeamScoreStatsServiceImpl teamScoreStatsService;
    private GameServiceImpl gameService;
    
    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        playerScoreStats = (PlayerScoreStatsServiceImpl) context.getBean(
                "playerScoreStatsService");
        teamScoreStatsService = (TeamScoreStatsServiceImpl) context.getBean("teamScoreStatsService");
        gameService = (GameServiceImpl) context.getBean("gameService");
    }
    
    public HashMap<String, Object> getMap(List<PlayerScoreStats> playerList) {
        int score = 0; // 得分
        int court = 0; // 篮板可以由前场后场篮板相加得到
        int assist = 0;
        int steal = 0;
        int block = 0;
        int frontCourt = 0;
        int backCourt = 0;
        int shot = 0; // 出手
        int goal = 0; // 命中
        String team = "";
        HashMap<String, Object> teamStatsMap = new HashMap<>();
        for (PlayerScoreStats playerStats : playerList) {
            score += playerStats.getScore();
            backCourt += playerStats.getBackcourt();
            frontCourt += playerStats.getFrontcourt();
            assist += playerStats.getAssist();
            steal += playerStats.getSteal();
            block += playerStats.getBlock();
            Pattern pattern = Pattern.compile("(\\d+)-(\\d+)");
            Matcher matcher = pattern.matcher(playerStats.getShot());
            if (matcher.matches()) {
                goal += Integer.parseInt(matcher.group(1));
                shot += Integer.parseInt(matcher.group(2));
            }
            team = playerStats.getTeamid();
            court = backCourt + frontCourt; // 篮板
            String hitRate = goal + "-" + shot; // 命中率
            teamStatsMap.put("score", score);
            teamStatsMap.put("court", court);
            teamStatsMap.put("assist", assist);
            teamStatsMap.put("steal", steal);
            teamStatsMap.put("block", block);
            teamStatsMap.put("frontCourt", frontCourt);
            teamStatsMap.put("backCourt", backCourt);
            teamStatsMap.put("hitRate", hitRate);
            teamStatsMap.put("team", team);
        }
        return teamStatsMap;
    }
    
    @Test
    public void getTeamStats() {
        int gameId = 156542;
        HashMap<String, Object> gameMap = new HashMap<>();
        List<PlayerScoreStats> listHome = new ArrayList<>(), listAway = new ArrayList<>();
        for (PlayerScoreStats stats : playerScoreStats.queryByGameId(gameId)) {
            if (stats.getTeamstatsid() % 10 == 0) {
                listAway.add(stats);
            } else {
                listHome.add(stats);
            }
        }
        gameMap.put("home", getMap(listHome));
        gameMap.put("away", getMap(listAway));
        System.out.println(JSON.toJSON(gameMap));
    }
    
    
    @Test
    public void getPlayerStats() { // 查询异常比赛的球员统计
        int gameId = 156542;
        HashMap<String, Object> gameMap = new HashMap<>();
        // 查询一次数据库
        ArrayList<PlayerScoreStats> awayList = new ArrayList<>();
        ArrayList<PlayerScoreStats> homeList = new ArrayList<>();
        for (PlayerScoreStats playerStats : playerScoreStats.queryByGameId(gameId)) {
            if (playerStats.getTeamstatsid() % 10 == 0) {
                awayList.add(playerStats);
            } else {
                homeList.add(playerStats);
            }
        }
        gameMap.put("home", homeList);
        gameMap.put("away", awayList);
        System.out.println(JSON.toJSON(gameMap));
    }
    
    @Test
    public void getTeamScore() { // 得到球队的统计 O(1)的复杂度只需要访问一次数据库
        int gameId = 156542;
        HashMap<String, Object> map = new HashMap<>();
        for (TeamScoreStats teamScore :
                teamScoreStatsService.getTeamStatsByGameId(gameId)) {
            if (teamScore.getIshome() == 0) {
                map.put("away", teamScore);
            } else {
                map.put("home", teamScore);
            }
        }
        System.out.println(JSON.toJSON(map));
    }
}
