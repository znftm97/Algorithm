package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 촌수계산_2644 {
    private static boolean[] visit;
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int endDepth = 0;
    private static int result = -1;

    public static void dfs(int startDepth, int cnt) {
        visit[startDepth] = true;

        for (int node : graph.get(startDepth)) {
            if (!visit[node]) {
                if (node == endDepth) {
                    result = cnt + 1;
                    return;
                }

                dfs(node, cnt + 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        int startDepth = Integer.parseInt(st.nextToken());
        endDepth = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int depthX = Integer.parseInt(st.nextToken());
            int depthY = Integer.parseInt(st.nextToken());

            graph.get(depthX).add(depthY);
            graph.get(depthY).add(depthX);
        }

        dfs(startDepth,0);
        System.out.println(result);
        br.close();
    }

}
