package com.company.v2.릿코드.알고리즘.medium;

public class _790 {
    public int numTilings(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            for (int j = i - 3; j >= 0; j--) {
                dp[i] = (dp[i] + 2 * dp[j]) % 1000000007;
            }
        }

        return (int) dp[n];
    }
}
