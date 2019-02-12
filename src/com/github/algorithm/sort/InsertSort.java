package com.github.algorithm.sort;

import com.github.algorithm.data.BaseData;
import com.github.algorithm.util.Log;
import static com.github.algorithm.sort.SortUtil.swap;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = BaseData.ARR;
        sort(arr);
        Log.print(arr);
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
