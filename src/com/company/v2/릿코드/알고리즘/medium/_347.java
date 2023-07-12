package com.company.v2.릿코드.알고리즘.medium;

import java.util.*;

public class _347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCntMap = new HashMap<>();

        for (int num : nums) {
            numToCntMap.put(num, numToCntMap.getOrDefault(num, 1) + 1);
        }

        Queue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(numToCntMap::get));

        for (int key : numToCntMap.keySet()) {
            q.add(key);
            if(q.size() > k) q.poll();
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = q.poll();
        }

        return result;
    }
}
