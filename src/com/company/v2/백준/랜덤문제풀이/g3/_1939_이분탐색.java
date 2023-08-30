package com.company.v2.백준.랜덤문제풀이.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1939_이분탐색 {
    static List<List<Node>> graph = new ArrayList<>();
    static int V,E,source, destination;

    static class Node {
        int id;
        int weight;

        public Node(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Node(y, weight));
            graph.get(y).add(new Node(x, weight));
        }

        st = new StringTokenizer(br.readLine());
        source = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean canArrive = bfs(mid);

            if(canArrive) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(end);
    }

    static boolean bfs(int mid) {
        boolean[] visited = new boolean[V + 1];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(source, 0));
        visited[source] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            if(now.id == destination) return true;

            for (Node next : graph.get(now.id)) {
                if (mid <= next.weight && !visited[next.id]) {
                    q.add(next);
                    visited[next.id] = true;
                }
            }
        }

        return false;
    }
}
