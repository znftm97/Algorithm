package com.company.v2.릿코드.알고리즘.medium;

import java.util.Stack;

public class _227 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int num = 0;
        char operator = '+';

        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                num = num * 10 + chars[i] - '0';
            }

            if (!Character.isDigit(chars[i]) && chars[i] != ' ' || i == chars.length - 1) {
                if (operator == '+') stack.push(num);
                else if (operator == '-') stack.push(num * -1);
                else if (operator == '*') stack.push(stack.pop() * num);
                else if (operator == '/') stack.push(stack.pop() / num);
                operator = chars[i];
                num = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
