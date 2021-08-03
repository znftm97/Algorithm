package com.company.프로그래머스.dp;

import java.io.IOException;

public class 정수삼각형 {
    public static void main(String[] args) throws IOException {
        int[][] arr = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        int[][] dp = new int[arr.length][arr.length];

        dp[0][0] = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + arr[i][j]);
                dp[i][j + 1] = dp[i - 1][j] + arr[i][j + 1];
            }
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(dp[dp.length - 1][i], max);
        }

        System.out.println(max);
    }
}
