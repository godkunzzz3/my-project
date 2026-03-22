package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.*;

import java.util.List;

public interface StudentService {



    PageResult page(StudentQueryParam param);

    void DeleteId(List<Integer> ids);

    void save(Student student);

    Student GetById(Integer id);

    void Update(Student student);

    void BreakR(Integer id, Integer score);



}
