package com.java.SingleTon;

/**饿汉模式，一开始类中就定义,非常的安全，有可能造成资源浪费
 * Created by 18362 on 2017/11/19.
 */
public class SingleTon05 {
    private static SingleTon05 singleTon05=new SingleTon05();
    private SingleTon05()
    {

    }
    public static SingleTon05 getSingleTon05()
    {
        return singleTon05;
    }
}
