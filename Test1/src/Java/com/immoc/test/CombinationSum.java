package com.immoc.test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**CombiantionSum自己的解决方案(动态规划轻松解决）
 * Created by 18362 on 2017/11/5.
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>();
        Arrays.sort(candidates);
        int length=candidates.length;
        for (int i = 1; i <= target; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (int j = 0; j < length && i - candidates[j] >= 0; j++) {
                if (i == candidates[j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(candidates[j]);
                    temp.add(0, list);//这里有问题，应该把这个放在temp第一位
                } else if (dp.size() > 0 && dp.get(i - candidates[j] - 1).size() > 0) {
                    for (int k = 0; k < dp.get(i - candidates[j] - 1).size(); k++)//修改之后的逻辑,多重循环
                    {
                        List<Integer> list1 = new ArrayList<>();
                        list1.addAll(dp.get(i - candidates[j] - 1).get(k));//addAll操作(挖坑给自己跳。。）
                        list1.add(candidates[j]);
                        Collections.sort(list1);
                        temp.add(list1);
                    }
                }
            }
            dp.add(temp);
        }
        List<List<Integer>>result=new ArrayList<>();
        for(List list:dp.get(dp.size()-1))
        {
            if(!result.contains(list))
                result.add(list);
        }
        return result;
    }
    public static void main(String args[])
    {
        int []a=new int[4];
        a[0]=8;a[1]=7;a[2]=4;a[3]=3;
        int target=11;
        List<List<Integer>>result=new ArrayList<>();
        result=combinationSum(a,target);
        System.out.println();
    }
}
