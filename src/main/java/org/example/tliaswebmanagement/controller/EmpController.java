package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.Emp;
import org.example.tliaswebmanagement.pojo.EmpQueryParam;
import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

  @Autowired
    private EmpService empService;



  @GetMapping
  public  Result page(EmpQueryParam empQueryParam) {
    log.info("查询请求参数：{}", empQueryParam);
    PageResult pageResult =empService.page(empQueryParam);
    return Result.success(pageResult);


  }
  @PostMapping
public  Result save(@RequestBody Emp emp) {
    log.info("请求参数emp：{}",emp);
    empService.save(emp);
    return Result.success();



}
@DeleteMapping
public  Result delete(@RequestParam List<Integer> ids) {
      log.info("批量删除员工：ids={}", ids);
    empService.DeleteByIds(ids);
      return  Result.success();

}
    @GetMapping("/{id}")
public  Result getInfo(@PathVariable Integer id) {
      log.info("根据id查询员工的详细信息");
      Emp emp =empService.getInfo(id);

      return  Result.success(emp);
}
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息, {}", emp);
        empService.update(emp);
        return Result.success();
    }
    @GetMapping("/list")
    public Result empList(){
      log.info("查询全部员工");
      List<Emp> list = empService.list();
      return Result.success(list);    }
}
