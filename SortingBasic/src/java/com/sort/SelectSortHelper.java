package com.sort;

import java.lang.reflect.Method;

/**随机数生成数字的工具,答应工具
 * Created by 18362 on 2017/11/10.
 */
public class SelectSortHelper {
    private SelectSortHelper() {

    }

    public static Integer[] generateRandomArray(int n, int begin, int end) {
        assert end>=begin;//断言，声明
        Integer arr[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((int) (Math.random() * (end - begin) + begin));//强制类型转换
        }
        return arr;
    }

    public static void printArray(Object arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();

        return;
    }
    // 判断arr数组是否有序
    public static boolean isSorted(Comparable[] arr){

        for( int i = 0 ; i < arr.length - 1 ; i ++ )
            if( arr[i].compareTo(arr[i+1]) > 0 )
                return false;
        return true;
    }
    public static void swap(Object[] arr, int a, int b) {
        //交换数值的程序
        Object temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // 生成一个近乎有序的数组
    // 首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数据
    // swapTimes定义了数组的无序程度:
    // swapTimes == 0 时, 数组完全有序
    // swapTimes 越大, 数组越趋向于无序
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes){

        Integer[] arr = new Integer[n];
        for( int i = 0 ; i < n ; i ++ )
            arr[i] = new Integer(i);

        for( int i = 0 ; i < swapTimes ; i ++ ){
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }
    public static void testSort(Comparable []arr,String sortClassName)
    {
        //通过Java中的反射机制获取类名，获取对应类的排序方法
        // 通过Java的反射机制，通过排序的类名，运行排序函数
        // * 依然是，使用反射机制并不是这个课程的重点, 大家也完全可以使用自己的方式书写代码, 最终只要能够测试出自己书写的算法的效率即可
        // * 推荐大家阅读我在问答区向大家分享的一个学习心得: 【学习心得分享】请大家抓大放小，不要纠结于C++语言的语法细节
        // * 链接: http://coding.imooc.com/learn/questiondetail/4100.html
        try{
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort",new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            assert isSorted( arr );

            System.out.println( sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms" );
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
