package com.github.algorithm.easy;

import com.github.algorithm.util.Log;

public class IntReverse {

    public static void main(String[] args) {

        int intStr = reverse(110000099);
        Log.print(Math.pow(2, -2));

    }

    public static int reverse(int x) {
        String str = String.valueOf(x);
        String reverse = new StringBuilder(str).reverse().toString();
        long longNum = Long.parseLong(reverse);
        if (longNum > Math.pow(-2, 31) && longNum <= Math.pow(2, 31) - 1) {
            return (int) longNum;
        }
        return 0;
    }

}
