package com.hupu.dao;

import com.hupu.pojo.Recap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Recap)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-20 10:40:31
 */
public interface RecapDao {
    
    /**
     * 通过ID查询单条数据
     *
     * @param gameid 主键
     * @return 实例对象
     */
    Recap queryById(int gameid);
    
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Recap> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param recap 实例对象
     * @return 对象列表
     */
    List<Recap> queryAll(Recap recap);
    
    /**
     * 新增数据
     *
     * @param recap 实例对象
     * @return 影响行数
     */
    int insert(Recap recap);
    
    /**
     * 修改数据
     *
     * @param recap 实例对象
     * @return 影响行数
     */
    int update(Recap recap);
    
    /**
     * 通过主键删除数据
     *
     * @param gameid 主键
     * @return 影响行数
     */
    int deleteById(String gameid);
    
    
    List<Recap> getRecapByDate(@Param("foreDate") String foreDate,
                               @Param("backDate") String backDate);
}