package com.github.algorithm;

import com.github.algorithm.data.BaseData;
import com.github.algorithm.util.Util;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = BaseData.ARR;
        quickSort(arr);
        Util.printArr(arr);
    }

    private static void quickSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        sort(arr, left, right);
    }

    /**
     * 依次比较第一个元素v，比第一个元素小，就将其移动到v前方，然后递归重复调用
     * @param arr
     * @param left
     * @param right
     */
    private static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int p = partition(arr, left, right);
        sort(arr, left, p - 1);
        sort(arr, p + 1, right);
    }

    /**
     * 核心实现，一般称之为partition <br>
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] arr, int left, int right) {
        int v = arr[left];
        int j = left;

        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < v) {
                j++;
                swap(arr, i, j);
            }
        }

        swap(arr, left, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
