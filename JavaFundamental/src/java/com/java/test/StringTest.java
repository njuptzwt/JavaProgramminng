package com.java.test;

/**
 * Created by 18362 on 2017/12/9.
 */
public class StringTest {
    public static void main(String args[])
    {
//       String a="a1";
//       String b="a"+1;
//       System.out.println(a==b);true

//       String a="ab";
//       String bb="b";
//       String b="a"+bb;//编译器无法确定变量是否为常量
//       System.out.println(a==b);//false
        String test=new String("124");
        String a="ab";
        final String bb="b";
        String b="a"+bb;//可以确定bb为常量
        System.out.println(a==b);//true
    }
}
