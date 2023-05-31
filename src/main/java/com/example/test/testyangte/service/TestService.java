package com.example.test.testyangte.service;


import com.example.test.testyangte.entity.*;

import java.util.List;
import java.util.Map;

public interface TestService {
    PageInfo<Goods> Findbykey(String searchKey, int start, int end);
    PageInfo<Goods> loadList(int start, int end);

    boolean delete(Integer id);

    Integer deleteInBatch(Integer[] ids);

    boolean input(SaleDetail saleDetail);

    boolean update(Goods goods);

    Map<String,Object> select();




//////----------------------mybatis-plus--------------------------
    PageInfo<Goods> Select(PageParam pageParam);



}
