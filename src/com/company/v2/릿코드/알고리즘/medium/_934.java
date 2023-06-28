package com.company.v2.릿코드.알고리즘.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _934 {
    private class Point{
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private int[][] map;
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
    private int R, C;
    private final int A = 3;
    private final int B = 4;
    private final int LAND = 1;
    private List<Point> APoints = new ArrayList<>();
    private List<Point> BPoints = new ArrayList<>();

    public int shortestBridge(int[][] grid) {
        R = grid.length;
        C = R;
        map = new int[R][C];
        for (int i = 0; i < grid.length; i++) {
            map[i] = grid[i].clone();
        }

        int cnt = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == LAND) {
                    if (cnt == 0) {
                        paint(A, r, c, APoints);
                        cnt++;
                    } else {
                        paint(B, r, c, BPoints);
                    }
                }
            }
        }

        int minBridge = Integer.MAX_VALUE;
        for (Point aPoint : APoints) {
            for (Point bPoint : BPoints) {
                minBridge = Math.min(minBridge, calculateDistance(aPoint, bPoint));
            }
        }

        return minBridge == 1 ? 1 : minBridge - 1;
    }

    private int calculateDistance(Point a, Point b) {
        return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
    }

    private void paint(int AB, int startR, int startC, List<Point> points) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startR, startC));
        map[startR][startC] = AB;
        points.add(new Point(startR, startC));

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isInArea(nr, nc) && map[nr][nc] == LAND) {
                    map[nr][nc] = AB;
                    points.add(new Point(nr, nc));
                    q.add(new Point(nr, nc));
                }
            }
        }
    }

    private boolean isInArea(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
