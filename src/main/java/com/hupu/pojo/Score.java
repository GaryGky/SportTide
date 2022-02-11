package com.hupu.pojo;


import java.io.Serializable;

public class Score implements Serializable {
    private String team;
    private String date;
    private String opponent;
    private String home;
    private String winorloss;
    private int teamPoints;
    private int opponentPoints;
    
    @Override
    public String toString() {
        return "Score{" +
                "team='" + team + '\'' +
                ", date='" + date + '\'' +
                ", opponent='" + opponent + '\'' +
                ", home='" + home + '\'' +
                ", winorloss='" + winorloss + '\'' +
                ", teamPoints=" + teamPoints +
                ", opponentPoints=" + opponentPoints +
                '}';
    }
    
    public Score(String team, String date, String opponent, String home, String winorloss, int teamPoints, int opponentPoints) {
        this.team = team;
        this.date = date;
        this.opponent = opponent;
        this.home = home;
        this.winorloss = winorloss;
        this.teamPoints = teamPoints;
        this.opponentPoints = opponentPoints;
    }
    
    public String getTeam() {
        return team;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getOpponent() {
        return opponent;
    }
    
    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }
    
    public String getHome() {
        return home;
    }
    
    public void setHome(String home) {
        this.home = home;
    }
    
    public String getWinorloss() {
        return winorloss;
    }
    
    public void setWinorloss(String winorloss) {
        this.winorloss = winorloss;
    }
    
    public int getTeamPoints() {
        return teamPoints;
    }
    
    public void setTeamPoints(int teamPoints) {
        this.teamPoints = teamPoints;
    }
    
    public int getOpponentPoints() {
        return opponentPoints;
    }
    
    public void setOpponentPoints(int opponentPoints) {
        this.opponentPoints = opponentPoints;
    }
}
