package com.hupu.dao;

import com.hupu.pojo.Game;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Map;

public interface GameDao {
    Game queryById(Integer gameid); // 通过id访问比赛数据
    
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Game> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param game 实例对象
     * @return 对象列表
     */
    List<Game> queryAll(Game game); // 直接查询所有比赛
    
    /**
     * 新增数据
     *
     * @param game 实例对象
     * @return 影响行数
     */
    int insert(Game game);
    
    /**
     * 修改数据
     *
     * @param game 实例对象
     * @return 影响行数
     */
    int update(Game game); // 通过gameid进行索引
    
    /**
     * 通过主键删除数据
     *
     * @param gameid 主键
     * @return 影响行数
     */
    int deleteById(Integer gameid);
    
    List<Map<String, Object>> getGameIndex();
    
}