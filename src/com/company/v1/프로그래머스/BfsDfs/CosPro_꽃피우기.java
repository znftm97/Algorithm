package com.company.v1.프로그래머스.BfsDfs;

import java.util.*;

public class CosPro_꽃피우기 {
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static class Point {
        int r, c, day;

        public Point(int r, int c, int day) {
            this.r = r;
            this.c = c;
            this.day = day;
        }
    }

    public int solution(int[][] garden) {
        int rLen = garden.length;
        int cLen = garden[0].length;

        Queue<Point> q = new LinkedList<>();
        boolean[][] visit = new boolean[rLen][cLen ];

        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (garden[i][j] == 1) {
                    q.add(new Point(i, j, 0));
                    visit[i][j] = true;
                }
            }
        }

        if (rLen * cLen == q.size()) {
            return 0;
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < rLen && nc < cLen && !visit[nr][nc] && garden[nr][nc] == 0) {
                    q.add(new Point(nr, nc, p.day + 1));
                    visit[nr][nc] = true;
                    garden[nr][nc] = p.day + 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                result = Math.max(result, garden[i][j]);
            }
        }

        return result;
    }
}
