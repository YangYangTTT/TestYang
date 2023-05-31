package com.example.test.testyangte.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.test.testyangte.entity.Goods;
import com.example.test.testyangte.service.TestService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;


import java.io.IOException;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
public class TestControllerTest {
@Autowired
private TestService testService;
    @Autowired
    private  TestController testController;

   @Test
   @Scheduled
    public void list(){

       String url="http://localhost:8080/list";
       CloseableHttpClient httpClient= HttpClients.createDefault();

       try {
           CloseableHttpResponse response=httpClient.execute(new HttpGet(url));
           String pageInfo=EntityUtils.toString(response.getEntity());
           //将pageinfo里面的数据转换为json对象格式
           JSONObject datas=JSONObject.parseObject(pageInfo);
           int code = (int) datas.get("code");
           if(code==0){
               //将json对象数据中的data先转成字符串   再转成json对象使用
               JSONObject data=JSONObject.parseObject(datas.get("data").toString());
               JSONArray list=JSONObject.parseArray(data.get("list").toString());
               List<Goods> goodsList = JSONArray.parseArray(list.toJSONString(), Goods.class);
               System.out.println(goodsList);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }


       TimerTask timerTask = new TimerTask() {
           @Override
           public void run() {

           }
       };
   }


   @Test
    public void Executor(){
       ExecutorService executorService = Executors.newCachedThreadPool();
       executorService.execute(new Runnable() {
           @Override
           public void run() {

           }
       });
   }


   /* @Test
    List<Object> select() {
        List<Object> select = this.testService.select();
        System.out.println(select);
        return  select;
    }*/
}