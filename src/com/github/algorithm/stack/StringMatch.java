package com.github.algorithm.stack;

import java.util.Stack;

public class StringMatch {

    public static void main(String[] args) {
        String str = "{[(123)]}{}223{}";
        boolean isValid = isValid(str);
        System.out.println("是否匹配：" + isValid);
    }

    /**
     * 思路：先将{[(入栈，然后将依次)]}入栈时和站定元素比较 <br>
     *     是一对是就移除栈，最后如果栈是空的则匹配成功，否则匹配失败，其他是无效字符，不考虑
     * @param str
     * @return
     */
    private static boolean isValid(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }

        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }

            if (c == '}') {
                if ('{' == stack.peek()) {
                    stack.pop();
                }
            }

            if (c == ']') {
                if ('[' == stack.peek()) {
                    stack.pop();
                }
            }

            if (c == ')') {
                if ('(' == stack.peek()) {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }

}
