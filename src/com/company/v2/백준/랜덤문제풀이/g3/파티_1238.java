package com.company.v2.백준.랜덤문제풀이.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티_1238 {

    private static int N, M, X;
    private static final int INF = Integer.MAX_VALUE;

    private static class Node implements Comparable<Node>{
        int id;
        int cost;

        public Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        private static Node of(int id, int cost) {
            return new Node(id, cost);
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        List<List<Node>> reverseGraph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(x).add(Node.of(y, cost));
            reverseGraph.get(y).add(Node.of(x, cost));
        }

        int[] dist = dijkstra(Node.of(X, 0), graph);
        int[] reverseDist = dijkstra(Node.of(X, 0), reverseGraph);
        int result = 0;

        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dist[i] + reverseDist[i]);
        }

        System.out.println(result);
    }

    private static int[] dijkstra(Node startNode, List<List<Node>> graph) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(startNode);

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[startNode.id] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.cost > dist[now.id]) continue;

            for (Node next : graph.get(now.id)) {
                if (dist[next.id] > now.cost + next.cost) {
                    dist[next.id] = now.cost + next.cost;
                    pq.add(Node.of(next.id, dist[next.id]));
                }
            }
        }

        return dist;
    }

}
