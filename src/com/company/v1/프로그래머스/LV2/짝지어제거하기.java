package com.company.v1.프로그래머스.LV2;

import java.util.Stack;

public class 짝지어제거하기 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
                continue;
            }

            char input = s.charAt(i);

            if (input == stack.peek()) stack.pop();
            else stack.push(input);
        }

        return stack.isEmpty() ? 1 : 0;
    }

}
