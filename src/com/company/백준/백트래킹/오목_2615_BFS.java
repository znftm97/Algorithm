package com.company.백준.백트래킹;

import java.io.*;
import java.util.*;

public class 오목_2615_BFS {
    private static int[][] map;
    private static boolean[][] visit;
    private static int result;
    private static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};

    private static class Point{
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        map = new int[19][19];

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int c = 0; c < 19; c++) {
            for (int r = 0; r < 19; r++) {
                if(map[r][c] == 1 || map[r][c] == 2) {
                    for (int dir = 0; dir < 8; dir++) {
                        int nr = r + dr[dir];
                        int nc = c + dc[dir];
                        int nr2 = r + dr[dir] * -1;
                        int nc2 = c + dc[dir] * -1;

                        if (isAbleArea(nr, nc) && isAbleArea(nr2, nc2) && (map[nr][nc] == map[nr2][nc2])) {
                            continue;
                        }

                        visit = new boolean[19][19];
                        bfs(r, c, dir);

                        if (result == 5) {
                            if(map[r][c] == 1) sb.append("1").append("\n");
                            else sb.append("2").append("\n");

                            sb.append(r + 1).append(" ").append(c + 1);
                            System.out.println(sb);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    private static void bfs(int r, int c, int dir){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c, 1));
        visit[r][c] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            result = p.cnt;

            int nr = p.r + dr[dir];
            int nc = p.c + dc[dir];

            if (isAbleArea(nr, nc) && isAbleVisit(nr, nc) && isEqualsColor(r, c, nr, nc)) {
                q.add(new Point(nr, nc, p.cnt + 1));
                visit[nr][nc] = true;
            }
        }
    }

    private static boolean isAbleArea(int r, int c){
        return r >= 0 && c >= 0 && r < 19 && c < 19;
    }

    private static boolean isAbleVisit(int r, int c){
        return !visit[r][c];
    }

    private static boolean isEqualsColor(int r, int c, int nr, int nc){
        return map[r][c] == map[nr][nc];
    }

}
