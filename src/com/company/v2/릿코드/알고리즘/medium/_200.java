package com.company.v2.릿코드.알고리즘.medium;

import java.util.LinkedList;
import java.util.Queue;

public class _200 {

    private static int R, C;
    private static boolean[][] visit;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int numIslands(char[][] grid) {
        int result = 0;
        R = grid.length;
        C = grid[0].length;
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (isNotVisit(i, j) && grid[i][j] == '1') {
                    bfs(i,j,grid);
                    result++;
                }
            }
        }

        return result;
    }

    private static void bfs(int r, int c, char[][] grid) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        visit[r][c] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isAvailableArea(nr, nc) && isNotVisit(nr, nc) && grid[nr][nc] == '1') {
                    q.add(new Point(nr, nc));
                    visit[nr][nc] = true;
                }
            }
        }
    }

    private static boolean isAvailableArea(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static boolean isNotVisit(int r, int c) {
        return !visit[r][c];
    }

}
