package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int num = 1;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c == '(') {
                stack.push(c);
                num *= 2; // 언젠간 닫히므로 열릴때 무조건 계산
            } else if (c == '[') {
                stack.push(c);
                num *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') exit();

                if(chars[i-1] == '(') result += num; // 처음으로 닫히는 구간을 만났을때만, 지금껏 계산한걸 결과값에 반영
                stack.pop();
                num /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') exit();

                if(chars[i-1] == '[') result += num;
                stack.pop();
                num /= 3;
            }
        }

        if(!stack.isEmpty()) exit();
        System.out.println(result);
    }

    static void exit() {
        System.out.println(0);
        System.exit(0);
    }
}
