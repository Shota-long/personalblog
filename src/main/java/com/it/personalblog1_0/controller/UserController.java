package com.it.personalblog1_0.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.it.personalblog1_0.entity.User;
import com.it.personalblog1_0.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lls
 * @version 1.0
 * @date 2020/5/22 15:54
 */
/**
 *  如果只是使用@RestController注解，则Controller中的方法无法返回jsp页面，或者html，配置的视图解析器 InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 * */
@EnableAspectJAutoProxy
@Controller
public class UserController {

    @GetMapping("/")
    public String toHomePage(){
        return "index";
    }

    /*@Autowired(required = false)
    UserMapper userMapper;

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userMapper.getUsers();
    }
    @GetMapping("/addUser")
    public User addUser(User user){
        userMapper.addUser(user);
        return user;
    }

    @RequestMapping("/getPassWord/{username}")
    public String getPassWord1(@PathVariable("username") String username){
        return userMapper.getPassWord1(username).getPassword();
    }*/

    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/getUserList")
    public void test(){
        /*
        * PageHelper.startPage(pageNum,pageSize,boolean);
        * -boolean : 为true时表示需要统计总数count(0).
        * */
        PageHelper.startPage(2,2,false);
        Page<User> userList = userMapper.getUserList();
        for (User user : userList
             ) {
            System.out.println(user);
        }
    }
}
