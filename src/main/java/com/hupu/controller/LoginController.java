package com.hupu.controller;

import com.alibaba.fastjson.JSON;
import com.hupu.pojo.Admin;
import com.hupu.pojo.User;
import com.hupu.service.Impl.AdminServiceImpl;
import com.hupu.service.Impl.UserServiceImpl;
import com.hupu.utils.DateUtils;
import com.hupu.utils.UserIdGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminServiceImpl adminService;
    
    @Autowired
    @Qualifier("userService")
    private UserServiceImpl userService;
    
    @RequestMapping("/adminLogin")
    public int varifyLogIn(String name, String password,
                           HttpSession session, HttpServletRequest request) {
        if (name == null || password == null) {
            return -1;
        } // 如果输入字段为空，直接fail
        try {
            if (adminService.queryPwdByName(name).equals(password)) {
                session.setAttribute("admin", name); //
                // 成功登录，把信息加入session
                Admin admin = adminService.queryAdminById(17);
                request.getSession().setAttribute(String.valueOf(admin.getAdmin_id()), admin);
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }
    
    @RequestMapping("/logout")
    public String logOut(HttpSession session) {
        session.removeAttribute("admin");
        return "logOut";
    }
    
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public int register(@RequestBody User user) { // 创建一个用户
        log.info("用户注册信息为：" + JSON.toJSONString(user));
        return userService.insert(user);
    }
    
    @RequestMapping(value = "/register-web", method = {RequestMethod.POST})
    public int register_web(@RequestParam Map map) { // 创建一个用户
        log.info(JSON.toJSONString(map));
        User user = new User((int) UserIdGen.get().nextId(), (String) map.get(
                "name"),
                (String) map.get("email"),
                map.get("password"),
                (String) map.get("nikeName"), DateUtils.getCurTime(), 0, 0);
        return userService.insert(user);
    }
}
