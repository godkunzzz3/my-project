package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.ClazzCountVO;
import org.example.tliaswebmanagement.pojo.DegreeCount;
import org.example.tliaswebmanagement.pojo.JobOption;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 统计各个职位的员工人数
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计各个职位的员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }
    /**
     * 统计员工性别信息
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别信息");
        List<Map> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }
    @GetMapping("/studentDegreeData")
    public Result getStuDegreeData(){
        log.info("统计学员学历：");
        List<DegreeCount> data = reportService.getStuDegreeData();
        return Result.success(data);
    }
    /**
     * 统计员工性别信息
     */
    @GetMapping("/studentCountData")
    public Result getStuCountData(){
        log.info("统计班级人数信息");
        ClazzCountVO data = reportService.getStuCountData();
        return Result.success(data);
    }

}
