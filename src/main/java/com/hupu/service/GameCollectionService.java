package com.hupu.service;

import com.hupu.pojo.GameCollection;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (GameCollection)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 12:33:13
 */
public interface GameCollectionService {
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    GameCollection queryById(Integer id);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<GameCollection> queryAllByLimit(int offset, int limit);
    
    List<GameCollection> queryAll(GameCollection gameCollection);
    
    /**
     * 新增数据
     *
     * @param gameCollection 实例对象
     * @return 实例对象
     */
    int insert(GameCollection gameCollection);
    
    /**
     * 修改数据
     *
     * @param gameCollection 实例对象
     * @return 实例对象
     */
    int update(GameCollection gameCollection);
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(Integer id);
    
    List<Map> getUserCollection(int user_id);
    
    List<Map> getUserColFuture(int userId);
    
    int isUserCollection(int gameId,
                         int userId);
    
    int deleteByGameUser(int gameId,
                         int userId);
}