package com.company.v2.코드트리.LV4.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사각형_채우기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i <= N; i++) {
            dp[i] = (2 * dp[i - 1] + 3 * dp[i - 2]) % 1000000007;
            for (int j = i - 3; j >= 0; j--) {
                dp[i] = (dp[i] + 2 * dp[j]) % 1000000007;
            }
        }

        System.out.println(dp[N]);
    }

}
