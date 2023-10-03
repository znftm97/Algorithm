package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        long[][] dp = new long[N - 1][21];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][nums[0]] = 1;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if(j + nums[i] <= 20) dp[i][j] += dp[i - 1][j + nums[i]];
                if(j - nums[i] >= 0) dp[i][j] += dp[i - 1][j - nums[i]];
            }
        }

        System.out.println(dp[N - 2][nums[N - 1]]);
    }
}
