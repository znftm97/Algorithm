package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1922 {
    static int N;
    static int[] parents;
    static int[] ranks;
    static Queue<Connection> pq = new PriorityQueue<>();

    static class Connection implements Comparable<Connection> {
        int x, y, cost;

        public Connection(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Connection o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        ranks = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        for(int i = 0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Connection(x, y, cost));
        }

        int result = 0;
        while (!pq.isEmpty()) {
            Connection connection = pq.poll();
            int x = connection.x;
            int y = connection.y;
            if (find(x) != find(y)) {
                union(x, y);
                result += connection.cost;
            }
        }

        System.out.println(result);
    }

    static int find(int x) {
        if(x == parents[x]) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            return;
        }

        if(ranks[x] < ranks[y]) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }

        if(ranks[x] == ranks[y]) {
            ranks[x]++;
        }
    }
}
