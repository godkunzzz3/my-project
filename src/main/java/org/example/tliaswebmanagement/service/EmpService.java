package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.Emp;
import org.example.tliaswebmanagement.pojo.EmpQueryParam;
import org.example.tliaswebmanagement.pojo.LoginInfo;
import org.example.tliaswebmanagement.pojo.PageResult;

import java.util.List;

public interface EmpService {

//     PageResult<Emp> page(Integer page, Integer pageSize , String name, Integer gender, LocalDate begin, LocalDate end);
    PageResult page(EmpQueryParam empQueryParam);
    /**
     * 添加员工
     * @param emp
     */
    void save(Emp emp);

    void DeleteByIds(List<Integer> ids);

    Emp getInfo(Integer id);
    /**
     * 更新员工信息
     * @param emp
     */
    void update(Emp emp);



    List<Emp> list();

    LoginInfo login(Emp emp);
}