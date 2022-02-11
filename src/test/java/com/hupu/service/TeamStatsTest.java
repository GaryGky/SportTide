package com.hupu.service;

import com.hupu.service.Impl.GameServiceImpl;
import com.hupu.service.Impl.TeamScoreStatsServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TeamStatsTest {
    private TeamScoreStatsServiceImpl teamScoreStatsService;
    
    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        teamScoreStatsService = (TeamScoreStatsServiceImpl) context.getBean("teamScoreStatsService");
    }
    
    @Test
    public void testGame1() {
        System.out.println("=====Test Bean Create=====");
        System.out.println(teamScoreStatsService);
    }
    
    @Test
    public void testGame2() {
        System.out.println("=====Test Query By Page=====");
        teamScoreStatsService.queryAllByLimit(10, 20).forEach(System.out::println);
    }
    
    @Test
    public void testGame3() throws ParseException {
        String date = "2019年01月01日 04:00";
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        SimpleDateFormat format = new SimpleDateFormat("%yyyy%MM%dd%");
        System.out.println(format.format(myFmt.parse(date)));
        teamScoreStatsService.getGameIndexByDay(format.format(myFmt.parse(date))).forEach(System
                .out::println);
    }
}
