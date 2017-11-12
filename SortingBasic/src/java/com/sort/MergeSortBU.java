package com.sort;

import sun.security.util.LegacyAlgorithmConstraints;

import java.util.Arrays;

/**
 * 类似动态规划的做法，一般可以用递归的方法做的题目（自顶向下的规则）
 * 都可以使用迭代的方式做题(自底向上的思路实现）
 * Created by 18362 on 2017/11/12.
 */
public class MergeSortBU {
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);//辅助空间
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
    //自底向上的解决思路！！和动态规划联系起来
    private static void sort(Comparable[] arr) {
        int length = arr.length;
        int gap = 1;
        for (; gap <= length; gap = gap * 2) {
            //外层循环控制每次归并的数组的大小内层循环控制哪几个模块合并
            for (int i = 0; i + gap < length; i += 2 * gap)//这边的控制边界条件是为了控制合并的时候有两组数据，否则不合并
            {
                if(arr[i+gap-1].compareTo(arr[i+gap])>0)//优化点
                merge(arr, i, i + gap - 1, Math.min(i + gap + gap - 1, length - 1));//防止数组越界，因为分到后面，最后一组的个数可能要少
            }
        }
    }
    public static void main(String args[])
    {
        Integer a[]=SelectSortHelper.generateRandomArray(100,1,100);
        sort(a);
        SelectSortHelper.printArray(a);
    }
}
