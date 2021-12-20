package com.github.algorithm.sort;

import com.github.algorithm.data.BaseData;
import com.github.algorithm.util.Log;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = BaseData.ARR;
        mergeSort(arr, 0, arr.length - 1);
        Log.print(arr);
    }

    /**
     * 递归对arr[l...r]范围内的数据进行排序
     * @param arr
     * @param l
     * @param r
     */
    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        Log.println("mergeSort(arr, l, mid) called");
        mergeSort(arr, mid + 1, r);
        Log.println("mergeSort(arr, mid + 1, r) called");
        merge(arr, l, mid, r);
        Log.println("mergeSort(arr, l, mid, r) called");
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

}
