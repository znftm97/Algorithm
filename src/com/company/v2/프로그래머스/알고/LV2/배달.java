package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class 배달 {

    static List<List<Node>> graph = new ArrayList<>();
    static int[] dists;

    static class Node implements Comparable<Node>{
        int id,cost;

        public Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }

    public int solution(int N, int[][] road, int K) {
        dists = new int[N + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        for(int i = 0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        dists[1] = 0;

        for(int[] route : road) {
            int x = route[0];
            int y = route[1];
            int cost = route[2];
            graph.get(x).add(new Node(y,cost));
            graph.get(y).add(new Node(x,cost));
        }

        dijkstra(1);

        int result = 0;
        for(int dist : dists) {
            if(dist <= K) {
                result++;
            }
        }

        return result;
    }

    static void dijkstra(int startNodeId) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNodeId, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(dists[now.id] < now.cost) {
                continue;
            }

            for(Node next : graph.get(now.id)) {
                if(dists[next.id] > now.cost + next.cost) {
                    dists[next.id] = now.cost + next.cost;
                    pq.add(new Node(next.id, dists[next.id]));
                }
            }
        }
    }
}
