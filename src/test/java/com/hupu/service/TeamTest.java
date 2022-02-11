package com.hupu.service;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.Team;
import com.hupu.service.Impl.TeamServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TeamTest {
    private TeamServiceImpl teamService;
    
    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        teamService = (TeamServiceImpl) context.getBean("teamService");
    }
    
    @Test
    public void testGet() {
        teamService.queryAllByLimit(0, 100).stream().map(JSON::toJSONString).forEach(System.out::println);
    }
    

}
