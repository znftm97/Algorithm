package com.company.v2.릿코드.알고리즘.medium;

import java.util.Arrays;

public class _1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int[] accumulateSums = new int[costs.length + 1];

        for (int i = 1; i < accumulateSums.length; i++) {
            accumulateSums[i] = accumulateSums[i-1] + costs[i-1];
        }

        for (int i = 0; i < accumulateSums.length; i++) {
            if(accumulateSums[i] > coins) return i-1;
        }

        return costs.length;
    }
}
