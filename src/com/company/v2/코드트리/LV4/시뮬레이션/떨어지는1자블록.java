package com.company.v2.코드트리.LV4.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 떨어지는1자블록 {
    private static final int BLOCK = 1;
    private static int N, blockWidthLen, startC;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        blockWidthLen = Integer.parseInt(st.nextToken());
        startC = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int nowR = 1;
        while (true) {
            if (isBottom(nowR) || canNotDrop(nowR)) {
                for (int c = startC; c <= startC + blockWidthLen - 1; c++) {
                    map[nowR][c] = BLOCK;
                }

                break;
            }

            nowR++;
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                sb.append(map[r][c]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean canNotDrop(int nowR) {
        for (int c = startC; c <= startC + blockWidthLen - 1; c++) {
            if (map[nowR + 1][c] == BLOCK) {
                return true;
            }
        }

        return false;
    }

    private static boolean isBottom(int nowR) {
        return nowR == N;
    }

}
