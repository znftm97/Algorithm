package com.company.v2.릿코드.알고리즘.medium;

import java.util.*;

public class _215 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            q.add(num);
        }

        int cnt = 0;
        int result = 0;
        while (!q.isEmpty() && cnt < k) {
            result = q.poll();
            cnt++;
        }

        return result;
    }
}
