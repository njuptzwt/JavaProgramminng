package com.java.SingleTon;

/**饱汉模式4,使用volatile关键值保证操作的原子性，不会出现半实例的情况
 * volatile的内存屏障，可见性，禁止代码重排序
 * Created by 18362 on 2017/11/19.
 */
public class SingleTon4 {
    private static volatile SingleTon4 singleton4;
    private SingleTon4()
    {

    }
    public static SingleTon4 getSingleton4()
    {
        if(singleton4==null)
        {
            //同步代码块，只允许一次实例化话
            synchronized (SingleTon4.class)
            {
                if(singleton4==null)
                    singleton4=new SingleTon4();//禁止代码的重排序，完整实例化对象
            }

        }
        return singleton4;
    }
}
