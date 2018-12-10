package com.github.algorithm;

import com.github.algorithm.data.BaseData;
import com.github.algorithm.util.Util;

/**
 * 将两个有序的数组合并为一个有序数组
 */
public class MergeSorted {

    public static void main(String[] args) {
        int[] mergeSorted = mergeSorted(BaseData.ARR2, BaseData.ARR3);
        Util.printArr(mergeSorted);
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
