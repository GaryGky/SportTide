package com.hupu.controller;

import com.hupu.pojo.GameCollection;
import com.hupu.pojo.Post;
import com.hupu.service.Impl.GameCollectionServiceImpl;
import com.hupu.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/collect")
public class GameColController {
    @Autowired
    private GameCollectionServiceImpl gameCollectionService;
    
    @RequestMapping(value = "/addCollection")
    public int addCollection(int gameId, int userId) {
        return gameCollectionService.insert(new GameCollection(userId, gameId,
                DateUtils.getCurTime()));
    }
    
    @RequestMapping("/delCollection")
    public int removeCollection(int collectionId) {
        return gameCollectionService.deleteById(collectionId);
    }
    
    @RequestMapping("/getUserCollection")
    public List<Map> getUserCollection(int userId) {
        return gameCollectionService.getUserCollection(userId);
    }
    
    @RequestMapping("/isCollection")
    public int isUserColletion(int gameId, int userId) {
        return gameCollectionService.isUserCollection(gameId, userId);
    }
    
    @RequestMapping("/delByUserGame")
    public int deleteByUserGame(int gameId, int userId) {
        return gameCollectionService.deleteByGameUser(gameId, userId);
    }
}
