package com.hupu.redis;

import com.alibaba.fastjson.JSON;
import com.hupu.config.RedisConfig;
import com.hupu.pojo.Admin;
import com.hupu.pojo.User;
import com.hupu.service.Impl.UserServiceImpl;
import com.hupu.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/application-context.xml"})

public class RedisTest {
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;
    
    @Autowired
    @Qualifier("redisUtil")
    private RedisUtil redisUtil;
    
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void test1() {
        // 操作不同的数据类型
        Admin admin = new Admin(1, "name", "pwd");
        for (User user : userService.queryAllByLimit(0, 10)) {
            redisUtil.set(user.getUserName(), user);
        }
    }
    
    @Test
    public void test2() {
        // 列表
        ListOperations listOperations = redisTemplate.opsForList();
    }
    
    @Test
    public void test3() {
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
    }
    
    @Test
    public void test4() {
        RedisConnection redisConnection =
                redisTemplate.getConnectionFactory().getConnection();
        redisConnection.flushAll();
    }
}
