package com.it.personalblog1_0.services.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.it.personalblog1_0.entity.Type;
import com.it.personalblog1_0.mappers.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lls
 * @version 1.0
 * @date 2020/6/6 17:51
 */
@Service
public class TypeServiceImpl {

    @Autowired
    private TypeMapper typeMapper;

    public Page<Type> getTypeList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize,true);
        return typeMapper.getTypeList();
    }

    public boolean addType(Type type){
        int num = typeMapper.addType(type);
        if (num != 0)
            return true;
        else
            return false;
    }
}
