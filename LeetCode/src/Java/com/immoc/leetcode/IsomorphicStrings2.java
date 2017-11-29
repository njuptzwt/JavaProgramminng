package com.immoc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**使用Map做模式匹配的问题
 * Created by 18362 on 2017/11/29.
 */
public class IsomorphicStrings2 {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        Map<Character,Character>map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            Character a=s.charAt(i);
            Character b=t.charAt(i);
            if(map.containsKey(a))
            {
                if(map.get(a)!=b)
                    return false;
            }
            else
                if(!map.containsValue(b))
                map.put(a,b);
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
