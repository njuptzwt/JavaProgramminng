package com.immoc.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 18362 on 2017/11/2.
 */
public class Test {
    public static void main(String []args)
    {

        Set<Integer> set=new TreeSet<Integer>();
        String s1=new String("hello");
        String s2=new String("hello");
        System.out.println(s1==s2);
        System.out.println("hello");
    }
}
