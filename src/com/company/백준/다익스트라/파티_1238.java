package com.company.백준.다익스트라;

import java.io.*;
import java.util.*;

public class 파티_1238 {
    private static final int INF = Integer.MAX_VALUE;
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
        int nodeId = Integer.parseInt(st.nextToken());

        List<List<Node>> graph; // X 노드에서 자기 노드로 되돌아가는 그래프
        List<List<Node>> reversGraph; // 자기 노드에서 X 노드로 가는 그래프

        graph = new ArrayList<>();
        reversGraph = new ArrayList<>();
        for (int i = 0; i <= nodeCnt; i++) {
            graph.add(new ArrayList<>());
            reversGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Node(y, cost));
            reversGraph.get(y).add(new Node(x, cost));
        }

        int[] dist = dijkstra(nodeId, graph);
        int[] reverseDist = dijkstra(nodeId, reversGraph);

        int result = 0;
        for (int i = 1; i <= nodeCnt; i++) {
            result = Math.max(result, dist[i] + reverseDist[i]);
        }

        System.out.println(result);
    }

    private static int[] dijkstra(int nodeId, List<List<Node>> graph) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(nodeId, 0));

        int[] dist = new int[nodeCnt + 1];
        Arrays.fill(dist, INF);
        dist[nodeId] = 0;

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

        return dist;
    }
}
