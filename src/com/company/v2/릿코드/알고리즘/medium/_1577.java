package com.company.v2.릿코드.알고리즘.medium;

import java.util.*;

public class _1577 {
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long, Integer> map1 = new HashMap<>();
        Map<Long, Integer> map2 = new HashMap<>();
        int result = 0;

        for(int i = 0; i<nums1.length-1; i++) {
            for(int j = i + 1; j<nums1.length; j++) {
                long num = (long) nums1[i] * nums1[j];
                map1.put(num, map1.getOrDefault(num, 0) + 1);
            }
        }

        for (int i = 0; i < nums2.length - 1; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                long num = (long) nums2[i] * nums2[j];
                map2.put(num, map2.getOrDefault(num, 0) + 1);
            }
        }

        for(int num : nums1) {
            long squareNum = (long) num * num;
            if(map2.containsKey(squareNum)) result += map2.get(squareNum);
        }

        for(int num : nums2) {
            long squareNum = (long) num * num;
            if(map1.containsKey(squareNum)) result += map1.get(squareNum);
        }

        return result;
    }

}
