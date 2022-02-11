package com.hupu.service.Impl;


import com.hupu.dao.PlayerShotHelpDao;
import com.hupu.pojo.PlayerShotHelp;
import com.hupu.service.PlayerShotHelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (PlayerShotHelp)表服务实现类
 *
 * @author makejava
 * @since 2020-05-23 13:23:39
 */
@Service("playerShotHelpService")
@Transactional
public class PlayerShotHelpServiceImpl implements PlayerShotHelpService {
    
    @Autowired
    private PlayerShotHelpDao playerShotHelpDao;
    
    @Override
    public PlayerShotHelp queryById(Integer id) {
        return playerShotHelpDao.queryById(id);
    }
    
    @Override
    public List<PlayerShotHelp> queryAllByLimit(int offset, int limit) {
        return playerShotHelpDao.queryAllByLimit(offset, limit);
    }
    
    @Override
    public List<PlayerShotHelp> queryAll(PlayerShotHelp playerShotHelp) {
        return playerShotHelpDao.queryAll(playerShotHelp);
    }
    
    @Override
    public int insert(PlayerShotHelp playerShotHelp) {
        return playerShotHelpDao.insert(playerShotHelp);
    }
    
    @Override
    public int update(PlayerShotHelp playerShotHelp) {
        return playerShotHelpDao.update(playerShotHelp);
    }
    
    @Override
    public int deleteById(Integer id) {
        return playerShotHelpDao.deleteById(id);
    }
    
    @Override
    public int insertAll(List<PlayerShotHelp> list) {
        return playerShotHelpDao.insertAll(list);
    }
}