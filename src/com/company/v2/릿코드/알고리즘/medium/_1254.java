package com.company.v2.릿코드.알고리즘.medium;

import java.util.LinkedList;
import java.util.Queue;

public class _1254 {
    private class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private int[][] map;
    private boolean[][] visit;
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
    private int R, C = 0;
    private final int ISLAND = 0;

    public int closedIsland(int[][] grid) {
        int islandCnt = 0;
        R = grid.length;
        C = grid[0].length;
        map = new int[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < grid.length; i++) {
            map[i] = grid[i].clone();
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == ISLAND && isNotVisit(r,c) && bfs(new Point(r, c))) {
                    islandCnt++;
                }
            }
        }

        return islandCnt;
    }

    private boolean bfs(Point startPoint) {
        Queue<Point> q = new LinkedList<>();
        q.add(startPoint);
        visit[startPoint.r][startPoint.c] = true;
        int side = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (isSide(p.r, p.c)) {
                side++;
            }

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if(isInArea(nr,nc) && isNotVisit(nr,nc) && map[nr][nc] == ISLAND) {
                    q.add(new Point(nr, nc));
                    visit[nr][nc] = true;

                    if (isSide(nr, nc)) {
                        side++;
                    }
                }
            }
        }

        return side > 0 ? false : true;
    }

    private boolean isInArea(int r, int c) {
        return r < R && c < C && r >= 0 && c >= 0;
    }

    private boolean isNotVisit(int r, int c) {
        return !visit[r][c];
    }

    private boolean isSide(int r, int c) {
        return r == 0 || r == R - 1 || c == 0 || c == C - 1;
    }
}
