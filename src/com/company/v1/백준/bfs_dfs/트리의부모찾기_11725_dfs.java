package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725_dfs {
    static int[] parents;
    static boolean[] visit;
    static List<List<Integer>> graph;

    public static void dfs(int val) {
        visit[val] = true;

        for (int node : graph.get(val)) {
            if (!visit[node]) {
                parents[node] = val;
                dfs(node);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        parents = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }

        br.close();
    }

}
