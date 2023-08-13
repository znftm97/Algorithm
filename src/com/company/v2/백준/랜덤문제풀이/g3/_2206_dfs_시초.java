package com.company.v2.백준.랜덤문제풀이.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2206_dfs_시초 {
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int R, C;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }

        dfs(0, 0, 1, false);

        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    private static void dfs(int r, int c, int distance, boolean isRemoveWall) {
        if (r == R - 1 && c == C - 1) {
            result = Math.min(result, distance);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isInArea(nr, nc) && isNotVisit(nr, nc)) {
                visited[nr][nc] = true;
                if (map[nr][nc] == '1' && !isRemoveWall) {
                    dfs(nr, nc, distance + 1, true);
                } else if (map[nr][nc] == '0') {
                    dfs(nr, nc, distance + 1, isRemoveWall);
                }
                visited[nr][nc] = false;
            }
        }
    }

    private static boolean isInArea(int r, int c) {
        return r < R && c < C && r >= 0 && c >= 0;
    }

    private static boolean isNotVisit(int r, int c) {
        return !visited[r][c];
    }

}
