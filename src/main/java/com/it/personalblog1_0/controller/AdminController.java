package com.it.personalblog1_0.controller;

import com.it.personalblog1_0.entity.User;
import com.it.personalblog1_0.services.IUserService;
import com.it.personalblog1_0.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author lls
 * @version 1.0
 * @date 2020/5/30 15:18
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    @Qualifier(value = "userServiceImpl")
    IUserService userService;

    @GetMapping
    public String toLoginPage(){
        return "admin/login";
    }

    @RequestMapping("/toLogin")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session){
        //System.out.println("登录验证：[email="+email+",password="+password+"]");
        User user = userService.adminLogin(email, MD5Util.code(password));
        if (user != null){
            session.setAttribute("user",user.getUsername());
            return "redirect:/admin/toAdminMainPage";
        }
        else{
            System.out.println("用户密码错误");
            return "redirect:/admin";
        }
    }

    @RequestMapping("/toLogout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        System.out.println("注销后的user="+session.getAttribute("user"));
        return "redirect:/admin";
    }

    @RequestMapping("/toPublishBlog")
    public String toPublishBlogPage(){
        return "admin/publishBlog";
    }
    @RequestMapping("/toAdminMainPage")
    public String toAdminMainPage(){
        return "admin/adminMain";
    }
}
