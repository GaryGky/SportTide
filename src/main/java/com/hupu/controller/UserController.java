package com.hupu.controller;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.Admin;
import com.hupu.pojo.User;
import com.hupu.service.Impl.AdminServiceImpl;
import com.hupu.service.Impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminServiceImpl adminService;
    
    @Autowired
    @Qualifier("userService")
    private UserServiceImpl userService;
    
    @RequestMapping("/getLimitUser")
    public ArrayList<User> getLimitUser(HttpServletRequest request) {
        System.out.println("获取用户");
        ArrayList<User> users = new ArrayList<>(userService.queryAllByLimit(0
                , 100));
        request.getSession().setAttribute("userMap", users);
        return users;
    }
    
    @RequestMapping("/getAdmin")
    public List<Admin> getAllAdmin(HttpServletRequest request) {
        List<Admin> list = adminService.queryAllAdmins();
        request.getSession().setAttribute("allAdmin", list);
        return list;
    }
    
    @RequestMapping("/addAdmin")
    public int addAdmin(String name, String pwd1) {
        return adminService.createAdmin(name, pwd1);
    }
    
    @RequestMapping("/delUser") // 删除用户
    public String delUser(int id, HttpServletRequest request) {
        String delMsg = "";
        System.out.println("进入删除用户: id ===> " + id);
        int res = userService.deleteById(id);
        delMsg = res == 1 ? "success" : "fail";// 返回一表示成功删除了用户
        ArrayList<User> users = new ArrayList<>(userService.queryAllByLimit(0
                , 100));
        request.getSession().setAttribute("userMap", users); // 重新设置model
        return delMsg;
    }
    
    @RequestMapping(value = "/updateUser", method = {RequestMethod.POST})
    public int updateUser(@RequestBody User user) {
        return userService.update(user);
    }
    
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public int userLogin(@RequestBody Map map) {
        log.info("用户登录传入的map为：" + JSON.toJSON(map));
        if (map == null || userService.getPwdByUserName((String) map.get(
                "user_name")) == null || map.get("user_name") == null) {
            log.info("【用户登录】存在空值！！！");
            return 0;
        }
        log.info("用户的登录密码为 ===> " + userService.getPwdByUserName((String) map.get("user_name")));
        return userService.getPwdByUserName((String) map.get("user_name")).equals(map.get(
                "password")) ? 1 : 0;
    }
    
    @RequestMapping(value = "/getUserByName", method = RequestMethod.GET)
    public User queryUserById(String user_name) {
        return userService.getUserByName(user_name);
    }
}
