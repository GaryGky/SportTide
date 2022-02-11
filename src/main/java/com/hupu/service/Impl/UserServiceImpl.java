package com.hupu.service.Impl;


import com.alibaba.fastjson.JSON;
import com.hupu.config.HupuEnum;
import com.hupu.dao.UserDao;
import com.hupu.pojo.User;
import com.hupu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-04-23 18:56:43
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public User queryById(Integer userId) {
        return userDao.queryById(userId);
    }
    
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return userDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<User> queryAll(User user) {
        return userDao.queryAll(user);
    }
    
    @Override
    public int insert(User user) { // 用户注册
        logger.info(JSON.toJSONString(user));
        if (userDao.getUserByUserName(user.getUserName()) != null) {
            logger.info("用户注册时用户名重复");
            return HupuEnum.LogInRet.USER_NAME_DUP.getReturnCode();
        } else {
            logger.info("注册成功");
            return userDao.insert(user);
        }
    }
    
    @Override
    public int update(User user) {
        return userDao.update(user);
    }
    
    @Override
    public int deleteById(Integer userId) {
        return userDao.deleteById(userId);
    }
    
    @Override
    public String getPwdByUserName(String user_name) {
        return userDao.getPwdByUserName(user_name);
    }
    
    @Override
    public User getUserByName(String user_name) {
        return userDao.getUserByUserName(user_name);
    }
    
    @Override
    public List<String> getAllUserName() {
        return userDao.getAllUserName();
    }
}