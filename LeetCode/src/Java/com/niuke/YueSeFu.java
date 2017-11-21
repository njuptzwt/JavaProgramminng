package com.niuke;

import java.util.ArrayList;
import java.util.List;

/**约瑟夫环的解决办法，使用java使用迭代的思想，使用递归的思路,正确
 * Created by 18362 on 2017/11/21.
 */
public class YueSeFu {
    public static void yuesefu(List list, int k, int count)
    {
        //list人，k从编号k开始叫，count每次叫到几出列,下标是k-1;
        k--;
        while(list.size()>0)
        {
            k=k+count-1;//下一个数字出列的下标
            if(k+1>list.size())
            {
                k=k%list.size();
            }
            System.out.println(list.get(k));
            list.remove(k);
        }
    }
    public static void main(String args[])
    {
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<10;i++)
            list.add(i+1);//构造人数
        yuesefu(list,1,3);
    }
}
