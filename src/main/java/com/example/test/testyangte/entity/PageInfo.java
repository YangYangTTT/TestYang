package com.example.test.testyangte.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//用来存放查询到当前页信息的类     有记录总条数  以及人员信息
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo<T> {
    private Long total;
    private List<Goods> list;
}
