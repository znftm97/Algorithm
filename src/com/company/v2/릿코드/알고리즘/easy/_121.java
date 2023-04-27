package com.company.v2.릿코드.알고리즘.easy;

public class _121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);

            int diff = prices[i] - min;
            result = Math.max(result, diff);
        }

        return result;
    }

}
