package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1987 {
    private static char[][] map;
    private static boolean[] alphabetChecks = new boolean[26];
    private static int R, C, result;
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

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        recursion(new Point(0, 0), 0);
        System.out.println(result);
    }

    private static void recursion(Point p, int distance) {
        if (isVisitAlphabet(p.r, p.c)) {
            result = Math.max(result, distance);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = p.r + dr[i];
            int nc = p.c + dc[i];

            if (isInArea(nr, nc)) {
                alphabetChecks[map[p.r][p.c] - 'A'] = true;
                recursion(new Point(nr, nc), distance + 1);
                alphabetChecks[map[p.r][p.c] - 'A'] = false;
            }
        }
    }

    private static boolean isInArea(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static boolean isVisitAlphabet(int r, int c) {
        return alphabetChecks[map[r][c] - 'A'];
    }
}
