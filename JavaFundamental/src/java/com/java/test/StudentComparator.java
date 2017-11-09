package com.java.test;

import java.util.Arrays;
import java.util.Comparator;

/**使用sort(arr[],new comparator)的方式实现重排序）
 * Created by 18362 on 2017/11/9.
 */
public class StudentComparator {
    private String name;
    private Integer age;

    public StudentComparator() {
    }

    public StudentComparator(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentComparator{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public static void main(String args[])
    {
        StudentComparator st[]=new StudentComparator[5];
        st[0]=new StudentComparator("zheng",12);
        st[1]=new StudentComparator("wen",10);
        st[2]=new StudentComparator("qeew",10);
        st[3]=new StudentComparator("qwe",15);
        st[4]=new StudentComparator("zfha",18);
        Arrays.sort(st, new Comparator<StudentComparator>() {
            @Override
            public int compare(StudentComparator o1, StudentComparator o2) {
                if(o1.age==o2.age)
                    return o1.name.compareTo(o2.name);//取反实现降序排列
                return o1.age-o2.age;//取反实现降序排列
            }
        });//内部类实现Comparator比较器的实现（需要重写compare(obj1,obj2)方法）
        for(StudentComparator s:st)
            System.out.println(s.age+":"+s.name);
    }
}
