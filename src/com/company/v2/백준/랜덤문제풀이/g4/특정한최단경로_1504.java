package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정한최단경로_1504 {
    private static List<List<Node>> graph = new ArrayList<>();
    private static final int INF = 2000000;
    private static int V;

    private static class Node implements Comparable<Node>{
        int id;
        int cost;

        public Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        public static Node of(int id, int cost) {
            return new Node(id, cost);
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(x).add(Node.of(y, cost));
            graph.get(y).add(Node.of(x, cost));
        }

        st = new StringTokenizer(br.readLine());
        int middleNode1 = Integer.parseInt(st.nextToken());
        int middleNode2 = Integer.parseInt(st.nextToken());

        int result1 = 0;
        result1 += dijkstra(1, middleNode1);
        result1 += dijkstra(middleNode1, middleNode2);
        result1 += dijkstra(middleNode2, V);

        int result2 = 0;
        result2 += dijkstra(1, middleNode2);
        result2 += dijkstra(middleNode2, middleNode1);
        result2 += dijkstra(middleNode1, V);

        if(result1 >= INF && result2 >= INF) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.min(result1, result2));
    }

    private static int dijkstra(int startNode, int endNode) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[startNode] = 0;

        Queue<Node> pq = new PriorityQueue<>();
        pq.add(Node.of(startNode, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if(dist[now.id] < now.cost) continue;

            for (Node next : graph.get(now.id)) {
                if (dist[next.id] > now.cost + next.cost) {
                    dist[next.id] = now.cost + next.cost;
                    pq.add(Node.of(next.id, dist[next.id]));
                }
            }
        }

        return dist[endNode];
    }

}
