package com.company.v2.백준.랜덤문제풀이.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2638 {
    private static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int[][] map, countMap;
    private static boolean[][] visit;
    private static int R, C, cheese;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static final int CHEESE = 1;
    private static final int AIR = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == CHEESE) cheese++;
            }
        }

        int time = 0;
        while (cheese > 0) {
            time++;
            visit = new boolean[R][C];
            countMap = new int[R][C];
            findRemoveCheese();
            removeCheese();
        }

        System.out.println(time);
    }

    private static void findRemoveCheese() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        visit[0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isInArea(nr, nc)) {
                    if (map[nr][nc] == CHEESE) {
                        countMap[nr][nc]++;
                    } else if (map[nr][nc] == AIR && isNotVisit(nr, nc)) {
                        q.add(new Point(nr, nc));
                        visit[nr][nc] = true;
                    }
                }
            }
        }
    }

    private static void removeCheese() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (countMap[r][c] >= 2) {
                    map[r][c] = AIR;
                    cheese--;
                }
            }
        }
    }

    private static boolean isInArea(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static boolean isNotVisit(int r, int c) {
        return !visit[r][c];
    }
}
