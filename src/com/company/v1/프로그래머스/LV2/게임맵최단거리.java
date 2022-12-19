package com.company.v1.프로그래머스.LV2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int[][] map;
    private static boolean[][] visit;
    private static int R, C;

    private static class Point{
        int r, c, val;

        public Point(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }

    public int solution(int[][] maps) {
        map = maps.clone();
        R = map.length;
        C = map[0].length;
        visit = new boolean[R][C];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        visit[0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isArrive(nr, nc)) return p.val + 1;

                if (isAbleArea(nr, nc) && isNotVisit(nr, nc) && isNotWall(nr, nc)) {
                    q.add(new Point(nr, nc, p.val + 1));
                    visit[nr][nc] = true;
                }
            }
        }

        return -1;
    }

    private static boolean isAbleArea(int r, int c){
        if (r >= 0 && c >= 0 && r < R && c < C) return true;
        return false;
    }

    private static boolean isNotVisit(int r, int c){
        return !visit[r][c];
    }

    private static boolean isNotWall(int r, int c){
        return map[r][c] != 0;
    }

    private static boolean isArrive(int r, int c){
        if (r == R - 1 && c == C - 1) return true;
        return false;
    }

}
