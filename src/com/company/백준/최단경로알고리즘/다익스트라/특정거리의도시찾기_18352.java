package com.company.백준.최단경로알고리즘.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기_18352 {
    private static List<List<Node>> graph = new ArrayList<>();
    private static int[] dist;
    private static final int INF = 1000000;

    private static class Node implements Comparable<Node>{
        int id;
        int cost;

        public Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());
        int targetLineCnt = Integer.parseInt(st.nextToken());
        int startNodeId = Integer.parseInt(st.nextToken());

        dist = new int[nodeCnt + 1];
        Arrays.fill(dist, INF);
        dist[startNodeId] = 0;

        for (int i = 0; i <= nodeCnt; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Node(y, 1));
        }

        dijkstra(startNodeId);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= nodeCnt; i++) {
            if(dist[i] == targetLineCnt) sb.append(i).append("\n");
        }

        if(sb.length() == 0) System.out.println(-1);
        else System.out.println(sb);
    }

    private static void dijkstra(int startNodeId) {
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
    }

}
