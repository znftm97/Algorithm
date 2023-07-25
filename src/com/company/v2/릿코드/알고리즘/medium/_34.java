package com.company.v2.릿코드.알고리즘.medium;

public class _34 {
    public int[] searchRange(int[] nums, int target) {
        int[] results = new int[]{-1,-1};
        if(nums.length == 0) return results;

        int start = 0;
        int end = nums.length - 1;
        int min = nums.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                end = mid - 1;
                min = Math.min(min, mid);
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if(min != nums.length) results[0] = min;

        start = 0;
        end = nums.length - 1;
        int max = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                start = mid + 1;
                max = Math.max(max, mid);
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if(max != -1) results[1] = max;

        return results;
    }
}
