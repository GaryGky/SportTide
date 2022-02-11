package com.hupu.service;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.Recap;
import com.hupu.service.Impl.RecapServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/application-context.xml"})
public class RecapTest {
    
    @Autowired
    @Qualifier("recapService")
    private RecapServiceImpl recapService;
    
    @Test
    public void testQueryById() {
        System.out.println(recapService.queryById(156542));
        // recapService.queryById(156542);
    }
    
    @Test
    public void testRecap() {
        for (Recap recap : recapService.getRecapByDay("2019-1-10", "2019-1-19")) {
            System.out.println(JSON.toJSON(recap));
        }
    }
}
