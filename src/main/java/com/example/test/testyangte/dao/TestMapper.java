package com.example.test.testyangte.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.testyangte.entity.*;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface TestMapper extends BaseMapper<Goods> {
    List<Goods> Findbykey(@Param("searchKey") String searchKey, @Param("start") int start,@Param("end") int end);
    List<Goods> loadList(@Param("start") int start,@Param("end")int end);
    int input( SaleDetail saleDetail);
    int delete(Integer id);
    Integer deleteInBatch(Integer[] ids);
    int update(Goods goods);

@MapKey("goodsid")
    Map<String,Object> select();
}
