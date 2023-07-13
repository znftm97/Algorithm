package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1261_bfs {
    private static final int WALL = 1;
    private static int R, C;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static class Point implements Comparable<Point>{
        int r, c, wallCnt;

        public Point(int r, int c, int wallCnt) {
            this.r = r;
            this.c = c;
            this.wallCnt = wallCnt;
        }


        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.wallCnt, o.wallCnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visit = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String s = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = s.charAt(c) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, 0));
        visit[0][0] = true;

        while (!pq.isEmpty()) {
            Point p = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr == R - 1 && nc == C - 1) return p.wallCnt;

                if (isInArea(nr, nc) && canVisit(nr, nc)) {
                    visit[nr][nc] = true;
                    if(map[nr][nc] == WALL) pq.add(new Point(nr, nc, p.wallCnt + 1));
                    else pq.add(new Point(nr, nc, p.wallCnt));
                }
            }
        }

        return 0;
    }

    private static boolean isInArea(int nr, int nc){
        return nr < R && nc < C && nr >= 0 && nc >=0;
    }

    private static boolean canVisit(int nr, int nc){
        return !visit[nr][nc];
    }
}
