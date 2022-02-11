package com.hupu.service;

import com.hupu.pojo.Team;

import java.util.List;
import java.util.Map;

/**
 * (Team)表服务接口
 *
 * @author makejava
 * @since 2020-04-23 19:30:22
 */
public interface TeamService {
    
    /**
     * 通过ID查询单条数据
     *
     * @param teamid 主键
     * @return 实例对象
     */
    Team queryById(String teamid);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Team> queryAllByLimit(int offset, int limit);
    
    List<Team> queryAll(Team team);
    
    /**
     * 新增数据
     *
     * @param team 实例对象
     * @return 实例对象
     */
    int insert(Team team);
    
    /**
     * 修改数据
     *
     * @param team 实例对象
     * @return 实例对象
     */
    int update(Team team);
    
    /**
     * 通过主键删除数据
     *
     * @param teamid 主键
     * @return 是否成功
     */
    int deleteById(String teamid);
    
    
    List<Map<String, Object>> getAllTeam();
}