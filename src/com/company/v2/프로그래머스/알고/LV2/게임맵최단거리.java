package com.company.v2.프로그래머스.알고.LV2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    private static class Point{
        int r, c, val;

        public Point(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }

    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        q.add(new Point(0, 0, 1));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isAbleArea(nr, nc, N, M) && isNotWall(nr, nc, maps) && isNotVisit(nr, nc, visited)) {
                    maps[nr][nc] = p.val + 1;
                    q.add(new Point(nr, nc, maps[nr][nc]));
                    visited[nr][nc] = true;
                }
            }
        }

        if (maps[N - 1][M - 1] == 1) {
            return -1;
        }

        return maps[N - 1][M - 1];
    }

    private static boolean isAbleArea(int nr, int nc, int N, int M) {
        return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }

    private static boolean isNotWall(int nr, int nc, int[][] maps) {
        return maps[nr][nc] != 0;
    }

    private static boolean isNotVisit(int nr, int nc, boolean[][] visited) {
        return !visited[nr][nc];
    }

}
