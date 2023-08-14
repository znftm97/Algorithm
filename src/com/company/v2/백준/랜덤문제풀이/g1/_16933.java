package com.company.v2.백준.랜덤문제풀이.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16933 {
    private static int N,M,K;
    private static char[][] map;
    private static boolean[][][][] visited; // [낮,밤][부순개수][r][c]
    private static final int AFTERNOON = 0;
    private static final int NIGHT = 1;
    private static final char EMPTY = '0';
    private static final char WALL = '1';

    private static class Point {
        int r,c,removeWall, distance;
        boolean isNight;

        public Point(int r,int c, int removeWall, int distance, boolean isNight) {
            this.r=r;
            this.c=c;
            this.removeWall = removeWall;
            this.distance = distance;
            this.isNight = isNight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[2][K + 1][N][M];

        for(int i = 0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bfs();
    }

    private static void bfs() {
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0, 1, false));
        visited[AFTERNOON][0][0][0] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();

            if (p.r == N - 1 && p.c == M - 1) {
                System.out.println(p.distance);
                return;
            }

            for(int i = 0; i<4; i++){
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if(!isInArea(nr,nc)) {
                    continue;
                }

                if(map[nr][nc] == EMPTY) {
                    if (isNightAndNotVisit(nr, nc, p)) {
                        q.add(new Point(nr, nc, p.removeWall, p.distance + 1, !p.isNight));
                        visited[AFTERNOON][p.removeWall][nr][nc] = true;
                    } else if (isAfternoonAndNotVisit(nr, nc, p)) {
                        q.add(new Point(nr, nc, p.removeWall, p.distance + 1, !p.isNight));
                        visited[NIGHT][p.removeWall][nr][nc] = true;
                    }
                } else if (map[nr][nc] == WALL && canRemoveWall(p)) {
                    if (isNightAndNotVisit(nr ,nc ,p)) {
                        q.add(new Point(p.r, p.c, p.removeWall, p.distance + 1, !p.isNight));
                        visited[AFTERNOON][p.removeWall][nr][nc] = true;
                    } else if (isAfternoonAndNotVisit(nr, nc, p)) {
                        q.add(new Point(nr, nc, p.removeWall + 1, p.distance + 1, !p.isNight));
                        visited[NIGHT][p.removeWall + 1][nr][nc] = true;
                    }
                }
            }
        }

        System.out.println(-1);
    }

    private static boolean isInArea(int r,int c) {
        return r>=0 && c>=0 && r<N && c<M;
    }

    private static boolean isNightAndNotVisit(int nr, int nc, Point p) {
        return p.isNight && !visited[AFTERNOON][p.removeWall][nr][nc];
    }

    private static boolean isAfternoonAndNotVisit(int nr, int nc, Point p) {
        return !p.isNight && !visited[NIGHT][p.removeWall][nr][nc];
    }

    private static boolean canRemoveWall(Point p) {
        return p.removeWall < K;
    }

}
