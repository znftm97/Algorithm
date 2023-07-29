package com.company.v2.릿코드.알고리즘.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _983_top_down {
    private Set<Integer> travelDays = new HashSet<>();

    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        Arrays.fill(dp, -1);

        for (int day : days) {
            travelDays.add(day);
        }

        return recursion(dp, days, costs, 1);
    }

    private int recursion(int[] dp, int[] days, int[] costs, int nowDay) {
        if (nowDay > days[days.length - 1]) {
            return 0;
        }

        if (!travelDays.contains(nowDay)) {
            return recursion(dp, days, costs, nowDay + 1);
        }

        if (dp[nowDay] != -1) {
            return dp[nowDay];
        }

        int one = costs[0] + recursion(dp, days, costs, nowDay + 1);
        int seven = costs[1] + recursion(dp, days, costs, nowDay + 7);
        int thirty = costs[2] + recursion(dp, days, costs, nowDay + 30);

        dp[nowDay] = Math.min(one, Math.min(seven, thirty));
        return dp[nowDay];
    }
}
