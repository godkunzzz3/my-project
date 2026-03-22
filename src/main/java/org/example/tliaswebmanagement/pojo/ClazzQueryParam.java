package org.example.tliaswebmanagement.pojo;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ClazzQueryParam{
private String name;        // 班级名称（模糊查询）
private LocalDate begin;    // 范围匹配的开始时间
private LocalDate end;      // 范围匹配的结束时间
private Integer page = 1;   // 页码，默认1
private Integer pageSize = 10; // 每页条数，默认10{
}
