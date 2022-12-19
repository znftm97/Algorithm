package com.company.v1.백준.최단경로알고리즘.다익스트라;

import java.io.*;
import java.util.*;

public class 최단경로_1753 {
    private static int[] dist;
    private static List<List<Node>> graph;
    private static final int INF = Integer.MAX_VALUE;

    private static class Node implements Comparable<Node>{
        int id; // 노드의 식별자
        int cost; // 연결된 노드 간선의 비용 (특정 노드에서 -> 현재 노드로 오는 비용)

        public Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) { // 우선순위큐에서 비용이 작은거부터 꺼내기위해 정렬
            return Integer.compare(this.cost, n.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());
        int startNodeId = Integer.parseInt(br.readLine());

        dist = new int[nodeCnt + 1];
        Arrays.fill(dist, INF);
        dist[startNodeId] = 0;

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

        dijkstra(startNodeId);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= nodeCnt; i++) {
            if (dist[i] == INF) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void dijkstra(int startNodeId) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNodeId, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(dist[now.id] < now.cost) continue; // 현재 비용이 dist에 저장된 비용보다 크면 갱신 x (최단경로가 아닌경우)

            for (Node next : graph.get(now.id)) { // 현재 노드에서 갈 수 있는 노드들 모두 검사
                if (dist[next.id] > now.cost + next.cost) { // 새로 구한 비용이 더 적을경우 갱신 (최단경로인 경우)
                    dist[next.id] = now.cost + next.cost;
                    pq.add(new Node(next.id, dist[next.id]));
                }
            }
        }
    }

}
