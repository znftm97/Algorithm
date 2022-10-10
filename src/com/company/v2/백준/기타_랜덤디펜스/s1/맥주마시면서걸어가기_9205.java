package com.company.v2.백준.기타_랜덤디펜스.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class 맥주마시면서걸어가기_9205 {
    private static Queue<Node> nodes = new LinkedList<>();
    private static Queue<Node> visitedNodes = new LinkedList<>();
    private static Node endNode;

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public static Node of(int r, int c) {
            return new Node(r, c);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return r == node.r && c == node.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());
            Node startNode = Node.of(startR, startC);

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                nodes.add(Node.of(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            st = new StringTokenizer(br.readLine());
            int endR = Integer.parseInt(st.nextToken());
            int endC = Integer.parseInt(st.nextToken());
            endNode = Node.of(endR, endC);
            nodes.add(endNode);

            sb.append(bfs(startNode) ? "happy" : "sad").append("\n");

            nodes.clear();
            visitedNodes.clear();
        }

        System.out.println(sb);
    }

    private static boolean bfs(Node startNode){
        Queue<Node> q = new LinkedList<>();
        q.add(startNode);
        visitedNodes.add(startNode);

        while (!q.isEmpty()) {
            Node nowNode = q.poll();

            for (Node nextNode : nodes) {
                if (!nowNode.equals(nextNode) && isAbleVisit(nextNode) && isGo(nowNode, nextNode)) {
                    if (nextNode.equals(endNode)) {
                        return true;
                    }
                    q.add(nextNode);
                    visitedNodes.add(nextNode);
                }
            }
        }

        return false;
    };

    private static boolean isGo(Node n1, Node n2) {
        return 1000 >= Math.abs(n1.r - n2.r) + Math.abs(n1.c - n2.c);
    }

    private static boolean isAbleVisit(Node n) {
        return !visitedNodes.contains(n);
    }

}
