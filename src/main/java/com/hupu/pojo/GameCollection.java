package com.hupu.pojo;

import java.io.Serializable;

public class GameCollection implements Serializable {
    
    private int id;
    private Integer userId;
    
    private Integer gameId;
    
    private String collectTime;
    
    public GameCollection() {
    }
    
    public GameCollection(Integer userId, Integer gameId, String collectTime) {
        this.userId = userId;
        this.gameId = gameId;
        this.collectTime = collectTime;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getGameId() {
        return gameId;
    }
    
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
    
    public String getCollectTime() {
        return collectTime;
    }
    
    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }
    
    @Override
    public String toString() {
        return "GameCollection{" +
                "userId=" + userId +
                ", gameId=" + gameId +
                ", collectTime='" + collectTime + '\'' +
                '}';
    }
}