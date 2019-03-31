package com.github.algorithm.water;

import com.github.algorithm.util.Log;

/**
 * 求最大存水量问题，数组中每个元素为柱子的高度，求柱子中间的存水量
 */
public class Water {

    public static void main(String[] args) {
        int[] arr = {6, 3, 2, 5, 4};
        int water = getWater(arr);
        Log.println(water);

    }

    /**
     * 时间复杂度是O(n^2)，待优化
     * @param arr
     * @return
     */
    public static int getWater(int[] arr) {
        int water = 0;
        //合法条件检测
        if (arr == null || arr.length <= 1) {
            return 0;
        }

        int leftLargest = 0;
        int rightLargest = 0;

        for (int i = 0; i < arr.length; i++) {
            leftLargest = 0;
            rightLargest = 0;

            //求出左侧最高的柱子
            for (int j = 0; j < i; j++) {
                leftLargest = Math.max(leftLargest, arr[j]);
            }
            //求出右侧最高的柱子
            for (int j = arr.length - 1; j > i; j--) {
                rightLargest = Math.max(rightLargest, arr[j]);
            }

            //如果左侧最大值和右侧最大值的最小值大于当前元素，则存水量为左侧最大值和右侧最大值的最小值减去当前元素的值，否则存水量为0
            water += Math.min(leftLargest, rightLargest) > arr[i] ? Math.min(leftLargest, rightLargest) - arr[i] : 0;
        }
        return water;
    }

}
