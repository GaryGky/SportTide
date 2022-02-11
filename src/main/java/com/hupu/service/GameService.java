package com.hupu.service;

import com.hupu.pojo.Game;

import java.util.List;

public interface GameService {
    
    /**
     * 通过ID查询单条数据
     *
     * @param gameid 主键
     * @return 实例对象
     */
    Game queryById(Integer gameid);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Game> queryAllByLimit(int offset, int limit);
    
    List<Game> queryAll(Game game);
    
    /**
     * 新增数据
     *
     * @param game 实例对象
     * @return 实例对象
     */
    int insert(Game game);
    
    /**
     * 修改数据
     *
     * @param game 实例对象
     * @return 实例对象
     */
    int update(Game game);
    
    /**
     * 通过主键删除数据
     *
     * @param gameid 主键
     * @return 是否成功
     */
    int deleteById(Integer gameid);
    
}