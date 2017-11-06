package com.java.quanxian;

/**比较Public,Protected,default,private权限的使用范围
 * public的访问属性本类，子类，同包，不同包
 * protected的访问权限本类，子类（包外的子类），同包（不可以修饰类）
 * default属性（可以修饰类，friendly）,本类，同包（默认最高权限是包访问权限）
 * private属性（不可以修饰类)只有本类的方法可以访问
 * （一般为了安全，要把类的属性设置为私有属性，只能在本类中的方法中访问，提供本类的public方法来获取这些属性）
 * Created by 18362 on 2017/11/6.
 */
public class Person {
    public String name;
    public void sayhello()
    {
        System.out.println("hello:"+name);
    }
    public void UseSayhello()
    {
        sayhello();
    }
    public String getName()
    {
        return name;
    }
//    public static void main(String args[])//不属于类的成员方法
//    {
//        System.out.println("hello"+name);
//    }
}
