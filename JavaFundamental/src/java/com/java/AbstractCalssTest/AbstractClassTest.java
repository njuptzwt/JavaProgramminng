package com.java.AbstractCalssTest;

/**抽象类
 * 抽象类不能有实例！
 * 抽象类的子类可以有实例！
 * 抽象类中可以定义私有成员（不可以继承给子类）
 * 可以定义非抽象方法（子类可以继承，不一定要覆盖）
 * 可以定义抽象方法（子类一定要覆盖抽象方法）
 * 抽象方法一定要定义在抽象类中或者接口中！
 * Created by 18362 on 2017/11/6.
 */
public abstract class AbstractClassTest {
    public String name="sgh";
    public void sayheelo()
    {
        System.out.println(name);
    }
    abstract public void test();
    abstract protected void test1();
}
