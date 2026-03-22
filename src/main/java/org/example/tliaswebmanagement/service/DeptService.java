package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门
     */
    public List<Dept> findAll();

    void deleteById(Integer id);

    void save(Dept dept);

    void update(Dept dept);

    Dept getById(Integer id);
}