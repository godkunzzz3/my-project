package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.tliaswebmanagement.pojo.DegreeCount;
import org.example.tliaswebmanagement.pojo.Student;
import org.example.tliaswebmanagement.pojo.StudentQueryParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Student> list(StudentQueryParam param);

    void delete(@Param("ids") List<Integer> ids);

    void save(Student student);

    Student getById(Integer id);

    void violation(Integer id, Integer score);

    List<DegreeCount> selectDegreeStat();

    List<Map<String, Object>> selectClazzCount();
}
