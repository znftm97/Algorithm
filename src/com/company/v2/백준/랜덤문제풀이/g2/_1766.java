package com.company.v2.백준.랜덤문제풀이.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1766 {

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] inputNodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        inputNodes = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            inputNodes[y]++;
        }

        topologySort();
    }

    static void topologySort() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < inputNodes.length; i++) {
            if(inputNodes[i] == 0) pq.add(i);
        }

        while (!pq.isEmpty()) {
            int node = pq.poll();
            sb.append(node).append(" ");

            for (int nextNode : graph.get(node)) {
                inputNodes[nextNode]--;
                if(inputNodes[nextNode] == 0) pq.add(nextNode);
            }
        }

        System.out.println(sb);
    }
}
