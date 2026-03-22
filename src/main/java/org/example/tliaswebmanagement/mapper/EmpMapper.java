package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.*;
import org.example.tliaswebmanagement.pojo.Emp;
import org.example.tliaswebmanagement.pojo.EmpQueryParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {



    List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 新增员工数据
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);
    /**
     * 批量删除员工信息
     */
    void deleteByIds(List<Integer> ids);
    /**
     * 根据ID查询员工详细信息
     */
    Emp getById(Integer id);

    /**
     * 更新员工基本信息
     */
    void updateById(Emp emp);
    /**
     * 统计各个职位的员工人数
     */
    @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();
    @MapKey("name")
    List<Map> countEmpGenderData();

    @Select("select * from emp where job=1")
    List<Emp> allEmpList();
}