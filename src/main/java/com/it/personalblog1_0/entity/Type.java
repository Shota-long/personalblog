package com.it.personalblog1_0.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lls
 * @version 1.0
 * @date 2020/5/25 22:10
 */
@Data
public class Type implements Serializable {

    private static final long serialVersionUID = 8703390941464499116L;
    private Integer typeId;
    private String typeName;

}
