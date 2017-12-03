package com.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 18362 on 2017/11/26.
 */
public class Demo {
    public static int j=0;
    class inner
    {

    }
    public Demo()
    {

    }
    public Demo(int a)
    {
        this();
    }
    public Demo(int a,int b)
    {
        this(a);
    }
    float func1()
    {
        short i=1;
        return i;//因为不是返回的对象！无所谓！
    }
    float func2()
    {
        int i=1;
        List<Integer> list=new ArrayList<Integer>();
        return i;
    }
    float func3()
    {
//        double i=4;
//        return i;
        return 1;
    }
    public static void main(String args[])
    {
        Integer.valueOf("1024").intValue();
        Scanner sc=new Scanner(System.in);
        System.out.println(j);
        System.out.println(100%3.0);
    }
}

