package com.hupu.service;

import com.hupu.pojo.VersionInfo;

import java.util.List;

/**
 * (VersionInfo)表服务接口
 *
 * @author makejava
 * @since 2020-05-17 20:56:43
 */
public interface VersionInfoService {
    
    /**
     * 通过ID查询单条数据
     *
     * @param versionCode 主键
     * @return 实例对象
     */
    VersionInfo queryById(Integer versionCode);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<VersionInfo> queryAllByLimit(int offset, int limit);
    
    List<VersionInfo> queryAll(VersionInfo versionInfo);
    
    /**
     * 新增数据
     *
     * @param versionInfo 实例对象
     * @return 实例对象
     */
    int insert(VersionInfo versionInfo);
    
    /**
     * 修改数据
     *
     * @param versionInfo 实例对象
     * @return 实例对象
     */
    int update(VersionInfo versionInfo);
    
    /**
     * 通过主键删除数据
     *
     * @param versionCode 主键
     * @return 是否成功
     */
    int deleteById(Integer versionCode);
    
    VersionInfo getMaxVersionCode();
}