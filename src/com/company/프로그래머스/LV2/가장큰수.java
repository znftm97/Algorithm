package com.company.프로그래머스.LV2;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class 가장큰수 {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, (n1, n2) -> Integer.compare(parseInt(n2 + n1), parseInt(n1 + n2)));
        //Arrays.sort(nums, (o1, o2) -> (o2+o1).compareTo(o1+o2))
        if(nums[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : nums) {
            sb.append(s);
        }

        return sb.toString();
    }

}
