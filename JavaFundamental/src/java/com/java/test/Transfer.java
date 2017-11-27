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
 * 二、数据类型转换
 当使用 +、-、*、/、%、运算操作是，遵循如下规则：
 只要两个操作数中有一个是double类型的，另一个将会被转换成double类型，
 并且结果也是double类型，如果两个操作数中有一个是float类型的，
 另一个将会被转换为float类型，并且结果也是float类型，如果两个操作数
 中有一个是long类型的，另一个将会被转换成long类型，并且结果也是long类型，
 否则（操作数为：byte、short、int 、char），两个数都会被转换成int类型，并且结果也是int类型。
 语句 1  :（b1 + b2） 被转换为int类型 但是 b3仍为 byte ，所以出错
 要么将b3转化为int 要么将（b1 + b2） 强制转换为byte类型。所以语句1错误。
 语句 2：b4 、b5被声明final 所以类型是不会转换， 计算结果任然是byte  ，所以 语句2正确。
 语句 3：(b1 + b4)  结果仍然转换成int  所以语句 3 错误。
 语句 4 : (b2 + b5)  结果仍然转换为int ， 所以语句4错误。
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
        byte b1=1,b2=2,b3,b6,b8;
        final byte b4=4,b5=6,b7;
        b3=(byte)(b1+b2);  /*语句1，编译错误，编译不通过的语句！直接显示*/
        b6=b4+b5;    /*语句2*/
        b8=(byte)(b1+b4);  /*语句3*/
        b7=(byte)(b2+b5);  /*语句4*/
        System.out.println(b3+b6);
    }
}
