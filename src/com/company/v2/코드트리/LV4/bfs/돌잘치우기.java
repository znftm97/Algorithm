package com.company.v2.코드트리.LV4.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 돌잘치우기 {
    private static int N, M, K, result;
    private static final int ROCK = 1;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static List<Point> startPoints = new ArrayList<>(); // 문제에서 주어지는 시작 지점들
    private static List<Point> cleanUpRockPoints = new ArrayList<>(); // 치워야할 돌 지점들
    private static List<Point> rockPoints = new ArrayList<>(); // 돌이 존재하는 지점들

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

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == ROCK) {
                    rockPoints.add(new Point(r, c));
                }
            }
        }

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken()) - 1;
            int startC = Integer.parseInt(st.nextToken()) - 1;
            startPoints.add(new Point(startR, startC));
        }

        recursion(0, 0);

        System.out.println(result);
    }

    private static void recursion(int idx, int depth) {
        if (depth == M) {
            // 조합된 돌 치우기
            for (Point p : cleanUpRockPoints) {
                map[p.r][p.c] = 0;
            }

            // 최대값 계산
            for (Point p : startPoints) {
                int visitCnt = bfs(p);
                result = Math.max(result, visitCnt);
            }

            // 돌 치운거 복구
            for (Point p : cleanUpRockPoints) {
                map[p.r][p.c] = ROCK;
            }

            return;
        }

        for (int i = idx; i < rockPoints.size(); i++) {
            cleanUpRockPoints.add(rockPoints.get(i));
            recursion(i + 1, depth + 1);
            cleanUpRockPoints.remove(cleanUpRockPoints.size() - 1);
        }
    }

    private static int bfs(Point startPoint) {
        Queue<Point> q = new LinkedList<>();
        q.add(startPoint);

        visit = new boolean[N][N];
        visit[startPoint.r][startPoint.c] = true;
        int visitCnt = 1;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nr = p.r + dr[dir];
                int nc = p.c + dc[dir];

                if (isAbleArea(nr, nc) && isNotVisited(nr, nc) && hasNotRock(nr, nc)){
                    q.add(new Point(nr, nc));
                    visit[nr][nc] = true;
                    visitCnt++;
                }
            }
        }

        return visitCnt;
    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static boolean isNotVisited(int r, int c) {
        return !visit[r][c];
    }

    private static boolean hasNotRock(int r, int c) {
        return map[r][c] != ROCK;
    }

}
