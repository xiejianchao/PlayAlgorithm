package com.github.algorithm;

import com.github.algorithm.util.Log;

public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5}, {12, 13, 14, 15, 6}, {11, 10, 9, 8, 7}};
        int[] res = spiralOrder(matrix);
        Log.print("res:" + res);
    }

    private static int[] spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int[] res = new int[(right + 1) * (bottom + 1)];
        int index = 0;
        while (true) {
            //从左到右打印 行
            for (int row = left; row <= right; row++) {
                res[index++] = matrix[top][row];
            }
            top ++;
            if (top > bottom) break;
            //从上到下打印 列
            for (int column = top; column <= bottom; column++) {
                res[index++] = matrix[column][right];
            }
            right --;
            if (right < left) break;
            //从右到左打印 行
            for (int row = right; row >= left; row--) {
                res[index++] = matrix[bottom][row];
            }
            bottom --;
            if (bottom < top) break;
            //从下往上打印 列
            for (int column = bottom; column >= top; column--) {
                res[index++] = matrix[column][left];
            }
            left ++;
            if (left > right) break;
        }
        return res;
    }

}
