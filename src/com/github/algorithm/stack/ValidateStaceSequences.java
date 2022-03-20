package com.github.algorithm.stack;

import com.github.algorithm.util.Log;

import java.util.Stack;

public class ValidateStaceSequences {

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        int[] popped2 = {5, 4, 3, 2, 1};
        boolean b = validateStackSequences(pushed, popped);
        boolean b2 = validateStackSequences2(pushed, popped);
        Log.print("res:" + b);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num = 0; num < pushed.length; num++) {
            stack.push(pushed[num]);
            while (!stack.isEmpty() && stack.peek().equals(popped[i])) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

}
