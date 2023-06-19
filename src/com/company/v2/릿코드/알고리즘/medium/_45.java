package com.company.v2.릿코드.알고리즘.medium;

public class _45 {
    public int jump(int[] nums) {
        int steps = 0, curLevelEnd = 0, nxtLevelEnd = 0;
        for(int i=0;i<nums.length;i++) {
            if(i>curLevelEnd) {
                steps++;
                curLevelEnd = nxtLevelEnd;
            }
            nxtLevelEnd = Math.max(nxtLevelEnd, i+nums[i]);
        }
        return steps;
    }
}
