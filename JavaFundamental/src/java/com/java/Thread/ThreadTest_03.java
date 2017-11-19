package com.java.Thread;

/**同步锁之类锁！
 * Created by 18362 on 2017/11/19.
 */
public class ThreadTest_03 extends Thread{

    public synchronized static void test(){
        for(int i = 0 ; i < 3 ; i++){
            System.out.println(Thread.currentThread().getName() + " run......");
        }
    }

    @Override
    public void run() {
        test();
    }

    public static void main(String[] args) {
        for(int i = 0 ; i < 5 ; i++){
            new ThreadTest_03().start();
        }
    }
}