package com.company.프로그래머스.LV2;

import java.util.Stack;

public class 올바른괄호 {
    public boolean solution(String msg){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);

            if(stack.isEmpty()) {
                stack.add(c);
                continue;
            }

            if(stack.peek() == '(' && c == ')') stack.pop();
            else stack.add(c);
        }

        return stack.isEmpty();
    }

}
