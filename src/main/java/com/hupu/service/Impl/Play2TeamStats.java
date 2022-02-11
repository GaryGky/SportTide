package com.hupu.service.Impl;

import com.hupu.pojo.PlayerScoreStats;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Play2TeamStats {
    public HashMap<String, Object> getMap(List<PlayerScoreStats> playerList) {
        //TODO: 问题是shot是"10-30"的字符串，只能提取出来用正则匹配再相加
        double score = 0; // 得分
        double court; // 篮板可以由前场后场篮板相加得到
        double assist = 0;
        double steal = 0;
        double block = 0;
        double frontCourt = 0;
        double backCourt = 0;
        double shot = 0; // 出手
        double goal = 0; // 命中
        
        double shot3 = 0; // 三分出手
        double goal3 = 0; // 三分命中
        String team = "";
        Matcher matcher;
        HashMap<String, Object> teamStatsMap = new HashMap<>();
        for (PlayerScoreStats playerStats : playerList) {
            score += playerStats.getScore();
            backCourt += playerStats.getBackcourt();
            frontCourt += playerStats.getFrontcourt();
            assist += playerStats.getAssist();
            steal += playerStats.getSteal();
            block += playerStats.getBlock();
            Pattern pattern = Pattern.compile("(\\d+)-(\\d+)");
            matcher = pattern.matcher(playerStats.getShot());
            if (matcher.matches()) {
                goal += Integer.parseInt(matcher.group(1));
                shot += Integer.parseInt(matcher.group(2));
            }
            
            matcher = pattern.matcher(playerStats.getThreeshot());
            if (matcher.matches()) {
                goal3 += Integer.parseInt(matcher.group(1));
                shot3 += Integer.parseInt(matcher.group(2));
            }
        }
        team = playerList.get(0).getTeamid();
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
        teamStatsMap.put("shot", shot);
        teamStatsMap.put("shot3", shot3);
        teamStatsMap.put("goal", goal);
        teamStatsMap.put("goal3", goal3);
        return teamStatsMap;
    }
    
}
