package com.company.v1.백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());

            int zero = 1;
            int one = 0;
            int zeroPlusOne = 1;

            for (int j = 0; j < n; j++) {
                zero = one;
                one = zeroPlusOne;
                zeroPlusOne = zero + one;
            }

            sb.append(zero).append(" ").append(one).append("\n");
        }

        System.out.println(sb.toString());
    }
}
