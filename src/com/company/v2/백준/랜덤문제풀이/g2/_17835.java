package com.company.v2.백준.랜덤문제풀이.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17835 {
    static List<List<Node>> graph = new ArrayList<>();
    static long[] dist;
    static int V,E,K;

    static class Node implements Comparable<Node>{
        int id;
        long cost;

        public Node(int id, long cost) {
            this.id = id;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost,o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new long[V + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        for(int i = 0; i<=V; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(y).add(new Node(x,cost));
        }

        st = new StringTokenizer(br.readLine());
        List<Node> targets = new ArrayList<>();
        while(st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());
            targets.add(new Node(target, 0));
            dist[target] = 0;
        }

        dijkstra(targets);

        long max = 0;
        int idx = 0;
        for (int i = 1; i < dist.length; i++) {
            if (max < dist[i]) {
                max = dist[i];
                idx = i;
            }
        }

        System.out.println(idx);
        System.out.println(max);
    }

    static void dijkstra(List<Node> targets) {
        Queue<Node> pq = new PriorityQueue<>(targets);

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(dist[now.id] < now.cost) {
                continue;
            }

            for(Node next : graph.get(now.id)) {
                if(dist[next.id] > now.cost + next.cost) {
                    dist[next.id] = now.cost + next.cost;
                    pq.add(new Node(next.id, dist[next.id]));
                }
            }
        }
    }
}
