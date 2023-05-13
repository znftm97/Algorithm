package com.company.v2.릿코드.알고리즘.medium;

import java.util.Arrays;

public class _1626 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;
        int[][] team = new int[len][2];
        for (int i = 0; i < len; i++) {
            team[i][0] = ages[i];
            team[i][1] = scores[i];
        }

        Arrays.sort(team, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int[] dp = new int[len];
        dp[0] = team[0][1];

        for (int i = 1; i < len; i++) {
            int max = team[i][1];
            for (int j = 0; j < i; j++) {
                if (team[i][1] >= team[j][1]) {
                    max = Math.max(max, dp[j] + team[i][1]);
                }
            }
            dp[i] = max;
        }

        int res = 0;
        for (int num : dp) {
            res = Math.max(res, num);
        }

        return res;
    }
}
