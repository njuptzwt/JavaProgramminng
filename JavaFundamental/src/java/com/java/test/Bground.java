package com.java.test;

/**
 * Created by 18362 on 2017/11/18.
 */
public class Bground extends Thread {
    public static void main(String argv[]){
        Bground b = new Bground();
        b.run();
    }
    public void start(){
        for(int i=0;i<10;i++){
            System.out.println("Value of i = "+i);
        }
    }
}