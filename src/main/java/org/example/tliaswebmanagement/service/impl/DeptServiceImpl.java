package org.example.tliaswebmanagement.service.impl;

import org.example.tliaswebmanagement.mapper.DeptMapper;
import org.example.tliaswebmanagement.pojo.Dept;
import org.example.tliaswebmanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public List<Dept> findAll() {

        return deptMapper.findAll();
    }


    public void deleteById(Integer id) {

        deptMapper.deleteById(id);
    }

    public void save(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);


    }
    public  void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);


    }
    public Dept getById(Integer id) {
         return  deptMapper.getById(id);


    }

}