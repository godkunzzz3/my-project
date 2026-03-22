package org.example.tliaswebmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.tliaswebmanagement.mapper.ClazzMapper;
import org.example.tliaswebmanagement.pojo.Clazz;
import org.example.tliaswebmanagement.pojo.ClazzQueryParam;
import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
@Autowired

private ClazzMapper clazzMapper;

@Override

    public PageResult page(ClazzQueryParam param) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(param.getPage(), param.getPageSize());
        //2. 执行查询
        List<Clazz> clazzList = clazzMapper.list(param);
        //3. 封装分页结果
        PageInfo<Clazz> pageInfo = new PageInfo<>(clazzList);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }


    @Override
    public void DeleteById(Integer id) {
        clazzMapper.DeleteById(id);
    }
   @Override
    public  void update(Clazz clazz) {
       clazzMapper.update(clazz);
       clazz.setCreateTime(LocalDateTime.now());
       clazz.setUpdateTime(LocalDateTime.now());

    }
@Override
    public  void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
    clazzMapper.save(clazz);
    }
    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.getById(id);
    }
    public List<Clazz> findAll() {

        return clazzMapper.findAll();
    }

}
