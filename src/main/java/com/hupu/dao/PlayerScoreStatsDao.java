package com.hupu.dao;

import com.hupu.pojo.PlayerScoreStats;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (PlayerScoreStats)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-20 10:37:06
 */
public interface PlayerScoreStatsDao {
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PlayerScoreStats queryById(Integer id);
    
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PlayerScoreStats> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param playerScoreStats 实例对象
     * @return 对象列表
     */
    List<PlayerScoreStats> queryAll(PlayerScoreStats playerScoreStats);
    
    /**
     * 新增数据
     *
     * @param playerScoreStats 实例对象
     * @return 影响行数
     */
    int insert(PlayerScoreStats playerScoreStats);
    
    /**
     * 修改数据
     *
     * @param playerScoreStats 实例对象
     * @return 影响行数
     */
    int update(PlayerScoreStats playerScoreStats);
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    
    public List<PlayerScoreStats> queryByTeamStatsId(@Param("teamStatsId") int teamStatsId);
    
    List<PlayerScoreStats> queryByGameId(@Param("game_id") int gameId);
}