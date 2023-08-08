package com.company.v2.릿코드.알고리즘.medium;

public class _72 {
    public int minDistance(String word1, String word2) {
        int aLen = word1.length();
        int bLen = word2.length();
        int[][] dp = new int[aLen + 1][bLen + 1];

        for (int i = 1; i <= aLen; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= bLen; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[aLen][bLen];
    }
}
