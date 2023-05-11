package com.company.v2.릿코드.알고리즘.medium;

public class _134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = sum(gas);
        int totalCost = sum(cost);

        if(totalCost > totalGas) return -1;

        int[] sum = new int[gas.length];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = cost[i] - gas[i];
        }

        int startIdx = 0;
        int remainGas = 0;
        for (int i = 0; i < gas.length; i++) {
            remainGas += gas[i] - cost[i];

            if (remainGas < 0) {
                startIdx = i + 1;
                remainGas = 0;
            }
        }

        return startIdx;
    }

    private static int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
