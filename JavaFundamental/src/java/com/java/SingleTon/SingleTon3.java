package com.java.SingleTon;

/**饱汉模式3，DCL(double check lock)双重锁检查，避免了阻塞
 * 但是由于操作的非原子性操作，有可能导致某个线程只获取了半个实例对象
 * Created by 18362 on 2017/11/19.
 */
public class SingleTon3 {
    private static SingleTon3 singleTon3;
    private SingleTon3()
    {

    }
    public static SingleTon3 getSingleTon3()
    {
        if(singleTon3==null)
        {
            //同步代码块，只允许一次实例化
            // 二次检查是为了排除同时在等待对象锁的线程进入同步代码块时，new新的实例对象
            synchronized (SingleTon3.class)
            {
                if(singleTon3==null)
                    singleTon3=new SingleTon3();//非原子性操作,代码的重排序，出现办个实例化对象
            }

        }
        return singleTon3;
    }
}
