package com.example.test.testyangte.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Goods {
    @Column(name="goodsid")
    private Integer goodsid;
    private String goodsname;
    private  Double price;
    private  Integer status;
    private  Integer stock;
    private Date createtime;
    private  Date updatetime;
    private  Integer spike;
}
