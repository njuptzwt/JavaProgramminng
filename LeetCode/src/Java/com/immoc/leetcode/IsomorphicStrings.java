package com.immoc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 18362 on 2017/11/29.
 */
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
    if(s.length()!=t.length())
        return false;
        List<Character> list1=new ArrayList<>();
        List<Character>list2=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            if(!list1.contains(s.charAt(i))&&!list2.contains(t.charAt(i)))
            {
                list1.add(s.charAt(i));
                list2.add(t.charAt(i));
            }
            else if(list1.contains(s.charAt(i))&&list2.contains(t.charAt(i)))
            {
                if(list1.indexOf(s.charAt(i))!=list2.indexOf(t.charAt(i)))
                    return false;
                list1.add(s.charAt(i));
                list2.add(t.charAt(i));
            }
            else
                return false;
        }
        return true;
    }
    public static void main(String args[])
    {
        String s="paper",t="tetle";
        System.out.println(isIsomorphic(s,t));
    }

}
