package com.hupu.redis;

import com.hupu.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.web.config.SpringDataWebConfigurationMixin;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:application-context.xml"})
public class SubPubTest {
    @Autowired
    @Qualifier("redisUtil")
    private RedisUtil redisUtil;
    
    @Test
    public void test1() {

    }
    
}
