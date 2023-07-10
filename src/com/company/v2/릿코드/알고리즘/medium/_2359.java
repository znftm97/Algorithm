package com.company.v2.릿코드.알고리즘.medium;

import java.util.*;

public class _2359 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> targetToDistanceMap = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int distance = 0;
        q.add(node1);

        while (!q.isEmpty()) {
            int node = q.poll();
            if(node == -1 || targetToDistanceMap.containsKey(node)) break;

            q.add(edges[node]);
            targetToDistanceMap.put(node, distance++);
        }

        Set<Integer> visits = new HashSet<>();
        int result = -1;
        int min = Integer.MAX_VALUE;
        distance = 0;
        q.clear();
        q.add(node2);

        while (!q.isEmpty()) {
            int node = q.poll();
            if(node == -1 || visits.contains(node)) break;

            if (targetToDistanceMap.containsKey(node)) {
                int max = Math.max(distance, targetToDistanceMap.get(node));
                if (min >= max) {
                    result = max == min ? Math.min(result, node) : node;
                    min = max;
                }
            }

            distance++;
            q.add(edges[node]);
            visits.add(node);
        }

        return result;
    }
}
