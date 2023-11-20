package com.company.v2.백준.랜덤문제풀이.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2623 {
    static int[] indegree;
    static List<List<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cnt - 1; j++) {
                int nextNode = Integer.parseInt(st.nextToken());
                graph.get(node).add(nextNode);
                indegree[nextNode]++;
                node = nextNode;
            }
        }

        topologySort();
        System.out.println(sb);
    }

    static void topologySort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append("\n");

            for (int nextNode : graph.get(node)) {
                indegree[nextNode]--;

                if (indegree[nextNode] == 0) {
                    q.add(nextNode);
                }
            }
        }

        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] != 0) {
                sb.setLength(0);
                sb.append(0);
            }
        }
    }
}
