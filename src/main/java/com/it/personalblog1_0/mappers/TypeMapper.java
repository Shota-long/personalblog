package com.it.personalblog1_0.mappers;

import com.github.pagehelper.Page;
import com.it.personalblog1_0.entity.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lls
 * @version 1.0
 * @date 2020/6/7 17:31
 */
@Mapper
public interface TypeMapper {

    //获取type列表
    @Select("select * from tb_types")
    Page<Type> getTypeList();

    //插入newType
    @Insert("insert into tb_types value(null,#{typeName})")
    int addType(Type type);
}
