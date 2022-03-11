package com.github.algorithm.dp;

import com.github.algorithm.util.Log;

public class CuttingRope {

    public static void main(String[] args) {
        int n = 4;
        int i = cuttingRope(n);
        int i2 = cuttingRope2(n);
        Log.println("最大乘积：" + i);
        Log.print("最大乘积2：" + i2);
    }

    /**
     * 贪心解法
     * @param n
     * @return
     */
    public static int cuttingRope2(int n) {
        if(n < 4){
            return n - 1;
        }
        if (n == 4) {
            return 4;
        }
        int res = 1;
        while(n > 4){
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

    public static int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }

        int[] dp = new int[n + 1];
        for (int i = 5; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

}
