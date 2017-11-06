package com.java.AbstractCalssTest;

/**This指针
 * Created by 18362 on 2017/11/6.
 */
public class RealizeAbstract extends AbstractClassTest {
    public String address="sdj";
    protected Integer age=10;
    @Override
    public void test() {

    }
    //子类中覆盖父类的方法
    public void sayheelo()
    {
        System.out.println("dhjsfj");
    }
    @Override
    protected void test1() {
    sayheelo();
    }
    public static void main(String args[])//可以把main方法看成是同包下的方法
    {
        //在main方法中没有this这个用法，只有在类的内部使用this指针，代表的是当前对象！
        //类名.方法名是针对static的静态方法使用的！
        //main方法不属于版本类的内部方法
        RealizeAbstract test=new RealizeAbstract();
        test.sayheelo();
        System.out.println(test.address);
        System.out.println(test.age);


    }
}
