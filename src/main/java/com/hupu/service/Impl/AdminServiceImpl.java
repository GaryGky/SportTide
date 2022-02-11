package com.hupu.service.Impl;

import com.hupu.dao.AdminMapper;
import com.hupu.pojo.Admin;
import com.hupu.service.AdminService;
import com.hupu.service.ConstantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends ConstantService implements AdminService {
    @Autowired
    @Qualifier("adminMapper")
    private AdminMapper adminMapper;
    
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }
    
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }
    
    public AdminServiceImpl() {
    }
    
    public int createAdmin(String name, String pwd) {
        return adminMapper.createAdmin(name, pwd);
    }
    
    public int updateAdminPwd(int id, String oldPwd, String newPwd) {
        if (oldPwd.equals(queryAdminPwdById(id))) {
            return adminMapper.updateAdminPwd(id, newPwd);
        } else {
            return ErrorCodeForPwd;
        }
    }
    
    public int updateAdminName(int id, String newName) {
        return adminMapper.updateAdminName(id, newName);
    }
    
    public List<Admin> queryAllAdmins() {
        return adminMapper.queryAllAdmins();
    }
    
    public String queryAdminPwdById(int id) {
        return adminMapper.queryAdminPwdById(id);
    }
    
    public Admin queryAdminById(int id) {
        return adminMapper.queryAdminById(id);
    }
    
    public int deleteAdminById(int id) {
        return adminMapper.deleteAdminById(id);
    }
    
    @Override
    public String queryPwdByName(String name) {
        return adminMapper.queryPwdByName(name);
    }

    @Override
    public int queryIdByName(String name) {
        return adminMapper.queryIdByName(name);
    }
}
