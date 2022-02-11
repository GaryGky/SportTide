package com.hupu.dao;

import com.hupu.pojo.Team;
import com.hupu.pojo.TeamScoreStats;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface TeamScoreStatsDao {
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TeamScoreStats queryById(Integer id);
    
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TeamScoreStats> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param teamScoreStats 实例对象
     * @return 对象列表
     */
    List<TeamScoreStats> queryAll(TeamScoreStats teamScoreStats);
    
    /**
     * 新增数据
     *
     * @param teamScoreStats 实例对象
     * @return 影响行数
     */
    int insert(TeamScoreStats teamScoreStats);
    
    /**
     * 修改数据
     *
     * @param teamScoreStats 实例对象
     * @return 影响行数
     */
    int update(TeamScoreStats teamScoreStats);
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    
    
    List<TeamScoreStats> getTeamStatsByGameId(@Param("game_id") int game_id);
    
    List<TeamScoreStats> getGameIndex(@Param("date") String date);
}