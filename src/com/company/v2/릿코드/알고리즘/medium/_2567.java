package com.company.v2.릿코드.알고리즘.medium;

import java.util.Arrays;

public class _2567 {
    public int minimizeSum(int[] nums) {
        if(nums.length <= 3) return 0;

        Arrays.sort(nums);
        int a = Math.abs(nums[0] - nums[nums.length - 3]);
        int b = Math.abs(nums[2] - nums[nums.length - 1]);
        int c = Math.abs(nums[1] - nums[nums.length - 2]);

        return Math.min(a, Math.min(b, c));
    }
}
