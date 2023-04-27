package com.company.v2.릿코드.알고리즘.easy;

import java.util.Stack;

public class _20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if(s.length() == 1) return false;

        for (int i = 0; i < s.length(); i++) {
            char input = s.charAt(i);
            if (input == '(' || input == '{' || input == '[') {
                stack.push(input);
                continue;
            }

            if(stack.isEmpty()) return false;

            char output = stack.peek();
            if ((input == ')' && output == '(') ||
                    (input == '}' && output == '{') ||
                    (input == ']' && output == '[')
            ) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
