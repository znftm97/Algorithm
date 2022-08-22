package com.company.v1.백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        while (true) {
            String str = br.readLine();

            /*탈출조건*/
            if (str.length() == 1 && str.equals(".")) {
                break;
            }

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if ( (c == ']' || c == ')') && stack.empty()) { // 1. ), ] 가 들어왔는데 스택이 비어있는경우
                    stack.push('x');
                    break;
                } else if (c == ')') { // 2. )가 들어와서 스택에서 꺼낸 문자가 [ 일떄
                    Character pop = stack.pop();
                    if (pop == '[') {
                        stack.push('x');
                        break;
                    }
                } else if (c == ']') { // 3. ]가 들어와서 스택에서 꺼낸 문자가 ( 일떄
                    Character pop = stack.pop();
                    if (pop == '(') {
                        stack.push('x');
                        break;
                    }
                }
            }

            if (stack.empty()) {
                sb.append("yes").append("\n");
            }else {
                sb.append("no").append("\n");
            }

            stack.clear();
        }

        System.out.println(sb);
    }
}