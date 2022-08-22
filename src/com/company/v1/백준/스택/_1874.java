package com.company.v1.백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int cur = 0;

        while (N-- > 0) {
            int val = Integer.parseInt(br.readLine());

            if (val > cur) {
                for (int i = cur + 1; i <= val; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                cur = val;
            } else if (stack.peek() != val) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append('\n');
        }

        System.out.println(sb);
    }
}
