package com.hupu.dao;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.User;
import com.hupu.service.Impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class UserTest {
    private UserServiceImpl userService;
    
    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        userService = (UserServiceImpl) context.getBean("userService");
    }
    
    @Test
    public void testInsert() {
        System.out.println("====Test Insert=====");
        for (int i = 0; i < 10; i++) {
            User user = new User(i, "user_name" + i,
                    "email" + i,
                    "pwd" + i, "nikename" + i,
                    "time" + i, 0, 0);
            userService.insert(user);
        }
    }
    
    @Test
    public void testQuery() {
        userService.queryAllByLimit(5, 10).stream().map(JSON::toJSON).forEach(System.out::println);
    }
    
    @Test
    public void deleteById() {
        for (int i = 0; i < 10; i++) {
            userService.deleteById(i);
        }
    }
    
    @Test
    public void testGet() {
        System.out.println(JSON.toJSONString(userService.getUserByName(
                "q")));
    }
    
    @Test
    public void testUpd() {

    }
}
