package com.hupu.pojo;

import java.io.Serializable;

public class PlayerShotHelp implements Serializable {
    
    private int id;
    private String teamid;
    
    private Integer teamstatsid;
    
    private String playername;
    
    private Integer shotin;
    
    private Integer shotall;
    
    private Integer threeshotin;
    
    private Integer threeshotall;
    
    private Integer penaltyin;
    
    private Integer penaltyall;
    
    public PlayerShotHelp() {
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public PlayerShotHelp(int id, String teamid, Integer teamstatsid, String playername, Integer shotin, Integer shotall, Integer threeshotin, Integer threeshotall, Integer penaltyin, Integer penaltyall) {
        this.id = id;
        this.teamid = teamid;
        this.teamstatsid = teamstatsid;
        this.playername = playername;
        this.shotin = shotin;
        this.shotall = shotall;
        this.threeshotin = threeshotin;
        this.threeshotall = threeshotall;
        this.penaltyin = penaltyin;
        this.penaltyall = penaltyall;
    }
    
    public String getTeamid() {
        return teamid;
    }
    
    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }
    
    public Integer getTeamstatsid() {
        return teamstatsid;
    }
    
    public void setTeamstatsid(Integer teamstatsid) {
        this.teamstatsid = teamstatsid;
    }
    
    public String getPlayername() {
        return playername;
    }
    
    public void setPlayername(String playername) {
        this.playername = playername;
    }
    
    public Integer getShotin() {
        return shotin;
    }
    
    public void setShotin(Integer shotin) {
        this.shotin = shotin;
    }
    
    public Integer getShotall() {
        return shotall;
    }
    
    public void setShotall(Integer shotall) {
        this.shotall = shotall;
    }
    
    public Integer getThreeshotin() {
        return threeshotin;
    }
    
    public void setThreeshotin(Integer threeshotin) {
        this.threeshotin = threeshotin;
    }
    
    public Integer getThreeshotall() {
        return threeshotall;
    }
    
    public void setThreeshotall(Integer threeshotall) {
        this.threeshotall = threeshotall;
    }
    
    public Integer getPenaltyin() {
        return penaltyin;
    }
    
    public void setPenaltyin(Integer penaltyin) {
        this.penaltyin = penaltyin;
    }
    
    public Integer getPenaltyall() {
        return penaltyall;
    }
    
    public void setPenaltyall(Integer penaltyall) {
        this.penaltyall = penaltyall;
    }
    
}