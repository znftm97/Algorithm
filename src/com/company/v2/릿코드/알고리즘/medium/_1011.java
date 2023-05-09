package com.company.v2.릿코드.알고리즘.medium;

public class _1011 {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = Integer.MIN_VALUE, totalWeight = 0;

        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }

        int left = maxWeight, right = totalWeight;

        while (left < right) {
            int mid = (left + right) / 2;
            int day = 1, sum = 0;

            for (int weight : weights) {
                if (sum + weight > mid) {
                    day++;
                    sum = 0;
                }
                sum += weight;
            }

            if (day > days) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left;
    }
}
