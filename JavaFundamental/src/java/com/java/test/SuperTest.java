package com.java.test;

/**父子类继承中的 super关键字的用法
 * 在子类中super代表的是父类的对象，需要访问父类的对象或者方法不需要
 * 单独定义父类对象，而可以直接使用super关键字，调用父类的构造方法
 * 可以直接使用super()
 *
 * 子类的构造函数中一定要优先调用父类的构造函数,super的调用一定要放在函数中的第一行！！
 * 1、如果是调用父类的无参构造函数，那么使用super()即可，或者直接由程序隐式的调用即可
 * 2、如果子类中的构造函数要调用父类的有参构造函数，那么需要super(arg0,arg1);
 * Created by 18362 on 2017/11/9.
 */
public class SuperTest {
    public String nmae="zheng";
    public int age=30;
    public SuperTest()
    {
        System.out.println("parent");
    }
    public SuperTest(String name,int age)
    {
        this.age=age;
        this.nmae=name;
    }
    public void test()
    {
        System.out.println("next");
    }

}
class Test extends SuperTest
{
    public Test()
    {
        super();
        super.test();//super可以指代父类的对象
    }
    public void test()
    {
        SuperTest superTest=new SuperTest("sadj",12);
        System.out.println(superTest.nmae+" "+superTest.age);
        System.out.println(super.age);
        System.out.println(super.nmae);
    }
    public static void main(String args[])
    {
        Test test=new Test();
        test.test();
    }

}

