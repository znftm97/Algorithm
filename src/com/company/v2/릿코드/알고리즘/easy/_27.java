package com.company.v2.릿코드.알고리즘.easy;

import java.util.Arrays;

public class _27 {
    public int removeElement(int[] nums, int val) {
        int equalCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = Integer.MAX_VALUE;
                equalCount++;
            }
        }

        Arrays.sort(nums);

        return nums.length - equalCount;
    }
}
