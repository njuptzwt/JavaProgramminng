package com.java.test;

import java.util.Arrays;

/**java中的数组Arrays.sort()实现的是按照字典序的上升排序
 * 如何实现自定义的对象的升序排列或者实现降序排列，
 * //所有的比较器都是返回int类型的值，0相等，大于0，第一个数大于第二个数字，小于0第一个数小于第二个数字
 * 1、需要让需要进行重排序的对象实现Comparable的接口，重写int compareto(Obj)，当前对象和比较对象比较
 * 2、或者让对象调用sort(arr[],new comparator()),重新实现一个比较器，修改他的compare(obj1,obj2)的方法
 * Comparable
 * Created by 18362 on 2017/11/9.
 */
public class ComarableAndComparator implements Comparable<ComarableAndComparator> {
    private String name;
    private int age;
    private String gender;

    public ComarableAndComparator(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    //需要对接口中的compareto(obj1)方法尽心重写，重定义排序规则
    @Override
    public int compareTo(ComarableAndComparator o) {
        //重新定义比较器（结果取正负可以实现sort的升序降序实现）
        if(this.age==o.age)
            return this.name.compareTo(o.name);
        return (this.age-o.age);//实现按照年龄进行降序排序，如果是 return -(this.age-o.age)升序排序，默认排序方式
    }
    public static void main(String args[])
    {
        ComarableAndComparator[]c=new ComarableAndComparator[6];
        c[0]= new ComarableAndComparator("zheng",19,"male");
        c[1]= new ComarableAndComparator("wen",19,"male");
        c[2]= new ComarableAndComparator("xu",16,"male");
        c[3]= new ComarableAndComparator("chun",15,"male");
        c[4]= new ComarableAndComparator("zhang",14,"male");
        c[5]=new ComarableAndComparator("lin",13,"male");
        Arrays.sort(c);
        for(ComarableAndComparator ctest:c)
            System.out.println(ctest.age+":"+ctest.name);
    }
}
