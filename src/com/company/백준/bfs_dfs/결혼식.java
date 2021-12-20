package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 결혼식 {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];
        visit[1] = true;
        int cnt = 0;

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(1, 0);
        for (int i = 2; i < visit.length; i++) {
            if (visit[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int node, int depth) {
        if (depth == 2) {
            return;
        }

        for (int i = 0; i< graph.get(node).size(); i++) {
            int friend = graph.get(node).get(i);
            visit[friend] = true;
            dfs(friend, depth + 1);
        }
    }

}
