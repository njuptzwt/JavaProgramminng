package com.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * 自旋锁是采用让当前线程
 * 不停地的在循环体内执行实现的，当循环的条件被其他线程改变时 才能进入临界区
 * 由于自旋锁只是将当前线程不停地执行循环体，不进行线程状态的改变，所以响应速度更快。
 * 但当线程数不停增加时，性能下降明显，因为每个线程都需要执行，占用CPU时间。
 * 如果线程竞争不激烈，并且保持锁的时间段。适合使用自旋锁。
 *
 * 锁(类）的基本操作lock(),unlock（），lock()上锁之后，其他线程等待unlock()之后才能执行临界区
 * 自旋锁线程不停，其他锁导致线程阻塞，等待锁释放！！区别联系
 * Created by 18362 on 2017/11/25.
 */
public class SpinLock {
    private AtomicReference<Thread> sign = new AtomicReference<>();//定义线程类型的原子引用
    //使用的是Atomic下的包的类型AtomicInteger,AtomicLong,AtomicReference(引用类型）类对象
    //Atomic下的包，使用的是CAS操作，保证了“读-改-写"的原子操作
    //Concurrent下的方法主要是Volatile(可见性)+CAS操作"读-改-写”原子操作！！
    public void lock() {
        Thread current = Thread.currentThread();
        while (!sign.compareAndSet(null, current)) {
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        sign.compareAndSet(current, null);
    }
    public static void main(String args[])
    {
        int a[]=null;
        a[0]=1;
    }
}
