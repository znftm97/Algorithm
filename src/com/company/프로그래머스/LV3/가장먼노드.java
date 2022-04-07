package com.company.프로그래머스.LV3;

import java.util.*;

public class 가장먼노드 {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int[] dist;
    private static int N, max;

    public int solution(int n, int[][] edge) {
        int result = 0;
        dist = new int[n + 1];
        N = n;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        bfs();

        for (int num : dist) {
            if(num == max) result++;
        }

        return result;
    }

    private static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        q.add(1);
        visit[1] = true;

        while (!q.isEmpty()) {
            Integer now = q.poll();

            for (int next : graph.get(now)) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                    dist[next] = dist[now] + 1;
                    max = Math.max(max, dist[next]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        가장먼노드 c = new 가장먼노드();
        int solution = c.solution(6, vertex);
        System.out.println(solution);
    }
}
