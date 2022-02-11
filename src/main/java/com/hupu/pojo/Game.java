package com.hupu.pojo;

import java.io.Serializable;

public class Game implements Serializable {
    
    private Integer gameid;
    private String gametime;
    private String consumtime;
    private String arena;
    private String peoplenum;
    private int homeScore;
    private int awayScore;
    private String awayTeam;
    private String homeTeam;
    
    public String getAwayTeam() {
        return awayTeam;
    }
    
    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }
    
    public String getHomeTeam() {
        return homeTeam;
    }
    
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }
    
    public Game(Integer gameid, String gametime, String consumtime, String arena, String peoplenum, int homeScore, int awayScore, String awayTeam, String homeTeam) {
        this.gameid = gameid;
        this.gametime = gametime;
        this.consumtime = consumtime;
        this.arena = arena;
        this.peoplenum = peoplenum;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
    }
    
    public Game() {
    }
    
    @Override
    public String toString() {
        return "Game{" +
                "gameid=" + gameid +
                ", gametime='" + gametime + '\'' +
                ", consumtime='" + consumtime + '\'' +
                ", arena='" + arena + '\'' +
                ", peoplenum='" + peoplenum + '\'' +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                ", awayTeam='" + awayTeam + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                '}';
    }
    public int getHomeScore() {
        return homeScore;
    }
    
    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }
    
    public int getAwayScore() {
        return awayScore;
    }
    
    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }
    
    public Integer getGameid() {
        return gameid;
    }
    
    public void setGameid(Integer gameid) {
        this.gameid = gameid;
    }
    
    public String getGametime() {
        return gametime;
    }
    
    public void setGametime(String gametime) {
        this.gametime = gametime;
    }
    
    public String getConsumtime() {
        return consumtime;
    }
    
    public void setConsumtime(String consumtime) {
        this.consumtime = consumtime;
    }
    
    public String getArena() {
        return arena;
    }
    
    public void setArena(String arena) {
        this.arena = arena;
    }
    
    public String getPeoplenum() {
        return peoplenum;
    }
    
    public void setPeoplenum(String peoplenum) {
        this.peoplenum = peoplenum;
    }
    
}