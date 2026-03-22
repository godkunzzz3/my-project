package org.example.tliaswebmanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzCountVO {
    private List<String> clazzList;  // 班级名称列表
    private List<Integer> dataList;   // 对应班级人数列表
}