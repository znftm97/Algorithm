package com.company.v1.백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < N; i++) {

            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if (c == '(') {
                    stack.push(c);
                } else if (stack.empty()) {
                    /*여기서 빌더에 NO를 추가하던, break문으로 그냥 탈출하던 스택이 비어있기 때문에 아래 조건문에서 YES가 빌더에 추가됨
                      래서 임의이 문자를 추가 후 break로 반복문 탈출하면 아래 조건문에서 NO를 빌더에 추가함*/
                    stack.push('x');
                    break;
                } else {
                    stack.pop();
                }
            }

            if (stack.empty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
            stack.clear();
        }

        System.out.println(sb);
    }
}
