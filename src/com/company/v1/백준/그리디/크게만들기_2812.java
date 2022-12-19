package com.company.v1.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 크게만들기_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        Stack<Integer> stack = new Stack<>();
        stack.push(s.charAt(0) - '0');

        int cnt = 0;
        for (int i = 1; i < N; i++) {
            int num = s.charAt(i) - '0';

            while (!stack.isEmpty() && cnt < K) {
                if (stack.peek() < num) {
                    stack.pop();
                    cnt++;
                } else {
                    break;
                }
            }
            stack.push(num);
        }

        for (int i = 0; i < N - K; i++) {
            sb.append(stack.get(i));
        }

        System.out.println(sb);
        br.close();
    }

}
