package com.company.v1.백준.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악프로그램_2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] indegree = new int[n + 1];
        int[][] graph = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int point1 = Integer.parseInt(st.nextToken());

            for (int j = 0; j < count-1; j++) {
                int point2 = Integer.parseInt(st.nextToken());
                if (graph[point1][point2] == 0) {
                    graph[point1][point2] = 1;
                    indegree[point2]++;
                }

                point1 = point2;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append("\n");

            for (int i = 1; i <= n; i++) {
                if (graph[node][i] == 1) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (indegree[i] != 0) {
                sb.setLength(0);
                sb.append(0);
            }
        }

        System.out.println(sb);
    }
}
