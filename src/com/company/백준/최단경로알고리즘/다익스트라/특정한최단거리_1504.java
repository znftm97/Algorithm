package com.company.백준.최단경로알고리즘.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정한최단거리_1504 {
    private static List<List<Node>> graph;
    private static final int INF = 2000000; // 간선 최대값 * 가중치 최대값
    private static int nodeCnt;

    private static class Node implements Comparable<Node>{
        int id;
        int cost;

        public Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nodeCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= nodeCnt; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Node(y, cost));
            graph.get(y).add(new Node(x, cost));
        }

        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int result1 = 0;
        result1 += dijkstra(1, n1);
        result1 += dijkstra(n1, n2);
        result1 += dijkstra(n2, nodeCnt);

        int result2 = 0;
        result2 += dijkstra(1, n2);
        result2 += dijkstra(n2, n1);
        result2 += dijkstra(n1, nodeCnt);

        if(result1 >= INF && result2 >= INF) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.min(result1, result2));
    }

    private static int dijkstra(int startNodeId, int endNodeId) {
        int[] dist = new int[nodeCnt + 1];
        Arrays.fill(dist, INF);
        dist[startNodeId] = 0;

        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNodeId, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if(dist[now.id] < now.cost) continue;

            for (Node next : graph.get(now.id)) {
                if (dist[next.id] > now.cost + next.cost) {
                    dist[next.id] = now.cost + next.cost;
                    pq.add(new Node(next.id, dist[next.id]));
                }
            }
        }

        return dist[endNodeId];
    }

}
