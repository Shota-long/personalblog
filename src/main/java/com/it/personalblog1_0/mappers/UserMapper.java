package com.it.personalblog1_0.mappers;

import com.github.pagehelper.Page;
import com.it.personalblog1_0.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lls
 * @version 1.0
 * @date 2020/5/22 15:48
 */
@Mapper
public interface UserMapper {

    @Insert("insert into tb_users(username,password) values(#{username},#{password})")
    int addUser(User user);

    @Select("select * from tb_users where email=#{email} and password=#{password}")
    User verification(String email, String password);

    @Select("select * from tb_users")
    Page<User> getUserList();

}
