package com.java.test;

/**static类方法详解和this的关键字！！！
 * Created by 18362 on 2017/11/6.
 */
public class StaticMethod {
    public static void test()
    {
        System.out.println("test");
        test2();;
        //类（static)方法中不能出现this关键字，他是针对类的，而this是针对对象的
        //类方法通过创建类的实例，调用类的实例方法
       StaticMethod st= new StaticMethod();
       st.sayhello();
    }
    public void sayhello()
    {
        //类的成员方法中可以调用本类中的所有方法（包括成员方法和静态方法）
        //this关键字一定指代的是当前的对象！！不能使用this.static的方法
        System.out.println("hello");
        test2();
        test();
    }
    public static void test2()
    {
        System.out.println("dhdf");
    }
    public void test3()
    {
        this.sayhello();
        test();
        test2();
    }
}
