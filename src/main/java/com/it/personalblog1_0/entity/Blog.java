package com.it.personalblog1_0.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lls
 * @version 1.0
 * @date 2020/6/4 17:02
 */
@Data
public class Blog implements Serializable {
    private static final long serialVersionUID = 40841276993484440L;
    private String id;
    private String title;
    private String content;
}
