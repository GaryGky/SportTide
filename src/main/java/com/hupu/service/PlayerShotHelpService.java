package com.hupu.service;

    import com.hupu.pojo.PlayerShotHelp;

    import java.util.List;

/**
 * (PlayerShotHelp)表服务接口
 *
 * @author makejava
 * @since 2020-05-23 13:23:39
 */
public interface PlayerShotHelpService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PlayerShotHelp queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PlayerShotHelp> queryAllByLimit(int offset, int limit);

    List<PlayerShotHelp> queryAll(PlayerShotHelp playerShotHelp);

    /**
     * 新增数据
     *
     * @param playerShotHelp 实例对象
     * @return 实例对象
     */
    int insert(PlayerShotHelp playerShotHelp);

    /**
     * 修改数据
     *
     * @param playerShotHelp 实例对象
     * @return 实例对象
     */
    int update(PlayerShotHelp playerShotHelp);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(Integer id);
    
    int insertAll(List<PlayerShotHelp> list);

    }