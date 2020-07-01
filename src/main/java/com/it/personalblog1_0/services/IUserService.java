package com.it.personalblog1_0.services;

import com.it.personalblog1_0.entity.User;

/**
 * @author lls
 * @version 1.0
 * @date 2020/5/30 22:39
 */
public interface IUserService {

    User adminLogin(String email, String password);
}
