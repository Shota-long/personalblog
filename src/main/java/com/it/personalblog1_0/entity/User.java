package com.it.personalblog1_0.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lls
 * @version 1.0
 * @date 2020/5/22 10:20
 */

@Data
public class User implements Serializable{

    private static final long serialVersionUID = 8745919604834395781L;
    private Integer userId;
    private String username;
    private String password;
    private String email;

}
