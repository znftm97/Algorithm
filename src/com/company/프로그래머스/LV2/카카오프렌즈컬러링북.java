package com.company.프로그래머스.LV2;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int R, C;

    private static class Point{
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int[] solution(int r, int c, int[][] records) {
        map = records.clone();
        visit = new boolean[r][c];
        R = r;
        C = c;
        int areaCnt = 0;
        int maxElementCnt = Integer.MIN_VALUE;
        int[] result = new int[2];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != 0 && !visit[i][j]) {
                    int elementCnt = bfs(i, j, map[i][j]);
                    maxElementCnt = Math.max(elementCnt, maxElementCnt);
                    areaCnt++;
                }
            }
        }

        result[0] = areaCnt;
        result[1] = maxElementCnt;
        return result;
    }

    private static int bfs(int r, int c, int num) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        visit[r][c] = true;

        int elementCnt = 1;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isAbleArea(nr, nc, num)) {
                    q.add(new Point(nr, nc));
                    visit[nr][nc] = true;
                    elementCnt++;
                }
            }
        }

        return elementCnt;
    }

    private static boolean isAbleArea(int nr, int nc, int num){
        if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
            if (!visit[nr][nc] && map[nr][nc] == num) {
                return true;
            }
        }

        return false;
    }
}
