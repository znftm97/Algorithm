package com.company.v2.릿코드.알고리즘.medium;

import java.util.ArrayList;
import java.util.List;

public class _1493 {
    public int longestSubarray(int[] nums) {
        final int PLUS = -1;
        boolean nonZero = true;
        boolean nonOne = true;
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if(num == 0) nonZero = false;
            else nonOne = false;
        }

        if(nonOne) return 0;

        int oneCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                oneCnt++;
            } else {
                if (oneCnt > 0) {
                    list.add(oneCnt);
                    oneCnt = 0;
                }

                if (i != 0 && i != nums.length - 1 && nums[i - 1] == 1 && nums[i + 1] == 1) {
                    list.add(PLUS);
                }
            }
        }

        if (oneCnt > 0) {
            list.add(oneCnt);
        }

        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == PLUS) result = Math.max(result, list.get(i - 1) + list.get(i + 1));
            else result = Math.max(result, list.get(i));
        }

        return nonZero ? result - 1 : result;
    }
}
