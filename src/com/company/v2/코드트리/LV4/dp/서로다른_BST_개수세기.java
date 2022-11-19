package com.company.v2.코드트리.LV4.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 서로다른_BST_개수세기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            int sum = 0;

            for (int j = 0; j < i; j++) {
                sum += dp[j] * dp[i - 1 - j];
            }

            dp[i] = sum;
        }

        System.out.println(dp[N]);
    }

}
