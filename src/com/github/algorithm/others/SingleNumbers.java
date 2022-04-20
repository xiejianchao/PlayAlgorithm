package com.github.algorithm.others;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SingleNumbers {

    public static void main(String[] args) {
        int[] arr = {1, 2, 10, 4, 1, 4, 3, 3};
        singleNumbers(arr);
    }

    public static int[] singleNumbers(int[] nums) {
        if (nums.length < 2) return new int[0];
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            if (list.contains(n)) {
                list.removeIf(integer -> integer == n);
            } else {
                list.add(n);
            }
        }
        return list.stream().mapToInt(value -> value).toArray();
    }


}
