package com.immoc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**判断两个字符串是否是调换顺序得到的
 * Created by 18362 on 2017/11/29.
 */
public class Anagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        Map<Character,Integer> map1=new HashMap<>();
        for(int i=0;i<s.length();i++)
            if(map1.get(s.charAt(i))!=null)
                map1.put(s.charAt(i),map1.get(s.charAt(i))+1);
        else
            map1.put(s.charAt(i),1);
        for(int i=0;i<t.length();i++)
            if(!map1.containsKey(t.charAt(i))||map1.get(t.charAt(i))==0)
                return false;
        else
            map1.put(t.charAt(i), map1.get(t.charAt(i))-1);
        return true;
    }
    public static void main(String args[])
    {
        String s = "rat", t = "cat";
        System.out.println(isAnagram(s,t));
    }
}
