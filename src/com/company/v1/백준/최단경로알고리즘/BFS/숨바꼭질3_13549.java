package com.company.v1.백준.최단경로알고리즘.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {
    private static boolean[] visit = new boolean[100001];
    private static int result = Integer.MAX_VALUE;
    private static final int MAX = 100000;

    private static class Node implements Comparable<Node>{
        int pos;
        int cost;

        public Node(int pos, int cost) {
            this.pos = pos;
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

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(start, end);
    }

    private static void bfs(int start, int end){
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            visit[node.pos] = true;

            if(node.pos == end) { // 우선순위 큐로 비용이 가장 작은거부터 꺼내므로 발견하면 바로 끝내야한다.
                System.out.println(node.cost);
                return;
            }

            if(node.pos * 2 <= MAX && !visit[node.pos * 2]) pq.add(new Node(node.pos * 2, node.cost));
            if(node.pos + 1 <= MAX && !visit[node.pos + 1]) pq.add(new Node(node.pos + 1, node.cost + 1));
            if(node.pos - 1 >= 0 && !visit[node.pos - 1]) pq.add(new Node(node.pos - 1, node.cost + 1));
        }
    }

}
