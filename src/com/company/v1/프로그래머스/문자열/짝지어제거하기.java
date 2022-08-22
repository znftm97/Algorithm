package com.company.v1.프로그래머스.문자열;

import java.util.Stack;

public class 짝지어제거하기 {
    public int solution(String s){
        Stack<String> stack = new Stack<>();
        String[] arr = s.split("");

        stack.add(arr[0]);

        for (int i = 1; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(arr[i]);
                continue;
            }
            if (stack.peek().equals(arr[i])) {
                stack.pop();
            } else {
                stack.push(arr[i]);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
