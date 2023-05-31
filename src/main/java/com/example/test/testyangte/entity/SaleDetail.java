package com.example.test.testyangte.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDetail {
    private  Integer saleNo;
    private  Integer goodsNo;//编号
    private    Integer number;//数量
    private  Double subTotal;//小计
   private  Good good;
}
