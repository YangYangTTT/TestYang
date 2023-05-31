package com.example.test.testyangte.entity;
//用来接收参数的类  (存当前页，每页记录条数，搜索信息)


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParam {
    private String searchKey;
    private Integer pageSize=5, currentPage=1;
}
