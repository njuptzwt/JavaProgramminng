package com.immoc.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 18362 on 2017/11/5.
 */
public class ListTest {
    public static void  main(String args[])
    {
        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        List<Integer> list1=list;
        list1.add(3);
        for(int a:list)
            System.out.println(a);
    }
}
