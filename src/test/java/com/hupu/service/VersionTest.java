package com.hupu.service;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.VersionInfo;
import com.hupu.service.Impl.VersionInfoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/application-context.xml"})
public class VersionTest {
    @Autowired
    private VersionInfoServiceImpl versionInfoService;
    
    @Test
    public void insert() {
        for (int i = 0; i < 10; i++) {
            versionInfoService.insert(new VersionInfo(i+989,
                    "versionName" + i + 989,
                    true, "url" + i, "info" + i));
        }
    }
    @Test
    public void getMax(){
        System.out.println(JSON.toJSON(versionInfoService.getMaxVersionCode()));
    }
    
    @Test
    public void testBase(){
        for (VersionInfo info : versionInfoService.queryAllByLimit(0, 10)) {
            System.out.println(JSON.toJSON(info));
        }
    }
}
