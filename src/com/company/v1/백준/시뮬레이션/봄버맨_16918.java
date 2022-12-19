package com.company.v1.백준.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 봄버맨_16918 {
    private static int[][] map;
    private static int R, C, S;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};
    private static Queue<Point> q = new LinkedList<>();
    private static StringBuilder sb = new StringBuilder();

    private static final int EMPTY = 0;
    private static final int NOW_BOOM_BOMB = 1;
    private static final int AFTER_BOOM_BOMB = 2;

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

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String[] split = br.readLine().split("");

            for (int j = 0; j < C; j++) {
                if (split[j].equals(".")) {
                    map[i][j] = EMPTY;
                } else {
                    map[i][j] = NOW_BOOM_BOMB;
                    q.add(new Point(i, j));
                }
            }
        }

        int second = 0;
        while (true) {
            if(++second == S) break; // 시간되면 종료 이 if문이 putBoom() 아래로 가면 시간초과
            putBoom(); // 폭탄없는 모든칸에 AFTER_BOOM_BOMB 폭탄 설치

            if(++second == S) break;
            boom(); // NOW_BOOM_BOMB 폭탄만 폭발
            changeBomb(); // AFTER_BOOM_BOMB -> NOW_BOOM_BOMB 폭탄 변경
        }

        print();
        br.close();
    }

    private static void putBoom() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == EMPTY) {
                    map[i][j] = AFTER_BOOM_BOMB;
                }
            }
        }
    }

    private static void boom(){
        while (!q.isEmpty()) {
            Point p = q.poll();
            map[p.r][p.c] = 0;

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isAbleArea(nr, nc)) {
                    map[nr][nc] = EMPTY;
                }
            }
        }
    }

    private static boolean isAbleArea(int nr, int nc){
        if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
            return true;
        }

        return false;
    }

    private static void changeBomb(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == AFTER_BOOM_BOMB) {
                    map[i][j] = NOW_BOOM_BOMB;
                    q.add(new Point(i, j));
                }
            }
        }
    }

    private static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) {
                    sb.append(".");
                } else {
                    sb.append("O");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
