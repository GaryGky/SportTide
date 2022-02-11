package com.hupu.service;


import com.hupu.pojo.PlayerScoreStats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (PlayerScoreStats)表服务接口
 *
 * @author makejava
 * @since 2020-04-20 12:38:35
 */
public interface PlayerScoreStatsService {
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PlayerScoreStats queryById(Integer id);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PlayerScoreStats> queryAllByLimit(int offset, int limit);
    
    List<PlayerScoreStats> queryAll(PlayerScoreStats playerScoreStats);
    
    /**
     * 新增数据
     *
     * @param playerScoreStats 实例对象
     * @return 实例对象
     */
    int insert(PlayerScoreStats playerScoreStats);
    
    /**
     * 修改数据
     *
     * @param playerScoreStats 实例对象
     * @return 实例对象
     */
    int update(PlayerScoreStats playerScoreStats);
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(Integer id);
    
    public List<PlayerScoreStats> queryByTeamStatsId(int teamStatsId);
    
    public List<PlayerScoreStats> queryByGameId(int teamStatsId);
    
    public HashMap<String, Object> getTeamStatsByGame(int gameId);
    
    public HashMap<String, Object> getPlayerStatsByGame(int gameId);
}