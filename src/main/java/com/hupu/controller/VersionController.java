package com.hupu.controller;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.VersionInfo;
import com.hupu.service.Impl.VersionInfoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/version")
public class VersionController {
    @Autowired
    private VersionInfoServiceImpl versionInfoService;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping(value = "/addVersion", method = RequestMethod.POST)
    public int addVersionInfo(VersionInfo versionInfo) {
        logger.info(JSON.toJSONString(versionInfo));
        return versionInfoService.insert(versionInfo);
    }
    
    @RequestMapping("/allVersion")
    public List<VersionInfo> getAllVersion(HttpServletRequest request) {
        List<VersionInfo> list = versionInfoService.queryAllByLimit(0, 100);
        request.getSession().setAttribute("versionInfo", list);
        return list;
    }
    
    @RequestMapping("/getLatestVersion")
    public VersionInfo getLatestVersion() {
        return versionInfoService.getMaxVersionCode();
    }
    
    @RequestMapping("/update")
    public int updateVersion(VersionInfo versionInfo) {
        return versionInfoService.update(versionInfo);
    }
}
