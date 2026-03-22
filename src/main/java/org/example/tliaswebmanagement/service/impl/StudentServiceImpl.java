package org.example.tliaswebmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.example.tliaswebmanagement.mapper.StudentMapper;
import org.example.tliaswebmanagement.pojo.*;
import org.example.tliaswebmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentMapper studentMapper;

    @Override

    public PageResult page(StudentQueryParam param) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(param.getPage(), param.getPageSize());
        //2. 执行查询
        List<Student> studentList = studentMapper.list(param);
        //3. 封装分页结果
        PageInfo<Student> pageInfo = new PageInfo<>(studentList);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }


    @Transactional(rollbackFor = {Exception.class})
    @Override
  public  void DeleteId(List<Integer> ids)
    {
        studentMapper.delete(ids);


    }


    @Override
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
      studentMapper.save(student);

    }


    @Override
    public Student GetById(Integer id) {
       return  studentMapper.getById(id);


    }

@Override
    public void  Update(Student student){
        student.setUpdateTime(LocalDateTime.now());
        student.setCreateTime(LocalDateTime.now());


        student.update(student);



    }
    @Override
    public  void BreakR(Integer id, Integer score){
        if (score == null || score <= 0) {
            score = 1;
        }
        studentMapper.violation(id, score);
        // 如果前端传null或0，默认扣1分


    }


}
