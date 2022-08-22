package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림_1926_bfs {
    private static int[][] map;
    private static boolean[][] visit;
    private static int dr[] = {-1 , 1, 0, 0};
    private static int dc[] = {0, 0, 1, -1};
    private static int N, M;

    private static class Point{
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int paintCnt = 0;
        int maxWidth = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visit[i][j] && map[i][j] == 1){
                    paintCnt++;
                    maxWidth = Math.max(maxWidth, bfs(i, j));
                }
            }
        }

        System.out.println(paintCnt);
        System.out.println(maxWidth);
    }

    private static int bfs(int r, int c){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        visit[r][c] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isAbleArea(nr, nc) && isAbleVisit(nr, nc)) {
                    q.add(new Point(nr, nc));
                    visit[nr][nc] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static boolean isAbleArea(int r, int c){
        if (r >= 0 && c >= 0 && r < N && c < M && map[r][c] == 1) {
            return true;
        }

        return false;
    }

    private static boolean isAbleVisit(int r, int c){
        if (!visit[r][c]) {
            return true;
        }

        return false;
    }

}
