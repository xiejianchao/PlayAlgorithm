package com.github.algorithm.others;

import com.github.algorithm.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetLeastNumber {

    public static void main(String[] args) {
        int[] arr = {0,1,2,1};
        int[] leastNumbers = getLeastNumbers(arr, 1);
        Log.println("res:" + leastNumbers);
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        for (int i : arr) {
            if (i <= k && list.size() < k) {
                list.add(i);
            }
        }
        int[] primitive = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return primitive;
    }

}
