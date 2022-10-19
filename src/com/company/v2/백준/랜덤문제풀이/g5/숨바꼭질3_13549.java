package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {

    private static boolean[] visit;
    private static int K;
    private static int result = Integer.MAX_VALUE;
    private static final int MAX = 100000;

    private static class Node{
        int pos;
        int time;

        public Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }

        public static Node of(int pos, int time) {
            return new Node(pos, time);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[MAX + 1];

        bfs(Node.of(N, 0));

        System.out.println(result);
    }

    private static void bfs(Node startNode) {
        Queue<Node> q = new LinkedList<>();
        q.add(startNode);

        while (!q.isEmpty()) {
            Node node = q.poll();
            visit[node.pos] = true;

            if(node.pos == K){
                result = Math.min(result, node.time);
                continue;
            }

            if(node.pos + 1 <= MAX && !visit[node.pos + 1]) {
                q.add(Node.of(node.pos + 1, node.time + 1));
            }

            if(node.pos - 1 >= 0 && !visit[node.pos - 1]) {
                q.add(Node.of(node.pos - 1, node.time + 1));
            }

            if(node.pos * 2 <= MAX && !visit[node.pos * 2]) {
                q.add(Node.of(node.pos * 2, node.time));
            }
        }
    }

}
