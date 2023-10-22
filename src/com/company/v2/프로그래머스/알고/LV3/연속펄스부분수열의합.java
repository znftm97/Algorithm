package com.company.v2.프로그래머스.알고.LV3;

public class 연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        int len = sequence.length;
        int[] sumA = new int[len];
        int[] sumB = new int[len];
        int n = 1;

        for(int i = 0; i<len; i++) {
            sumA[i] = sequence[i] * n;
            n *= -1;
            sumB[i] = sequence[i] * n;
        }

        long[] dpA = new long[len];
        long[] dpB = new long[len];
        dpA[0] = sumA[0];
        dpB[0] = sumB[0];
        long result = Math.max(dpA[0], dpB[0]);

        for(int i = 1; i<len; i++) {
            dpA[i] = Math.max(dpA[i - 1] + sumA[i], sumA[i]);
            dpB[i] = Math.max(dpB[i - 1] + sumB[i], sumB[i]);

            long max = Math.max(dpA[i], dpB[i]);
            result = Math.max(result, max);
        }

        return result;
    }
}
