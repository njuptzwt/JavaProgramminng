package com.sort;

/**
 * 使用模板类统一实现各种算法的排序
 * java中实现Comparable的重排序和CompareTo()方法
 * http://www.cnblogs.com/xujian2014/p/5215082.html（comparable()和comparator接口的比较）
 * Created by 18362 on 2017/11/3.
 */
public class Templatesort {
    private Templatesort() {

    }

    public static void sort(Comparable[] arr) {
        int length = arr.length;
        //开始排序算法
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++)
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;//选择排序找到每一轮的最小索引值
            swap(arr, i, minIndex);
        }
    }

    public static void swap(Object[] arr, int a, int b) {
        //交换数值的程序
        Object temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String args[]) {
        Integer a[] = {1, 23, 43, 34, 2, 12, 34, 2, 23, 47, 8, 9};//不能使用int,float等数据类型，要使用Integer,Double,Float等包装类实现了Comparble接口
        sort(a);
        for(int i:a)
            System.out.print(i+" ");
        Double d[]={21.3,32.89,12.32,123.23,12.23,121.12,23.34,23.434,3.34};
        sort(d);
        for(Double te:d)
            System.out.print(te+" ");
        Student []st=new Student[5];
        st[0]=new Student("sdhj",23);
        st[1]=new Student("we",2435);
        st[2]=new Student("sdh435",35);
        st[3]=new Student("353wer",345);
        st[4]=new Student("fs",543);
        sort(st);
        for(Student s:st)
            System.out.println(s.getScore()+" "+s.getName());
    }
}
