package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class 괄호회전하기 {
    static Deque<Character> dq = new ArrayDeque<>();

    public int solution(String s) {
        for(int i = 0; i<s.length(); i++) {
            dq.add(s.charAt(i));
        }

        int result = 0;
        for(int i = 0; i<s.length(); i++) {
            if(isRight()) result++;
            rotate();
        }

        return result;
    }

    static boolean isRight() {
        Stack<Character> stack = new Stack();
        Deque<Character> copyDq = new ArrayDeque<>(dq);

        while(!copyDq.isEmpty()) {
            if(stack.isEmpty()) {
                char input = copyDq.pollFirst();
                if(input == '(' || input == '[' || input == '{') {
                    stack.add(input);
                    continue;
                } else {
                    return false;
                }
            }

            char peek = stack.peek();
            char input = copyDq.pollFirst();
            if(input == '(' || input == '[' || input == '{') {
                stack.add(input);
            } else if((peek == '(' && input == ')') || (peek == '[' && input == ']') || (peek == '{' && input == '}')) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    static void rotate() {
        dq.addLast(dq.pollFirst());
    }
}
