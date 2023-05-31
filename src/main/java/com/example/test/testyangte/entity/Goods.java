package com.example.test.testyangte.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private Integer goodsid;
    private String goodsname;
    private  Double price;
    private  Integer status;
    private  Integer stock;
    private Date createtime;
    private  Date updatetime;
    private  Integer spike;
}
