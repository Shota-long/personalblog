package com.it.personalblog1_0.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lls
 * @version 1.0
 * @date 2020/5/25 22:24
 */
@Data
public class Comments implements Serializable {

    private static final long serialVersionUID = -7765102347766618458L;
    private long commentId;
    private String content;

}
