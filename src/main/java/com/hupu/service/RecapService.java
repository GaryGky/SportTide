package com.hupu.service;

import com.hupu.pojo.Recap;

import java.util.List;

/**
 * (Recap)表服务接口
 *
 * @author makejava
 * @since 2020-04-26 19:41:25
 */
public interface RecapService {
    
    /**
     * 通过ID查询单条数据
     *
     * @param gameid 主键
     * @return 实例对象
     */
    Recap queryById(int gameid);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Recap> queryAllByLimit(int offset, int limit);
    
    List<Recap> queryAll(Recap recap);
    
    /**
     * 新增数据
     *
     * @param recap 实例对象
     * @return 实例对象
     */
    int insert(Recap recap);
    
    /**
     * 修改数据
     *
     * @param recap 实例对象
     * @return 实例对象
     */
    int update(Recap recap);
    
    /**
     * 通过主键删除数据
     *
     * @param gameid 主键
     * @return 是否成功
     */
    int deleteById(String gameid);
    
    List<Recap> getRecapByDay(String foreDate, String backDate);
    
    
}