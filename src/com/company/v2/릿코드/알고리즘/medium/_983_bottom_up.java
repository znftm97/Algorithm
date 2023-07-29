package com.company.v2.릿코드.알고리즘.medium;

public class _983_bottom_up {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];

        int idx = 0;
        for (int nowDay = 1; nowDay <= lastDay; nowDay++) {
            if (nowDay < days[idx]) {
                dp[nowDay] = dp[nowDay - 1];
                continue;
            }

            idx++;
            int one = costs[0] + dp[nowDay - 1];
            int seven = costs[1] + dp[Math.max(nowDay - 7, 0)];
            int thirty = costs[2] + dp[Math.max(nowDay - 30, 0)];
            dp[nowDay] = Math.min(one, Math.min(seven, thirty));
        }

        return dp[lastDay];
    }
}
