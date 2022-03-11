package com.github.algorithm.dfs;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MatrixPath {

    public static void main(String[] args) {
        char[][] arr = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "BFDE";
        boolean exist = exist(arr, word);
        System.out.println("是否存在 ASAD:" + exist);
    }

    private static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, chars, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || word[index] != board[i][j]) {
            return false;
        }
        if (index == word.length - 1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '#';
        boolean res = dfs(board, word, i - 1, j, index + 1)
                || dfs(board, word, i + 1, j, index + 1)
                || dfs(board, word, i, j - 1, index + 1)
                || dfs(board, word, i, j + 1, index + 1);
        board[i][j] = temp;
        return res;
    }

}
