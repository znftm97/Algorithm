package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원순회2_10971 {

    private static int[][] map;
    private static boolean[] visit;
    private static int N, sum;
    private static int result = Integer.MAX_VALUE;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            visit[i] = true;
            dfs(i, i, 0);
        }

        System.out.println(result);
    }

    private static void dfs(int start, int now, int cost) {
        if(isAbleRound(start, now)){
            result = Math.min(result, cost + map[now][0]);
            return;
        }

        for (int next = 1; next < N; next++) {
            if(visit[next] || map[now][next] == 0) continue;

            visit[next] = true;
            dfs(start, next, cost + map[now][next]);
            visit[next] = false;
        }
    }

    private static boolean isAbleRound(int start, int now){
        for (int i = 0; i < N; i++) {
            if(!visit[i] || map[now][start] == 0) return false;
        }

        return true;
    }

}
