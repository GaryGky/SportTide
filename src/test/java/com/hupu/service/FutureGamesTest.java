package com.hupu.service;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.FutureGames;
import com.hupu.service.Impl.FutureGamesServiceImpl;
import com.hupu.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/application-context.xml"})
public class FutureGamesTest {
    @Autowired
    @Qualifier("redisUtil")
    private RedisUtil redisUtil;
    @Autowired
    @Qualifier("futureGamesService")
    private FutureGamesServiceImpl futureGamesService;
    
    private final Logger logger =
            LoggerFactory.getLogger(FutureGamesTest.class);
    
    @Test
    public void futGameTest() {
        for (FutureGames games : futureGamesService.queryAllByLimit(0, 10)) {
            System.out.println(games);
        }
    }
    
    @Test
    public void testDate() throws ParseException {
        for (FutureGames games : futureGamesService.getFutureGameByDate("2020" +
                "-4-14")) {
            System.out.println(JSON.toJSON(games));
        }
    }
    
    @Test
    public void testPre() {
        System.out.println(futureGamesService.getTeamPreview("LAL"));
    }
    
    @Test
    public void testWin() {
        System.out.println(futureGamesService.getAllGames("LAL"));
        System.out.println(futureGamesService.getWinGames("LAL"));
    }
    
    
    @Test
    public void getPre(){
//        System.out.println(JSON.toJSON(futureGamesService.getTeamPreview("LAC")));
        System.out.println(JSON.toJSON(futureGamesService.getTeamPreview("SAS")));
        System.out.println(JSON.toJSON(futureGamesService.getTeamPreview("LAL")));
    }
    
    @Test
    public void getPreByGame(){
        System.out.println(futureGamesService.getGamePreview(158498));
    }
}
