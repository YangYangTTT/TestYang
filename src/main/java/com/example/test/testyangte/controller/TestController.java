package com.example.test.testyangte.controller;


import com.example.test.testyangte.common.AjaxResp;
import com.example.test.testyangte.entity.*;
import com.example.test.testyangte.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class TestController {

    @Autowired
    private TestService testService;
    ////加载列表(分页查询)    ----》参数为搜索条件以及当前页和每页条数-----》接收数据类里面存储total总数和数据list集合
@GetMapping("/list")
@ResponseBody
    public AjaxResp List(PageParam pageParam){
    int start=(pageParam.getCurrentPage()-1)*pageParam.getPageSize();//从哪条开始
    int end=pageParam.getPageSize();//一共查多少条
    PageInfo<Goods> pageInfo=new PageInfo();
    if(pageParam.getSearchKey()!=null){
        //查询条件不为空   按条件查询
        pageInfo=this.testService.Findbykey(pageParam.getSearchKey(),start,end);
    }else{
        //查询条件为空，查询所有
        pageInfo=this.testService.loadList(start,end);
    }
    System.out.println(pageInfo+"------------------------------------------");
    return AjaxResp.ok(pageInfo);
}
///删除
@GetMapping("/delete")
@ResponseBody
    public AjaxResp delete( Integer id ){
        boolean result= this.testService.delete(id);
    System.out.println(result);
        return AjaxResp.ok(result);
}
//批量删除(可放list,可放array)
@DeleteMapping("/deleteInBatch")
@ResponseBody
    public AjaxResp deleteInBatch(Integer[] ids){
    System.out.println(ids);
    int count = this.testService.deleteInBatch(ids);
    return AjaxResp.ok(count);
    }

//增加
@PostMapping("/input")
@ResponseBody
    public AjaxResp input(@RequestBody SaleDetail saleDetail ){
            boolean result=this.testService.input(saleDetail);
            return  AjaxResp.ok(result);
}
//修改
    @PostMapping("/update")
    @ResponseBody
    public AjaxResp update(@RequestBody Goods goods){
        boolean result= this.testService.update(goods);
        return  AjaxResp.ok(result);
    }




    @GetMapping("/select")
    @ResponseBody
    public List<Object> select(){
        Map<String,Object> select = testService.select();
        Collection<Object> values = select.values();
        ArrayList<Object> objects = new ArrayList<>();
        for(Object a:values){
            objects.add(a);
        }
        System.out.println(objects);
       return objects;
    }
    //----------------------------------------------------------------------mybatis-plus----------------------------------------------------------------------
    //查询

    public PageInfo<Goods> Select(PageParam pageParam){
        PageInfo <Goods>pageInfo2=this.testService.Select(pageParam);
        return  pageInfo2;
    }

}
