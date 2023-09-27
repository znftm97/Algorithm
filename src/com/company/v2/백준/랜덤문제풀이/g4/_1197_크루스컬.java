package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1197_크루스컬 {
    static int[] parents;
    static int[] ranks;
    static Queue<Node> pq = new PriorityQueue<>();

    static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
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
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        parents = new int[V + 1];
        ranks = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Node(x, y, cost));
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int parentX = find(node.x);
            int parentY = find(node.y);

            if (parentX != parentY) {
                union(parentX, parentY);
                sum += node.cost;
            }
        }

        System.out.println(sum);
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return;

        if(ranks[x] < ranks[y]) parents[y] = x;
        else parents[x] = y;

        if(ranks[x] == ranks[y]) ranks[x]++;
    }
}
