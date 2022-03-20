package com.github.algorithm.stack;

import com.github.algorithm.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class MinStack {

    private static Stack<Integer> stackA = new Stack<>();
    private static Stack<Integer> stackB = new Stack<>();

    public static void main(String[] args) {
        push(0);
        push(1);
        push(0);
        int min = min();
        pop();
        int min2 = min();

        Log.print("res:" + stackA);
    }

    public static void push(int num) {
        stackA.add(num);
        if (stackB.empty() || num <= stackB.peek()) {
            stackB.add(num);
        }
    }

    public static void pop() {
        if (stackA.pop().equals(stackB.peek())) {
            stackB.pop();
        }
    }

    public static int min() {
        return stackB.peek();
    }

    public static int top() {
        return stackA.peek();
    }

}
