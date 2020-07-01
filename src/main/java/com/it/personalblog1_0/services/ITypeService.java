package com.it.personalblog1_0.services;

import com.it.personalblog1_0.entity.Type;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author lls
 * @version 1.0
 * @date 2020/6/6 17:51
 */
public interface ITypeService {

    Type saveType(Type type);
    Type getType(Integer id);
    void updateType(Integer id);
    void deleteType(Integer id);
    List<Type> typeList();


}
