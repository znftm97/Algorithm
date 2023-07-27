package com.company.v2.백준.랜덤문제풀이.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206 {
    private static char[][] map;
    private static int[][] visit;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int R, C;

    private static class Point {
        int r, c, distance, breakCnt;

        public Point(int r, int c, int distance, int breakCnt) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.breakCnt = breakCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new int[R][C];

        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
            Arrays.fill(visit[r], Integer.MAX_VALUE);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1, 0)); // 자기 자신 포함 distance = 1
        visit[0][0] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.r == R - 1 && p.c == C - 1) {
                return p.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                // 벽을 안부수고 왔을때랑, 벽을 부수고 왔을때가 겹친다면, 벽을 안부수고 온 경우가 우선(앞으로 벽을 더 부숴서 최단거리로 갈 수 있으므로)
                if (isInArea(nr, nc) && visit[nr][nc] > p.breakCnt) {
                    if (map[nr][nc] == '0') {
                        visit[nr][nc] = p.breakCnt;
                        q.add(new Point(nr, nc, p.distance + 1, p.breakCnt));
                    } else if (p.breakCnt == 0) {
                        visit[nr][nc] = p.breakCnt + 1;
                        q.add(new Point(nr, nc, p.distance + 1, p.breakCnt + 1));
                    }
                }
            }
        }

        return -1;
    }

    private static boolean isInArea(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
