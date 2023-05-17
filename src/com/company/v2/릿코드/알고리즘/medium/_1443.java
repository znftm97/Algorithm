package com.company.v2.릿코드.알고리즘.medium;

import java.util.ArrayList;
import java.util.List;

public class _1443 {
    private List<List<Integer>> grpah = new ArrayList<>();

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        for (int i = 0; i < n; i++) {
            grpah.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            grpah.get(edge[0]).add(edge[1]);
            grpah.get(edge[1]).add(edge[0]);
        }

        return recursion(0, 0, hasApple);
    }

    private int recursion(int idx, int parent, List<Boolean> hasApples) {
        int total = 0;

        for (int nextIdx : grpah.get(idx)) {
            if(nextIdx == parent) continue;
            total += recursion(nextIdx, idx, hasApples);
        }

        if (idx != 0 && (hasApples.get(idx) || hasAppleByChild(total))) {
            total += 2;
        }

        return total;
    }

    private boolean hasAppleByChild(int total) {
        return total > 0;
    }
}
