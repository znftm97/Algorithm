package com.company.v1.코드트리.프로그래밍연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class LR그리고B {
    private static boolean[][] visit;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static Point targetPoint;
    private static Point wallPoint;
    private static Point sourcePoint;
    private static int result = 0;

    private static class Point{
        int r, c, v;

        public Point(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        visit = new boolean[10][10];

        for (int i = 0; i < 10; i++) {
            String str = br.readLine();
            if (str.contains("B")) {
                targetPoint = new Point(i, str.indexOf('B'), 0);
            }

            if (str.contains("R")) {
                wallPoint = new Point(i, str.indexOf('R'), 0);
            }

            if (str.contains("L")) {
                sourcePoint = new Point(i, str.indexOf('L'), 0);
            }
        }

        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(sourcePoint);
        visit[sourcePoint.r][sourcePoint.c] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isAbleArea(nr, nc) && isAbleVisit(nr, nc) && isNotWall(nr, nc)) {
                    if (isTarget(nr, nc)) {
                        result = p.v;
                        return;
                    }
                    q.add(new Point(nr, nc, p.v + 1));
                    visit[nr][nc] = true;
                }
            }
        }

    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < 10 && c < 10;
    }

    private static boolean isAbleVisit(int r, int c) {
        return !visit[r][c];
    }

    private static boolean isNotWall(int r, int c) {
        return r != wallPoint.r || c != wallPoint.c;
    }

    private static boolean isTarget(int r, int c) {
        return r == targetPoint.r && c == targetPoint.c;
    }

}
