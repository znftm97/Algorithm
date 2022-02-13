package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 침투_13565_dfs {
    private static int[][] map;
    private static boolean[][] visit;
    private static int R, C;
    private static boolean flag = false;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j) - 48;
            }
        }

        for (int i = 0; i < C; i++) {
            if(flag) break;
            else if (map[0][i] == 0) {
                visit = new boolean[R][C];
                dfs(0, i);
            }
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void dfs(int r, int c){
        if (isArriveInner(r)) {
            flag = true;
            return;
        }

        visit[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isAbleArea(nr, nc) && isNotVisit(nr, nc) && isZero(nr, nc)) {
                dfs(nr, nc);
            }
        }
    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static boolean isNotVisit(int r, int c) {
        return !visit[r][c];
    }

    private static boolean isZero(int r, int c){
        return map[r][c] == 0;
    }

    private static boolean isArriveInner(int r) {
        return r == R - 1;
    }

}
