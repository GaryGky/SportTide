package com.hupu.service;

import com.hupu.pojo.TeamScoreStats;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (TeamScoreStats)表服务接口
 *
 * @author makejava
 * @since 2020-04-20 13:40:39
 */
public interface TeamScoreStatsService {
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TeamScoreStats queryById(Integer id);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TeamScoreStats> queryAllByLimit(int offset, int limit);
    
    List<TeamScoreStats> queryAll(TeamScoreStats teamScoreStats);
    
    /**
     * 新增数据
     *
     * @param teamScoreStats 实例对象
     * @return 实例对象
     */
    int insert(TeamScoreStats teamScoreStats);
    
    /**
     * 修改数据
     *
     * @param teamScoreStats 实例对象
     * @return 实例对象
     */
    int update(TeamScoreStats teamScoreStats);
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(Integer id);
    
    List<TeamScoreStats> getTeamStatsByGameId(int gameId);
    
    ArrayList<Map> getGameIndexByDay(String date) throws ParseException;
    
    HashMap<String, Object> getScoreByGame(int gameId);
    
    void updateGameScore(int gameId, String newScore);
}