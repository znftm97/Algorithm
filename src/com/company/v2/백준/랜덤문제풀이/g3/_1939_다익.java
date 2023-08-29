package com.company.v2.백준.랜덤문제풀이.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1939_다익 {
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;
    static int start, end;
    static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node>{
        int id, cost;

        public Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.cost, this.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        dist = new int[V + 1];
        Arrays.fill(dist, -1); // 최대값 구해야하니까 -1로 초기화

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Node(y, cost));
            graph.get(y).add(new Node(x, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(dist[end]);
    }

    static void dijkstra() {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, INF));
        dist[start] = INF;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(dist[now.id] > now.cost) continue;

            for (Node next : graph.get(now.id)) {
                int min = Math.min(now.cost, next.cost);
                if (dist[next.id] < min) {
                    dist[next.id] = min;
                    pq.add(new Node(next.id, min));
                }
            }
        }
    }
}
