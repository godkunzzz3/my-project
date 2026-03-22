package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.*;
import org.example.tliaswebmanagement.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询所有部门
     */
    @Select("select * from dept")
    public List<Dept> findAll();

    @Delete("delete from dept where id = #{id}")
     void deleteById(int id);
   @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime}) ")
    void insert(Dept dept);
    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
   @Select("select id, name, create_time, update_time from dept where id = #{id} ")
    Dept getById(Integer id);
}