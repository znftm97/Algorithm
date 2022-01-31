package com.company.프로그래머스.LV2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 괄호회전하기 {
//    private static Deque<Character> brackets = new LinkedList<>();
    private static int len;
    private static String str;

    public int solution(String s) {
        int result = 0;
        str = s;
        len = s.length();

//        for (int i = 0; i < len; i++) {
//            brackets.add(s.charAt(i));
//        }

        for (int i = 0; i < len - 1; i++) {
            if(isBalance()) result++;
            str = move2();
        }

        return result;
    }

    private static boolean isBalance(){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if(c == '('){
                stack.push(c);
                continue;
            } else if(c == '{') {
                stack.push(c);
                continue;
            } else if(c == '[') {
                stack.push(c);
                continue;
            }

            if(stack.isEmpty() && (c == ']' || c == '}' || c == ')')) return false;

            if (stack.peek() == '[' && c == ']') {
                stack.pop();
                continue;
            } else if(stack.peek() == '{' && c == '}') {
                stack.pop();
                continue;
            } else if(stack.peek() == '(' && c == ')') {
                stack.pop();
                continue;
            } else stack.push(c);
        }

        return stack.isEmpty();
    }

    /*Deque를 이용하는 방법, 당연히 시간 더 오래걸림*/
//    private static String move1(){
//        brackets.addLast(brackets.pollFirst());
//        StringBuilder sb = new StringBuilder();
//
//        for (char c : brackets) {
//            sb.append(c);
//        }
//        return sb.toString();
//    }

    /*substring 이용하는 방법*/
    private static String move2(){
        return str.substring(1) + str.charAt(0);
    }

}
