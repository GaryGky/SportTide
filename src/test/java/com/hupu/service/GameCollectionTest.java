package com.hupu.service;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.GameCollection;
import com.hupu.service.Impl.GameCollectionServiceImpl;
import com.hupu.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/application-context.xml"})

public class GameCollectionTest {
    @Autowired
    private GameCollectionServiceImpl gameCollectionService;
    
    @Test
    public void testInsert() {
        int gameId = 158498;
        for (int i = 0; i < 10; i++) {
            gameCollectionService.insert(new GameCollection(1, gameId + i,
                    DateUtils.getCurTime()));
        }
    }
    
    @Test
    public void testInsert2() {
        int gameId = 156542;
        for (int i = 0; i < 10; i++) {
            gameCollectionService.insert(new GameCollection(1, gameId + i,
                    DateUtils.getCurTime()));
        }
    }
    
    @Test
    public void testGetUsrCollection() {
        gameCollectionService.getUserCollection(1).forEach(System.out::println);
    }
    
    @Test
    public void testBaseGet() {
        System.out.println(JSON.toJSON(gameCollectionService.queryAllByLimit(0, 1)));
    }
    
    @Test
    public void test1(){
        System.out.println(gameCollectionService.deleteByGameUser(158499,1));
    }
    
    @Test
    public void test2(){
        System.out.println(gameCollectionService.isUserCollection(158501,1));
    }
    
    @Test
    public void test3(){
        for (Map map : gameCollectionService.getUserCollection(1)) {
            System.out.println(JSON.toJSON(map));
        }
    }
    
}
