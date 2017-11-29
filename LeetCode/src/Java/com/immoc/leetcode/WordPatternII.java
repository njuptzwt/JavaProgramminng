package com.immoc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 18362 on 2017/11/29.
 */
public class WordPatternII {
    public boolean wordPattern(String pattern, String str) {
        String []s=str.split(" ");
        Map<Character,String>map=new HashMap<>();
        if(s.length!=pattern.length())
            return false;
        for(int i=0;i<pattern.length();i++)
        {
            Character a=pattern.charAt(i);
            if(map.containsKey(a))
            {
                if(!map.get(a).equals(s[i]))
                    return false;
            }
            else
                if(!map.containsValue(s[i]))
                    map.put(a,s[i]);
            else
                return false;
        }
        return true;
    }
}
