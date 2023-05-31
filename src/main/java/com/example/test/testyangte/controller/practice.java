package com.example.test.testyangte.controller;


import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        System.out.println("请输入数量：");
        Scanner scanner = new Scanner(System.in);
        int  next = scanner.nextInt();
        int drink = drink(next);
        System.out.println(drink);
    }
    //二分查找
    public static int drink(int a){
        int b=a/2;
        int add=0;
        if(b!=1){
            add=a+b;
            int drink = drink(b);
             add+=drink;
        }
        add=add+1;
        return add;
    }
}
