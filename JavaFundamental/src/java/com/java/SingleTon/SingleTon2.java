package com.java.SingleTon;

/**饱汉模式2，获取实例对象的为同步方法，每一次只能有一个线程获取实例，线程安全，低效！
 * Created by 18362 on 2017/11/19.
 */
public class SingleTon2 {
    private static SingleTon2 singleTon2;
    private SingleTon2()
    {}
    public static synchronized SingleTon2 getsingleTon2()
    {
        if(singleTon2==null)
            singleTon2=new SingleTon2();
        return singleTon2;
    }
}
