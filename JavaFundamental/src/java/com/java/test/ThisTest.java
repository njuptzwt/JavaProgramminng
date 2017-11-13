package com.java.test;

/**This不仅可以指代当前类的对象的引用还可以在不同的构造器中调用另一个构造器
 * this（）构造器函数必须放在第一行的位置
 * Created by 18362 on 2017/11/13.
 */
public class ThisTest {
    private String name;
    private Integer age;
    private String gender;
    private String adress;
    public ThisTest(String name,Integer age)
    {
        this.name=name;
        this.age=age;
    }
    public ThisTest(String name,Integer age,String gender,String adress)
    {
        this(name,age);//用this调用内部的其他构造器，必须是放在第一个语句中！！！
        this.gender=gender;
        this.adress=adress;

    }
}
