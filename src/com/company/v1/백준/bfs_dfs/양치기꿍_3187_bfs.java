package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양치기꿍_3187_bfs {

    private static char[][] map;
    private static boolean[][] visit;
    private static int R, C, totalSheepCnt, totalWolfCnt;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static class Point{
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (isNotFence(i, j) && isNotVisit(i, j)) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(totalSheepCnt + " " + totalWolfCnt);
    }

    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        visit[r][c] = true;

        int sheepCnt = 0;
        int wolfCnt = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();

            if(map[p.r][p.c] == 'v') wolfCnt++;
            else if (map[p.r][p.c] == 'k') sheepCnt++;

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isAbleArea(nr, nc) && isNotVisit(nr, nc) && isNotFence(nr, nc)) {
                    q.add(new Point(nr, nc));
                    visit[nr][nc] = true;
                }
            }
        }

        if(wolfCnt >= sheepCnt) totalWolfCnt += wolfCnt;
        else totalSheepCnt += sheepCnt;
    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static boolean isNotVisit(int r, int c) {
        return !visit[r][c];
    }

    private static boolean isNotFence(int r, int c){
        return map[r][c] != '#';
    }

}
