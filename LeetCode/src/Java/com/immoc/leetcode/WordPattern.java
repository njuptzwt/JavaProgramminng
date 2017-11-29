package com.immoc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**模式匹配
 * Created by 18362 on 2017/11/29.
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        String []s=str.split(" ");
        List<String> list1=new ArrayList<>();
        List<Character>list2=new ArrayList<>();
        if(s.length!=pattern.length())
            return false;
        for(int i=0;i<pattern.length();i++)
        {
            if(!list1.contains(s[i])&&!list2.contains(pattern.charAt(i)))
            {
                list2.add(pattern.charAt(i));
                list1.add(s[i]);
            }
            else if(list1.contains(s[i])&&list2.contains(pattern.charAt(i)))
            {
                if(list1.indexOf(s[i])!=list2.indexOf(pattern.charAt(i)))
                    return false;
                list2.add(pattern.charAt(i));
                list1.add(s[i]);
            }
            else
                return false;
        }
        return true;
    }
    public static void main(String args[])
    {
        String pattern = "abba", str = "dog cat cat fish";
        System.out.println(wordPattern(pattern,str));
    }
}
