package com.hupu.service.Impl;


import com.hupu.dao.VersionInfoDao;
import com.hupu.pojo.VersionInfo;
import com.hupu.service.VersionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (VersionInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-05-17 20:56:43
 */
@Service("versionInfoService")
@Transactional
public class VersionInfoServiceImpl implements VersionInfoService {
    
    @Autowired
    @Qualifier("versionInfoDao")
    private VersionInfoDao versionInfoDao;
    
    @Override
    public VersionInfo queryById(Integer versionCode) {
        return versionInfoDao.queryById(versionCode);
    }
    
    @Override
    public List<VersionInfo> queryAllByLimit(int offset, int limit) {
        return versionInfoDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<VersionInfo> queryAll(VersionInfo versionInfo) {
        return versionInfoDao.queryAll(versionInfo);
    }
    
    @Override
    public int insert(VersionInfo versionInfo) {
        return versionInfoDao.insert(versionInfo);
    }
    
    @Override
    public int update(VersionInfo versionInfo) {
        return versionInfoDao.update(versionInfo);
    }
    
    @Override
    public int deleteById(Integer versionCode) {
        return versionInfoDao.deleteById(versionCode);
    }
    
    @Override
    public VersionInfo getMaxVersionCode() {
        return versionInfoDao.getMaxVersionCode();
    }
}