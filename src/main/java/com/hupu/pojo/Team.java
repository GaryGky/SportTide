package com.hupu.pojo;

import java.io.Serializable;

public class Team implements Serializable {
    private String teamid;
    private String teamname;
    private String buildtime;
    private String area;
    private String homecourt;
    private String chiefcoach;
    private String logourl;
    private String website;
    private String description;
    
    public Team(String teamid, String teamname, String buildtime, String area, String homecourt, String chiefcoach, String logourl, String website, String description) {
        this.teamid = teamid;
        this.teamname = teamname;
        this.buildtime = buildtime;
        this.area = area;
        this.homecourt = homecourt;
        this.chiefcoach = chiefcoach;
        this.logourl = logourl;
        this.website = website;
        this.description = description;
    }
    
    public Team() {
    }
    
    @Override
    public String toString() {
        return "Team{" +
                "teamid='" + teamid + '\'' +
                ", teamname='" + teamname + '\'' +
                ", buildtime='" + buildtime + '\'' +
                ", area='" + area + '\'' +
                ", homecourt='" + homecourt + '\'' +
                ", chiefcoach='" + chiefcoach + '\'' +
                ", logourl='" + logourl + '\'' +
                ", website='" + website + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    
    public String getTeamid() {
        return teamid;
    }
    
    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }
    
    public String getTeamname() {
        return teamname;
    }
    
    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }
    
    public String getBuildtime() {
        return buildtime;
    }
    
    public void setBuildtime(String buildtime) {
        this.buildtime = buildtime;
    }
    
    public String getArea() {
        return area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }
    
    public String getHomecourt() {
        return homecourt;
    }
    
    public void setHomecourt(String homecourt) {
        this.homecourt = homecourt;
    }
    
    public String getChiefcoach() {
        return chiefcoach;
    }
    
    public void setChiefcoach(String chiefcoach) {
        this.chiefcoach = chiefcoach;
    }
    
    public String getLogourl() {
        return logourl;
    }
    
    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }
    
    public String getWebsite() {
        return website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
}