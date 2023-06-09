package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _14567 {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int[] indegree;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            indegree[y]++;
        }

        System.out.println(topology());
    }

    private static String topology() {
        Queue<Integer> zeroNodes = new LinkedList<>();
        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                zeroNodes.add(i);
                result[i] = 1;
            }
        }

        while (!zeroNodes.isEmpty()) {
            int node = zeroNodes.poll();

            for (int target : graph.get(node)) {
                indegree[target]--;

                if (indegree[target] == 0) {
                    zeroNodes.add(target);
                    result[target] = result[node] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }

        return sb.toString();
    }
}
