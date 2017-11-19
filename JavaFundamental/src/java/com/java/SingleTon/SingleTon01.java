package com.java.SingleTon;

/**单例模式1(内存模型和并发的知识synchronized)
 * 饱汉模式，核心都是通过静态变量来实现的,将构造方法设置为私有.要用的时候才初始化
 * 只能通过获取实例模式获取单例
 * Created by 18362 on 2017/11/19.
 */
public class SingleTon01 {
    private static SingleTon01 singleTon01;
    private SingleTon01()
    {

    }
    public static SingleTon01 getSingleTon01()
    {
        //存在线程竞争，可能导致实例有多个
        if(singleTon01==null)
            singleTon01=new SingleTon01();
        return singleTon01;
    }

}
