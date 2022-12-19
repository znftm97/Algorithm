package com.company.v2.코드트리.LV4.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 정수사각형_최장증가수열 {
    private static int[][] map, dp;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int N;

    private static class Point implements Comparable<Point>{
        int r, c, val;

        public Point(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.val, o.val);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                points.add(new Point(i, j, map[i][j]));
            }
        }

        Collections.sort(points);

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 1);
        }

        for (Point p : points) {
            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isAbleArea(nr, nc) && map[p.r][p.c] < map[nr][nc]) {
                    dp[nr][nc] = Math.max(dp[nr][nc], dp[p.r][p.c] + 1);
                }
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }

        System.out.println(result);
    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

}
