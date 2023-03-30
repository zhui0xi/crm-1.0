package com.chen.crm.settings.web.controller;

import com.chen.crm.settings.domain.User;
import com.chen.crm.settings.service.UserService;
import com.chen.crm.settings.service.impl.UserServiceImpl;
import com.chen.crm.utils.MD5Util;
import com.chen.crm.utils.PrintJson;
import com.chen.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        if ("/settings/user/login.do".equals(path)) {
            login(request, response);
        }
    }

    //登录
    private void login(HttpServletRequest request, HttpServletResponse response) {
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        //给密码加密
        loginPwd = MD5Util.getMD5(loginPwd);
        //获取浏览器的ip地址
        //String ip = request.getRemoteAddr();

        //运用动态代理
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        try {
            //User user = us.login(loginAct, loginPwd, ip);
            User user = us.login(loginAct, loginPwd);

            //登录成功，把user放入session
            //返回 {"success":true}
            request.getSession().setAttribute("user", user);
            PrintJson.printJsonFlag(response, true);
        } catch (Exception e) {
            e.printStackTrace(); //在后台输出错误信息

            //登录失败
            //返回 {"success":false,"msg":msg}
            String msg = e.getMessage(); //错误信息
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", false);
            map.put("msg", msg);
            PrintJson.printJsonObj(response, map);
        }

    }
}
