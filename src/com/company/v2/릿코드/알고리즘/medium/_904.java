package com.company.v2.릿코드.알고리즘.medium;

import java.util.HashMap;
import java.util.Map;

public class _904 {
    public int totalFruit(int[] fruits) {
        int result = 0;
        Map<Integer, Integer> numCountMap = new HashMap<>();

        for (int left = 0, right = 0; right < fruits.length; ++right) {
            numCountMap.put(fruits[right], numCountMap.getOrDefault(fruits[right], 0) + 1);

            while (numCountMap.size() > 2) {
                numCountMap.put(fruits[left], numCountMap.get(fruits[left]) - 1);
                numCountMap.remove(fruits[left], 0);
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
