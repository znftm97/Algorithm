package com.company.v2.릿코드.알고리즘.medium;

import java.util.Arrays;

public class _1498 {
    public int numSubseq(int[] nums, int target) {
        final int MOD = 1000000007;
        int start = 0;
        int end = nums.length - 1;
        int result = 0;
        Arrays.sort(nums);
        int[] pows = new int[nums.length];
        pows[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            pows[i] = pows[i - 1] * 2 % MOD;
        }

        while (start <= end) {
            if (nums[start] + nums[end] <= target) {
                result = (result + pows[end - start]) % MOD;
                start++;
            } else {
                end--;
            }
        }

        return result;
    }
}
