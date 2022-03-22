package com.github.algorithm.sort;

import com.github.algorithm.data.BaseData;
import com.github.algorithm.util.Log;

/**
 * 将两个有序的数组合并为一个有序数组
 */
public class MergeSorted {

    public static void main(String[] args) {
//        int[] mergeSorted = mergeSorted(BaseData.ARR_SORTED_1, BaseData.ARR_SORTED_2);
        int[] mergeSorted = mergeSorted(BaseData.ARR_SORTED_3, BaseData.ARR_SORTED_3.length, BaseData.ARR_SORTED_4, BaseData.ARR_SORTED_4.length);
        Log.print(mergeSorted);
    }

    public static int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }

        while(i < m) {
            result[k++] = nums1[i++];
        }

        while(j < m) {
            result[k++] = nums2[j++];
        }

        System.out.println(result);
        return result;
    }

    private static int[] mergeSorted(int[] arr, int[] arr2) {
        int[] result = new int[arr.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr.length && j < arr2.length) {
            if (arr[i] < arr2[j]) {
                result[k++] = arr[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < arr.length) {
            result[k++] = arr[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        return result;
    }
}
