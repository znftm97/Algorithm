package com.company.v2.백준.랜덤문제풀이.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _2644 {
    private static List<List<Integer>> grpah = new ArrayList<>();
    private static boolean[] visited;
    private static int result = -1;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            grpah.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            grpah.get(x).add(y);
            grpah.get(y).add(x);
        }

        dfs(start, end, 1);

        System.out.println(result);
    }

    private static void dfs(int start, int end, int cnt) {
        visited[start] = true;

        for (int node : grpah.get(start)) {
            if(visited[node]) continue;

            if(node == end) {
                result = cnt;
                return;
            }

            dfs(node, end, cnt + 1);
        }
    }
}
