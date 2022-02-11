package com.hupu.pojo;

import java.io.Serializable;

public class PlayerScoreStats implements Serializable {
    
    private int id;
    private String teamid;
    private Integer teamstatsid;
    private String playername;
    private Integer isfirst;
    private String position;
    private Integer playminute;
    private String shot;
    private String threeshot;
    private String penaltyshot;
    private Integer frontcourt;
    private Integer backcourt;
    private Integer rebound;
    private Integer assist;
    private Integer foul;
    private Integer steal;
    private Integer fault;
    private Integer block;
    private Integer score;
    private Integer contribution;
    
    public PlayerScoreStats() {
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public PlayerScoreStats(int id, String teamid, Integer teamstatsid, String playername, Integer isfirst, String position, Integer playminute, String shot, String threeshot, String penaltyshot, Integer frontcourt, Integer backcourt, Integer rebound, Integer assist, Integer foul, Integer steal, Integer fault, Integer block, Integer score, Integer contribution) {
        this.id = id;
        this.teamid = teamid;
        this.teamstatsid = teamstatsid;
        this.playername = playername;
        this.isfirst = isfirst;
        this.position = position;
        this.playminute = playminute;
        this.shot = shot;
        this.threeshot = threeshot;
        this.penaltyshot = penaltyshot;
        this.frontcourt = frontcourt;
        this.backcourt = backcourt;
        this.rebound = rebound;
        this.assist = assist;
        this.foul = foul;
        this.steal = steal;
        this.fault = fault;
        this.block = block;
        this.score = score;
        this.contribution = contribution;
    }
    
    @Override
    public String toString() {
        return "PlayerScoreStats{" +
                "teamid='" + teamid + '\'' +
                ", teamstatsid=" + teamstatsid +
                ", playername='" + playername + '\'' +
                ", isfirst=" + isfirst +
                ", position='" + position + '\'' +
                ", playminute=" + playminute +
                ", shot='" + shot + '\'' +
                ", threeshot='" + threeshot + '\'' +
                ", penaltyshot='" + penaltyshot + '\'' +
                ", frontcourt=" + frontcourt +
                ", backcourt=" + backcourt +
                ", rebound=" + rebound +
                ", assist=" + assist +
                ", foul=" + foul +
                ", steal=" + steal +
                ", fault=" + fault +
                ", block=" + block +
                ", score=" + score +
                ", contribution=" + contribution +
                '}';
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
    
    public Integer getIsfirst() {
        return isfirst;
    }
    
    public void setIsfirst(Integer isfirst) {
        this.isfirst = isfirst;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public Integer getPlayminute() {
        return playminute;
    }
    
    public void setPlayminute(Integer playminute) {
        this.playminute = playminute;
    }
    
    public String getShot() {
        return shot;
    }
    
    public void setShot(String shot) {
        this.shot = shot;
    }
    
    public String getThreeshot() {
        return threeshot;
    }
    
    public void setThreeshot(String threeshot) {
        this.threeshot = threeshot;
    }
    
    public String getPenaltyshot() {
        return penaltyshot;
    }
    
    public void setPenaltyshot(String penaltyshot) {
        this.penaltyshot = penaltyshot;
    }
    
    public Integer getFrontcourt() {
        return frontcourt;
    }
    
    public void setFrontcourt(Integer frontcourt) {
        this.frontcourt = frontcourt;
    }
    
    public Integer getBackcourt() {
        return backcourt;
    }
    
    public void setBackcourt(Integer backcourt) {
        this.backcourt = backcourt;
    }
    
    public Integer getRebound() {
        return rebound;
    }
    
    public void setRebound(Integer rebound) {
        this.rebound = rebound;
    }
    
    public Integer getAssist() {
        return assist;
    }
    
    public void setAssist(Integer assist) {
        this.assist = assist;
    }
    
    public Integer getFoul() {
        return foul;
    }
    
    public void setFoul(Integer foul) {
        this.foul = foul;
    }
    
    public Integer getSteal() {
        return steal;
    }
    
    public void setSteal(Integer steal) {
        this.steal = steal;
    }
    
    public Integer getFault() {
        return fault;
    }
    
    public void setFault(Integer fault) {
        this.fault = fault;
    }
    
    public Integer getBlock() {
        return block;
    }
    
    public void setBlock(Integer block) {
        this.block = block;
    }
    
    public Integer getScore() {
        return score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }
    
    public Integer getContribution() {
        return contribution;
    }
    
    public void setContribution(Integer contribution) {
        this.contribution = contribution;
    }
    
}