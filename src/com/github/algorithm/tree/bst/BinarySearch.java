package com.github.algorithm.tree.bst;


public class BinarySearch {

    /**
     *
     * @param arr 要查找的数组
     * @param target 要查找的具体数字
     * @return 返回 target 所在数组的 index
     */
    public static int find(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
//        int mid = (l + r) / 2;//有溢出风险
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        arr[99] = 666;
        int findNumber = 666;
//        int i = BinarySearch.find(arr, findNumber);
//        System.out.println("查找到 " + findNumber + " 在数组中的索引为：" + i);

        Integer a = 3;
        Integer b = 4;
        Integer c = 5;

        int i = b.compareTo(b);
        System.out.println("a compareTo b = " + i);
    }

}
