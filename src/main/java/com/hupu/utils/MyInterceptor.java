package com.hupu.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor, WebMvcConfigurer {
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("**")
                .excludePathPatterns("/Hupu-Admin/static/**");
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object arg2, Exception arg3)
            throws Exception {
    }
    
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        
    }
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1,
                             Object arg2) throws Exception {
        //System.out.println("=====执行前======");
        //System.out.println(requestURI);
        String requestURL = request.getRequestURI();
        if (requestURL.indexOf("to") > 0) {
            //说明处在编辑的页面
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("admin");
            if (username != null) {
                //登陆成功的用户
                return true;
            } else {
                //没有登陆，转向登陆界面
                request.getRequestDispatcher("/index.jsp").forward(request,
                        arg1);
                return false;
            }
        } else {
            return true;
        }
    }
    
}