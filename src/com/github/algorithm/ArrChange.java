package com.github.algorithm;

import java.util.ArrayList;
import java.util.List;

public class ArrChange {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] change = exchange3(arr);
        System.out.println("res:" + change);
    }

    /**
     * 快慢指针法
     * @param nums
     * @return
     */
    public static int[] exchange3(int[] nums) {
        int slow = 0, fast = 0, temp;
        while (fast < nums.length) {
            if (nums[fast] % 2 == 1) {
                temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
        return nums;
    }

    /**
     * 首尾双指针
     * @param nums
     * @return
     */
    public static int[] exchange2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int l = 0, r = nums.length - 1, temp = 0;
        while (l < r) {
            if (nums[l] % 2 == 0 && nums[r] % 2 != 0) {
                temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
            if (nums[l] % 2 != 0) {
                l++;
            }
            if (nums[r] % 2 == 0) {
                r--;
            }
        }
        return nums;
    }

    public static int[] exchange1(int[] nums) {
        int l = 0, r = nums.length - 1, temp;
        while (l < r) {
            if (nums[l] % 2 == 0 && nums[r] % 2 != 0) {
                temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
            if (nums[l] % 2 == 0 && nums[r] % 2 == 0) {
                r--;
            } else if(nums[l] % 2 != 0 && nums[r] % 2 == 0) {
                l++;
            } else {
                l++;
                r++;
            }
        }
        return nums;
    }

    //辅助空间，时间复杂度0(N)
    public static int[] change(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenList.add(nums[i]);
            } else {
                oddList.add(nums[i]);
            }
        }
        result.addAll(oddList);
        result.addAll(evenList);
        int[] primitive = result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return primitive;
    }

}
