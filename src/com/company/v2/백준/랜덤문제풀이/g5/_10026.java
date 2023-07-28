package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _10026 {
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int N;

    private static class Point {
        int r, c;

        public Point(int r,int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < N; r++) {
            map[r] = br.readLine().toCharArray();
        }

        int cnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c]) {
                    bfs(r,c);
                    cnt++;
                }
            }
        }
        sb.append(cnt).append(" ");

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if(map[r][c] == 'R') map[r][c] = 'G';
            }
        }

        cnt = 0;
        visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c]) {
                    bfs(r,c);
                    cnt++;
                }
            }
        }
        sb.append(cnt);

        System.out.println(sb);
    }

    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        visited[r][c] = true;
        char color = map[r][c];

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isInArea(nr, nc) && isNotVisit(nr, nc) && map[nr][nc] == color) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }
        }
    }

    private static boolean isInArea(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static boolean isNotVisit(int r, int c) {
        return !visited[r][c];
    }
}
