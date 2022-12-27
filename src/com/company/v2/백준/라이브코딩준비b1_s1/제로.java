package com.company.v2.백준.라이브코딩준비b1_s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if (stack.isEmpty() && num == 0) {
                continue;
            }

            if (num == 0) {
                stack.pop();
            } else {
                stack.add(num);
            }
        }

        int result = 0;
        for (int num : stack) {
            result += num;
        }

        System.out.println(result);
    }

}
