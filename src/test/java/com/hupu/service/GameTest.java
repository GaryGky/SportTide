package com.hupu.service;

import com.alibaba.fastjson.JSON;
import com.hupu.service.Impl.GameServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GameTest {
    private GameServiceImpl gameService;
    
    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        gameService = (GameServiceImpl) context.getBean("gameService");
    }
    
    @Test
    public void testGame1() {
        System.out.println("=====Test Bean Create=====");
        System.out.println(gameService);
    }
    
    @Test
    public void testGame2() {
        System.out.println("=====Test Query By Page=====");
        gameService.queryAllByLimit(10, 20).forEach(System.out::println);
    }
    
    @Test
    public void testBaseGet(){
        System.out.println(JSON.toJSON(gameService.queryById(156562)));
    }
}
