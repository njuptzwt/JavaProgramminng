package com.java.Thread;

/**
 * Created by 18362 on 2017/11/19.
 */
public class Thread01_test extends Thread{
    public synchronized void run()
    {
        //重写run的方法
        for(int i=0;i<3;i++)
            System.out.println(Thread.currentThread().getName()+"......run");
    }
    public static void main(String[] args) {
        Thread thread=new Thread01_test();
        for(int i = 0 ; i < 5 ; i++){
            new Thread(thread,"Thread_" + i).start();//同一个thread对象
        }
    }

}
