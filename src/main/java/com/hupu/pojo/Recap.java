package com.hupu.pojo;

import java.io.Serializable;

public class Recap implements Serializable {
    private String gameid;
    private String header;
    private String content;
    private String updtime;
    private String capture;
    
    public Recap() {
    }
    
    public Recap(String gameid, String header, String content, String updtime, String capture) {
        this.gameid = gameid;
        this.header = header;
        this.content = content;
        this.updtime = updtime;
        this.capture = capture;
    }
    
    @Override
    public String toString() {
        return "Recap{" +
                "gameid='" + gameid + '\'' +
                ", header='" + header + '\'' +
                ", content='" + content + '\'' +
                ", updtime='" + updtime + '\'' +
                ", capture='" + capture + '\'' +
                '}';
    }
    
    public String getGameid() {
        return gameid;
    }
    
    public void setGameid(String gameid) {
        this.gameid = gameid;
    }
    
    public String getHeader() {
        return header;
    }
    
    public void setHeader(String header) {
        this.header = header;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getUpdtime() {
        return updtime;
    }
    
    public void setUpdtime(String updtime) {
        this.updtime = updtime;
    }
    
    public String getCapture() {
        return capture;
    }
    
    public void setCapture(String capture) {
        this.capture = capture;
    }
    
}