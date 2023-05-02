package com.company.v2.릿코드.알고리즘.medium;

import java.util.HashMap;
import java.util.Map;

public class _2244 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (int task : tasks) {
            numToCountMap.put(task, numToCountMap.getOrDefault(task, 0) + 1);
        }

        int result = 0;
        for (int count : numToCountMap.values()) {
            if(count == 1) return -1;
            else if(count % 3 == 0) result += count / 3;
            else if(count % 3 == 1 || count% 3 == 2) result += (count / 3) + 1;
            else return -1;
        }

        return result;
    }
}
