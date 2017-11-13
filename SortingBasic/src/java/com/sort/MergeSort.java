package com.sort;
import java.util.Arrays;

/**
 * 归并排序的时间复杂度和思想（可以理解为贪心算法的思想，每一次从两个数组中挑选小的数字往，aux中放（最后的结果)
 * O(N*LogN)时间复杂度
 * 每次将需要排序的数组对半分，每一个部分用归并排序递归
 * 给定一个数组：1,3,4,5,7,8,6,5
 * Created by 18362 on 2017/11/12.
 */

public class MergeSort{

    // 我们的算法类不允许产生任何实例
    private MergeSort(){}

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l]; j ++;
            }
            else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l].compareTo(aux[j-l]) < 0 ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l]; i ++;
            }
            else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l]; j ++;
            }
        }
    }
    //指定的顺序中进行插入排序
    private static void  insertionSort(Comparable []arr,int begin,int end)
    {
        for(int i=begin+1;i<=end;i++)
        {
            Comparable temp=arr[i];
            int j=i;
            for(;j>begin&&arr[j-1].compareTo(temp)>0;j--)
                    arr[j]=arr[j-1];
            arr[j]=temp;
        }
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        if (l >= r)
            return;//归并到只有一个元素为止

        //归并排序的第二个优化，当r-l比较小的时候用直接插入排序比归并排序快（因为算法的复杂度前面还有系数不能忘记）
        if(r-l<=15)
        {
            insertionSort(arr,l,r);
            return;
        }
        int mid = (l+r)/2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        //归并排序的优化点1
        if(arr[mid].compareTo(arr[mid+1])>0)//只有当这种情况下，才需要对两路有序的序列进行合并
        merge(arr, l, mid, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    // 测试MergeSort
    public static void main(String[] args) {

        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 500000;
        Integer[] arr = SelectSortHelper.generateNearlyOrderedArray(N,10);
        SelectSortHelper.testSort(arr, "com.sort.MergeSort");
        return;
    }
}
