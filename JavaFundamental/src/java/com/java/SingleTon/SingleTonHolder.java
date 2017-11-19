package com.java.SingleTon;

/**饿汉模式，线程安全，但是会提前预支资源给内存带来损耗
 * 懒汉模式前两种（除了使用volatile的DCC）延迟加载，线程不安全
 * 使用Java的静态内部类实现线程安全而且延迟加载的但例模式
 * Created by 18362 on 2017/11/19.
 * 这种方法使用内部类来做到延迟加载对象，在初始化这个内部类的时候，
 * JLS(Java Language Sepcification)会保证这个类的线程安全(the class initialization phase is guaranteed by the JLS to be serial)
 */
public class SingleTonHolder {
    private static class singletonholder
    {
        private final static SingleTonHolder singleton=new SingleTonHolder();
    }
    private SingleTonHolder()
    {}
    public static SingleTonHolder getInstance()
    {
        return singletonholder.singleton;//当调用内部类的时候开始加载内部类相关信息，
    }
}
