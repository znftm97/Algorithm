package com.company.백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 내 점화식 : dp[i] = dp[i - 1] + dp[i - 5];
 * 다른 점화식 : dp[i] = dp[n-2] + dp[n-3]; 피보나치 수열과 비슷하다.
 * 주의할점은 수가 크기때문에 long타입을 사용해야 한다.
 * */
public class 파도반수열_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());
        long[] dp = new long[102];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;

        for (int t = 0; t < testcase; t++) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 5; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 5];
            }

            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}
