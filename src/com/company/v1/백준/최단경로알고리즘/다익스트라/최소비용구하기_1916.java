package com.company.v1.백준.최단경로알고리즘.다익스트라;

import java.io.*;
import java.util.*;

public class 최소비용구하기_1916 {
    private static List<List<Node>> graph;
    private static int[] dist;
    private static final int INF = Integer.MAX_VALUE;

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
        StringTokenizer st;

        int nodeCnt = Integer.parseInt(br.readLine());
        int lineCnt = Integer.parseInt(br.readLine());

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
        }

        st = new StringTokenizer(br.readLine());
        int startNodeId = Integer.parseInt(st.nextToken());
        int endNodeId = Integer.parseInt(st.nextToken());

        dist = new int[nodeCnt + 1];
        Arrays.fill(dist, INF);
        dist[startNodeId] = 0;

        dijkstra(startNodeId);

        System.out.println(dist[endNodeId]);
    }

    private static void dijkstra(int startNodeId){
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNodeId, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(dist[now.id] < now.cost) continue;

            for (Node next : graph.get(now.id)) {
                if(dist[next.id] > now.cost + next.cost){
                    dist[next.id] = now.cost + next.cost;
                    pq.add(new Node(next.id, dist[next.id]));
                }
            }
        }
    }

}
