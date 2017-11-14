package com.sort;

/**双路排序解决大量重复键值的方案（快排的非等大小数组缺陷解决！！！）
 * Created by 18362 on 2017/11/13.
 */
public class QuickSort2 {
    public static void sort(Comparable []arr)
    {
        int length=arr.length;
        quickSort(arr,0,length-1);
    }
    public static void quickSort(Comparable []arr,int l,int r)
    {
        if(r-l<=15)
        {
            insertionSort(arr,l,r);
            return ;
        }
        int index=partion(arr,l,r);
        quickSort(arr,l,index-1);
        quickSort(arr,index+1,r);
    }
    public static int partion(Comparable []arr,int l,int r)
    {
        int i=l+1;//标记小于的数的下标
        int j=r;//标记大于数的下标
        int rand=(int)Math.random()*(r-l)+l;
        swap(arr,l,rand);//随机数防止有序的冲突
        Comparable temp=arr[l];
        while(true)
        {
            //O(N*Log(N)的算法是建立在左右两边的每次分解趋于平衡的状态，如果一方偏多就会造成时间复杂度的增加！
            //如果设计成等于号，对于连续的和比较值相等的点就会集中的往一边靠，导致二叉树的不平衡性！时间复杂度增加！
            while(i<=r&&arr[i].compareTo(temp)<0)//如果边界条件设计成等于号会导致子树的不平衡性
                i++;
            while(j>=l+1&&arr[j].compareTo(temp)>0)
                j--;
            if(i>j)
                break;
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);//最后一轮的结果肯定是i的位置第一个大于等于temp的位置，j的位置在最后一个小于等于temp的值
        return j;
    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void insertionSort(Comparable []arr,int l,int r)
    {
        if(l>=r)
            return ;
        for(int i=l+1;i<=r;i++)//这边的限制就可以保证数组的不越界问题，不需要额外的第一个判断
        {
            Comparable temp=arr[i];
            int j=i;
            for(;j>l&&arr[j-1].compareTo(temp)>0;j--)
                arr[j]=arr[j-1];
            arr[j]=temp;
        }
    }
    public static void main(String[] args) {

        // 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SelectSortHelper.generateRandomArray(N, 0, 100000);
        Integer[] arr1=SelectSortHelper.generateRandomArray(N,1,10);//体现双路排序的优点
        SelectSortHelper.testSort(arr1,"com.sort.QuickSort2");
//        Integer arr[]=SelectSortHelper.generateRandomArray(20,1,100);
//        sort(arr);
//        SelectSortHelper.printArray(arr);
        return;
    }
}
