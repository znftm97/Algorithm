package com.company.v2.릿코드.알고리즘.medium;

import java.util.ArrayList;
import java.util.List;

public class _1519 {
    private int[] result;
    private boolean[] visit;
    private List<List<Integer>> graph = new ArrayList<>();

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        result = new int[n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        recursion(0, labels);

        return result;
    }

    private int[] recursion(int node, String labels) {
        int[] counts = new int[26];
        visit[node] = true;

        for (int nextNode : graph.get(node)) {
            if (!visit[nextNode]) {
                int[] tmp = recursion(nextNode, labels);
                for (int i = 0; i < 26; i++) {
                    counts[i] += tmp[i];
                }
            }
        }

        int count = ++counts[labels.charAt(node) - 'a'];
        result[node] = count;
        return counts;
    }
}
