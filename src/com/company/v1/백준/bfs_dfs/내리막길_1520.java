package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내리막길_1520 {
    private static int[][] map, dp;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};
    private static int N, M;

    private static class Point{
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int dfs(Point point) {
        if (point.r == N - 1 && point.c == M - 1) { // 도착
            return 1;
        }

        if (dp[point.r][point.c] != -1) { // 이미 방문한 경우
            return dp[point.r][point.c];
        } else {
            dp[point.r][point.c] = 0;

            for (int i = 0; i < 4; i++) {
                int nr = point.r + dr[i];
                int nc = point.c + dc[i];

                if (notEscape(nr, nc) && isLow(nr, nc, point)) {
                    dp[point.r][point.c] += dfs(new Point(nr, nc));
                }
            }
        }

        return dp[point.r][point.c];
    }

    private static boolean notEscape(int nr, int nc){
        if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
            return true;
        }

        return false;
    }

    private static boolean isLow(int nr, int nc, Point beforePoint){
        if (map[nr][nc] < map[beforePoint.r][beforePoint.c]) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(new Point(0,0)));
        br.close();
    }
}
