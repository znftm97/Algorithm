package com.company.v2.릿코드.알고리즘.medium;

public class _55 {
    public boolean canJump(int[] nums) {
        int maxIdx = 0;
        for(int i = 0; i<nums.length; i++) {
            if(i > maxIdx) return false;
            maxIdx = Math.max(maxIdx, i + nums[i]);
        }

        return true;
    }
}
