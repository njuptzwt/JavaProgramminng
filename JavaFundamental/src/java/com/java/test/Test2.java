package com.java.test;

/**
 * Created by 18362 on 2017/11/26.
 */
public class Test2 {
    static int i;//静态成员变量初始值为0
    public static void add(Byte b)
    {
        b = b++;
    }
    public static void test()
    {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
    public static void main(String args[])
    {
        System.out.println(i);//局部变量没有初始化，不能使用。
//        Integer test;
//        System.out.println(test);
        test();
    }
}
