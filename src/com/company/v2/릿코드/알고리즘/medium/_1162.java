package com.company.v2.릿코드.알고리즘.medium;

import java.util.LinkedList;
import java.util.Queue;

public class _1162 {
    private int R, C;
    private final int LAND = 1;
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
    private int[][] map;
    private boolean[][] visit;
    private int maxDistance = -1;

    private class Point{
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int maxDistance(int[][] grid) {
        Queue<Point> q = new LinkedList<>();
        R = grid.length;
        C = grid[0].length;
        map = new int[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = grid[i].clone();
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == LAND) {
                    visit[r][c] = true;
                    q.add(new Point(r, c));
                }
            }
        }

        bfs(q);
        return maxDistance == 0 ? -1 : maxDistance;
    }

    private void bfs(Queue<Point> q) {
        while (!q.isEmpty()) {
            Point p = q.poll();
            maxDistance = Math.max(maxDistance, map[p.r][p.c] - 1);

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isInArea(nr, nc) && isNotVisit(nr, nc)) {
                    q.add(new Point(nr, nc));
                    visit[nr][nc] = true;
                    map[nr][nc] = map[p.r][p.c] + 1;
                }
            }
        }
    }

    private boolean isInArea(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private boolean isNotVisit(int r, int c) {
        return !visit[r][c];
    }

}
