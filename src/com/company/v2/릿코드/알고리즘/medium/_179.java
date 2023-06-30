package com.company.v2.릿코드.알고리즘.medium;

import java.util.Arrays;

public class _179 {
    public String largestNumber(int[] numbers) {
        String[] nums = new String[numbers.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));


        StringBuilder sb = new StringBuilder();
        for (String s : nums) {
            sb.append(s);
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
