package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.Clazz;
import org.example.tliaswebmanagement.pojo.ClazzQueryParam;
import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    // 班级分页查询
    @GetMapping
    public Result page(ClazzQueryParam param) {
        log.info("班级列表数据如下:{}", param);
        PageResult pageResult = clazzService.page(param);
        return Result.success(pageResult);
    }

    // 🔥 修复1：删除重复 /clazzs → 正确路径 /clazzs/{id}
    @DeleteMapping("/{id}")
    public Result Delete(@PathVariable Integer id) { // 🔥 漏了@PathVariable，补上！
        log.info("根据id删除班级,id{}", id);
        clazzService.DeleteById(id);
        return Result.success();
    }

    // 修改班级
    @PutMapping
    public Result Update(@RequestBody Clazz clazz) {
        log.info("修改班级信息，{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    // 添加班级
    @PostMapping
    public Result Add(@RequestBody Clazz clazz) {
        log.info("添加班级信息{}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    // 根据ID查询班级
    @GetMapping("/{id}")
    public Result GetById(@PathVariable Integer id) {
        log.info("根据id查询班级{}", id);
        Clazz clazz = clazzService.getById(id);
        if (clazz == null) {
            return Result.error("班级不存在");
        }
        return Result.success(clazz); // 🔥 修复：返回查到的班级数据
    }

    // 🔥 修复2：删除重复 /clazzs → 正确路径 /clazzs/list
    @GetMapping("/list")
    public Result GetAllId() {
        log.info("查询所有班级信息");
        List<Clazz> clazzList = clazzService.findAll();
        return Result.success(clazzList);
    }
}