package com.company.v2.코드트리.LV4.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트로미노 {
    private static int N, M, result = 0;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                calSum(r, c, r - 1, c, r + 1, c);
                calSum(r, c, r, c + 1, r, c - 1);
                calSum(r, c, r - 1, c, r, c + 1);
                calSum(r, c, r, c - 1, r + 1, c);
                calSum(r, c, r - 1, c, r, c - 1);
                calSum(r, c, r + 1, c, r, c + 1);
            }
        }

        System.out.println(result);
    }

    private static void calSum(int r1, int c1, int r2, int c2, int r3, int c3) {
        int sum = 0;

        if (isAbleArea(r1, c1) && isAbleArea(r2, c2) && isAbleArea(r3, c3)) {
            sum += map[r1][c1] + map[r2][c2] + map[r3][c3];
        }

        result = Math.max(result, sum);
    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

}
