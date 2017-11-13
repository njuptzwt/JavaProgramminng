package com.java.test;

/**try-catch的一些基本用法
 * finally语句块一定会执行，如果finally语句块中有return语句，那么会覆盖其他的try中的return语句
 * try中的return语句执行时候，先把要返回的局部变量压栈，再去执行finally语句块，再把局部变量出栈返回
 * Created by 18362 on 2017/11/10.
 */
public class TryCatch {
    public static int test()
    {
        int a=1;
        try {
            System.exit(0);
            return  a;
        }
        finally {
            a++;
            return a;
        }
    }
    public static void main(String args[])
    {
        System.out.println(test());
    }
}
