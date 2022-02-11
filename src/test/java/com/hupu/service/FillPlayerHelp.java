package com.hupu.service;

import com.hupu.dao.PlayerScoreStatsDao;
import com.hupu.pojo.PlayerScoreStats;
import com.hupu.pojo.PlayerShotHelp;
import com.hupu.service.Impl.PlayerShotHelpServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/application-context.xml"})
public class FillPlayerHelp {
    @Autowired
    private PlayerShotHelpServiceImpl playerShotHelpService;
    
    @Autowired
    @Qualifier("playerScoreStatsDao")
    private PlayerScoreStatsDao playerScoreStatsDao;
    
    @Test
    public void test() {
        List<PlayerScoreStats> playerList =
                playerScoreStatsDao.queryAllByLimit(0, 100000);
        getMap(playerList);
    }
    
    private void getMap(List<PlayerScoreStats> playerList) {
        
        int shot = 0; // 出手
        int goal = 0; // 命中
        
        int shot3 = 0; // 三分出手
        int goal3 = 0; // 三分命中
        
        int shotP = 0;
        int goalP = 0;
        String team = "";
        Matcher matcher;
        List<PlayerShotHelp> shotHelpList = new ArrayList<>();
        for (PlayerScoreStats playerStats : playerList) {
            Pattern pattern = Pattern.compile("(\\d+)-(\\d+)");
            matcher = pattern.matcher(playerStats.getShot());
            if (matcher.matches()) {
                goal = Integer.parseInt(matcher.group(1));
                shot = Integer.parseInt(matcher.group(2));
            }
            
            matcher = pattern.matcher(playerStats.getThreeshot());
            if (matcher.matches()) {
                goal3 = Integer.parseInt(matcher.group(1));
                shot3 = Integer.parseInt(matcher.group(2));
            }
            matcher = pattern.matcher(playerStats.getPenaltyshot());
            if (matcher.matches()) {
                goalP = Integer.parseInt(matcher.group(1));
                shotP = Integer.parseInt(matcher.group(2));
            }
            shotHelpList.add(new PlayerShotHelp(playerStats.getId(),
                    playerStats.getTeamid(),
                    playerStats.getTeamstatsid(), playerStats.getPlayername(),
                    goal, shot, goal3, shot3, goalP, shotP));
        }
        playerShotHelpService.insertAll(shotHelpList);
    }
}
