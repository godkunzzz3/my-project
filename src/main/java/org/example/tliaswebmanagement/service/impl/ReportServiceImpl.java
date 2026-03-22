package org.example.tliaswebmanagement.service.impl;

import org.example.tliaswebmanagement.mapper.EmpMapper;
import org.example.tliaswebmanagement.mapper.StudentMapper;
import org.example.tliaswebmanagement.pojo.ClazzCountVO;
import org.example.tliaswebmanagement.pojo.DegreeCount;
import org.example.tliaswebmanagement.pojo.JobOption;
import org.example.tliaswebmanagement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service

public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
     private StudentMapper studentMapper;
    @Override
    public JobOption getEmpJobData()
    {

        List<Map<String,Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }
    @Override
    public List<Map> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public ClazzCountVO getStuCountData() {
        // 1. 查询数据库：班级名称 + 对应人数
        List<Map<String, Object>> list = studentMapper.selectClazzCount();

        // 2. 拆分出 clazzList 和 dataList
        List<String> clazzList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();
        for (Map<String, Object> map : list) {
            clazzList.add((String) map.get("name"));
            dataList.add(((Long) map.get("value")).intValue());
        }

        // 3. 封装返回
        return new ClazzCountVO(clazzList, dataList);
    }


    @Override
    public  List<DegreeCount> getStuDegreeData(){

        return  studentMapper.selectDegreeStat();


    }
}
