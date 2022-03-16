package com.github.algorithm;

import com.github.algorithm.util.Log;

public class PrintNumbers {

    public static void main(String[] args) {
        int[] arr = printNumbers(3);
        Log.println("res:" + arr);
    }

    public static int[] printNumbers(int n) {
        if (n == 0) {
            return new int[0];
        }
        int number = (int)Math.pow(10, n) - 1;
        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

}
