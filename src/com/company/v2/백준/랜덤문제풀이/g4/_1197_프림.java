package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1197_프림 {
    static List<List<Node>> graph = new ArrayList<>();
    static int V;

    static class Node implements Comparable<Node> {
        int id, cost;

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
            graph.get(x).add(new Node(y, cost));
            graph.get(y).add(new Node(x, cost));
        }

        System.out.println(prim());
    }

    static int prim() {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        boolean[] visited = new boolean[V + 1];
        int sum = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(visited[now.id]) continue;

            visited[now.id] = true;
            sum += now.cost;

            for (Node next : graph.get(now.id)) {
                if (!visited[next.id]) {
                    pq.add(next);
                }
            }
        }

        return sum;
    }
}
