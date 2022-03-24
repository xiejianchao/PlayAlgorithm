package com.github.algorithm;

import com.github.algorithm.util.Log;

public class MyPow {

    public static void main(String[] args) {
        double res = myPow(2, 11);
        Log.print("res:" + res);
    }

    public static double myPow(int x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

}
