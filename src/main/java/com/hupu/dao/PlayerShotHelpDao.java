package com.hupu.dao;

import com.hupu.pojo.PlayerShotHelp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PlayerShotHelp)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-23 13:23:39
 */
public interface PlayerShotHelpDao {
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PlayerShotHelp queryById(Integer id);
    
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PlayerShotHelp> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param playerShotHelp 实例对象
     * @return 对象列表
     */
    List<PlayerShotHelp> queryAll(PlayerShotHelp playerShotHelp);
    
    /**
     * 新增数据
     *
     * @param playerShotHelp 实例对象
     * @return 影响行数
     */
    int insert(PlayerShotHelp playerShotHelp);
    
    /**
     * 修改数据
     *
     * @param playerShotHelp 实例对象
     * @return 影响行数
     */
    int update(PlayerShotHelp playerShotHelp);
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    
    int insertAll(@Param("list") List<PlayerShotHelp> list);
    
}