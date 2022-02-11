package com.hupu.service;

import com.hupu.pojo.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2020-04-23 18:50:30
 */
public interface UserService {
    
    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Integer userId);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);
    
    List<User> queryAll(User User);
    
    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    int insert(User user);
    
    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    int update(User user);
    
    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    int deleteById(Integer userId);
    
    
    String getPwdByUserName(String user_name);
    
    User getUserByName(String user_name);
    
    List<String> getAllUserName();
}