package com.github.algorithm.dfs;

import com.github.algorithm.util.Log;


/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MovingCount {

    static boolean[][] visited;

    public static void main(String[] args) {
        int m = 10, n = 20, k = 5;
        int count = movingCount(m, n,  k);
        Log.println("movingCount:" + count);
    }

    private static int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return dfs(m, n, 0, 0, k);
    }

    private static int dfs(int m, int n, int i, int j, int k) {
        if (i >= m || j >= n || getNum(i, j) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(m, n, i + 1, j, k) + dfs(m, n, i, j + 1, k);
    }

    static int getNum(int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }

        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }

}
