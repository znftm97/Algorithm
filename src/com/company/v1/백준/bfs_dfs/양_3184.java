package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양_3184 {
    private static String[][] map;
    private static boolean[][] visit;
    private static int N, M, areaWolfCnt, areaSheepCnt;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};

    private static class Point{
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));

        if (map[r][c].equals("v")) {
            areaWolfCnt++;
        } else if (map[r][c].equals("o")) {
            areaSheepCnt++;
        }

        while (!q.isEmpty()) {
            Point getPoint = q.poll();
            visit[getPoint.r][getPoint.c] = true;

            for (int i = 0; i < 4; i++) {
                int nr = getPoint.r + dr[i];
                int nc = getPoint.c + dc[i];

                if (notEscape(nr, nc) && notVisit(nr, nc) && notFence(nr, nc)) {
                    q.add(new Point(nr, nc));
                    visit[nr][nc] = true;

                    if (map[nr][nc].equals("v")) {
                        areaWolfCnt++;
                    } else if (map[nr][nc].equals("o")) {
                        areaSheepCnt++;
                    }
                }
            }
        }

        if (areaWolfCnt >= areaSheepCnt) {
            areaSheepCnt = 0;
        } else {
            areaWolfCnt = 0;
        }

    }

    public static boolean notVisit(int nr, int nc) {
        if (!visit[nr][nc]) {
            return true;
        }

        return false;
    }

    private static boolean notEscape(int nr, int nc){
        if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
            return true;
        }

        return false;
    }

    private static boolean notFence(int nr, int nc){
        if (!map[nr][nc].equals("#")) {
            return true;
        }

        return false;
    }

    private static boolean isYard(int i, int j){
        if (map[i][j].equals(".") || map[i][j].equals("v") || map[i][j].equals("o")) {
            if (!map[i][j].equals("#")) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = split[j];
            }
        }

        int totalWolfCnt = 0;
        int totalSheepCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && isYard(i, j)) {
                    bfs(i, j);
                    totalWolfCnt += areaWolfCnt;
                    totalSheepCnt += areaSheepCnt;
                    areaWolfCnt = 0;
                    areaSheepCnt = 0;
                }
            }
        }

        System.out.println(totalSheepCnt + " " + totalWolfCnt);
        br.close();
    }
}
