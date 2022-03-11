package com.github.algorithm.dp;

import com.github.algorithm.util.Log;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
        //小于4 直接返回 n - 1
        if(n < 4){
            return n - 1;
        }
        //等于 4 返回 4
        if (n == 4) {
            return 4;
        }
        //尽可能切成长度为 3 的片段，每次循环减去 3，乘积 res * 3，最后返回时乘以 小于等于 4 的值
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
                /**
                 * Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]))
                 * 中的 dp[i] 的含义为：j 的取值从 [2, i) 中不断更新 dp[i] 的值，比当前大，就更新
                 */
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

}
