package com.company.v2.릿코드.알고리즘.medium;

import java.util.Arrays;

public class _322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int am = 1; am <= amount; am++) {
            for (int coin : coins) {
                if (am >= coin && dp[am - coin] != -1) {
                    dp[am] = dp[am] == -1 ? dp[am - coin] + 1 : Math.min(dp[am], dp[am - coin] + 1);
                }
            }
        }

        return dp[amount];
    }

}
