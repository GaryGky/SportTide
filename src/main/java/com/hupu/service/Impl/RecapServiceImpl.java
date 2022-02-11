package com.hupu.service.Impl;


import com.hupu.config.HupuEnum;
import com.hupu.dao.RecapDao;
import com.hupu.pojo.Recap;
import com.hupu.service.RecapService;
import com.hupu.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (Recap)表服务实现类
 *
 * @author makejava
 * @since 2020-04-26 19:41:25
 */
@Service("recapService")
@Transactional
public class RecapServiceImpl implements RecapService {
    
    @Autowired
    @Qualifier("recapDao")
    private RecapDao recapDao;
    
    @Autowired
    @Qualifier("redisUtil")
    private RedisUtil redisUtil;
    
    @Override
    public Recap queryById(int gameid) {
        String key = "recap" + gameid;
        if (redisUtil.hasKey(key)) {
            return (Recap) redisUtil.get(key);
        }
        Recap recap = recapDao.queryById(gameid);
        redisUtil.set(key, recap, HupuEnum.RedisExpTime.SHORT_TIME.getTime());
        return recap;
    }
    
    @Override
    public List<Recap> queryAllByLimit(int offset, int limit) {
        return recapDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<Recap> queryAll(Recap recap) {
        return recapDao.queryAll(recap);
    }
    
    @Override
    public int insert(Recap recap) {
        return recapDao.insert(recap);
    }
    
    @Override
    public int update(Recap recap) {
        return recapDao.update(recap);
    }
    
    @Override
    public int deleteById(String gameid) {
        return recapDao.deleteById(gameid);
    }
    
    @Override
    public List<Recap> getRecapByDay(String foreDate, String backDate) {
        String key = foreDate + backDate + "getRecapByDate";
        if (redisUtil.hasKey(key)) {
            return (List<Recap>) redisUtil.get(key);
        }
        List<Recap> recaps = recapDao.getRecapByDate(foreDate, backDate);
        redisUtil.set(key, recaps, HupuEnum.RedisExpTime.Mid_Time.getTime());
        return recaps;
    }
}