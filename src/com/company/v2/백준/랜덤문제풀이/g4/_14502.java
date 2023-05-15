package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _14502 {
    private static final int limitWall = 3;
    private static final int VIRUS = 2;
    private static final int WALL = 1;
    private static final int EMPTY = 0;
    private static int[][] map;
    private static List<Point> virusPoints = new ArrayList<>();
    private static int N, M;
    private static int maxSafeArea = Integer.MIN_VALUE;

    private static class Point {
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
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == VIRUS) virusPoints.add(new Point(r, c));
            }
        }

        recursion(0);
        System.out.println(maxSafeArea);
    }

    private static void recursion(int depth) {
        if (depth == limitWall) {
            int[][] copyMap = spreadVirus();
            maxSafeArea = Math.max(maxSafeArea, getSafeAreaSize(copyMap));
            return;
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 0) {
                    map[r][c] = WALL;
                    recursion(depth + 1);
                    map[r][c] = EMPTY;
                }
            }
        }
    }

    private static int[][] spreadVirus() {
        int[][] copyMap = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            copyMap[i] = map[i].clone();
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Queue<Point> q = new LinkedList<>(virusPoints);

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isAbleArea(nr, nc) && copyMap[nr][nc] == EMPTY) {
                    q.add(new Point(nr, nc));
                    copyMap[nr][nc] = VIRUS;
                }
            }
        }

        return copyMap;
    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    private static int getSafeAreaSize(int[][] copyMap) {
        int cnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(copyMap[r][c] == EMPTY) cnt++;
            }
        }

        return cnt;
    }

}
