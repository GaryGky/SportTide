package com.hupu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class Admin implements Serializable {
    private int admin_id;
    private String admin_name;
    private String admin_pwd;
    
    public Admin(int id, String name, String pwd) {
        this.admin_id = id;
        this.admin_name = name;
        this.admin_pwd = pwd;
    }
    
    public Admin() {
    }
    
    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_name='" + admin_name + '\'' +
                ", admin_pwd='" + admin_pwd + '\'' +
                '}';
    }
    
    public int getAdmin_id() {
        return admin_id;
    }
    
    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }
    
    public String getAdmin_name() {
        return admin_name;
    }
    
    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }
    
    public String getAdmin_pwd() {
        return admin_pwd;
    }
    
    public void setAdmin_pwd(String admin_pwd) {
        this.admin_pwd = admin_pwd;
    }
}
