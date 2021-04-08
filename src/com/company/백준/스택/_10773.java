package com.company.백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] stack = new int[k];
        int cur = 0;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            int val = Integer.parseInt(br.readLine());

            if (val == 0) {
                stack[--cur] = 0;
            }else {
                stack[cur] = val;
                cur++;
            }
        }

        for (int i = 0; i <= cur; i++) {
            sum += stack[i];
        }
        System.out.println(sum);
    }
}
