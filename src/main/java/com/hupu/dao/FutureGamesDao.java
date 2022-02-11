package com.hupu.dao;

import com.hupu.pojo.FutureGames;
import com.hupu.pojo.TeamScoreStats;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * (FutureGames)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-11 11:18:25
 */
public interface FutureGamesDao {
    
    /**
     * 通过ID查询单条数据
     *
     * @param gameid 主键
     * @return 实例对象
     */
    FutureGames queryById(String gameid);
    
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<FutureGames> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param futureGames 实例对象
     * @return 对象列表
     */
    List<FutureGames> queryAll(FutureGames futureGames);
    
    /**
     * 新增数据
     *
     * @param futureGames 实例对象
     * @return 影响行数
     */
    int insert(FutureGames futureGames);
    
    /**
     * 修改数据
     *
     * @param futureGames 实例对象
     * @return 影响行数
     */
    int update(FutureGames futureGames);
    
    /**
     * 通过主键删除数据
     *
     * @param gameid 主键
     * @return 影响行数 // 获得球队的所有比赛场数
     */
    int deleteById(String gameid);
    
    List<FutureGames> getFutureGameByDate(@Param("date") String date);
    
    int getStatsByTeam(@Param("teamId") String teamId);
    
    int getAllGames(@Param("teamId") String teamId);
    
    int getWinGames(@Param("teamId") String teamId); // 获得球队的胜场
    
    Map<String, BigDecimal> getFutureAVGShot(@Param("teamId") String teamId,
                                             @Param("min") long min,
                                             @Param("max") long max);
    
    Map<String, BigDecimal> getFutureSUMScore(@Param("teamId") String teamId,
                                              @Param("min") long min,
                                              @Param("max") long max);
    
    Map<String, Long> getMinMax();
}