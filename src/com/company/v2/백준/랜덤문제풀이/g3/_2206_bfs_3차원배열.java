package com.company.v2.백준.랜덤문제풀이.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206_bfs_3차원배열 {

    private static char[][] map;
    private static boolean[][][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int R, C;
    private static int result = Integer.MAX_VALUE;

    private static class Point {
        int r, c, distance;
        boolean isRemoveWall;

        public Point(int r, int c, int distance, boolean isRemoveWall) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.isRemoveWall = isRemoveWall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[2][R][C];

        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }

        bfs();

        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.r == R - 1 && p.c == C - 1) {
                result = Math.min(result, p.distance);
            }

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (!isInArea(nr, nc)) {
                    continue;
                }

                if (map[nr][nc] == '1') {
                    if (!p.isRemoveWall) {
                        q.add(new Point(nr, nc, p.distance + 1, true));
                        visited[1][nr][nc] = true;
                    }
                } else {
                    if (p.isRemoveWall && !visited[1][nr][nc]) {
                        q.add(new Point(nr, nc, p.distance + 1, p.isRemoveWall));
                        visited[1][nr][nc] = true;
                    } else if(!p.isRemoveWall && !visited[0][nr][nc]){
                        q.add(new Point(nr, nc, p.distance + 1, p.isRemoveWall));
                        visited[0][nr][nc] = true;
                    }
                }
            }
        }
    }

    private static boolean isInArea(int r, int c) {
        return r < R && c < C && r >= 0 && c >= 0;
    }
}
