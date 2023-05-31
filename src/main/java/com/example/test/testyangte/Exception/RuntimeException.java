package com.example.test.testyangte.Exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@ControllerAdvice
public class RuntimeException {

    //运行错误记录日志
    @ExceptionHandler(java.lang.RuntimeException.class)
    public String Error(){
        log.error("服务器异常");
        //返回逻辑视图名
        return "error";
    }


  //运行错误返回json数据
    @ExceptionHandler(java.lang.RuntimeException.class)
    @ResponseBody
    public Map<String,String> ReturnJson(java.lang.RuntimeException e){
     log.error("运行异常，记录日志");
        Map<String,String> map=new HashMap<>();
        map.put("status","500");
        map.put("message",e.getMessage());
        return  map;

    }

}
