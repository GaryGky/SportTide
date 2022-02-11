package com.hupu.dao;

import com.hupu.pojo.Admin;
import com.hupu.service.Impl.AdminServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminTest {
    
    @Test
    public void addRoot() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        AdminServiceImpl adminService = (AdminServiceImpl) context.getBean(
                "adminServiceImpl");
        System.out.println("====== Test Add Admin ====== ");
        System.out.println(adminService);
    }
    
    @Test
    public void testInsert() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        AdminServiceImpl adminService = (AdminServiceImpl) context.getBean(
                "adminServiceImpl");
        System.out.println("====== Test Add Admin ====== ");
        adminService.createAdmin("root", "root");
    }
    
    @Test
    public void testQuery() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        AdminServiceImpl adminService = (AdminServiceImpl) context.getBean(
                "adminServiceImpl");
        System.out.println("====== Test Query BY ID ====== ");
        System.out.println(adminService.queryAdminById(1));
        System.out.println(adminService.queryAdminById(3));
        System.out.println(adminService.queryAdminById(3));
        
        System.out.println("====== Test Query ALL Admin======");
        for (Admin admin : adminService.queryAllAdmins()) {
            System.out.println(admin);
        }
        
        System.out.println("===== Test Query Pwd=======");
        System.out.println(adminService.queryAdminPwdById(1));
        System.out.println(adminService.queryAdminPwdById(2));
        System.out.println(adminService.queryAdminPwdById(3));
        
        System.out.println("===== Test Update Pwd=======");
        System.out.println(adminService.updateAdminPwd(1, "admin1", "1admin"));
        System.out.println(adminService.updateAdminPwd(1, "admin1", "1admin"));
        System.out.println(adminService.updateAdminPwd(2, "admin2", "2admin"));
        
        System.out.println("===== Test Update Name ===== ");
        System.out.println(adminService.updateAdminName(1, "ad1"));
        System.out.println(adminService.updateAdminName(2, "ad2"));
        System.out.println(adminService.updateAdminName(3, "ad3"));
    }
    
    @Test
    public void testDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        AdminServiceImpl adminService = (AdminServiceImpl) context.getBean(
                "adminServiceImpl");
        System.out.println("====== Test Delete Admin ====== ");
        System.out.println(adminService.deleteAdminById(8));
        System.out.println(adminService.deleteAdminById(16));
        System.out.println(adminService.deleteAdminById(15));
        System.out.println(adminService.deleteAdminById(14));
        System.out.println(adminService.deleteAdminById(13));
        System.out.println(adminService.deleteAdminById(7));
    }
    
    @Test
    public void tmp() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        AdminServiceImpl adminService = (AdminServiceImpl) context.getBean(
                "adminServiceImpl");
        System.out.println("====== Test Delete Admin ====== ");
        System.out.println(adminService.queryPwdByName("admin1"));
    }
}
