package com.company.v2.백준.랜덤문제풀이.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2146 {

    static int N;
    static int color = 2;
    static List<Integer> colors = new ArrayList<>();
    static final int LAND = 1;
    static final int EMPTY = 0;
    static List<List<Point>> graph = new ArrayList<>();
    static Map<Integer, List<Point>> areaToPointsMap = new HashMap<>();
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int result = Integer.MAX_VALUE;

    static class Point {
        int r,c,val;

        public Point(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph.add(new ArrayList<>());
            for (int j = 0; j < N; j++) {
                graph.get(i).add(new Point(i, j, Integer.parseInt(st.nextToken())));
            }
        }

        // 각 지역마다 다른 color로 마킹
        visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (graph.get(r).get(c).val == LAND && !visited[r][c]) {
                    mark(r, c, color);
                    colors.add(color);
                    color++;
                }
            }
        }

        // 각 지역의 바깥쪽 Point만 Map에 저장
        visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (graph.get(r).get(c).val == EMPTY) {
                    getSideLand(r, c);
                }
            }
        }

        // 최소 거리 계산
        for (int i = 2; i < color; i++) {
            List<Point> aPoints = areaToPointsMap.get(i);
            for (int j = i + 1; j < color; j++) {
                List<Point> bPoints = areaToPointsMap.get(j);
                calculate(aPoints, bPoints);
            }
        }

        System.out.println(result - 1); // 거리가 아니라 칸수 계산이라 1뺴줘야함
    }

    static void mark(int r, int c, int color) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c, color));
        visited[r][c] = true;
        graph.get(r).get(c).val = color;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isInArea(nr, nc) && canVisit(nr, nc) && isLand(nr, nc)) {
                    graph.get(nr).get(nc).val = color;
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, color));
                }
            }
        }
    }

    static void getSideLand(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isInArea(nr, nc) && canVisit(nr, nc) && isLand(nr, nc)) {
                visited[nr][nc] = true;
                Point point = graph.get(nr).get(nc);
                areaToPointsMap.computeIfAbsent(point.val, key -> new ArrayList<>()).add(point);
            }
        }
    }

    static void calculate(List<Point> aPoints, List<Point> bPoints) {
        for (Point ap : aPoints) {
            for (Point bp : bPoints) {
                int distance = Math.abs(ap.r - bp.r) + Math.abs(ap.c - bp.c);
                result = Math.min(result, distance);
            }
        }
    }

    static boolean isInArea(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    static boolean canVisit(int r, int c) {
        return !visited[r][c];
    }

    static boolean isLand(int r, int c) {
        return graph.get(r).get(c).val != EMPTY;
    }

}
