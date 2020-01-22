package com.alex.controller;

import com.alex.AppConst;
import com.alex.api.AdminService;
import com.alex.api.constant.AppConstant;
import com.alex.bean.TAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    AdminService adminService;

    @PostMapping("/doLogin")
    public String login(String username , String password , Model model , HttpSession session){
        logger.info("{}用户正在使用{}密码进行登录操作.",username,password);
        TAdmin admin = adminService.login(username, password);
        if (admin != null){
            //保存用户状态
            session.setAttribute(AppConstant.LOGIN_USER_INFO,admin);
            return "redirect:/main.html";
        }else{
            //回显用户名
            model.addAttribute(AppConstant.LOGIN_USER_NAME,username);
            //错误提示
            model.addAttribute("errorMsg","用户名或密码错误！");
            return "forward:/login.jsp";
        }

    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        TAdmin user = (TAdmin)session.getAttribute(AppConstant.LOGIN_USER_INFO);
        if (user == null){
            model.addAttribute("errorMsg","您还没有登录！请先登陆！");
            return "forward:/login.jsp";
        }else{
            return "main";
        }

    }

}
