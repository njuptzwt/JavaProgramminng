package com.immoc.leetcode;

import java.util.Arrays;

/**
 * Created by 18362 on 2017/12/10.
 */
public class MergeSort {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = Arrays.copyOf(nums1,m);
        int i = 0;
        int j = 0;
        int k = 0;
        for(;i<m+n;i++){
            if (j >= m) {
                nums1[i] = nums2[k];
                k++;
            } else if (k >= n) {
                nums1[i] = temp[j];
                j++;
            } else {
                if (temp[j] > nums2[k]) {
                    nums1[i] = nums2[k];
                    k++;
                } else if (temp[j] <= nums2[k]) {
                    nums1[i] = temp[j];
                    j++;
                }
            }
        }
    }
}
