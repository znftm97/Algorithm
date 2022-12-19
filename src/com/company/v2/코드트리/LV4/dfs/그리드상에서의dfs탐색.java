package com.company.v2.코드트리.LV4.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 그리드상에서의dfs탐색 {
    private static final int SNAKE = 0;
    private static int N, M;
    private static boolean result = false;
    private static int[] dr = {0, 1};
    private static int[] dc = {1, 0};
    private static boolean[][] visit;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        if (visit[N - 1][M - 1]) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(int r, int c) {
        for (int dir = 0; dir <= 1; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (isAbleArea(nr, nc) && isNotVisit(nr, nc) && hasNotSnake(nr, nc)) {
                visit[nr][nc] = true;
                dfs(nr, nc);
            }
        }
    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    private static boolean isNotVisit(int r, int c) {
        return !visit[r][c];
    }

    private static boolean hasNotSnake(int r, int c) {
        return map[r][c] != SNAKE;
    }

}
