package com.company.v2.프로그래머스.알고.LV3;

import java.util.*;

public class 등산코스정하기 {
    static List<List<Node>> graph = new ArrayList<>();
    static Queue<Node> pq = new PriorityQueue<>();
    static Set<Integer> summitSet = new HashSet<>();
    static int[] dist;
    static int N;

    static class Node implements Comparable<Node>{
        int id,cost;
        public Node(int id, int cost) {
            this.id=id;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        N = n;
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int summit : summits) {
            summitSet.add(summit);
        }

        for(int i = 0; i<=N; i++) {
            graph.add( new ArrayList<>());
        }

        for(int[] path : paths) {
            int x = path[0];
            int y = path[1];
            int cost = path[2];
            graph.get(x).add(new Node(y,cost));
            graph.get(y).add(new Node(x,cost));
        }

        for(int gate : gates) {
            pq.add(new Node(gate, 0));
            dist[gate] = 0;
        }

        dijkstra();

        int minCost = Integer.MAX_VALUE;
        int minNode = Integer.MAX_VALUE;
        for(int summit : summits) {
            if(minCost == dist[summit]) {
                minNode = Math.min(minNode, summit);
            } else if(minCost > dist[summit]){
                minCost = dist[summit];
                minNode = summit;
            }
        }

        return new int[]{minNode, minCost};
    }

    static void dijkstra() {
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            // 산봉우리 도착하면, 다시 되돌아갈 필요 없음
            if(dist[now.id] < now.cost || summitSet.contains(now.id)) {
                continue;
            }

            for(Node next : graph.get(now.id)) {
                int max = Math.max(dist[now.id], next.cost);
                if(dist[next.id] > max) {
                    dist[next.id] = max;
                    pq.add(new Node(next.id, max));
                }
            }
        }
    }
}
