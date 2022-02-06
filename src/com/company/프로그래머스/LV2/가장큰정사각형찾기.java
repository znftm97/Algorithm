package com.company.프로그래머스.LV2;

public class 가장큰정사각형찾기 {
    public int solution(int[][] board){
        int maxLen = 0;
        int[][] dp = new int[board.length + 1][board[0].length + 1];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dp[i + 1][j + 1] = board[i][j];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (dp[i][j] == 1) {
                    int left = dp[i][j - 1];
                    int up = dp[i - 1][j];
                    int leftUp = dp[i - 1][j - 1];

                    int min = Math.min(left, Math.min(up, leftUp));
                    dp[i][j] = min + 1;
                    maxLen = Math.max(maxLen, min + 1);
                }
            }
        }

        return maxLen * maxLen;
    }

}
