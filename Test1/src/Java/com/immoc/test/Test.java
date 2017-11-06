package com.immoc.test;
import java.util.*;

/**
 * Created by 18362 on 2017/11/2.
 */
public class Test {
    public static void main(String []args)
    {
//        List<List<List<Integer>>> dp=new ArrayList<>();
//        int []a=new int[4];
//        a[0]=2;a[1]=3;a[2]=4;a[3]=7;
//        for(int i=1;i<9;i++) {
//            List<List<Integer>> temp = new ArrayList<>();
//            for (int j = 0; j < 4 && i - a[j] >= 0; j++) {
//                if (i == a[j]) {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(a[j]);
//                    temp.add(0, list);//这里有问题，应该把这个放在temp第一位
//                }
//                else if (dp.size() > 0 && dp.get(i - a[j] - 1).size() > 0) {
//                    for (int k = 0; k < dp.get(i - a[j] - 1).size(); k++)//修改之后的逻辑,多重循环
//                    {
//                        List<Integer>list1=new ArrayList<>();
//                        list1.addAll(dp.get(i - a[j] - 1).get(k));//addAll操作(挖坑给自己跳。。）
//                        list1.add(a[j]);
//                        Collections.sort(list1);
//                        temp.add(list1);
//                    }
//                }
//            }
//            dp.add(temp);
//        }
        System.out.println("success");
    }
}
