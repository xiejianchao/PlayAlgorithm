package com.github.algorithm.sort;

import com.github.algorithm.data.BaseData;
import com.github.algorithm.util.Log;

public class TestSort {

    public static void main(String[] args) {
        int[] arr = BaseData.ARR;
//        11, 29, 25, 9, 21, 18, 7, 16
//        insertSort(arr);
        selectionSort(arr);
        Log.print(arr);
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            SortUtil.swap(arr, i, minIndex);
        }
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    SortUtil.swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
