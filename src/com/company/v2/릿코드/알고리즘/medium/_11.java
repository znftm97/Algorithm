package com.company.v2.릿코드.알고리즘.medium;

public class _11 {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int area = width * height;
            maxArea = Math.max(maxArea, area);

            if (heights[left] < heights[right]) left++;
            else right--;
        }

        return maxArea;
    }
}
