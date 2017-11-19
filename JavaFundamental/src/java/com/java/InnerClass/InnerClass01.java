package com.java.InnerClass;

/**非静态的内部类！一句话：外部类中不能提前调用内部类，内部类可以调用外部类的所有属性
 * 非静态类中不允许出现静态的成员或者方法
 *1、 非静态内部类的成员可访问外部类的private成员，反过来不成立
 —原因：外部类对象访问非静态内部类成员时，可能非静态内部类对象根本不存在！而非静态内部类对象访问外部类成员时，外部类对象一定存在！
 2、不允许在外部类的静态成员中直接使用非静态内部类！
 3、非静态内部类里不能有静态方法，静态成员变量，静态初始化代码块！

 * Created by 18362 on 2017/11/19.
 * 总之：就是一个先来后到问题，先有外部类，才能有非静态内部类
 */
public class InnerClass01 {
    private String name="zheng";
    private int age=10;
    public void print(){}
    public class Inner{//内部类可以使得一个类实现多重继承
        private String name="wen";
        //private static int age=4;普通的内部类中不允许设置静态成员.静态的方法
//        private static void print()
//        {
//
//        }
        public void print()
        {
            System.out.println(age);//直接访问外部对象,外部类不能访问内部类的东西(不同名变量）
            System.out.println(InnerClass01.this.name);//同名变量需要使用外部类的类名区别
        }
    }
public static void main(String args[])
{
    //非静态的内部类的定义方式
    InnerClass01 innerClass01=new InnerClass01();
    InnerClass01.Inner inner=innerClass01.new Inner();//常规内部类需要通过外部类的实例才能创建对象
    inner.print();
}
}
