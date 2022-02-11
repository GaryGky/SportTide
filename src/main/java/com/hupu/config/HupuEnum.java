package com.hupu.config;

import com.hupu.pojo.Game;

public interface HupuEnum {
    enum RedisExpTime implements HupuEnum {
        SHORT_TIME(300), Mid_Time(500), LongTime(700), S_LONG(900),
        SS_LONG(86400);
        private long time = 0;
        
        public long getTime() {
            return time;
        }
        
        public void setTime(int time) {
            this.time = time;
        }
        
        RedisExpTime(int value) {
            this.time = value;
        }
    }
    
    // 登录成功，密码不正确，用户名重复
    enum LogInRet implements HupuEnum {
        SUCCESS(1), PWD_UNMATCHED(0), USER_NAME_DUP(2);
        private int returnCode = 0;
        
        LogInRet(int code) {
            this.returnCode = code;
        }
        
        public int getReturnCode() {
            return returnCode;
        }
        
        public void setReturnCode(int returnCode) {
            this.returnCode = returnCode;
        }
    }
    
    enum GameType implements HupuEnum {
        GAMEOVER(0), GAMEPOSTPONE(1);
        
        private int gameCode;
        
        GameType(int code) {
            this.gameCode = code;
        }
        
        public int getGameCode() {
            return gameCode;
        }
        
        public void setGameCode(int gameCode) {
            this.gameCode = gameCode;
        }
    }
    
    enum TopicType implements HupuEnum {
        COMMENT(0), GAME(1), POST(2);
        private int topicType;
        
        TopicType(int topicType) {
            this.topicType = topicType;
        }
    
        public int getTopicType() {
            return topicType;
        }
    
        public void setTopicType(int topicType) {
            this.topicType = topicType;
        }
    }
}
