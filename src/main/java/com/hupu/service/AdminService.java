package com.hupu.service;

import com.hupu.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {
    public int createAdmin(String name, String pwd);//
    // 创建一个管理员
    
    public int updateAdminPwd(int id, String oldPwd, String newPwd); // 更新管理员密码
    
    public int updateAdminName(int id, String newName); // 更新管理员名称
    
    public List<Admin> queryAllAdmins(); // 查看所有管理员
    
    public String queryAdminPwdById(int id);
    
    public Admin queryAdminById(int id);
    
    public int deleteAdminById(int id); // 删除一个管理员
    
    public String queryPwdByName(String name);

    public int queryIdByName(String name);
}
