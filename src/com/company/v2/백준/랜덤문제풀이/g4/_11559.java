package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11559 {
    private static class Point{
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static char[][] map;
    private static boolean[][] visit;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new char[12][6];

        for (int i = 0; i < 12; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        int cnt = 0;
        while (true) {
            visit = new boolean[12][6];
            if(!isBoom()) break;
            fall();
            cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean isBoom() {
        int cnt = 0;
        for (int r = 0; r < 12; r++) {
            for (int c = 0; c < 6; c++) {
                if (map[r][c] != '.' && !visit[r][c]) {
                    if(boom(r, c)) cnt++;
                }
            }
        }

        return cnt > 0;
    }

    private static boolean boom(int startR, int startC) {
        List<Point> points = new ArrayList<>();
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startR, startC));
        points.add(new Point(startR, startC));
        visit[startR][startC] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isInArea(nr, nc) && isNotVisit(nr, nc) && isEqualsAlphabet(nr, nc, startR, startC)) {
                    q.add(new Point(nr, nc));
                    points.add(new Point(nr, nc));
                    visit[nr][nc] = true;
                    cnt++;
                }
            }
        }

        if (cnt >= 4) {
            for (Point p : points) {
                map[p.r][p.c] = '.';
            }
        }

        return cnt >= 4;
    }

    private static void fall() {
        for (int c = 0; c < 6; c++) {
            for (int r = 11; r >= 0; r--) {
                if (map[r][c] == '.') {
                    for (int nr = r - 1; nr >= 0; nr--) {
                        if (map[nr][c] != '.') {
                            map[r][c] = map[nr][c];
                            map[nr][c] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    private static boolean isInArea(int r, int c) {
        return r >= 0 && c >= 0 && r < 12 && c < 6;
    }

    private static boolean isNotVisit(int r, int c) {
        return !visit[r][c];
    }

    private static boolean isEqualsAlphabet(int r, int c, int startR, int startC) {
        return map[r][c] == map[startR][startC];
    }
}
