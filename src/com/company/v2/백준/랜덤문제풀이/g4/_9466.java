package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9466 {
    static int[] nodes;
    static boolean[] visited, checked;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            result = 0;
            int N = Integer.parseInt(br.readLine());
            nodes = new int[N + 1];
            visited = new boolean[N + 1];
            checked = new boolean[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                nodes[i] = Integer.parseInt(st.nextToken());
                if (i == nodes[i]) {
                    result++;
                    checked[i] = true;
                }
            }

            for (int i = 1; i <= N; i++) {
                dfs(i);
            }

            System.out.println(N - result);
        }
    }

    static void dfs(int node) {
        if(checked[node]) {
            return;
        }

        if (visited[node]) {
            result++;
            checked[node] = true;
        }

        visited[node] = true;
        dfs(nodes[node]);
        visited[node] = false;
        checked[node] = true;
    }
}
