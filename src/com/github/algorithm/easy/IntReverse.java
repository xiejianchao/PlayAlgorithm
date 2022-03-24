package com.github.algorithm.easy;

import com.github.algorithm.util.Log;

public class IntReverse {

    public static void main(String[] args) {

        int intStr = reverse(110000099);
        int intStr2 = reverse2(110000099);
        Log.print(Math.pow(2, -2));

    }

    public static int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            //判断是否 大于 最大32位整数
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
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
