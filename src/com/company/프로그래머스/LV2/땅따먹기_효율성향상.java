package com.company.프로그래머스.LV2;

public class 땅따먹기_효율성향상 {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < land.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], Math.max(dp[i - 1][2], dp[i - 1][3])) + land[i][0];
            dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][2], dp[i - 1][3])) + land[i][1];
            dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3])) + land[i][2];
            dp[i][3] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])) + land[i][3];
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            result = Math.max(result, dp[dp.length - 1][i]);
        }

        return result;
    }

}
