package com.sort;

/**
 * 快速排序，三路键值的排序，可以将大量重复的元素排除在外
 * Created by 18362 on 2017/11/14.
 */
public class QuickSort3 {
    public static void sort(Comparable[] arr) {
        int length = arr.length;
        quickSort(arr, 0, length - 1);
    }

    public static void quickSort(Comparable[] arr, int l, int r) {
        if (r - l <= 15) {
            insertionSort(arr, l, r);
            return;
        }
        //三路排序开始
        int lt = l;//记录小于temp值的最后一位（保证初始的时候，数组为空）
        int gt = r + 1;//记录大于temp值的第一位，为什么不用r自己想清楚(保证初始的时候，该数组为空）
        int rand = (int) Math.random() * (r - l) + l;
        swap(arr, l, rand);
        Comparable temp = arr[l];
        int i = l + 1;
        while ( i < gt) {//循环条件的控制可以取到节省时间的作用！！
            if (arr[i].compareTo(temp) < 0) {
                swap(arr, lt + 1, i);
                lt++;
                i++;
            } else if (arr[i].compareTo(temp) > 0) {
                swap(arr, i, gt - 1);
                gt--;
            } else
                i++;
        }
        swap(arr, l, lt);
        quickSort(arr, l, lt - 1);
        quickSort(arr, gt, r);//下标边界的处理！！！很重要
    }

    public static void insertionSort(Comparable[] arr, int l, int r) {

        for (int i = l + 1; i <= r; i++) {
            Comparable temp = arr[l];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(temp) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void main(String[] args) {

        // 三路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SelectSortHelper.generateRandomArray(N, 0,100000);
        SelectSortHelper.testSort(arr, "com.sort.QuickSort3");

        return;
    }
}
