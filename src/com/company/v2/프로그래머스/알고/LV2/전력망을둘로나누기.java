package com.company.v2.프로그래머스.알고.LV2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 전력망을둘로나누기 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        for(int i = 0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i = 0; i<wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            graph.get(x).remove(Integer.valueOf(y));
            graph.get(y).remove(Integer.valueOf(x));
            partitionCheck(x, y, n);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        return result;
    }

    static void partitionCheck(int x, int y, int n) {
        int nodeCnt1 = 0;
        int nodeCnt2 = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(x);
        visited[x] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            nodeCnt1++;

            for(int next : graph.get(now)) {
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        visited = new boolean[n + 1];
        q.add(y);
        visited[y] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            nodeCnt2++;

            for(int next : graph.get(now)) {
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        result = Math.min(result, Math.abs(nodeCnt1 - nodeCnt2));
    }
}
