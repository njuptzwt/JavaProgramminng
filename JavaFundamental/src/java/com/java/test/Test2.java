package com.java.test;

/**
 * Created by 18362 on 2017/11/26.
 */
public class Test2 {
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
        test();
    }
}
