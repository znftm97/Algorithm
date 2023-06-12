package com.company.v2.릿코드.알고리즘.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int removeCount = 0;

        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (int num : arr) {
            numToCountMap.put(num, numToCountMap.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> countsQ = new PriorityQueue<>(numToCountMap.values());
        while (k > 0) {
            k -= countsQ.poll();
        }

        return k < 0 ? countsQ.size() + 1 : countsQ.size();
    }
}
