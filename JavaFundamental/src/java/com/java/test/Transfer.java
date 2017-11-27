package com.java.test;

/**java的类型转换规则
 * byte,short，char类型自动向上提升，变成int类型计算
 * 类型转换规则：两个不同时，应该精度小往精度大的方向变化最终保留精度大的
 * 为了保证转换的精度，向上转换
 * byte类型的数据-128-127
 * 有符号数据-0代表-128！！规定int -2^31-2^31-1;范围，补码形式存储数据
 * java表达式转型规则由低到高转换：
 1、所有的byte,short,char型的值将被提升为int型；
 2、如果有一个操作数是long型，计算结果是long型；
 3、如果有一个操作数是float型，计算结果是float型；
 4、如果有一个操作数是double型，计算结果是double型；
 5、被fianl修饰的变量不会自动改变类型，当2个final修饰相操作时，结果会根据左边变量的类型而转化。
 * Created by 18362 on 2017/11/27.
 */
public class Transfer {
    public static void main(String args[])
    {
        byte a=10;
       // byte a1;
        char b='3';
        short c=4;
        int d=b+c;
        int e=a+b;
        float f=10.9f;
        double g=f+a;
    }
}
