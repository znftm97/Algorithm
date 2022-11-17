package com.company.v2.코드트리.LV4.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1차원_바람 {

    private static int[][] map;
    private static int N, M;
    private static final int LEFT = -1;
    private static final int RIGHT = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] rowAndDirs = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            rowAndDirs[i][0] = Integer.parseInt(st.nextToken());

            if (st.nextToken().equals("L")) {
                rowAndDirs[i][1] = LEFT;
            } else {
                rowAndDirs[i][1] = RIGHT;
            }
        }

        for (int i = 0; i < rowAndDirs.length; i++) {
            int qr = rowAndDirs[i][0];
            int dir = rowAndDirs[i][1];

            dir = push(qr, dir);
            propagateUp(qr, dir);
            propagateDown(qr, dir);
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                sb.append(map[r][c]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void propagateUp(int originR, int dir) {
        if(originR == 1){
            return;
        }

        boolean canPropagate = false;
        int nr = originR - 1;

        for (int c = 1; c <= M; c++) {
            if (map[originR][c] == map[nr][c]) {
                canPropagate = true;
                break;
            }
        }

        if (!canPropagate) {
            return;
        }

        dir = push(nr, dir);

        propagateUp(nr, dir);
    }

    private static void propagateDown(int originR, int dir) {
        if(originR == N){
            return;
        }

        boolean canPropagate = false;
        int nr = originR + 1;

        for (int c = 1; c <= M; c++) {
            if (map[originR][c] == map[nr][c]) {
                canPropagate = true;
                break;
            }
        }

        if (!canPropagate) {
            return;
        }

        dir = push(nr, dir);

        propagateDown(nr, dir);
    }

    private static int push(int r, int dir) {
        if (dir == LEFT) {
            pushRight(r);
            dir = RIGHT;
        } else {
            pushLeft(r);
            dir = LEFT;
        }

        return dir;
    }

    private static void pushLeft(int r) {
        int tmp = map[r][1];

        for (int c = 1; c < M; c++) {
            map[r][c] = map[r][c + 1];
        }

        map[r][M] = tmp;
    }

    private static void pushRight(int r) {
        int tmp = map[r][M];

        for (int c = M; c > 1; c--) {
            map[r][c] = map[r][c - 1];
        }

        map[r][1] = tmp;
    }

}

