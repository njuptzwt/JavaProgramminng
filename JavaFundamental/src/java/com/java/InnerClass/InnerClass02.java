package com.java.InnerClass;

/**静态的内部类
 * 1、static修饰的，所以这个内部类属于外部类本身，也叫类内部类！
   2、静态内部类可以包含静态成员，也能包含非静态成员，静态成员不能访问非静态成员！（又是先来后到问题）
   3、java允许在接口中定义内部类，默认使用public static修饰！
 * Created by 18362 on 2017/11/19.
 */
public class InnerClass02 {
    private static String name="zheng";
    private int age=90;
    public static void next(){}
    public void print()
    {
        System.out.println();
    }//外部类不能访问内部
    public static class inner
    {
        String name="wen";
        String gender="male";
        public void print()
        {
            next();//静态内部类可以访问外部的静态方法！类的初始化顺序！外部先，内部后（内部类在外部类创建后生成）
           // System.out.println(age);//静态的内部类不能访问常规静态成员变量，初始化的先后顺序
            System.out.println(InnerClass02.name);
            System.out.println(name);
            //InnerClass02.this.print();不能访问非静态成员函数
        }
    }
    public static void main(String args[])
    {
        //静态内部类的初始化方式，可以直接使用类名初始化，不需要通过外部类的实例
        InnerClass02.inner in=new InnerClass02.inner();
        in.print();
    }
}
