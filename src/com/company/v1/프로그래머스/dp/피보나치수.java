package com.company.v1.프로그래머스.dp;

import java.io.IOException;

public class 피보나치수 {
    public static void main(String[] args) throws IOException {
        int n = 80000;

        int[] dp = new int[100001];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }

        System.out.println(dp[n]);
    }
}
