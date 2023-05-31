package com.example.test.testyangte.common;

import lombok.extern.slf4j.Slf4j;

import javax.xml.crypto.Data;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class Utils {

//日期转字符串用format         字符串转日期用parse
private  static MessageDigest messageDigest=null;
private  static final SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
private  static  final  SimpleDateFormat format2=new SimpleDateFormat("yyyy/MM/dd");
private  static final   SimpleDateFormat format3=new SimpleDateFormat("yyyyMMdd");

//放在静态代码块的目的是初始化MessageDigest     初始化以后才能使用
static{
    try {
        messageDigest=MessageDigest.getInstance("sha-256");
        log.debug("初始化Message成功");
    } catch (NoSuchAlgorithmException e) {
        log.error(e.getMessage());
    }
}
/*
* 将日期对象转换为字符串类型
* */
public static   String formatDate(Data data){
    String str="";
          if(data!=null){
           str= format1.format(data);
          }
          return str;
}

/*
* 将字符串转换为日期类型
* */
    public static Date  parseString(String str){
        Date date=null;
         if(str!=null&&str.length()>0){
             int index = str.indexOf("-");
             //符合format1格式
             if(index>0){
                 try {
               date=format1.parse(str);
                 } catch (ParseException e) {
                     e.printStackTrace();
                 }
             }else{
                 index=str.indexOf("/");
                 if(index>0){
                     try {
                     date= format2.parse(str);
                     } catch (ParseException e) {
                         e.printStackTrace();
                     }
                 }
             }
         }
         return date;
    }

    /*注册可用此方法将密码转换并存进数据库，登陆可将密码用此方法转换并且对比是否相等。
    * 计算密码摘要  并且转化为base64编码
    * */
    public static String MessageDigestPassWord(String text){
        String result = null;
            if(text!=null){
                byte[] bytes = text.getBytes();
                for (int i = 0; i < 5; i++) {
                    bytes = messageDigest.digest(bytes);
                    //将字节数组转换为Base64编码的字符串
                  result= Base64.getEncoder().encodeToString(bytes);
                }
            }
            return result;
    }



    /*
    * 将数组元素翻转方法1
    * */
    public static StringBuffer ReverseArray(int[]array){
        StringBuffer buffer=new StringBuffer();
        for(int a=0;a<array.length;a++){
            buffer.append(array[a]);
        }
        buffer.reverse();
        return buffer;
    }

    /*
    * 将数组元素翻转方法2
    * */

    public static  int[] ReverseArray2(int[]array){
        int length=array.length;
                int [] result=new int[length];
        for(int a=0;a<array.length;a++){
            result[a]=array[length-1];
            length--;
        }
        return result;


    }
    public static void main(String[] args) {

        int []a={1,2,3,4,5};
        int[] ints = Utils.ReverseArray2(a);
        String str="";
        for(int b:ints){
            str+=b;
        }
        System.out.println(str);



    }

    }



