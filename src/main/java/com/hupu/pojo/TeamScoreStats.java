package com.hupu.pojo;

import java.io.Serializable;

public class TeamScoreStats implements Serializable {
    private Integer id;
    private String teamid;
    private Integer gameid;
    private Integer ishome;
    private Integer score1;
    private Integer score2;
    private Integer score3;
    private Integer score4;
    private Integer score;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "TeamScoreStats{" +
                "id=" + id +
                ", teamid='" + teamid + '\'' +
                ", gameid=" + gameid +
                ", ishome=" + ishome +
                ", score1=" + score1 +
                ", score2=" + score2 +
                ", score3=" + score3 +
                ", score4=" + score4 +
                ", score=" + score +
                '}';
    }
    
    public TeamScoreStats() {
    }
    
    
    public TeamScoreStats(Integer id, String teamid, Integer gameid, Integer ishome, Integer score1, Integer score2, Integer score3, Integer score4, Integer score) {
        this.id = id;
        this.teamid = teamid;
        this.gameid = gameid;
        this.ishome = ishome;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.score = score;
    }
    
    public String getTeamid() {
        return teamid;
    }
    
    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }
    
    public Integer getGameid() {
        return gameid;
    }
    
    public void setGameid(Integer gameid) {
        this.gameid = gameid;
    }
    
    public Integer getIshome() {
        return ishome;
    }
    
    public void setIshome(Integer ishome) {
        this.ishome = ishome;
    }
    
    public Integer getScore1() {
        return score1;
    }
    
    public void setScore1(Integer score1) {
        this.score1 = score1;
    }
    
    public Integer getScore2() {
        return score2;
    }
    
    public void setScore2(Integer score2) {
        this.score2 = score2;
    }
    
    public Integer getScore3() {
        return score3;
    }
    
    public void setScore3(Integer score3) {
        this.score3 = score3;
    }
    
    public Integer getScore4() {
        return score4;
    }
    
    public void setScore4(Integer score4) {
        this.score4 = score4;
    }
    
    public Integer getScore() {
        return score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }
    
}