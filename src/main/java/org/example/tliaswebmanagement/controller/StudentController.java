package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.*;
import org.example.tliaswebmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public Result page(StudentQueryParam param) {
        log.info("学员信息如下:{}", param);
        PageResult pageResult = studentService.page(param);
        return Result.success(pageResult);

    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {

        log.info("删除学员信息：{}", ids);
        studentService.DeleteId(ids);
        return Result.success();

    }

    @PostMapping()
    public Result insert(@RequestBody Student student) {
        log.info("新增学员信息：{}", student);


        studentService.save(student);

        return Result.success();
    }

    @GetMapping("{id}")
    public Result GetById(@PathVariable Integer id) {

        log.info("根据id查询学员{}", id);
        Student student = studentService.GetById(id);
        return Result.success(student);


    }

    public Result update(@RequestBody Student student) {

        log.info("修改学员信息{}", student);
        studentService.Update(student);

        return Result.success();


    }

    @PutMapping("/violation/{id}/{score}")
    public Result BreakR(@PathVariable Integer id, @PathVariable Integer score) {
        log.info("违纪成员{}和分数{}", id, score);

        studentService.BreakR(id, score);


        return Result.success();

    }





}