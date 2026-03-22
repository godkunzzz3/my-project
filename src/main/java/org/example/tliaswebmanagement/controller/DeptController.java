package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.Dept;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理控制器
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    private static final Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    /**
     * 查询部门列表
     */
    @GetMapping
    public Result list(){
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
    @DeleteMapping
    public Result delete(Integer id){
//        System.out.println("根据ID删除部门: " + id);//
       log.info("根据ID删除部门,id:{ } " + id);
        deptService.deleteById(id);
        return Result.success();
    }
   @PostMapping
   public  Result save(@RequestBody Dept dept){
        /* System.out.println("新增部门，dept="+dept);*/
       log.info("新增部门, dept: {}" , dept);
         deptService.save(dept);
         return  Result.success();

 }
 @PutMapping
 public  Result update(@RequestBody Dept dept){
//        System.out.println("修改部门，dept="+dept);
     log.info("修改部门, dept: {}" , dept);
        deptService.update(dept);
        return  Result.success();


 }
 @GetMapping("/{id}")
 public  Result getById( @PathVariable Integer id){
//     System.out.println("根据id查询，id"+ id);
     log.info("根据ID查询, id: {}" , id);
     Dept dept= deptService.getById(id);
     return Result.success(dept);

 }


 }

