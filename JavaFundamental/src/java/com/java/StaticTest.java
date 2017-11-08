package com.java;

import javax.naming.Name;

/**静态的内部类只可以访问外围类的static数据包括私有静态数据
 * 普通的内部类可以访问外围的所有数据，包括私有数据
 * Static 关键字所有对象共同拥有的方法，类方法。Static方法中只可以访问Static方法
 * 如果要访问类的实例方法，需要new一个实例对象进行访问！！！
 * 普通的内部类中不允许有Static的方法！！！！
 * 内部类的静态方法只能访问外部的静态数据，非静态数据不允许！！
 * Created by 18362 on 2017/11/8.
 */
public class StaticTest {
    private String name="dhjf";
    private static int age=10;
    String sex="male";
    static int b=1;
    public static void test1()
    {
        test2();
    }
    static void test2()
    {
       // test3();//报错，不能访问非静态的数据
    }
    void test3()//默认default属性，本类和本包
    {
        test2();
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

   public class innerclass
    {
        void test()
        {
            System.out.println(name);
            System.out.println(age);
            System.out.println(sex);
            System.out.println(b);
        }
//        public static void test3()
//        {
//
//        }
    }
    static class innner2
    {
        public static void test3()
        {

        }
        void test()
        {
            //System.out.println(name);
            System.out.println(age);
            //System.out.println(sex);
            System.out.println(b);
        }
    }

}
