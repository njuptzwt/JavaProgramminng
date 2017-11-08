package com.java.test;

/**
 * Java中的数据类型byte,char,short运算的时候，数据类型自动提升，变成整形int进行计算
 * byte一个字节8位转化为32位，4个字节
 * 计算完毕返回的是int类型，要注意
 * final修饰的变量位常量不需要进行类型的转换
 * Created by 18362 on 2017/11/8.
 */
public class ByteTest {
    public static void main(String args[])
    {
        byte a=1;
        byte b=2;
        final byte c=3;
        final byte d=4;
        byte a1,b1;
        a1=c+d;
        System.out.println(a1);
        //b1=a+b;//有问题，类型转换有问题,byte/char如果没有final修饰，自动转化成int类型计算
        char test='a';
        char test1='b';
        int  test3;
        test3=test1+test;//类型的自动提升带来的影响,自动转化成int计算，这个时候会发生类型的转换异常
        final char test4='a';
        final char test5='b';
        char test6;
        test6=test4+test5;
        System.out.println(test3);
    }
}
