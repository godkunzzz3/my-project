package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.tliaswebmanagement.pojo.Clazz;
import org.example.tliaswebmanagement.pojo.ClazzQueryParam;

import java.util.List;
@Mapper
public interface ClazzMapper {
     List<Clazz> list(ClazzQueryParam param);

     void DeleteById(Integer id);

     void update(Clazz clazz);

     void save(Clazz clazz);

    Clazz getById(Integer id);

    @Select("SELECT * FROM clazz")
    List<Clazz> findAll();
}
