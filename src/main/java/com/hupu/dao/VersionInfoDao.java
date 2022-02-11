package com.hupu.dao;

import com.hupu.pojo.VersionInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (VersionInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-17 20:56:43
 */
public interface VersionInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param versionCode 主键
     * @return 实例对象
     */
    VersionInfo queryById(Integer versionCode);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<VersionInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param versionInfo 实例对象
     * @return 对象列表
     */
    List<VersionInfo> queryAll(VersionInfo versionInfo);

    /**
     * 新增数据
     *
     * @param versionInfo 实例对象
     * @return 影响行数
     */
    int insert(VersionInfo versionInfo);

    /**
     * 修改数据
     *
     * @param versionInfo 实例对象
     * @return 影响行数
     */
    int update(VersionInfo versionInfo);

    /**
     * 通过主键删除数据
     *
     * @param versionCode 主键
     * @return 影响行数
     */
    int deleteById(Integer versionCode);
    
    VersionInfo getMaxVersionCode();

}