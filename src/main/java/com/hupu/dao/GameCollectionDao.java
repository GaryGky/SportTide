package com.hupu.dao;

import com.hupu.pojo.GameCollection;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (GameCollection)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-15 12:32:10
 */
public interface GameCollectionDao {
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    GameCollection queryById(Integer id);
    
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<GameCollection> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param gameCollection 实例对象
     * @return 对象列表
     */
    List<GameCollection> queryAll(GameCollection gameCollection);
    
    /**
     * 新增数据
     *
     * @param gameCollection 实例对象
     * @return 影响行数
     */
    int insert(GameCollection gameCollection);
    
    /**
     * 修改数据
     *
     * @param gameCollection 实例对象
     * @return 影响行数
     */
    int update(GameCollection gameCollection);
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    
    List<Map> getUserCollection(@Param("userId") int user_id);
    
    List<Map> getUserColFuture(@Param("userId") int userId);
    
    int isUserCollection(@Param("gameId") int gameId,
                             @Param("userId") int userId);
    
    int deleteByGameUser(@Param("gameId") int gameId,
                         @Param("userId") int userId);
}