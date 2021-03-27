package com.github.algorithm.sort;

import com.github.algorithm.data.BaseData;
import com.github.algorithm.util.Log;

import static com.github.algorithm.sort.SortUtil.swap;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = BaseData.ARR;
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
            swap(arr, minIndex, i);
        }
    }

}
