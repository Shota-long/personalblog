package com.it.personalblog1_0.services.impl;

import com.it.personalblog1_0.entity.User;
import com.it.personalblog1_0.mappers.UserMapper;
import com.it.personalblog1_0.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

/**
 * @author lls
 * @version 1.0
 * @date 2020/5/30 23:29
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired(required = false )
    private UserMapper userMapper;

    /**管理员登录验证*/
    @Override
    public User adminLogin(String email, String password) {

        User user = userMapper.verification(email, password);
        return user;

    }
}
