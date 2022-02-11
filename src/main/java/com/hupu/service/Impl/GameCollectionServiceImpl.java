package com.hupu.service.Impl;


import com.hupu.dao.GameCollectionDao;
import com.hupu.pojo.GameCollection;
import com.hupu.service.GameCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * (GameCollection)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 12:33:13
 */
@Service("gameCollectionService")
@Transactional
public class GameCollectionServiceImpl implements GameCollectionService {
    
    @Autowired
    @Qualifier("gameCollectionDao")
    private GameCollectionDao gameCollectionDao;
    
    @Override
    public GameCollection queryById(Integer id) {
        return gameCollectionDao.queryById(id);
    }
    
    @Override
    public List<GameCollection> queryAllByLimit(int offset, int limit) {
        return gameCollectionDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<GameCollection> queryAll(GameCollection gameCollection) {
        return gameCollectionDao.queryAll(gameCollection);
    }
    
    @Override
    public int insert(GameCollection gameCollection) {
        return gameCollectionDao.insert(gameCollection);
    }
    
    @Override
    public int update(GameCollection gameCollection) {
        return gameCollectionDao.update(gameCollection);
    }
    
    @Override
    public int deleteById(Integer id) {
        return gameCollectionDao.deleteById(id);
    }
    
    @Override
    public List<Map> getUserCollection(int user_id) {
        List<Map> mapList = gameCollectionDao.getUserCollection(user_id);
        for (Map map : mapList) {
            map.put("awayWinRate",0);
            map.put("homeWinRate",0);
        }
        mapList.addAll(getUserColFuture(user_id));
        return mapList;
    }
    
    @Override
    public List<Map> getUserColFuture(int userId) {
        List<Map> list = gameCollectionDao.getUserColFuture(userId);
        for (Map map : list) {
            map.put("homeScore", 0); // 新增两个字段保持统一
            map.put("awayScore", 0);
            map.put("arena", null);
        }
        return list;
    }
    
    @Override
    public int isUserCollection(int gameId, int userId) {
        return gameCollectionDao.isUserCollection(gameId, userId);
    }
    
    @Override
    public int deleteByGameUser(int gameId, int userId) {
        return gameCollectionDao.deleteByGameUser(gameId, userId);
    }
}