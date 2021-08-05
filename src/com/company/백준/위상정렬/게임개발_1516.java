package com.company.백준.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임개발_1516 {
    static int result[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int indegree[] = new int[n + 1];
        ArrayList<Integer>[] al = new ArrayList[n + 1];
        int cost[] = new int[n + 1];
        result = new int[indegree.length];

        for (int i = 0; i < n + 1; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 1; i < n + 1; i++) {
            String str[] = br.readLine().split(" ");
            cost[i] = Integer.parseInt(str[0]);
            for (int j = 1; j < str.length - 1; j++) {
                int v2 = Integer.parseInt(str[j]);
                indegree[i]++;
                al[v2].add(i);
            }
        }

        topologicalSort(indegree, al, cost);

        for (int i = 1; i < n + 1; i++) {
            System.out.println(result[i]);
        }
    }

    static void topologicalSort(int indegree[], ArrayList<Integer>[] al, int cost[]) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < indegree.length; i++) {
            result[i] = cost[i];

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();

            for (Integer i : al[node]) {
                indegree[i]--;
                result[i] = Math.max(result[i], result[node] + cost[i]);

                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
    }
}
