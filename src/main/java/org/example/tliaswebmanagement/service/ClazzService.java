package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.Clazz;
import org.example.tliaswebmanagement.pojo.ClazzQueryParam;
import org.example.tliaswebmanagement.pojo.PageResult;

import java.util.List;

public interface ClazzService {


     PageResult page(ClazzQueryParam param) ;

    void DeleteById(Integer id);

    void update(Clazz clazz);

    void save(Clazz clazz);

    Clazz getById(Integer id);

    List<Clazz> findAll();
}
