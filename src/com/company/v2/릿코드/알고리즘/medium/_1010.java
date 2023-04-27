package com.company.v2.릿코드.알고리즘.medium;

import java.util.HashMap;
import java.util.Map;

public class _1010 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < time.length; i++) {
            int rest = time[i] % 60;
            int target = 60 - rest;

            if (map.containsKey(target)) {
                result += map.get(target);
            }

            if (rest != 0) {
                map.put(rest, map.getOrDefault(rest, 0) + 1);
            } else {
                map.put(60, map.getOrDefault(60, 0) + 1);
            }
        }

        return result;
    }
}
